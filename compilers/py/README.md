# Construção de Compiladores

Disciplina do curso de Ciência da Computação da Universidade Federal de Uberlândia (UFU).

Esta foi a última feature implementada para gerar código intermediário, **código de três endereços**.

## Requisitos mínimos

* ocaml: The OCaml toplevel, version 4.07.1
* rlwrap (optional)

#### Dependências Ocaml

* menhir
```bash
opam install menhir
```

## Compilação

Há um arquivo SH pré-configurado que ajuda gerar as mensagens de erro, logo basta executar:

```bash
./all.sh
```

Caso queira compilar somente o cod3endTest.ml para executar o tradutor de código de três endereços, basta executar:

```bash
ocamlbuild -use-ocamlfind -use-menhir -menhir "menhir --table --unused-token Linha" -package menhirLib cod3endTest.byte
```

## Testes

Abrindo o ocaml:

```bash
rlwrap ocaml
```

Para verificar o tradutor, utilize:

```bash
let cod = traduz "tests/micro09.py" in imprime_traducao cod;;
```

Será possível visualizar o código de três endereços. Se quiser obter o código sem tradução:

```bash
traduz "tests/micro09.py";;
```

