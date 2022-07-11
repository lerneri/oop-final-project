import java.util.*;
public class Caixa {
	
	public static void gerarNota(HashMap<ItemCardapio, Integer> pedido) {
		
	}
	
	public static void encerrarMesa(Mesa mesa) {
				
		mesa.getPedido().clear();
		mesa.setOcupada(false);
	}
	
	public Caixa() {
	
	}
}