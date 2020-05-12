def main() -> None:
    numero:int = int(input("Digite um numero de 1 a 5: "))
    if numero == 1:
        print("Um")
    elif numero == 2:
        print("Dois")
    elif numero == 3:
        print("Tres")
    elif numero == 4:
        print("Quatro")
    elif numero == 5:
        print("Cinco")
    else:
        print("Numero Inválido!!!")
    return

main()
