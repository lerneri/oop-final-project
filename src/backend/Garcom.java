package backend;

import java.io.IOException;
import java.util.*;

import excecoes.CodigoInvalidoException;
import excecoes.GarcomNaoPossuiMesaException;
import excecoes.ItemNaoExistenteException;
import excecoes.PedidoVazioException;
import excecoes.QuantidadeInvalidaException;

public class Garcom {
	private String nome;
	private String codigo;
	private ArrayList<Mesa> mesas;
	
	public ArrayList<Mesa> getMesasGarcom() {
		return this.mesas;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Mesa getMesa(String numeroMesa) throws GarcomNaoPossuiMesaException{
		Mesa resp = null;
		for (int i=0; i<mesas.size(); i++) {
			if (mesas.get(i).getNumeroMesa()==numeroMesa) {
				resp = mesas.get(i);
				break;
			}
		}
		if(resp == null) {
			throw new GarcomNaoPossuiMesaException();
		}else {
			return resp;
		}
		
	}
	
	public void adicionarPedido(String numeroMesa, String codigoItem, int quantidade) throws
	GarcomNaoPossuiMesaException, ItemNaoExistenteException, QuantidadeInvalidaException {
		if(quantidade <=0) {
			throw new QuantidadeInvalidaException();
		}
		Mesa mesa = getMesa(numeroMesa);
		if(mesa.isOcupada()==false) {
			mesa.setOcupada(true);
		}
		ItemCardapio item = Cardapio.getItemCardapio(codigoItem);
			if(mesa.getPedido().containsKey(item)) {
				mesa.setPedido(item, quantidade);
			} else {
				mesa.getPedido().put(item, quantidade);
			} 
	}
	
	public void encerrarPedido(String numeroMesa) throws GarcomNaoPossuiMesaException, PedidoVazioException, IOException {
		Mesa m = getMesa(numeroMesa);
		if (m.getPedido()==null) {
			throw new PedidoVazioException();
		}
		Caixa.gerarNota(m.getPedido());
	}
	
	
	public void removerPedido(String numeroMesa, String codigoItem, int quantidade) throws 
	GarcomNaoPossuiMesaException, ItemNaoExistenteException, QuantidadeInvalidaException {
		if(quantidade <=0) {
			throw new QuantidadeInvalidaException();
		}
		Mesa mesa = getMesa(numeroMesa);
		ItemCardapio item = Cardapio.getItemCardapio(codigoItem);
				if((mesa.getPedido().containsKey(item)) && (mesa.getPedido().get(item)>1) && 
						(mesa.getPedido().get(item) > quantidade)) {
							mesa.setPedido(item, (-quantidade));
				} else if((mesa.getPedido().containsKey(item)) && (mesa.getPedido().get(item)>1) && 
						(mesa.getPedido().get(item) == quantidade)) {
							mesa.getPedido().remove(item);
				} else {
					throw new QuantidadeInvalidaException();
				}
	}
	
		
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Garcom(String nome, String codigo) throws CodigoInvalidoException {
		for(byte b : codigo.getBytes()) {
			if(b<48 || b>57) {
				throw new CodigoInvalidoException();
			}
		}
		if(codigo.length()!=4) {
			throw new CodigoInvalidoException();
		}
		this.codigo = codigo;
		this.nome = nome;
		mesas = new ArrayList<Mesa>();
	}

}