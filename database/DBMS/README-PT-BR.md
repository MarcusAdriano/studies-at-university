# Gerenciamento de Banco de Dados

Trabalho desenvolvido para a disciplina de GBD da Universidade Federal de Uberlândia, disciplina ministrada pelo professor [Ilmério](http://www.facom.ufu.br/~ilmerio), da Faculdade de Computação.

Funcionalidades :+1::

 * Formatação de Arquivo (Heap File)
 * Inserção no final do arquivo sem alterar os demais registros
 * Alteração de um registro, sem alterar os demais
 * Deleção de registro, sem alterar os demais
 * Múltiplas páginas

O que falta :-1::

 * Estrutura de índice dinâmica (Tabela Hash ou Árvore B+)

# Tipos de Dados Suportados

* text - o tamanho máximo depende do tamanho de página utilizado, neste projeto 4 Kbytes
* int  - inteiro de 4 bytes

# Como funciona

1. É necessário criar um modelo de dados (metadados da tabela do banco de dados)
2. O nome do metados da tabela tem que ser exatamente o nome da tabela que se deseja criar acrescido da extensão ***.model**


Por exemplo, para criar uma entidade de amigos ***friends.table*** é necessário o seguinte metadados ***friends.table.model***:

```text
name : text
age  : int
```

# Organização dos Registros

O arquivo é organizado em páginas de **4096** bytes. Cada página possuí um campo que identifica o número de registros e um diretório que nada contém os ponteiros de onde estãos os registros na página. Um modelo detalhado é descrito no capítulo da 9 da terceira edição da tradução do livro **Raghu Ramakrishnan and Johannes Gehrke. 2000. Database Management Systems (2nd ed.). Osborne/McGraw-Hill, Berkeley, CA, USA.**

Afim de otimizar o espaço em página, os tipos primitivos de dados utilizados são:
 * *unsigned short* para o número de registros na página, ocupando **2 bytes**
 * *unsigned short* para cada elemento do diretório
 * *char** sendo que cada *char* em C ocupa 1 byte e uma *String* de tamanho ***N*** ocupa ***N + 1*** bytes
 * *int* ocupando ***4 bytes***

Cada registro em disco possuí um *header* contendo o tamanho de campo do registro e os dados do registro. Os elementos do *header* são do tipo *unsigned short* para reduzir o espaço utilizado na página.

# Estudo de Exemplo

Para o exemplo ***friends.table***, para salvar o meu nome e minha idade ("Marcus", 20) são necessários 7 bytes para o **text** e 4 bytes para o **int**. O registro completo contém um *header*, este *header* será nada menos que vetor de *unsigned short* contendo os valores **7** e **0**. O valor 7 indica que é um **text** de 7 bytes e o valor 0 é usado para designar **int**, toda vez que 0 for lido, significa que estamos lidando com **int**. Com isso, o espaço total ocupado por ("Marcus", 20) é **15 bytes** = 11 bytes dos dados do registro e 4 bytes do *header* do registro.

