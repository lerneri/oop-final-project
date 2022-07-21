package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import excecoes.*;
import fachada.Fachada;
import garcom.Garcom;
import restaurante.Mesa;

public class FrameListarMesasGarcom extends JFrame {
	private JScrollPane jScrollPane1;
	private JTable jTable1;

	/**
	 * Auto-generated main method to display this JFrame
	 * @throws ConjuntoGarcomVazioException 
	 * @throws GarcomInexistenteException 
	 */
	//public static void main(String[] args) {
		//SwingUtilities.invokeLater(new Runnable() {
			//public void run() {
				//FrameListarMesasGarcom inst = new FrameListarMesasGarcom();
				//inst.setLocationRelativeTo(null);
				//inst.setVisible(true);
			//}
		//});
	//}

	public FrameListarMesasGarcom(String codigo) throws GarcomInexistenteException, ConjuntoGarcomVazioException {
		super();
		initGUI(codigo);
		int larguraJanela = getWidth();
		int alturaJanela = getHeight();
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int larguraTela = d.width;
		int alturaTela = d.height;
		int posHorizontal = (larguraTela - larguraJanela) / 2;
		int posVertical = (alturaTela - alturaJanela) / 2;
		setLocation(posHorizontal, posVertical);

	}

	private void initGUI(String codigo) throws GarcomInexistenteException, ConjuntoGarcomVazioException {
	
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.addWindowFocusListener(new WindowFocusListener() {
				public void windowLostFocus(WindowEvent evt) {
					System.out.println("this.windowLostFocus, event=" + evt);
				}

				public void windowGainedFocus(WindowEvent evt) {
				}
			});
			{
				try {
					jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				
					DefaultTableModel modelo = new DefaultTableModel(null,
							new String[] { "Número da mesa"});
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(modelo);
					
						modificarTabela(codigo);
				} catch (ListaVaziaException e) {
					JOptionPane.showMessageDialog(jTable1, "Lista Vazia Exception");
				} catch (ConjuntoMesasVazioException e) {
					JOptionPane.showMessageDialog(jTable1, "Conjunto de mesas vazio!");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(jTable1, "IO Exception");
				} catch (CodigoItemInvalidoException e) {
					JOptionPane.showMessageDialog(jTable1, "Codigo de algum item invalido no cardapio");
				}
			}
		
			pack();
		
	}

	private void modificarTabela(String codigo)
			throws ListaVaziaException, ConjuntoMesasVazioException, IOException, CodigoItemInvalidoException, GarcomInexistenteException, ConjuntoGarcomVazioException {
		DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
		modelo.setNumRows(0);
		Garcom garcom = Fachada.getInstancia().getConjuntoGarcons().getGarcom(codigo);

		for (Mesa mesa : garcom.getMesasGarcom()) {

			modelo.addRow(new String[] { mesa.getNumeroMesa() });
		}
	}
}
