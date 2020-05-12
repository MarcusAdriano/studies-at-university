import socketserver
import cipher


class MyTCPHandler(socketserver.BaseRequestHandler):
    buffer_size = 1024
    """
    The request handler class for our server.

    It is instantiated once per connection to the server, and must
    override the handle() method to implement communication to the
    client.
    """

    def handle(self):
        print('client connected {}'.format(self.client_address[0]))

        signer = cipher.DigitalSignature(
            priv_file='keys/server_priv.pem',
            pub_file='keys/client_pub.pem'
        )

        # handshake
        self.request.recv(self.buffer_size)
        dh = cipher.DH()

        server_pub: bytes = dh.get_public_key().to_bytes(2048, byteorder='big')
        server_pub_signed = signer.sign(server_pub.hex())

        self.request.sendall(bytes(server_pub_signed, encoding='utf-8'))

        rv = self.request.recv(self.buffer_size)
        client_pub_signed = bytes()
        while rv:
            client_pub_signed += rv
            if len(rv) != self.buffer_size:
                break
            rv = self.request.recv(self.buffer_size)

        signed, client_pub = signer.verify(client_pub_signed)
        if not signed:
            print("[HANDSHAKE]: Can't trust in client!")
            return

        client_y = int.from_bytes(bytes.fromhex(client_pub), byteorder='big')

        dh.exchange(client_y)
        aes_key = dh.get_aes_key()

        # clean memory
        del client_pub_signed
        del server_pub_signed
        del server_pub
        del client_pub
        del client_y
        del dh

        while True:
            rv = self.request.recv(self.buffer_size)
            ciphertext = bytes()
            while rv:
                ciphertext += rv
                if len(rv) != self.buffer_size:
                    break
                rv = self.request.recv(self.buffer_size)

            if len(ciphertext) <= 0:
                print('client disconnected {}'.format(self.client_address[0]))
                del aes_key
                break

            plaintext = cipher.aes_dec(aes_key, ciphertext)
            is_signed, data = signer.verify(plaintext)
            if is_signed:
                print("{} wrote: {}".format(self.client_address[0], data))
                # just send back the same data, but upper-cased
                new_data = data.upper()
                json_data = signer.sign(new_data)
                self.request.sendall(cipher.aes_enc(aes_key, bytes(json_data, encoding='utf-8')))
            else:
                print("[MESSAGE]: Can't trust in client!")
                del aes_key
                break


if __name__ == "__main__":
    HOST, PORT = "ec2-52-25-49-251.us-west-2.compute.amazonaws.com", 8081

    # Create the server, binding to localhost on port 9999
    with socketserver.TCPServer((HOST, PORT), MyTCPHandler) as server:
        # Activate the server; this will keep running until you
        # interrupt the program with Ctrl-C
        server.serve_forever()

