package backend;

import excecoes.CodigoItemInvalidoException;

public class ItemCardapio {
	private String codigo;
	private String nome;
	private String descricao;
	private double valor;

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


	public ItemCardapio(String codigo, String nome, String descricao, double valor) throws CodigoItemInvalidoException{
		for(byte b : codigo.getBytes()) {
			if(b<48 || b>57) {
				throw new CodigoItemInvalidoException();
			}
		}
		if(codigo.length()!=4) {
			throw new CodigoItemInvalidoException();
		}
		this.codigo = codigo;
		this.descricao = descricao;
		this.nome = nome;
		this.valor = valor;
	}
}