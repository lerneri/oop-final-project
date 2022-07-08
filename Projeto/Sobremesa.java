public class Sobremesa extends ItemCardapio{
  
  public Sobremesa(String codigo ,String descricao, String nome, double valor) throws CodigoInvalidoException{
    super (codigo, descricao, nome, valor, '3');
  }
}