def main() -> None:
    intervalo:int = 0
    x:int
    num:int
    for x in range(0,5):
        print("Digite o numero: ")
        num = int(input())
        if num >= 10:
            if num <= 150:
                intervalo = intervalo + 1
    print("Ao total, foram digitados ", intervalo,
          " numeros no intervalo entre 10 e 150\n")
    return

main()
