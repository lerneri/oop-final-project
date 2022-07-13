package backend;

import java.util.ArrayList;
import excecoes.*;

public class ConjuntoMesas implements IConjuntoMesas{

	private ArrayList<Mesa> mesas;	
	
	// CRIAR DOIS ARRAYLIST - MESAS OCUPADAS E MESAS LIVRES E IMPLEMENTAR OS POSS�VEIS ERROS
	
	public ArrayList<Mesa> getArrayMesas() throws ConjuntoMesasVazioException{
		if (mesas == null) {
			throw new ConjuntoMesasVazioException();
		}
		return this.mesas;
	}
	
	public void inserirMesa(Mesa mesa) throws MesaJaExistenteException{
		if(mesas != null) {
			for(int i=0; i<mesas.size(); i++) {
				if (mesas.get(i).getNumeroMesa().equals(mesa.getNumeroMesa())) {
					throw new MesaJaExistenteException();
				}
			}
			
		}else {
			mesas = new ArrayList<Mesa>();
		}
		mesas.add(mesa);
	}
	
	public void removerMesa(Mesa mesa) throws MesaInexistenteException{
		if(mesas == null || !(mesas.contains(mesa))){
			throw new MesaInexistenteException();
		} else {
			mesas.remove(mesa);
		}
	}
	
	public Mesa getMesa(String numeroMesa) throws MesaInexistenteException, ConjuntoMesasVazioException{
		
		if(mesas == null) {
			throw new ConjuntoMesasVazioException();
		}
		Mesa mesaProcurada = null;
		for (int i = 0; i < mesas.size(); i++) {
			if ((mesas.get(i).getNumeroMesa()).equals(numeroMesa)) {
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
