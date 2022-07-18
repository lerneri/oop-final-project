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


public class FrameListarGarcons extends JFrame {
	private JScrollPane jScrollPane1;
	private JTable jTable1;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrameListarGarcons inst = new FrameListarGarcons();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public FrameListarGarcons() {
		super();
		initGUI();
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

	private void initGUI() {
		
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
						new String[] { "NOME", "CÓDIGO"});
				jTable1 = new JTable();
				jScrollPane1.setViewportView(jTable1);
				jTable1.setModel(modelo);
				
					modificarTabela();
			} catch (ListaVaziaException e) {
				JOptionPane.showMessageDialog(jTable1, "Lista Vazia Exception");
			} catch (ConjuntoGarcomVazioException e) {
				JOptionPane.showMessageDialog(jTable1, "Conjunto de garçons vazio!");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jTable1, "IO Exception");
			} catch (CodigoItemInvalidoException e) {
				JOptionPane.showMessageDialog(jTable1, "Codigo de algum item invalido no cardapio");
			}
		}
	
		pack();
	
}

	private void modificarTabela() throws ListaVaziaException, IOException, CodigoItemInvalidoException, ConjuntoGarcomVazioException {
		DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
		modelo.setNumRows(0);
		ArrayList<Garcom> garcons = Fachada.getInstancia().getConjuntoGarcons().getArrayGarcons();

		for (Garcom garcom : garcons) {

			modelo.addRow(new String[] { garcom.getNome(), garcom.getCodigo()});
		}
	}
}
