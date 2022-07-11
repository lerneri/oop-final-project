import java.util.*;
public class Caixa {
	
	public static void gerarNota(HashMap<ItemCardapio, Integer> pedido) {
		
	}
	
	public static void encerrarMesa(Mesa mesa) {
		mesa.getGarcomMesa().getMesasGarcom().remove(mesa);
		mesa.setGarcomMesa(null);
		mesa.getPedido().clear();
	}
	
	public Caixa() {
	
	}
}