import java.io.*;
import java.util.*;
public class Caixa {
	
	public static void gerarNota(HashMap<ItemCardapio, Integer> pedido) throws IOException {
		FileWriter fw = new FileWriter("NF.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		double soma = 0;
		for (Map.Entry <ItemCardapio, Integer> me : pedido.entrySet()) {
			bw.write(me.getKey().getCodigo() + "  ");
			bw.write(me.getKey().getNome() + "  ");
			bw.write(me.getKey().getValor() + "");
			soma += me.getKey().getValor();
			System.lineSeparator();
		}
		bw.write("Valor total do pedido: " + soma);
		bw.close();
	}
	
	public static void encerrarMesa(Mesa mesa) {
		
		// Quando a mesa é encerrada, o garçom continua responsável por ela
		//TRATAR POSSIVEIS ERROS QUE ISSO IRÁ GERAR
		//mesa.getGarcomMesa().getMesasGarcom().remove(mesa);
		//mesa.setGarcomMesa(null);
		mesa.getPedido().clear();
		//libera a mesa
		mesa.setOcupada(false);
	}
	
	public Caixa() {
	
	}
}