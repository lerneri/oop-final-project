import java.util.*;

public class Mesa {
	private String numeroMesa;
	private HashMap<ItemCardapio, Integer> pedido;
	

	public HashMap<ItemCardapio, Integer> getPedido(){
		return this.pedido;
	}
	
	public void setPedido(ItemCardapio item, int quantidade) {
		
	
	}
	
	
	public String getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(String numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public Mesa(String numeroMesa) {
		this.numeroMesa = numeroMesa;
		this.pedido = new HashMap<ItemCardapio, Integer>();
	}
}