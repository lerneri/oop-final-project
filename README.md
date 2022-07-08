# projeto-final-poo
Projeto Final da disciplina de Programação Orientada a Objetos 
<br/>
Equipe:<br/>
Aiko Hilly Ribeiro de Paula 
Letícia Rodrigues Neri 
Lucas Fernando Torquato Cares 
Rodrigo da Silva Carvalho Maia 
Victor Viana Paiva 
<br/>
<br/>
Sistema: Gerenciamento de Restaurante
<br/>
Classes presentes no programa: Cardápio (que contém Prato e Bebida), Funcionários
(que contém Gerente, Garçom, Caixa), Mesa
Funcionamento do sistema: Existem interfaces diferentes para cada um dos tipos de
funcionário.
● O garçom tem permissão para adicionar pedidos (armazenados na mesa, que tem o
atributo conta) referentes às mesas alocadas para ele e encerrar a conta
adicionando uma taxa de serviço sobre o somatório dos preços dos itens do
cardápio;
● O caixa recebe os pagamentos, imprime a nota fiscal referente aos pedidos da mesa
e à taxa de serviço e reseta a mesa;
● O gerente pode dar descontos a uma determinada mesa e alocar ou desalocar
mesas para cada garçom.