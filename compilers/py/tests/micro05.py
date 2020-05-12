def main() -> None:
    x:int
    m:int = 0
    h:int = 0
    nome:str = ""
    sexo:str = ""
    for x in range(0,1):
        nome = str(input("Digite o nome: "))
        sexo = str(input("H - Homem ou M - Mulher: "))
        if sexo == "H":
            h = h + 1
        elif sexo == "M":
            m = m + 1
        else:
            print("Sexo so pode ser H ou M!\n")

    print("\nForam inseridos ", h, " homens")
    print("\nForam inseridas ", m, " mulheres")
    return

main()
