import java.util.*;

public class Garcom {
	private String nome;
	private String codigo;
	private ArrayList<Mesa> mesas;

	public ArrayList<Mesa> getMesasGarcom() {
		return this.mesas;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Garcom(String nome, String codigo) {
		this.codigo = codigo;
		this.nome = nome;
		mesas = new ArrayList<Mesa>();
	}

}