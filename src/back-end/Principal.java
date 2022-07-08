public class Principal extends ItemCardapio{
  
  public Principal(String codigo ,String descricao, String nome, double valor)throws CodigoInvalidoException{
    super (codigo, descricao, nome, valor, '2');
  }
}