public class ItemCardapio{
  String codigo;
  String descricao;
  String nome;
  double valor;

  public boolean conferirCodigo(char c){
    boolean ret = false;
    if(this.codigo.charAt(0)==c && codigo.length()== 4){
      ret = true;
    }
    return ret;
  }
  
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

  public ItemCardapio(String codigo, String descricao, String nome, double valor) throws CodigoInvalidoException{
    
    this.codigo = codigo;
    this.descricao = descricao;
    this.nome = nome;
    this.valor = valor;
  }
}