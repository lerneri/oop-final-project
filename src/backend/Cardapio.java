package backend;

import java.io.*;
import java.util.*;

import excecoes.CodigoItemInvalidoException;
import excecoes.ItemNaoExistenteException;

public class Cardapio {
	public static ArrayList<ItemCardapio> cardapio;

	public Cardapio() throws IOException, CodigoItemInvalidoException {
		cardapio = new ArrayList<ItemCardapio>();
		RandomAccessFile raf = new RandomAccessFile("cardapio.txt", "r");
		String frase;
		ItemCardapio result = null;
		while ((frase = raf.readLine()) != null) {
			StringTokenizer fraseTK = new StringTokenizer(frase, ":");
			result = new ItemCardapio(fraseTK.nextToken(), fraseTK.nextToken(), fraseTK.nextToken(), Double.parseDouble(fraseTK.nextToken()));
			Cardapio.inserir(result);
			// result = new ItemCardapio(st[1],st[2],st[3],st[4])//converter st[4] pra
			// double
		}
		raf.close();

	}

	public static void inserir(ItemCardapio item) throws CodigoItemInvalidoException{
		
		for(int i=0; i< cardapio.size(); i++) {
			if(cardapio.get(i).getCodigo().equals(item.getCodigo())) {
				throw new CodigoItemInvalidoException();
			}
		}
		cardapio.add(item);
	}

	public static ItemCardapio getItemCardapio(String codigoItem) throws ItemNaoExistenteException {
		ItemCardapio resposta = null;

		for (int i = 0; i < cardapio.size(); i++) {
			if ((cardapio.get(i).getCodigo()).equals(codigoItem)) {
				resposta = cardapio.get(i);
			}
		}
		if (resposta == null) {
			throw new ItemNaoExistenteException();
		} else {
			return resposta;
		}

	}

}