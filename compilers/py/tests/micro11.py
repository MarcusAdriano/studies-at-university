def verifica(n:int) -> int:
    res: int
    if n > 0:
        res = 1
    elif n < 0:
        res = -1
    else:
        res = 0
    return res

def main() -> None:
    numero:int = int(input("Digite um numero: "))
    x:int = verifica(numero)
    if x == 1:
        print("Positivo")
    elif x == 0:
        print("zero")
    else:
        print("Negativo")
    return

main()
