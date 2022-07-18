package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import excecoes.*;

import backend.*;

public class FrameListarPedido extends JFrame {
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	
	public FrameListarPedido(String numMesa) throws IOException {
		super();
		initGUI(numMesa);
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

	private void initGUI(String numMesa) throws IOException {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.addWindowFocusListener(new WindowFocusListener() {
			public void windowLostFocus(WindowEvent evt) {
				System.out.println("this.windowLostFocus, event=" + evt);
			}

			public void windowGainedFocus(WindowEvent evt) {
			}
		});
				jScrollPane1 = new JScrollPane();
			getContentPane().add(jScrollPane1, BorderLayout.CENTER);
			
			DefaultTableModel modelo = new DefaultTableModel(null,
					new String[] {"CÓDIGO", "NOME", "DESCRIÇÃO", "VALOR", "QUANTIDADE"});
				jTable1 = new JTable();
				jScrollPane1.setViewportView(jTable1);
				jTable1.setModel(modelo);
				
					modificarTabela(numMesa);
	}

	private void modificarTabela(String numMesa){
		DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
		modelo.setNumRows(0);
		Mesa mesa;
		try {
			mesa = Fachada.getInstancia().getConjuntoMesas().getMesa(numMesa);
			HashMap<ItemCardapio, Integer> pedido = mesa.getPedido();
			double soma = 0;
			for (Map.Entry <ItemCardapio, Integer> me : pedido.entrySet()) {
				modelo.addRow(new String[] { me.getKey().getCodigo(), me.getKey().getNome(),me.getKey().getDescricao() ,me.getKey().getValor()+ "", +me.getValue()+""});
				soma += (me.getKey().getValor()*me.getValue());
			}
		} catch (MesaInexistenteException | ConjuntoMesasVazioException | IOException | CodigoItemInvalidoException e) {
			JOptionPane.showMessageDialog(jScrollPane1, "Mesa inválida");
		}
		
	}
}
