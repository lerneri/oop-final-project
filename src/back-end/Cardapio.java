import java.util.*;

public class Cardapio {
  public static ArrayList<ItemCardapio> cardapio;

  public Cardapio() {
    cardapio = new ArrayList<ItemCardapio>();
  }

  public void inserir(ItemCardapio item) {
    cardapio.add(item);
  }
  
  public static ItemCardapio getItemCardapio(String codigoItem) {
		ItemCardapio resposta = null;

		for (int i = 0; i < cardapio.size(); i++) {
			if ((cardapio.get(i).getCodigo()) == codigoItem) {
				resposta = cardapio.get(i);
			}
		}

		return resposta;
	}

}