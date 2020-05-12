def main() -> None:
	print("Digite um numero:  ")
	numero:int = int(input())
	if numero >= 100:
		if numero <= 200:
			print("\n numero entre 100 e 200")
		else:
			print("\n numero maior que 200")
	else:
		print("\n numero menor que 100")
	return
main()
