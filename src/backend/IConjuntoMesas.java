package backend;

import java.util.ArrayList;

import excecoes.MesaInexistenteException;
import excecoes.MesaJaExistenteException;

public interface IConjuntoMesas {
	public void inserirMesa(Mesa mesa) throws MesaJaExistenteException;
	
	public void removerMesa(Mesa mesa) throws MesaInexistenteException;
	
	public Mesa getMesa(String numeroMesa) throws MesaInexistenteException;
	
	public ArrayList<Mesa> getArrayMesas();	
}
