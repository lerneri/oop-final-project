import java.util.ArrayList;

import Excecoes.GarcomInexistenteException;
import Excecoes.GarcomJaExistenteException;

public class ConjuntoGarcons {
	private static ArrayList<Garcom> garcons = new ArrayList<Garcom>();
	
	public void inserirGarcom(Garcom garcom) throws GarcomJaExistenteException{
		if(garcons != null && garcons.contains(garcom)) {
			throw new GarcomJaExistenteException();
		}else {
			garcons.add(garcom);
		}
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
	
	public static Garcom getGarcom(String codigo) throws GarcomInexistenteException{
		Garcom garcomProcurado = null;
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
	
	
	public ArrayList<Garcom> getArrayGarcons(){
		return this.garcons;
	}
}
