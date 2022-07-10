import java.util.ArrayList;
import Excecoes.*;

public class ConjuntoMesas {

	private static ArrayList<Mesa> mesas;
	
	public void inserirMesa(Mesa mesa) throws MesaJaExistenteException{
		if(mesas != null && mesas.contains(mesa)) {
			throw new MesaJaExistenteException();
		}else {
			mesas.add(mesa);
		}
	}
	
	public static Mesa getMesa(String numeroMesa) throws MesaInexistenteException{
		Mesa mesaProcurada = null;

		for (int i = 0; i < mesas.size(); i++) {
			if ((mesas.get(i).getNumeroMesa()) == numeroMesa) {
				mesaProcurada = mesas.get(i);
			}
		}
		if(mesaProcurada== null) {
			throw new MesaInexistenteException();
		}else {
			return mesaProcurada;
		}
		
	}

}
