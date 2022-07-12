package backend;

import java.util.ArrayList;
import excecoes.*;

public class ConjuntoMesas {

	private static ArrayList<Mesa> mesas;	
	
	// CRIAR DOIS ARRAYLIST - MESAS OCUPADAS E MESAS LIVRES E IMPLEMENTAR OS POSS�VEIS ERROS
	
	public static ArrayList<Mesa> getArrayMesas(){
		return mesas;
	}
	
	public void inserirMesa(Mesa mesa) throws MesaJaExistenteException{
		if(mesas != null && mesas.contains(mesa)) {
			throw new MesaJaExistenteException();
		}else {
			mesas.add(mesa);
		}
	}
	
	public static Mesa getMesa(String numeroMesa) throws MesaInexistenteException{
		Mesa mesaProcurada = null;

		for (int i = 0; i < mesas.size(); i++) {
			if ((mesas.get(i).getNumeroMesa()) == numeroMesa) {
				mesaProcurada = mesas.get(i);
			}
		}
		if(mesaProcurada== null) {
			throw new MesaInexistenteException();
		}else {
			return mesaProcurada;
		}
		
	}

}
