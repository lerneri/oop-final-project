public class Mesa {
	private int numeroMesa;
	private Garcom garcom;

	public Garcom getGarcom() {
		return this.garcom;
	}
	
	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public Mesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
}