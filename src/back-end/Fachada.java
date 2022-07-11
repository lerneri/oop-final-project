import java.io.IOException;

import Excecoes.CodigoInvalidoException;

public class Fachada {
	private static Fachada instancia = null;
	private Gerente gerente;
	private Cardapio cardapio;

	public static Fachada getInstancia() throws IOException, CodigoInvalidoException {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	private Fachada() throws IOException, CodigoInvalidoException {
		gerente = new Gerente("Fernando Trinta");
		cardapio = new Cardapio();
	}
}