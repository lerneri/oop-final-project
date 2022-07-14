package backend;

import java.io.*;
import java.util.*;

import excecoes.MesaNaoEncerravelException;
public class Caixa {
	
//	public static void gerarNota(HashMap<ItemCardapio, Integer> pedido) throws IOException {
//		FileWriter fw = new FileWriter("NF.txt");
//		BufferedWriter bw = new BufferedWriter(fw);
//		double soma = 0;
//		for (Map.Entry <ItemCardapio, Integer> me : pedido.entrySet()) {
//			bw.write(me.getKey().getCodigo() + "  ");
//			bw.write(me.getKey().getNome() + "  ");
//			bw.write(me.getKey().getValor() + "");
//			bw.write("  R$ " + (me.getKey().getValor()*me.getValue()));
//			soma += me.getKey().getValor();
//			bw.write(System.lineSeparator());
//		}
//		bw.write("Valor total do pedido: R$" + soma);
//		bw.close();
//	}
	
	public void encerrarMesa(Mesa mesa) throws MesaNaoEncerravelException{
		if(mesa.isEncerrada()==false) {
			throw new MesaNaoEncerravelException();
		}
		mesa.getPedido().clear();
		mesa.setOcupada(false);
		mesa.setEncerrada(false);
	}
	
	public Caixa() {
	
	}
}