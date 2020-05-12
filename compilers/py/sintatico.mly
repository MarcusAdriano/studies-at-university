%{
open Ast
open Sast
%}

%token <int * int * token list>   Linha
%token <int * Lexing.position>    LITINT
%token <bool * Lexing.position>   LITBOOL
%token <float * Lexing.position>  LITFLOAT
%token <string * Lexing.position> LITSTRING
%token <string * Lexing.position> ID
%token <Lexing.position> DEF
%token <Lexing.position> RETURN
%token <Lexing.position> RANGE INPUT PRINT
%token <Lexing.position> I32 F32 STRING BOOL NONE
%token <Lexing.position> APAR FPAR
%token <Lexing.position> VIRG DPTOS SETA
%token <Lexing.position> OULOG ELOG NAO
%token <Lexing.position> MENOR MAIOR IGUAL MAIORIGUAL MENORIGUAL DIFERENTE
%token <Lexing.position> MAIS MENOS MUL DIV
%token <Lexing.position> ATRIB
%token <Lexing.position> IF ELIF ELSE
%token <Lexing.position> WHILE FOR IN
%token INDENTA DEDENTA
%token NOVALINHA
%token EOF

%left  OULOG
%left  ELOG 
%left  IGUAL DIFERENTE
%left  MAIOR MENOR MAIORIGUAL MENORIGUAL
%left  MAIS MENOS
%left  MUL DIV
%nonassoc unary_minus

%start <Sast.expressao Ast.programa> programa

%%

programa: ins= instrucao*
          EOF
          { Programa ins }

funcao: DEF  nome=ID 
        APAR args=separated_list(VIRG, parametro) FPAR
        SETA retorno=tipo DPTOS NOVALINHA
        INDENTA
        cmd=comandos
        DEDENTA
        { 
          Funcao {
            fn_nome    = nome;
            fn_tiporet = retorno;
            fn_formais = args;
            fn_corpo   = cmd
          } 
        }

parametro: nome = ID DPTOS t = tipo { (nome, t) }

instrucao: func=funcao   { func    }
         | cmd= comando  { Cmd cmd }

comandos: cmd=comando+ { cmd }
          
tipo: I32     { TipoInt   }
    | STRING  { TipoStr   }
    | BOOL    { TipoBool  }
    | F32     { TipoFloat }
    | NONE    { TipoNone  }

tipo_pos: pos = I32     { (TipoInt  , pos) }
        | pos = STRING  { (TipoStr  , pos) }
        | pos = BOOL    { (TipoBool , pos) }
        | pos = F32     { (TipoFloat, pos) }
        | pos = NONE    { (TipoNone , pos) }

comando: c=comando_vardec           { c }
       | c=comando_input            { c }
       | c=comando_atribuicao       { c }
       | c=comando_se               { c }
       | c=comando_while            { c }
       | c=comando_for              { c }  
       | c=comando_print            { c }
       | c=comando_chamada          { c }
       | c=comando_retorno          { c }

comando_vardec:  
    id = ID DPTOS t=tipo NOVALINHA  { CmdVarDec (ExpVar(VarSimples id), t) }
  | id = ID DPTOS t=tipo ATRIB e=expressao NOVALINHA  { CmdVarDecAtrib (ExpVar(VarSimples id), t, e) }

comando_atribuicao: id=ID ATRIB e=expressao NOVALINHA { 
  CmdAtrib (ExpVar(VarSimples id), e) 
}

comando_print: PRINT APAR args=separated_list(VIRG, expressao) FPAR NOVALINHA { CmdPrint args }

comando_se :  IF cond=expressao DPTOS NOVALINHA INDENTA entao=comandos DEDENTA
                 cmd1=option(comando_se2){ CmdIf (cond, entao, cmd1) }

comando_se2:  ELIF cond1=expressao DPTOS NOVALINHA INDENTA entao1=comandos DEDENTA
                   cmd1 =option(comando_se2){ CmdIf (cond1, entao1, cmd1) }
            | ELSE DPTOS NOVALINHA INDENTA cmd2=comandos DEDENTA { CmdElse cmd2 }

comando_while: WHILE cond=expressao DPTOS NOVALINHA INDENTA cmd=comando+ DEDENTA
            { CmdWhile(cond,cmd) }

comando_for: FOR v=ID IN RANGE APAR n1=expressao VIRG n2=expressao FPAR DPTOS NOVALINHA
             INDENTA
             cmd=comandos
             DEDENTA
             {  
                CmdIf ( ExpBool (true, snd v),
                        [ 
                          CmdAtrib (ExpVar(VarSimples v) , n1) ;
                          CmdWhile (
                            ExpOperB  ((Menor, snd v),
                                        ExpVar(VarSimples v), 
                                        n2
                                      ),
                            List.append cmd [CmdAtrib (ExpVar(VarSimples v) , 
                                            ExpOperB (
                                             (Mais, snd v), 
                                              ExpVar(VarSimples v), 
                                              ExpInt (1, snd v))
                                          )
                                        ]
                          )
                        ], 
                        None
                      ) 
            }

comando_input: t=tipo_pos APAR INPUT APAR e=separated_list(VIRG, expressao) FPAR FPAR { CmdInput(t,e) }

comando_chamada: exp=chamada NOVALINHA { CmdChmd exp }

chamada : nome=ID APAR args=separated_list(VIRG, expressao) FPAR { ExpChmd (nome, args) }

comando_retorno: RETURN e=expressao? NOVALINHA { CmdReturn e }

expressao:
      f=chamada   {          f }
    | x=variavel  { ExpVar   x }
    | c=comando_input { ExpInput c }
    | i=LITINT    { ExpInt   i }
    | f=LITFLOAT  { ExpFloat f }
    | s=LITSTRING { ExpStr   s }
    | b=LITBOOL   { ExpBool  b }
    | op=operU e=expressao %prec unary_minus { ExpOperU (op,e  ) }
    | l=expressao op=operB r=expressao       { ExpOperB (op,l,r) }
    | APAR e=expressao FPAR { e }

%inline operB:  
      pos = ELOG       { (Elog, pos)      }
    | pos = OULOG      { (Oulog,pos)      }
    | pos = MAIS       { (Mais, pos)      }
    | pos = MENOS      { (Menos,pos)      }
    | pos = MUL        { (Mul,  pos)      }
    | pos = DIV        { (Div,  pos)      }
    | pos = IGUAL      { (Igual,pos)      }
    | pos = DIFERENTE  { (Difer,pos)      }
    | pos = MAIOR      { (Maior,pos)      }
    | pos = MENOR      { (Menor,pos)      }
    | pos = MAIORIGUAL { (MaiorIgual,pos) }
    | pos = MENORIGUAL { (MenorIgual,pos) }
%inline operU:
    | pos = MENOS      { (Menos,pos)      }
    | pos = NAO        { (Not  ,pos)      }

variavel:
  | x = ID { VarSimples x }