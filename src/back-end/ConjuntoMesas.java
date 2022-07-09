import java.util.ArrayList;

public class ConjuntoMesas {

	private static ArrayList<Mesa> mesas;
	
	public static Mesa getMesa(String numeroMesa) {
		Mesa resposta = null;

		for (int i = 0; i < mesas.size(); i++) {
			if ((mesas.get(i).getNumeroMesa()) == numeroMesa) {
				resposta = mesas.get(i);
			}
		}

		return resposta;
	}

}
