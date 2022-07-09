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

	public void alocarGarcomMesa(String numeroMesa, String codigoGarcom) throws GarcomInexistenteException, MesaInexistenteException{
		Garcom garcomProcurado = getGarcom(codigoGarcom);
		Mesa mesaProcurada = ConjuntoMesas.getMesa(numeroMesa);
		if (garcomProcurado==null) {
			throw new GarcomInexistenteException();
		}else if(mesaProcurada==null){
			throw new MesaInexistenteException();
		}else {
			if(garcomProcurado.getMesasGarcom() != null && !(garcomProcurado.getMesasGarcom().contains(mesaProcurada)))
			garcomProcurado.getMesasGarcom().add(mesaProcurada);
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