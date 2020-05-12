import socket
import cipher
import sys

HOST, PORT = "ec2-52-25-49-251.us-west-2.compute.amazonaws.com", 8081
BUFFER_SIZE = 4096

# Create a socket (SOCK_STREAM means a TCP socket)
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    _exit = False
    sock.connect((HOST, PORT))

    signer = cipher.DigitalSignature(
        priv_file='keys/client_priv.pem',
        pub_file='keys/server_pub.pem'
    )

    # handshake
    sock.sendall(b'hello')
    rv = sock.recv(BUFFER_SIZE)
    server_pub_signed = bytes()
    while rv:
        server_pub_signed += rv
        if len(rv) != BUFFER_SIZE:
            break
        rv = sock.recv(BUFFER_SIZE)

    signed, server_pub = signer.verify(server_pub_signed)
    if not signed:
        print("Can't trust in server")
        sys.exit(0)

    server_pub = bytes.fromhex(server_pub)
    server_y = int.from_bytes(server_pub, byteorder='big')

    dh = cipher.DH()
    client_pub: bytes = dh.get_public_key().to_bytes(2048, byteorder='big')
    client_pub_signed = signer.sign(client_pub.hex())
    sock.sendall(bytes(client_pub_signed, encoding='utf-8'))

    dh.exchange(server_y)
    aes_key = dh.get_aes_key()

    # clean memory
    del client_pub
    del client_pub_signed
    del server_pub_signed
    del server_y
    del server_pub
    del dh

    while not _exit:
        value = input('Send: ')
        if value == 'exit':
            _exit = True
            continue

        json_with_signature = signer.sign(value)
        to_send = cipher.aes_enc(aes_key, bytes(json_with_signature, encoding='utf-8'))
        sock.sendall(to_send)

        rv = sock.recv(BUFFER_SIZE)
        ciphertext = bytes()
        while rv:
            ciphertext += rv
            if len(rv) != BUFFER_SIZE:
                break
            rv = sock.recv(BUFFER_SIZE)

        if len(ciphertext) <= 0:
            print('server closes connection!')
            sys.exit(0)

        server_response_signed = cipher.aes_dec(aes_key, ciphertext)
        is_signed, received = signer.verify(server_response_signed)

        if is_signed:
            print("Received: {}".format(received))
        else:
            del aes_key
            print("Can't trust in server!")
            sock.close()
            sys.exit(0)
finally:
    sock.close()
