def main() -> None:
    cel:float = 0.0
    far:float = 0.0
    print("Tabela de conversao: Celsius -> Fahrenheit\n")
    print("Digite a temperatura em Celsius: ")
    cel = float(input())
    far = (9.0 * cel + 160.0) / 5.0
    print("A nova temperatura é: ", far, " F")

main()

