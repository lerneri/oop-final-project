package garcom;

import java.util.ArrayList;

import excecoes.GarcomInexistenteException;
import excecoes.CodigoGarcomJaExistenteException;
import excecoes.ConjuntoGarcomVazioException;

public class ConjuntoGarcons implements IConjuntoGarcons{
	private ArrayList<Garcom> garcons;
	
	public void inserirGarcom(Garcom garcom) throws CodigoGarcomJaExistenteException{
		if(garcons != null) {
			for(int i=0; i<garcons.size(); i++) {
				if(garcons.get(i).getCodigo().equals(garcom.getCodigo())) {
					throw new CodigoGarcomJaExistenteException();
				}
			}
				
		}else {
			garcons = new ArrayList<Garcom>();
		}
		garcons.add(garcom);
	}
	
	public void removerGarcom(String codigoGarcom) throws GarcomInexistenteException{
		boolean aux = false;
		for(int i=0; i < garcons.size(); i++) {
			if (garcons.get(i).getCodigo().equals(codigoGarcom)) {
				garcons.remove(i);
				aux = true;
				break;
			}
		}
		if (aux == false) {
			throw new GarcomInexistenteException();
		}
		
	}
	
	public Garcom getGarcom(String codigo) throws GarcomInexistenteException, ConjuntoGarcomVazioException{
		Garcom garcomProcurado = null;
		if (garcons==null) {
			throw new ConjuntoGarcomVazioException();
		}
		for (int i = 0; i < garcons.size(); i++) {
			if (garcons.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				garcomProcurado = garcons.get(i);
				break;
			}
		}
		if(garcomProcurado== null) {
			throw new GarcomInexistenteException();
		}else {
			return garcomProcurado;
		}
		
	}
	
	
	public ArrayList<Garcom> getArrayGarcons() throws ConjuntoGarcomVazioException{
		return this.garcons;
	}
	
	public ConjuntoGarcons() {
		
	}
}
