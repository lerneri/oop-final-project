public class Mesa {
	private int numeroMesa;
	private Garcom garcom;

	public Garcom getGarcom() {
		return this.garcom;
	}
	
	public void setGarcom(Garcom garcom) {
		//tem que tirar a mesa do array de mesas do garçom antigo
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