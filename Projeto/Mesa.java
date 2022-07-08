public class Mesa{
  private int numeroMesa;
  // private Garcom garcom;

  // public Garcom getGarcom(){
  //   return this.garcom;
  // }
  
  public int getMesa() {
		return numeroMesa;
	}
	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

  public Mesa(int numeroMesa){
    this.numeroMesa = numeroMesa;
  }
}