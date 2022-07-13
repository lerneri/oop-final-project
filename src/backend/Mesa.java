package backend;

import java.util.*;

import excecoes.CodigoItemInvalidoException;

public class Mesa {
	private String numeroMesa;
	private HashMap<ItemCardapio, Integer> pedido;
	private Garcom garcomMesa;
	private boolean ocupada;
	
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
	
	public boolean isOcupada() {
		return ocupada;
	}

	// ALTERAR NOS CONJUNTOS DE MESAS, COLOCAR DE OCUPADA PRA LIVRE OU DE LIVRE PARA OCUPADA
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public Mesa(String numeroMesa) throws CodigoItemInvalidoException{
		for(byte b : numeroMesa.getBytes()) {
			if(b<48 || b>57) {
				throw new CodigoItemInvalidoException();
			}
		}
		this.numeroMesa = numeroMesa;
		this.garcomMesa = null;
		this.pedido = new HashMap<ItemCardapio, Integer>();
		this.ocupada = false;
	}
}