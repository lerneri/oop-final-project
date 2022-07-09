import java.util.*;

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
	
	public void adicionarPedido(String numeroMesa, String codigoItem, int quantidade) throws GarcomNaoPossuiMesaException {
		Mesa mesa = getMesa(numeroMesa);
		ItemCardapio item = Cardapio.getItemCardapio(codigoItem);
		
	}
	
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Garcom(String nome, String codigo) {
		this.codigo = codigo;
		this.nome = nome;
		mesas = new ArrayList<Mesa>();
	}

}