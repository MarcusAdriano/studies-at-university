(* The type of the abstract syntax tree (AST). *)
type identificador = string
(* posicao no arquivo *)
type 'a pos = 'a * Lexing.position

type 'expr programa  = Programa of 'expr instrucoes 
and 'expr comandos 	 = 'expr comando list
and 'expr instrucoes = 'expr instrucao list
and 'expr expressoes = 'expr list
and 'expr instrucao  = 
	  Funcao of 'expr decfn
	| Cmd 	 of 'expr comando

and 'expr decfn = {
  fn_nome:    identificador pos;
  fn_tiporet: tipo;
  fn_formais: (identificador pos * tipo) list;
  fn_corpo:   'expr comandos
}
and tipo =
	  TipoInt
	| TipoStr
	| TipoBool
	| TipoFloat
	| TipoNone
and 'expr comando =
	  CmdAtrib  of 'expr * 'expr 
	| CmdIf	    of 'expr * ('expr comandos) * ('expr comando option)
	| CmdElse   of 'expr comandos
	| CmdWhile  of 'expr * 'expr comandos
	| CmdReturn of 'expr option
	| CmdPrint  of 'expr expressoes
	| CmdChmd 	of 'expr
	| CmdVarDec of 'expr * tipo
	| CmdVarDecAtrib of 'expr * tipo * 'expr
	| CmdInput  of tipo pos * ('expr expressoes)
and 'expr variaveis = ('expr variavel) list
and 'expr variavel = 
	| VarSimples of identificador pos

	
and operador = 
	  Mais
	| Menos
	| Mul
	| Div
	| Maior
	| Menor
	| MaiorIgual
	| MenorIgual
	| Igual
	| Difer
	| Elog
	| Oulog
	| Not 


