import java.util.*;

import Excecoes.*;

public class Gerente {
	private String nome;
	private ConjuntoGarcons garcons;
	private ConjuntoMesas mesas;

	public Gerente(String nome) {
		this.nome = nome;
		this.garcons = new ConjuntoGarcons();
		this.mesas = new ConjuntoMesas();
	}

	//public void desconto(String numeroMesa, double porcentagem) {
	//	Mesa m = mesas.getMesa(numeroMesa);
	//	m.getPedido();
	//}
	
	public void alocarGarcomMesa(String numeroMesa, String codigoGarcom) throws GarcomInexistenteException, MesaInexistenteException{
		Garcom garcomProcurado = ConjuntoGarcons.getGarcom(codigoGarcom);
		Mesa mesaProcurada = ConjuntoMesas.getMesa(numeroMesa);
		
		if(garcomProcurado.getMesasGarcom() == null) {
			garcomProcurado.getMesasGarcom().add(mesaProcurada);
		}else if(!garcomProcurado.getMesasGarcom().contains(mesaProcurada)) {
			garcomProcurado.getMesasGarcom().add(mesaProcurada);
		}
		
	}

	
}