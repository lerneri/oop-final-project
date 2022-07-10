import java.util.*;

import Excecoes.ItemNaoExistenteException;

public class Cardapio {
  public static ArrayList<ItemCardapio> cardapio;

  public Cardapio() {
    cardapio = new ArrayList<ItemCardapio>();
  }

  public void inserir(ItemCardapio item) {
    cardapio.add(item);
  }
  
  public static ItemCardapio getItemCardapio(String codigoItem) throws ItemNaoExistenteException{
		ItemCardapio resposta = null;

		for (int i = 0; i < cardapio.size(); i++) {
			if ((cardapio.get(i).getCodigo()) == codigoItem) {
				resposta = cardapio.get(i);
			}
		}
		if(resposta==null) {
			throw new ItemNaoExistenteException();
		}else {
			return resposta;	
		}
		
	}

}