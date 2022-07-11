import java.io.IOException;
import java.util.ArrayList;

import Excecoes.CodigoInvalidoException;
import Excecoes.GarcomInexistenteException;
import Excecoes.GarcomJaExistenteException;
import Excecoes.MesaInexistenteException;
import Excecoes.MesaJaExistenteException;

public class Fachada {
	private static Fachada instancia = null;
	private Gerente gerente;
	private Cardapio cardapio;
	private ConjuntoMesas conjuntoMesas;
	private ConjuntoGarcons conjuntoGarcons;

	
	public static Fachada getInstancia() throws IOException, CodigoInvalidoException {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	private Fachada() throws IOException, CodigoInvalidoException {
		gerente = new Gerente("Fernando Trinta");
		cardapio = new Cardapio();
		conjuntoMesas = new ConjuntoMesas();
		conjuntoGarcons = new ConjuntoGarcons();
	}
	
}