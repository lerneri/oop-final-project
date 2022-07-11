public class Fachada {
	private static Fachada instancia = null;
	private Gerente gerente;
	private Cardapio cardapio;

	public static Fachada getInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	private Fachada() {
		gerente = new Gerente("Fernando Trinta");
		// cardapio = new Cardapio();
	}
}