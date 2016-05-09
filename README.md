# Projeto - Caixa Eletrônico

Esse projeto Java visa simular um caixa eletrônico, onde sua premissa é fazer o saque devolvendo a menor quantidade de notas possível.
O Projeto está dividido em 3 partes:

<b>ce-core</b> Onde efetivamente fica a regra de saque, onde verifica o saldo do usuário e do caixa, validando assim o saque. Esse projeto roda na porta 9002.

<b>ce-crud</b> Onde é possível cadastrar, editar e remover o usuário, assim como, o caixa eletrônico. Este projeto roda na porta 9001.

<b>ce-ui</b> As telas feitas em AngularJs, para que os cadastros, edições e saque, possam ser realizados. Este projeto roda na porta 3000.


Para rodar os projetos Java, basta na pasta do projeto via bash, dar o comando spring-boot:run (sendo que este vai rodar no ambiente local) ou definir o profile <elephant> (-Dspring.profiles.active=elephant), para rodar no Banco de dados Elephant.
O projeto AngularJS, para rodar basta via bash dar o comando: npm start, uma vez que o node já está instalado.
