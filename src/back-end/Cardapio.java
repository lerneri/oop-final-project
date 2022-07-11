import java.io.*;
import java.util.*;

import Excecoes.CodigoInvalidoException;
import Excecoes.ItemNaoExistenteException;

public class Cardapio {
	public static ArrayList<ItemCardapio> cardapio;

	public Cardapio(File arquivo) throws IOException, CodigoInvalidoException {
		cardapio = new ArrayList<ItemCardapio>();
		RandomAccessFile raf = new RandomAccessFile(arquivo, "r");
		String frase;
		ItemCardapio result = null;
		while ((frase = raf.readLine()) != null) {
			StringTokenizer fraseTK = new StringTokenizer(frase, ":");
			result.setCodigo(fraseTK.nextToken());
			result.setNome(fraseTK.nextToken());
			result.setDescricao(fraseTK.nextToken());
			result.setValor(Integer.parseInt(fraseTK.nextToken()));
			Cardapio.inserir(result);
			// result = new ItemCardapio(st[1],st[2],st[3],st[4])//converter st[4] pra
			// double
		}

	}

	public static void inserir(ItemCardapio item) throws CodigoInvalidoException{
		
		for(int i=0; i< cardapio.size(); i++) {
			if(cardapio.get(i).getCodigo().equals(item.getCodigo())) {
				throw new CodigoInvalidoException();
			}
		}
		cardapio.add(item);
	}

	public static ItemCardapio getItemCardapio(String codigoItem) throws ItemNaoExistenteException {
		ItemCardapio resposta = null;

		for (int i = 0; i < cardapio.size(); i++) {
			if ((cardapio.get(i).getCodigo()) == codigoItem) {
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