package backend;

import java.util.*;

import excecoes.*;

public class Gerente {
	private String nome;
	private ConjuntoGarcons garcons;
	private ConjuntoMesas mesas;

	public Gerente(String nome) {
		this.nome = nome;
		this.garcons = new ConjuntoGarcons();
		this.mesas = new ConjuntoMesas();
	}
	
	public ArrayList<Mesa> getMesasLivres(){
		ArrayList<Mesa> resposta = null;
		for (int i=0; i<ConjuntoMesas.getArrayMesas().size(); i++) {
			if(ConjuntoMesas.getArrayMesas().get(i).isOcupada()==false) {
				resposta.add(ConjuntoMesas.getArrayMesas().get(i));
			}
		}
		return resposta;
	}

	//public void desconto(String numeroMesa, double porcentagem) {
	//	Mesa m = mesas.getMesa(numeroMesa);
	//	m.getPedido();
	//}
	
	
	public void cadastrarMesa(String numeroMesa) throws MesaJaExistenteException {
		Mesa mesa = new Mesa(numeroMesa);
		mesas.inserirMesa(mesa);
	}
	
	public void cadastrarGarcom(String nome, String codigo) throws GarcomJaExistenteException, CodigoInvalidoException, NomeInvalidoException{
		Garcom garcom = new Garcom(nome, codigo);
		garcons.inserirGarcom(garcom);
	}
	
	
	public void removerGarcom(Garcom garcom) throws GarcomInexistenteException{
		garcons.removerGarcom(garcom.getNome());
	}
	
	
	public void alocarGarcomMesa(String numeroMesa, String codigoGarcom) throws GarcomInexistenteException,
	MesaInexistenteException{
		
		Garcom garcomProcurado = ConjuntoGarcons.getGarcom(codigoGarcom);
		Mesa mesaProcurada = ConjuntoMesas.getMesa(numeroMesa);
		
		if(mesaProcurada.getGarcomMesa() == null) {
			if((garcomProcurado.getMesasGarcom() == null) || 
			(!garcomProcurado.getMesasGarcom().contains(mesaProcurada))) {
				garcomProcurado.getMesasGarcom().add(mesaProcurada);
				mesaProcurada.setGarcomMesa(garcomProcurado);
			} 
		}
		else {
			Garcom garcomAntigo = mesaProcurada.getGarcomMesa();
			if((garcomProcurado.getMesasGarcom() == null) || 
			(!garcomProcurado.getMesasGarcom().contains(mesaProcurada))) {
				
				garcomAntigo.getMesasGarcom().remove(mesaProcurada);
				garcomProcurado.getMesasGarcom().add(mesaProcurada);
								
			}
		}
	}

	
}