import java.util.*;
public class Caixa {
	
	public static void gerarNota(HashMap<ItemCardapio, Integer> pedido) {
		
	}
	
	public static void encerrarMesa(Mesa mesa) {
		
		// Quando a mesa � encerrada, o gar�om continua respons�vel por ela
		//TRATAR POSSIVEIS ERROS QUE ISSO IR� GERAR
		//mesa.getGarcomMesa().getMesasGarcom().remove(mesa);
		//mesa.setGarcomMesa(null);
		mesa.getPedido().clear();
		//libera a mesa
		mesa.setOcupada(false);
	}
	
	public Caixa() {
	
	}
}