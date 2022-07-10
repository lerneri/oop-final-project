import java.util.*;

public class Mesa {
	private String numeroMesa;
	private HashMap<ItemCardapio, Integer> pedido;
	private Garcom garcomMesa;

	public Garcom getGarcomMesa() {
		return garcomMesa;
	}

	public void setGarcomMesa(Garcom garcomMesa) {
		this.garcomMesa = garcomMesa;
	}

	public HashMap<ItemCardapio, Integer> getPedido(){
		return this.pedido;
	}
	
	public void setPedido(ItemCardapio item, int quantidade) {
		this.pedido.replace(item, this.pedido.get(item)+quantidade);
	}
	
	
	public String getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(String numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public Mesa(String numeroMesa) {
		this.numeroMesa = numeroMesa;
		this.pedido = new HashMap<>();
	}
}