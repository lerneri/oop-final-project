import java.util.*;
public class Caixa {
	
	public static void gerarNota(HashMap<ItemCardapio, Integer> pedido) {
		
	}
	
	public static void encerrarMesa(Mesa mesa) {
		
		// Quando a mesa é encerrada, o garçom continua responsável por ela
		//mesa.getGarcomMesa().getMesasGarcom().remove(mesa);
		//mesa.setGarcomMesa(null);
		mesa.getPedido().clear();
	}
	
	public Caixa() {
	
	}
}