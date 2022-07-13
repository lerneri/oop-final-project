package backend;

import java.util.ArrayList;

import excecoes.CodigoGarcomJaExistenteException;
import excecoes.ConjuntoGarcomVazioException;
import excecoes.GarcomInexistenteException;

public interface IConjuntoGarcons {
	
	public void inserirGarcom(Garcom garcom) throws CodigoGarcomJaExistenteException;
	
	public void removerGarcom(String codigoGarcom) throws GarcomInexistenteException;
	
	public Garcom getGarcom(String codigoGarcom) throws GarcomInexistenteException, ConjuntoGarcomVazioException;
	
}
