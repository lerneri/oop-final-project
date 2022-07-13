package backend;

import java.util.ArrayList;
import excecoes.*;

public class ConjuntoMesas implements IConjuntoMesas{

	private static ArrayList<Mesa> mesas;	
	
	// CRIAR DOIS ARRAYLIST - MESAS OCUPADAS E MESAS LIVRES E IMPLEMENTAR OS POSS�VEIS ERROS
	
	public ArrayList<Mesa> getArrayMesas(){
		return ConjuntoMesas.mesas;
	}
	
	public void inserirMesa(Mesa mesa) throws MesaJaExistenteException{
		if(mesas != null && mesas.contains(mesa)) {
			throw new MesaJaExistenteException();
		}else {
			mesas.add(mesa);
		}
	}
	
	public void removerMesa(Mesa mesa) throws MesaInexistenteException{
		if(mesas == null || !(mesas.contains(mesa))){
			throw new MesaInexistenteException();
		} else {
			mesas.remove(mesa);
		}
	}
	
	public Mesa getMesa(String numeroMesa) throws MesaInexistenteException{
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
