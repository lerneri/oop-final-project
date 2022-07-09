import javax.swing.JOptionPane;

public class Main {
	
	
	
	public static void main(String[] args) {

		ConjuntoGarcons gc = new ConjuntoGarcons();
		Garcom g1 = new Garcom("Rod bala", "5012");
		Garcom g2 = new Garcom("Vv gol matador", "5044");
		Garcom g3 = new Garcom("Cuida", "4732");
		try {
			gc.inserirGarcom(g1);
			gc.inserirGarcom(g2);
			gc.inserirGarcom(g3);
			gc.inserirGarcom(g1);
			System.out.println("Deu certo tudo");
		} catch (GarcomJaExistenteException e) {
			System.out.println("Deu ruim");
		}
		
	}
}
