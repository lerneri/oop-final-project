public class Mesa {
	private String numeroMesa;
	private Garcom garcom;

	public Garcom getGarcom() {
		return this.garcom;
	}
	
	public void setGarcom(Garcom garcom) {
		
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