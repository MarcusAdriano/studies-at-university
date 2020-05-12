def main() -> None:
    print("Digite o primeiro numero: ")
    num1:int = int(input())
    print("Digite o segundo numero: ")
    num2:int = int(input())

    if num1 > num2:
        print("\nO primeiro numero",    num1, 
              "e maior que o segundo", num2)
    else:
        print("O segundo numero",       num2, 
              "e maior que o primeiro", num1)

main()
