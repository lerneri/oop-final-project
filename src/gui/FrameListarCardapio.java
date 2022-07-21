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
import restaurante.*;


public class FrameListarCardapio extends JFrame {
	private JScrollPane jScrollPane1;
	private JTable jTable1;


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrameListarCardapio inst = new FrameListarCardapio();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public FrameListarCardapio() {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameListarCardapio.class.getResource("/imagens/cardapio.png")));
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
						new String[] { "CÓ“DIGO", "DESCRIÇ‡ÃƒO", "PRODUTO", "PREÇ‡O"});
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
				JOptionPane.showMessageDialog(jTable1, "Código de algum item invalido no cardápio");
			}
		}
	
		pack();
	
}

	private void modificarTabela() throws ListaVaziaException, IOException, CodigoItemInvalidoException, ConjuntoGarcomVazioException {
		DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
		modelo.setNumRows(0);
		
		ArrayList<ItemCardapio> c = Fachada.getInstancia().getCardapio().cardapio;
		
		for (int i=0; i<c.size();i++) {
			modelo.addRow(new String[] {c.get(i).getCodigo(), c.get(i).getDescricao(), c.get(i).getNome(), c.get(i).getValor()+""});
		}
	}
}
