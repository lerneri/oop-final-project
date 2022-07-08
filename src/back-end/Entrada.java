public class Entrada extends ItemCardapio{
  
  public Entrada(String codigo ,String descricao, String nome, double valor) throws CodigoInvalidoException{
    super (codigo, descricao, nome, valor, '1');
  }
  
}