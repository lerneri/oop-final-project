package backend;

import java.io.*;

import javax.swing.JOptionPane;

import excecoes.CodigoInvalidoException;
import excecoes.GarcomInexistenteException;
import excecoes.GarcomJaExistenteException;
import excecoes.GarcomNaoPossuiMesaException;
import excecoes.ItemNaoExistenteException;
import excecoes.MesaInexistenteException;

public class Main {
	
	
	
	public static void main(String[] args) throws GarcomNaoPossuiMesaException, 
	ItemNaoExistenteException, GarcomInexistenteException, MesaInexistenteException, IOException, CodigoInvalidoException {
		

		Cardapio cardapio = new Cardapio();
		System.out.println(Cardapio.getItemCardapio("1001").getValor());
		
		Fachada fachada = new Fachada;
		
//		ConjuntoGarcons gc = new ConjuntoGarcons();
//		Garcom g1 = new Garcom("Rod bala", "5012");
//		Garcom g2 = new Garcom("Vv gol matador", "5044");
//		Garcom g3 = new Garcom("Cuida", "4732");
//		Mesa m1 = new Mesa("1");
//		Mesa m2 = new Mesa("2");
//		//ConjuntoMesas.mesas.add(m1);
//		//ConjuntoMesas.mesas.add(m2);
//		try {
//			gc.inserirGarcom(g1);
//			gc.inserirGarcom(g2);
//			gc.inserirGarcom(g3);
//			ger.alocarGarcomMesa("1", "5012");
//			System.out.println("Deu certo tudo");
//		} catch (GarcomJaExistenteException e) {
//			System.out.println("Deu ruim");
//		}
		
	}
}
