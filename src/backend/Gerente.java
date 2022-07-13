package backend;

import java.io.IOException;
import java.util.*;

import excecoes.*;

public class Gerente {
	private String nome;

	public Gerente(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Mesa> getMesasLivres() throws ConjuntoMesasVazioException, IOException, CodigoItemInvalidoException{
		ArrayList<Mesa> resposta = null;
		for (int i=0; i<Fachada.getInstancia().getConjuntoMesas().getArrayMesas().size(); i++) {
			if(Fachada.getInstancia().getConjuntoMesas().getArrayMesas().get(i).isOcupada()==false) {
				resposta.add(Fachada.getInstancia().getConjuntoMesas().getArrayMesas().get(i));
			}
		}
		return resposta;
	}

	//public void desconto(String numeroMesa, double porcentagem) {
	//	Mesa m = mesas.getMesa(numeroMesa);
	//	m.getPedido();
	//}
	
	
	public void cadastrarMesa(String numeroMesa) throws MesaJaExistenteException, NumeroMesaInvalidoException, IOException, CodigoItemInvalidoException {
		Mesa mesa = new Mesa(numeroMesa);
		Fachada.getInstancia().getConjuntoMesas().inserirMesa(mesa);
	}
	
	public void removerMesa(String numeroMesa) throws MesaInexistenteException, NumeroMesaInvalidoException, IOException, CodigoItemInvalidoException {
		Mesa mesa = new Mesa(numeroMesa);
		Fachada.getInstancia().getConjuntoMesas().removerMesa(mesa);
	}
	
	public void cadastrarGarcom(String nome, String codigo) throws CodigoGarcomJaExistenteException, CodigoGarcomInvalidoException, NomeInvalidoException, IOException, CodigoItemInvalidoException{
		Garcom garcom = new Garcom(nome, codigo);
		Fachada.getInstancia().getConjuntoGarcons().inserirGarcom(garcom);
	}
	
	
	public void removerGarcom(Garcom garcom) throws GarcomInexistenteException, IOException, CodigoItemInvalidoException{
		Fachada.getInstancia().getConjuntoGarcons().removerGarcom(garcom.getCodigo());
	}
	
	
	public void alocarGarcomMesa(String numeroMesa, String codigoGarcom) throws GarcomInexistenteException,
	MesaInexistenteException, ConjuntoGarcomVazioException, ConjuntoMesasVazioException, IOException, CodigoItemInvalidoException, GarcomJaPossuiMesaException{
		
		Garcom garcomProcurado = Fachada.getInstancia().getConjuntoGarcons().getGarcom(codigoGarcom);
		Mesa mesaProcurada = Fachada.getInstancia().getConjuntoMesas().getMesa(numeroMesa);
		
		if(mesaProcurada.getGarcomMesa() == null) {
			if((garcomProcurado.getMesasGarcom() == null) || 
			(!garcomProcurado.getMesasGarcom().contains(mesaProcurada))) {
				garcomProcurado.getMesasGarcom().add(mesaProcurada);
				mesaProcurada.setGarcomMesa(garcomProcurado);
			} else {
				throw new GarcomJaPossuiMesaException();
			}
		}
		else {
			Garcom garcomAntigo = mesaProcurada.getGarcomMesa();
			if((garcomProcurado.getMesasGarcom() == null) || 
			(!garcomProcurado.getMesasGarcom().contains(mesaProcurada))) {
				
				garcomAntigo.getMesasGarcom().remove(mesaProcurada);
				garcomProcurado.getMesasGarcom().add(mesaProcurada);
				mesaProcurada.setGarcomMesa(garcomProcurado);	
			} else {
				throw new GarcomJaPossuiMesaException();
			}
		}
	}

	
}