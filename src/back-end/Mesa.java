public class Mesa {
	private String numeroMesa;
	private Garcom garcom;

	public Garcom getGarcom() {
		return this.garcom;
	}
	
	public void setGarcom(Garcom garcom) {
		//tem que tirar a mesa do array de mesas do garçom antigo
		this.garcom = garcom;
	}

	public String getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(String numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public Mesa(String numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
}