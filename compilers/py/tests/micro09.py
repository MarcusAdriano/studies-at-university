def main() -> None:
    novopreco:float
    preco:float = float(input("Digite o preco: "))
    venda:float = float(input("Digite a venda: "))
    if venda < 500.0 or preco < 30.0:
        novopreco = preco + 10.0 / 100.0 * preco
    elif ((venda >= 500.0 and venda < 1200.0) or 
          (preco >= 30.0 and preco < 80.0)):
        novopreco = preco + 15.0 / 100.0 * preco
    elif venda >= 1200.0 or preco >= 80.0:
        novopreco = preco - 20.0 / 100.0 * preco

    print("O novo preco é:", novopreco)
    return

main()
