import java.util.*;

public class Mesa {
	private String numeroMesa;
	private HashMap<ItemCardapio, Integer> pedido;
	private Garcom garcomMesa;
	private boolean ocupada;

	public boolean mesaPossuiGarcom() {
		boolean resultado = false;
		Garcom gm = getGarcomMesa();
		if(gm != null) {
			resultado = true;
		}
		return resultado;
	}
	
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
		this.garcomMesa = null;
		this.pedido = new HashMap<ItemCardapio, Integer>();
		this.ocupada = false;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	// ALTERAR NOS CONJUNTOS DE MESAS, COLOCAR DE OCUPADA PRA LIVRE OU DE LIVRE PARA OCUPADA
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
}