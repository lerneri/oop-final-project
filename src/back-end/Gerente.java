import java.util.*;

public class Gerente {
	String nome;
	ArrayList<Garcom> garcons;

	public Gerente(String nome, ArrayList<Garcom> garcons) {
		this.nome = nome;
		this.garcons = garcons;
	}

	public void inserirGarcomMesa(String numeroMesa, String codigoGarcom) throws GarcomInvalidoException, MesaInvalidaException{
		Garcom procurado = getGarcom(codigoGarcom);
		if (procurado==null) {
			throw new GarcomInvalidoException();
		}
	}

	public Garcom getGarcom(String codigo) {
		Garcom g = null;
		for (int i = 0; i < garcons.size(); i++) {
			if (garcons.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				g = garcons.get(i);
				break;
			}
		}
		return g;
	}
}