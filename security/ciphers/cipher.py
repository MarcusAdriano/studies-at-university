from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes, padding, serialization
from cryptography.hazmat.primitives.asymmetric import dh, rsa, padding as as_padding
from cryptography.hazmat.primitives.kdf.hkdf import HKDF
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
import json

import base64

__DEFAULT_ENCODE = 'utf-8'

# bits (16 bytes)
__AES_BLOCK_SIZE = 128
IV = b'8492057321ABCDEF'


class DigitalSignature:
    __DEFAULT_ENCODE = 'utf-8'

    def __init__(self, priv_file, pub_file):
        with open(priv_file, 'rb') as key_file:
            self.private_key: rsa.RSAPrivateKey = serialization.load_pem_private_key(
                data=key_file.read(),
                password=None,
                backend=default_backend()
            )

        with open(pub_file, 'rb') as key_file:
            self.public_key: rsa.RSAPublicKey = serialization.load_pem_public_key(
                data=key_file.read(),
                backend=default_backend()
            )

    def sign(self, _data):
        try:
            signature:bytes = self.private_key.sign(
                data=bytes(_data, encoding=self.__DEFAULT_ENCODE),
                padding=as_padding.PKCS1v15(),
                algorithm=hashes.SHA256()
            )
            return json.dumps({'data': _data, 'sign': signature.hex()})
        except:
            return None

    def verify(self, json_bytes):
        try:
            json_data = json.loads(json_bytes)
            signature_hex = json_data['sign']
            signature = bytes.fromhex(signature_hex)
            data = json_data['data']

            self.public_key.verify(
                signature=signature,
                data=bytes(data, encoding=self.__DEFAULT_ENCODE),
                padding=as_padding.PKCS1v15(),
                algorithm=hashes.SHA256()
            )
            return True, data
        except Exception:
            return False, None


class DH:
    __PRIME_SIZE = 2048

    def __init__(self):
        with open('keys/dh/p', 'r') as p:
            self.__p = int(p.read(), 16)

        with open('keys/dh/g', 'r') as g:
            self.__g = int(g.read(), 16)

        with open('keys/dh/q', 'r') as q:
            self.__q = int(q.read(), 16)

        numbers: dh.DHParameterNumbers = dh.DHParameterNumbers(p=self.__p, g=self.__g, q=self.__q)
        self.__params: dh.DHParameters = numbers.parameters(backend=default_backend())

        self.__private_key: dh.DHPrivateKey = self.__params.generate_private_key()
        self.__public_key: dh.DHPublicKey = self.__private_key.public_key()
        self.__derived_key = None

    def get_public_key(self):
        return self.__public_key.public_numbers().y

    def exchange(self, y):
        pn = dh.DHParameterNumbers(self.__p, self.__g)
        pn.parameters(default_backend())
        peer_public_numbers = dh.DHPublicNumbers(y, pn)
        peer_public_key = peer_public_numbers.public_key(default_backend())

        shared_key = self.__private_key.exchange(peer_public_key)
        self.__derived_key = HKDF(
            algorithm=hashes.SHA256(),
            length=32,
            salt=None,
            info=None,
            backend=default_backend()
        ).derive(shared_key)
        del self.__private_key
        del self.__public_key
        del self.__params

    def get_aes_key(self):
        return self.__derived_key


def get_rsa_key(file):
    with open(file, 'r') as file:
        return file.read()


def aes_enc(key: bytes, data: bytes) -> bytes:
    cipher = Cipher(algorithms.AES(key), modes.CBC(IV), backend=default_backend())
    padder = padding.PKCS7(__AES_BLOCK_SIZE).padder()
    data_with_padding = padder.update(data) + padder.finalize()
    encryptor = cipher.encryptor()
    return encryptor.update(data_with_padding) + encryptor.finalize()


def aes_dec(key: bytes, ciphertext: bytes) -> bytes:
    cipher = Cipher(algorithms.AES(key), modes.CBC(IV), backend=default_backend())
    unpadder = padding.PKCS7(__AES_BLOCK_SIZE).unpadder()
    decipher = cipher.decryptor()
    plaintext = decipher.update(ciphertext) + decipher.finalize()
    return unpadder.update(plaintext) + unpadder.finalize()
