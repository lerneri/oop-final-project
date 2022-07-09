import java.util.*;

public class Gerente {
	private String nome;
	private ArrayList<Garcom> garcons;
	private ConjuntoMesas mesas;

	public Gerente(String nome) {
		this.nome = nome;
		this.garcons = new ArrayList<Garcom>();
	}

	public void inserirGarcomMesa(String numeroMesa, String codigoGarcom) throws GarcomInvalidoException, MesaInvalidaException{
		Garcom garcomProcurado = getGarcom(codigoGarcom);
		Mesa mesaProcurada = ConjuntoMesas.getMesa(numeroMesa);
		if (garcomProcurado==null) {
			throw new GarcomInvalidoException();
		}else if(mesaProcurada==null){
			throw new MesaInvalidaException();
		}else {
			mesaProcurada.setGarcom(garcomProcurado);
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