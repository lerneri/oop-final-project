public class Bebida extends ItemCardapio{
  
  public Bebida(String codigo ,String descricao, String nome, double valor) throws CodigoInvalidoException{
    super (codigo, descricao, nome, valor, '4');
  }

}