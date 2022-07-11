import java.io.*;
import java.util.*;

import Excecoes.ItemNaoExistenteException;

public class Cardapio {
  public static ArrayList<ItemCardapio> cardapio;

  public Cardapio() throws IOException {
    cardapio = new ArrayList<ItemCardapio>();
    RandomAccessFile raf = new RandomAccessFile("cardapio.txt", "r");
    String frase;
    	while ((frase = raf.readLine()) != null) {
    		ItemCardapio result=null;
    		StringTokenizer fraseTK = new StringTokenizer(frase, ":");
    		
    			//result = new ItemCardapio(st[1],st[2],st[3],st[4])//converter st[4] pra double
    	}
    
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