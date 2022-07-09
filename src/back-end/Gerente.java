import java.util.*;

public class Gerente {
	private String nome;
	private ConjuntoGarcons garcons;
	private ConjuntoMesas mesas;

	public Gerente(String nome) {
		this.nome = nome;
		this.garcons = new ConjuntoGarcons();
		this.mesas = new ConjuntoMesas();
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
		for (int i = 0; i < garcons.getArrayGarcons().size(); i++) {
			if (garcons.getArrayGarcons().get(i).getCodigo().equalsIgnoreCase(codigo)) {
				g = garcons.getArrayGarcons().get(i);
				break;
			}
		}
		return g;
	}
}