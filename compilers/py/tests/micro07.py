def main() -> None:
    numero:int = 0
    programa:int = 1
    opc:str = ""
    while programa == 1:
        numero = int(input("Digite um numero: "))
        if numero > 0:
            print("Positivo")
        else:
            if numero == 0:
                print("O numero é igual a 0")
            elif numero < 0:
                print("Negativo")

        opc = str(input("Deseja Finalizar? (S/N) :"))
        if opc == "S":
            programa = 0
    return

main()
