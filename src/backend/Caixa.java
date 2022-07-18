package backend;

import java.io.*;
import java.util.*;

import excecoes.MesaNaoEncerravelException;
public class Caixa {

	
	public void encerrarMesa(Mesa mesa) throws MesaNaoEncerravelException{
		if(mesa.isEncerrada()==false) {
			throw new MesaNaoEncerravelException();
		}
		mesa.getPedido().clear();
		mesa.setOcupada(false);
		mesa.setEncerrada(false);
	}
	
	public Caixa() {
	
	}
}