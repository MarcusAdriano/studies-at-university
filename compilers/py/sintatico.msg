programa: DEF ID APAR FPAR SETA STRING DPTOS NOVALINHA INDENTA VIRG
##
## Ends in an error in state: 157.
##
## funcao -> DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA tipo DPTOS NOVALINHA INDENTA . comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF BOOL ]
##
## The known suffix of the stack is as follows:
## DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA tipo DPTOS NOVALINHA INDENTA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF ID APAR FPAR SETA STRING DPTOS NOVALINHA WHILE
##
## Ends in an error in state: 156.
##
## funcao -> DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA tipo DPTOS NOVALINHA . INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF BOOL ]
##
## The known suffix of the stack is as follows:
## DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA tipo DPTOS NOVALINHA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF ID APAR FPAR SETA STRING DPTOS WHILE
##
## Ends in an error in state: 155.
##
## funcao -> DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA tipo DPTOS . NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF BOOL ]
##
## The known suffix of the stack is as follows:
## DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA tipo DPTOS
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF ID APAR FPAR SETA STRING WHILE
##
## Ends in an error in state: 154.
##
## funcao -> DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA tipo . DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF BOOL ]
##
## The known suffix of the stack is as follows:
## DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA tipo
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF ID APAR FPAR SETA WHILE
##
## Ends in an error in state: 153.
##
## funcao -> DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA . tipo DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF BOOL ]
##
## The known suffix of the stack is as follows:
## DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF ID APAR FPAR WHILE
##
## Ends in an error in state: 152.
##
## funcao -> DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR . SETA tipo DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF BOOL ]
##
## The known suffix of the stack is as follows:
## DEF ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF ID APAR ID DPTOS BOOL VIRG WHILE
##
## Ends in an error in state: 149.
##
## separated_nonempty_list(VIRG,parametro) -> parametro VIRG . separated_nonempty_list(VIRG,parametro) [ FPAR ]
##
## The known suffix of the stack is as follows:
## parametro VIRG
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF ID APAR ID DPTOS BOOL WHILE
##
## Ends in an error in state: 148.
##
## separated_nonempty_list(VIRG,parametro) -> parametro . [ FPAR ]
## separated_nonempty_list(VIRG,parametro) -> parametro . VIRG separated_nonempty_list(VIRG,parametro) [ FPAR ]
##
## The known suffix of the stack is as follows:
## parametro
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF ID APAR ID DPTOS WHILE
##
## Ends in an error in state: 145.
##
## parametro -> ID DPTOS . tipo [ VIRG FPAR ]
##
## The known suffix of the stack is as follows:
## ID DPTOS
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF ID APAR ID WHILE
##
## Ends in an error in state: 144.
##
## parametro -> ID . DPTOS tipo [ VIRG FPAR ]
##
## The known suffix of the stack is as follows:
## ID
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF ID APAR WHILE
##
## Ends in an error in state: 143.
##
## funcao -> DEF ID APAR . loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA tipo DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF BOOL ]
##
## The known suffix of the stack is as follows:
## DEF ID APAR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF ID WHILE
##
## Ends in an error in state: 142.
##
## funcao -> DEF ID . APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA tipo DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF BOOL ]
##
## The known suffix of the stack is as follows:
## DEF ID
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: DEF WHILE
##
## Ends in an error in state: 141.
##
## funcao -> DEF . ID APAR loption(separated_nonempty_list(VIRG,parametro)) FPAR SETA tipo DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF BOOL ]
##
## The known suffix of the stack is as follows:
## DEF
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR ID IN RANGE APAR LITSTRING VIRG LITSTRING FPAR DPTOS NOVALINHA INDENTA VIRG
##
## Ends in an error in state: 104.
##
## comando_for -> FOR ID IN RANGE APAR expressao VIRG expressao FPAR DPTOS NOVALINHA INDENTA . comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## FOR ID IN RANGE APAR expressao VIRG expressao FPAR DPTOS NOVALINHA INDENTA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR ID IN RANGE APAR LITSTRING VIRG LITSTRING FPAR DPTOS NOVALINHA WHILE
##
## Ends in an error in state: 103.
##
## comando_for -> FOR ID IN RANGE APAR expressao VIRG expressao FPAR DPTOS NOVALINHA . INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## FOR ID IN RANGE APAR expressao VIRG expressao FPAR DPTOS NOVALINHA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR ID IN RANGE APAR LITSTRING VIRG LITSTRING FPAR DPTOS WHILE
##
## Ends in an error in state: 102.
##
## comando_for -> FOR ID IN RANGE APAR expressao VIRG expressao FPAR DPTOS . NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## FOR ID IN RANGE APAR expressao VIRG expressao FPAR DPTOS
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR ID IN RANGE APAR LITSTRING VIRG LITSTRING FPAR WHILE
##
## Ends in an error in state: 101.
##
## comando_for -> FOR ID IN RANGE APAR expressao VIRG expressao FPAR . DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## FOR ID IN RANGE APAR expressao VIRG expressao FPAR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR ID IN RANGE APAR LITSTRING VIRG LITSTRING WHILE
##
## Ends in an error in state: 100.
##
## comando_for -> FOR ID IN RANGE APAR expressao VIRG expressao . FPAR DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
## expressao -> expressao . ELOG expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## FOR ID IN RANGE APAR expressao VIRG expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR ID IN RANGE APAR LITSTRING VIRG WHILE
##
## Ends in an error in state: 99.
##
## comando_for -> FOR ID IN RANGE APAR expressao VIRG . expressao FPAR DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## FOR ID IN RANGE APAR expressao VIRG
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR ID IN RANGE APAR LITSTRING WHILE
##
## Ends in an error in state: 98.
##
## comando_for -> FOR ID IN RANGE APAR expressao . VIRG expressao FPAR DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
## expressao -> expressao . ELOG expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## FOR ID IN RANGE APAR expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR ID IN RANGE APAR WHILE
##
## Ends in an error in state: 97.
##
## comando_for -> FOR ID IN RANGE APAR . expressao VIRG expressao FPAR DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## FOR ID IN RANGE APAR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR ID IN RANGE WHILE
##
## Ends in an error in state: 96.
##
## comando_for -> FOR ID IN RANGE . APAR expressao VIRG expressao FPAR DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## FOR ID IN RANGE
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR ID IN WHILE
##
## Ends in an error in state: 95.
##
## comando_for -> FOR ID IN . RANGE APAR expressao VIRG expressao FPAR DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## FOR ID IN
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR ID WHILE
##
## Ends in an error in state: 94.
##
## comando_for -> FOR ID . IN RANGE APAR expressao VIRG expressao FPAR DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## FOR ID
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: FOR WHILE
##
## Ends in an error in state: 93.
##
## comando_for -> FOR . ID IN RANGE APAR expressao VIRG expressao FPAR DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## FOR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: ID APAR FPAR WHILE
##
## Ends in an error in state: 119.
##
## comando_chamada -> chamada . NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## chamada
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: ID APAR WHILE
##
## Ends in an error in state: 11.
##
## chamada -> ID APAR . loption(separated_nonempty_list(VIRG,expressao)) FPAR [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## ID APAR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: ID ATRIB LITSTRING WHILE
##
## Ends in an error in state: 91.
##
## comando_atribuicao -> ID ATRIB expressao . NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
## expressao -> expressao . ELOG expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## ID ATRIB expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: ID ATRIB WHILE
##
## Ends in an error in state: 90.
##
## comando_atribuicao -> ID ATRIB . expressao NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ID ATRIB
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: ID DPTOS STRING ATRIB LITSTRING WHILE
##
## Ends in an error in state: 88.
##
## comando_vardec -> ID DPTOS tipo ATRIB expressao . NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
## expressao -> expressao . ELOG expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## ID DPTOS tipo ATRIB expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: ID DPTOS STRING ATRIB WHILE
##
## Ends in an error in state: 87.
##
## comando_vardec -> ID DPTOS tipo ATRIB . expressao NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ID DPTOS tipo ATRIB
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: ID DPTOS STRING WHILE
##
## Ends in an error in state: 85.
##
## comando_vardec -> ID DPTOS tipo . NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
## comando_vardec -> ID DPTOS tipo . ATRIB expressao NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ID DPTOS tipo
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: ID DPTOS WHILE
##
## Ends in an error in state: 79.
##
## comando_vardec -> ID DPTOS . tipo NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
## comando_vardec -> ID DPTOS . tipo ATRIB expressao NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ID DPTOS
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: ID WHILE
##
## Ends in an error in state: 78.
##
## chamada -> ID . APAR loption(separated_nonempty_list(VIRG,expressao)) FPAR [ NOVALINHA ]
## comando_atribuicao -> ID . ATRIB expressao NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
## comando_vardec -> ID . DPTOS tipo NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
## comando_vardec -> ID . DPTOS tipo ATRIB expressao NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ID
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA ELIF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA VIRG
##
## Ends in an error in state: 135.
##
## comando_se2 -> ELIF expressao DPTOS NOVALINHA INDENTA comandos DEDENTA . option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ELIF expressao DPTOS NOVALINHA INDENTA comandos DEDENTA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA ELIF LITSTRING DPTOS NOVALINHA INDENTA VIRG
##
## Ends in an error in state: 133.
##
## comando_se2 -> ELIF expressao DPTOS NOVALINHA INDENTA . comandos DEDENTA option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ELIF expressao DPTOS NOVALINHA INDENTA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA ELIF LITSTRING DPTOS NOVALINHA WHILE
##
## Ends in an error in state: 132.
##
## comando_se2 -> ELIF expressao DPTOS NOVALINHA . INDENTA comandos DEDENTA option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ELIF expressao DPTOS NOVALINHA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA ELIF LITSTRING DPTOS WHILE
##
## Ends in an error in state: 131.
##
## comando_se2 -> ELIF expressao DPTOS . NOVALINHA INDENTA comandos DEDENTA option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ELIF expressao DPTOS
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA ELIF LITSTRING WHILE
##
## Ends in an error in state: 130.
##
## comando_se2 -> ELIF expressao . DPTOS NOVALINHA INDENTA comandos DEDENTA option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
## expressao -> expressao . ELOG expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## ELIF expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA ELIF WHILE
##
## Ends in an error in state: 129.
##
## comando_se2 -> ELIF . expressao DPTOS NOVALINHA INDENTA comandos DEDENTA option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ELIF
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA ELSE DPTOS NOVALINHA INDENTA VIRG
##
## Ends in an error in state: 126.
##
## comando_se2 -> ELSE DPTOS NOVALINHA INDENTA . comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ELSE DPTOS NOVALINHA INDENTA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA ELSE DPTOS NOVALINHA WHILE
##
## Ends in an error in state: 125.
##
## comando_se2 -> ELSE DPTOS NOVALINHA . INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ELSE DPTOS NOVALINHA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA ELSE DPTOS WHILE
##
## Ends in an error in state: 124.
##
## comando_se2 -> ELSE DPTOS . NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ELSE DPTOS
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA ELSE WHILE
##
## Ends in an error in state: 123.
##
## comando_se2 -> ELSE . DPTOS NOVALINHA INDENTA comandos DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## ELSE
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA DEDENTA VIRG
##
## Ends in an error in state: 122.
##
## comando_se -> IF expressao DPTOS NOVALINHA INDENTA comandos DEDENTA . option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## IF expressao DPTOS NOVALINHA INDENTA comandos DEDENTA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA INDENTA VIRG
##
## Ends in an error in state: 77.
##
## comando_se -> IF expressao DPTOS NOVALINHA INDENTA . comandos DEDENTA option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## IF expressao DPTOS NOVALINHA INDENTA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS NOVALINHA WHILE
##
## Ends in an error in state: 76.
##
## comando_se -> IF expressao DPTOS NOVALINHA . INDENTA comandos DEDENTA option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## IF expressao DPTOS NOVALINHA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING DPTOS WHILE
##
## Ends in an error in state: 75.
##
## comando_se -> IF expressao DPTOS . NOVALINHA INDENTA comandos DEDENTA option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## IF expressao DPTOS
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF LITSTRING WHILE
##
## Ends in an error in state: 74.
##
## comando_se -> IF expressao . DPTOS NOVALINHA INDENTA comandos DEDENTA option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
## expressao -> expressao . ELOG expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## IF expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: IF WHILE
##
## Ends in an error in state: 73.
##
## comando_se -> IF . expressao DPTOS NOVALINHA INDENTA comandos DEDENTA option(comando_se2) [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## IF
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: PRINT APAR FPAR WHILE
##
## Ends in an error in state: 71.
##
## comando_print -> PRINT APAR loption(separated_nonempty_list(VIRG,expressao)) FPAR . NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## PRINT APAR loption(separated_nonempty_list(VIRG,expressao)) FPAR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: PRINT APAR LITSTRING VIRG WHILE
##
## Ends in an error in state: 26.
##
## separated_nonempty_list(VIRG,expressao) -> expressao VIRG . separated_nonempty_list(VIRG,expressao) [ FPAR ]
##
## The known suffix of the stack is as follows:
## expressao VIRG
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: PRINT APAR LITSTRING WHILE
##
## Ends in an error in state: 25.
##
## expressao -> expressao . ELOG expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## separated_nonempty_list(VIRG,expressao) -> expressao . [ FPAR ]
## separated_nonempty_list(VIRG,expressao) -> expressao . VIRG separated_nonempty_list(VIRG,expressao) [ FPAR ]
##
## The known suffix of the stack is as follows:
## expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: PRINT APAR WHILE
##
## Ends in an error in state: 69.
##
## comando_print -> PRINT APAR . loption(separated_nonempty_list(VIRG,expressao)) FPAR NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## PRINT APAR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: PRINT WHILE
##
## Ends in an error in state: 68.
##
## comando_print -> PRINT . APAR loption(separated_nonempty_list(VIRG,expressao)) FPAR NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## PRINT
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: RETURN LITSTRING WHILE
##
## Ends in an error in state: 67.
##
## expressao -> expressao . ELOG expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DIV DIFERENTE ]
## option(expressao) -> expressao . [ NOVALINHA ]
##
## The known suffix of the stack is as follows:
## expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: RETURN NOVALINHA VIRG
##
## Ends in an error in state: 163.
##
## list(instrucao) -> instrucao . list(instrucao) [ EOF ]
##
## The known suffix of the stack is as follows:
## instrucao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: RETURN WHILE
##
## Ends in an error in state: 64.
##
## comando_retorno -> RETURN . option(expressao) NOVALINHA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## RETURN
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: STRING APAR INPUT APAR FPAR WHILE
##
## Ends in an error in state: 23.
##
## comando_input -> tipo_pos APAR INPUT APAR loption(separated_nonempty_list(VIRG,expressao)) FPAR . FPAR [ WHILE VIRG STRING RETURN PRINT OULOG NOVALINHA NONE MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL IF ID I32 FPAR FOR F32 EOF ELOG DPTOS DIV DIFERENTE DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## tipo_pos APAR INPUT APAR loption(separated_nonempty_list(VIRG,expressao)) FPAR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: STRING APAR INPUT APAR WHILE
##
## Ends in an error in state: 20.
##
## comando_input -> tipo_pos APAR INPUT APAR . loption(separated_nonempty_list(VIRG,expressao)) FPAR FPAR [ WHILE VIRG STRING RETURN PRINT OULOG NOVALINHA NONE MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL IF ID I32 FPAR FOR F32 EOF ELOG DPTOS DIV DIFERENTE DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## tipo_pos APAR INPUT APAR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: STRING APAR INPUT WHILE
##
## Ends in an error in state: 19.
##
## comando_input -> tipo_pos APAR INPUT . APAR loption(separated_nonempty_list(VIRG,expressao)) FPAR FPAR [ WHILE VIRG STRING RETURN PRINT OULOG NOVALINHA NONE MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL IF ID I32 FPAR FOR F32 EOF ELOG DPTOS DIV DIFERENTE DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## tipo_pos APAR INPUT
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: STRING APAR WHILE
##
## Ends in an error in state: 18.
##
## comando_input -> tipo_pos APAR . INPUT APAR loption(separated_nonempty_list(VIRG,expressao)) FPAR FPAR [ WHILE VIRG STRING RETURN PRINT OULOG NOVALINHA NONE MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL IF ID I32 FPAR FOR F32 EOF ELOG DPTOS DIV DIFERENTE DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## tipo_pos APAR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: STRING WHILE
##
## Ends in an error in state: 17.
##
## comando_input -> tipo_pos . APAR INPUT APAR loption(separated_nonempty_list(VIRG,expressao)) FPAR FPAR [ WHILE VIRG STRING RETURN PRINT OULOG NOVALINHA NONE MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL IF ID I32 FPAR FOR F32 EOF ELOG DPTOS DIV DIFERENTE DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## tipo_pos
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: VIRG
##
## Ends in an error in state: 0.
##
## programa' -> . programa [ # ]
##
## The known suffix of the stack is as follows:
##
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE APAR LITSTRING WHILE
##
## Ends in an error in state: 54.
##
## expressao -> expressao . ELOG expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DIV DIFERENTE ]
## expressao -> APAR expressao . FPAR [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## APAR expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE APAR WHILE
##
## Ends in an error in state: 15.
##
## expressao -> APAR . expressao FPAR [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## APAR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE ID WHILE
##
## Ends in an error in state: 10.
##
## chamada -> ID . APAR loption(separated_nonempty_list(VIRG,expressao)) FPAR [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## variavel -> ID . [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## ID
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING DIFERENTE LITSTRING WHILE
##
## Ends in an error in state: 53.
##
## expressao -> expressao . ELOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao DIFERENTE expressao . [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao DIFERENTE expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING DIFERENTE WHILE
##
## Ends in an error in state: 52.
##
## expressao -> expressao DIFERENTE . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao DIFERENTE
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING DIV WHILE
##
## Ends in an error in state: 36.
##
## expressao -> expressao DIV . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao DIV
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING DPTOS NOVALINHA INDENTA RETURN NOVALINHA VIRG
##
## Ends in an error in state: 117.
##
## nonempty_list(comando) -> comando . [ DEDENTA ]
## nonempty_list(comando) -> comando . nonempty_list(comando) [ DEDENTA ]
##
## The known suffix of the stack is as follows:
## comando
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING DPTOS NOVALINHA INDENTA VIRG
##
## Ends in an error in state: 63.
##
## comando_while -> WHILE expressao DPTOS NOVALINHA INDENTA . nonempty_list(comando) DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## WHILE expressao DPTOS NOVALINHA INDENTA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING DPTOS NOVALINHA WHILE
##
## Ends in an error in state: 62.
##
## comando_while -> WHILE expressao DPTOS NOVALINHA . INDENTA nonempty_list(comando) DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## WHILE expressao DPTOS NOVALINHA
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING DPTOS WHILE
##
## Ends in an error in state: 61.
##
## comando_while -> WHILE expressao DPTOS . NOVALINHA INDENTA nonempty_list(comando) DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## WHILE expressao DPTOS
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING ELOG LITSTRING WHILE
##
## Ends in an error in state: 51.
##
## expressao -> expressao . ELOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao ELOG expressao . [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao ELOG expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING ELOG WHILE
##
## Ends in an error in state: 50.
##
## expressao -> expressao ELOG . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao ELOG
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING IGUAL LITSTRING WHILE
##
## Ends in an error in state: 49.
##
## expressao -> expressao . ELOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao IGUAL expressao . [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao IGUAL expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING IGUAL WHILE
##
## Ends in an error in state: 48.
##
## expressao -> expressao IGUAL . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao IGUAL
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MAIOR LITSTRING WHILE
##
## Ends in an error in state: 47.
##
## expressao -> expressao . ELOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao MAIOR expressao . [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MAIOR expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MAIOR WHILE
##
## Ends in an error in state: 46.
##
## expressao -> expressao MAIOR . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MAIOR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MAIORIGUAL LITSTRING WHILE
##
## Ends in an error in state: 45.
##
## expressao -> expressao . ELOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao MAIORIGUAL expressao . [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MAIORIGUAL expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MAIORIGUAL WHILE
##
## Ends in an error in state: 44.
##
## expressao -> expressao MAIORIGUAL . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MAIORIGUAL
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MAIS LITSTRING WHILE
##
## Ends in an error in state: 41.
##
## expressao -> expressao . ELOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao MAIS expressao . [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MAIS expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MAIS WHILE
##
## Ends in an error in state: 40.
##
## expressao -> expressao MAIS . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MAIS
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MENOR LITSTRING WHILE
##
## Ends in an error in state: 43.
##
## expressao -> expressao . ELOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao MENOR expressao . [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MENOR expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MENOR WHILE
##
## Ends in an error in state: 42.
##
## expressao -> expressao MENOR . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MENOR
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MENORIGUAL LITSTRING WHILE
##
## Ends in an error in state: 39.
##
## expressao -> expressao . ELOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao MENORIGUAL expressao . [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MENORIGUAL expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MENORIGUAL WHILE
##
## Ends in an error in state: 38.
##
## expressao -> expressao MENORIGUAL . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MENORIGUAL
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MENOS LITSTRING WHILE
##
## Ends in an error in state: 35.
##
## expressao -> expressao . ELOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao MENOS expressao . [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MENOS expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MENOS WHILE
##
## Ends in an error in state: 34.
##
## expressao -> expressao MENOS . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MENOS
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING MUL WHILE
##
## Ends in an error in state: 32.
##
## expressao -> expressao MUL . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao MUL
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING OULOG LITSTRING WHILE
##
## Ends in an error in state: 31.
##
## expressao -> expressao . ELOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao OULOG expressao . [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao OULOG expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING OULOG WHILE
##
## Ends in an error in state: 30.
##
## expressao -> expressao OULOG . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## expressao OULOG
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE LITSTRING WHILE
##
## Ends in an error in state: 60.
##
## comando_while -> WHILE expressao . DPTOS NOVALINHA INDENTA nonempty_list(comando) DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
## expressao -> expressao . ELOG expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . OULOG expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIS expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOS expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MUL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIV expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . IGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . DIFERENTE expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIOR expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENOR expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MAIORIGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
## expressao -> expressao . MENORIGUAL expressao [ OULOG MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## WHILE expressao
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE MENOS WHILE
##
## Ends in an error in state: 5.
##
## expressao -> MENOS . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## MENOS
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE NAO WHILE
##
## Ends in an error in state: 4.
##
## expressao -> NAO . expressao [ VIRG OULOG NOVALINHA MUL MENOS MENORIGUAL MENOR MAIS MAIORIGUAL MAIOR IGUAL FPAR ELOG DPTOS DIV DIFERENTE ]
##
## The known suffix of the stack is as follows:
## NAO
##

<YOUR SYNTAX ERROR MESSAGE HERE>

programa: WHILE WHILE
##
## Ends in an error in state: 1.
##
## comando_while -> WHILE . expressao DPTOS NOVALINHA INDENTA nonempty_list(comando) DEDENTA [ WHILE STRING RETURN PRINT NONE IF ID I32 FOR F32 EOF DEF DEDENTA BOOL ]
##
## The known suffix of the stack is as follows:
## WHILE
##

<YOUR SYNTAX ERROR MESSAGE HERE>

