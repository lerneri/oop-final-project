# Projeto Final da disciplina de Programação Orientada a Objetos 


## Equipe:

Letícia Rodrigues Neri [@lerneri](https://github.com/lerneri) - Gerenciamento de projeto e GUI <br/>
Rodrigo da Silva Carvalho Maia [@RodrigoMaia03](https://github.com/RodrigoMaia03) - Back-end <br/>
Victor Viana Paiva [@victorvp9](https://github.com/victorvp9) - Back-end <br/>


## Sistema: Gerenciamento de Restaurante


### Classes presentes no programa:

Cardápio (que contém Prato e Bebida), Funcionários
(que contém Gerente, Garçom, Caixa), Mesa

### Funcionamento do sistema: 

Existem interfaces diferentes para cada um dos tipos de
funcionário.<br/>
● O garçom tem permissão para adicionar pedidos (armazenados na mesa, que tem o
atributo conta) referentes às mesas alocadas para ele e encerrar a conta
adicionando uma taxa de serviço sobre o somatório dos preços dos itens do
cardápio;<br/>
● O caixa recebe os pagamentos, imprime a nota fiscal referente aos pedidos da mesa<br/>
e à taxa de serviço e reseta a mesa;<br/>
● O gerente pode dar descontos a uma determinada mesa e alocar ou desalocar
mesas para cada garçom.<br/>
