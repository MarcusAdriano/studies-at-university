import socketserver


class MyTCPHandler(socketserver.BaseRequestHandler):
    """
    The request handler class for our server.

    It is instantiated once per connection to the server, and must
    override the handle() method to implement communication to the
    client.
    """

    def handle(self):
        while True:
            # self.request is the TCP socket connected to the client
            data = self.request.recv(4096).strip()

            if len(data) <= 0:
                break

            print("{} wrote: {}".format(self.client_address[0], data))
            # just send back the same data, but upper-cased
            self.request.sendall(data.upper())


if __name__ == "__main__":
    HOST, PORT = "ec2-52-25-49-251.us-west-2.compute.amazonaws.com", 8080

    # Create the server, binding to localhost on port 9999
    with socketserver.TCPServer((HOST, PORT), MyTCPHandler) as server:
        # Activate the server; this will keep running until you
        # interrupt the program with Ctrl-C
        server.serve_forever()