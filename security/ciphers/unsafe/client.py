import socket
import sys

HOST, PORT = "ec2-52-25-49-251.us-west-2.compute.amazonaws.com", 8080

# Create a socket (SOCK_STREAM means a TCP socket)
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    _exit = False
    sock.connect((HOST, PORT))
    while not _exit:
        value = input('Send: ')
        if value == 'exit':
            _exit = True
            continue

        sock.send(bytes(value, encoding='utf-8'))

        received = sock.recv(4096).strip()
        print("Received: {}".format(received))
finally:
    sock.close()
