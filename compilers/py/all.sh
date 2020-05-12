
rm -rf _build

menhir -v --list-errors sintatico.mly > sintatico.msg

menhir sintatico.mly --compile-errors sintatico.msg > erroSint.ml

ocamlbuild -use-ocamlfind -use-menhir -menhir "menhir --table --unused-token Linha" -package menhirLib cod3endTest.byte