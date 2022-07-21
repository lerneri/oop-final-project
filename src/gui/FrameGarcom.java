package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import restaurante.ItemCardapio;
import restaurante.Mesa;
import excecoes.CodigoGarcomInvalidoException;
import excecoes.CodigoItemInvalidoException;
import excecoes.ConjuntoGarcomVazioException;
import excecoes.ConjuntoMesasVazioException;
import excecoes.GarcomInexistenteException;
import excecoes.GarcomNaoPossuiMesaException;
import excecoes.ItemNaoExistenteException;
import excecoes.MesaInexistenteException;
import excecoes.NomeInvalidoException;
import excecoes.QuantidadeInvalidaException;
import fachada.Fachada;
import garcom.Garcom;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class FrameGarcom extends JFrame {

	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private Garcom garcomFrame;
	private JTextField textField_7;
	private HashMap<ItemCardapio, Integer> pedido;
	private final Action action = new SwingAction();
	
	public HashMap<ItemCardapio, Integer> getPedido(){
		return pedido;
	}
	public void setGarcomFrame(String codigo) throws GarcomInexistenteException, ConjuntoGarcomVazioException, IOException, CodigoItemInvalidoException {
		this.garcomFrame = Fachada.getInstancia().getConjuntoGarcons().getGarcom(codigo);
	}
	
	public FrameGarcom() {
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[][130px][grow][][grow][grow]", "[][][][][][][][][][][][][][][][]"));
		
		
		JLabel lblInserirPedido = new JLabel("Inserir pedido");
		getContentPane().add(lblInserirPedido, "flowx,cell 1 1 5 1");
		
		textField_4 = new JTextField();
		getContentPane().add(textField_4, "cell 1 2,growx");
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Visualizar cardápio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameListarCardapio fm = new FrameListarCardapio();
				fm.setSize(400, 400);
				fm.setVisible(true);
			}
		});
		btnNewButton_1.setAction(action);
		getContentPane().add(btnNewButton_1, "cell 4 2");
		
		JLabel lblItem = new JLabel("Item:");
		getContentPane().add(lblItem, "cell 0 3,alignx trailing");
		
		JTextField textField_2 = new JTextField();
		getContentPane().add(textField_2, "cell 1 3");
		textField_2.setColumns(4);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		getContentPane().add(lblNewLabel_2, "cell 0 4,alignx trailing,aligny baseline");
		
		JTextField textField = new JTextField();
		getContentPane().add(textField, "flowx,cell 1 4 5 1");
		textField.setColumns(2);
		
		JButton btnNewButton = new JButton("Confirmar pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantidade = Integer.parseInt(textField.getText());
				String numeroMesa = textField_4.getText();
				String codigoItem = textField_2.getText();
				
				try {
				if(garcomFrame.getMesa(numeroMesa).isEncerrada()==true) {
					JOptionPane.showMessageDialog(contentPane, "Mesa já encerrada");
					return;
				}
					garcomFrame.adicionarPedido(numeroMesa, codigoItem, quantidade);
					Mesa mesa = garcomFrame.getMesa(numeroMesa);
					pedido = mesa.getPedido();
					JOptionPane.showMessageDialog(contentPane, "Pedido adicionado com sucesso!");
				} catch (GarcomNaoPossuiMesaException e1) {
					JOptionPane.showMessageDialog(contentPane, "Garçom não está responsável por esta mesa!");
				} catch (ItemNaoExistenteException e1) {
					JOptionPane.showMessageDialog(contentPane, "Código do item não existe!");
				} catch (QuantidadeInvalidaException e1) {
					JOptionPane.showMessageDialog(contentPane, "A quantidade deve ser maior que zero!");
				}
			}
		});
		getContentPane().add(btnNewButton, "flowx,cell 1 5 5 1");
		
		JLabel lblNewLabel_4 = new JLabel("Remover pedido");
		getContentPane().add(lblNewLabel_4, "flowx,cell 1 6 5 1");
		
		JLabel lblMesa2 = new JLabel("Mesa:");
		getContentPane().add(lblMesa2, "cell 0 2,alignx trailing");
		
		JLabel lblMesa = new JLabel("Mesa:");
		getContentPane().add(lblMesa, "cell 0 7,alignx trailing");
		
		textField_5 = new JTextField();
		getContentPane().add(textField_5, "cell 1 7,growx");
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Item:");
		getContentPane().add(lblNewLabel_7, "cell 0 8,alignx trailing");
		
		JTextField textField_3 = new JTextField();
		getContentPane().add(textField_3, "flowx,cell 1 8 5 1");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Quantidade:");
		getContentPane().add(lblNewLabel_8, "cell 0 9,alignx trailing");
		
		JTextField textField_1 = new JTextField();
		getContentPane().add(textField_1, "flowx,cell 1 9 5 1");
		textField_1.setColumns(2);
		
		JButton btnCancelar = new JButton("Cancelar pedido");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigoItem = textField_3.getText();
				String numeroMesa = textField_5.getText();
				try {
					if(garcomFrame.getMesa(numeroMesa).isEncerrada()==true) {
						JOptionPane.showMessageDialog(contentPane, "Mesa já encerrada");
						return;
					}
					int quantidade = Integer.parseInt(textField_1.getText());
					garcomFrame.removerPedido(numeroMesa, codigoItem, quantidade);
					Mesa mesa = garcomFrame.getMesa(numeroMesa);
					pedido = mesa.getPedido();
					JOptionPane.showMessageDialog(contentPane, "Item retirado do pedido com sucesso!");
				} catch (GarcomNaoPossuiMesaException e1) {
					JOptionPane.showMessageDialog(contentPane, "Garçom não está responsável por esta mesa!");
				} catch (ItemNaoExistenteException e1) {
					JOptionPane.showMessageDialog(contentPane, "Não existe item para este código!");
				} catch (QuantidadeInvalidaException e1) {
					JOptionPane.showMessageDialog(contentPane, "Quantidade inválida!");
				} catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(contentPane, "A quantidade digitada deve ser um número maior que zero!");
				}
			}
		});
		getContentPane().add(btnCancelar, "flowx,cell 1 10 5 1");
		
		JLabel lblDirecionar = new JLabel("Direcionar para pagamento");
		getContentPane().add(lblDirecionar, "cell 1 11 5 1");
		
		JLabel lblMesa3 = new JLabel("Mesa:");
		getContentPane().add(lblMesa3, "cell 0 12,alignx trailing");
		
		textField_6 = new JTextField();
		getContentPane().add(textField_6, "cell 1 12,growx");
		textField_6.setColumns(10);
		
		JButton btnEncerrar = new JButton("Encerrar mesa");
		btnEncerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = textField_6.getText();
				try {
					Mesa m = Fachada.getInstancia().getConjuntoMesas().getMesa(num);
					if(m.isEncerrada() == false) {
						m.setEncerrada(true);
						JOptionPane.showMessageDialog(contentPane, "Mesa encerrada!");
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Mesa já encerrada!");
					}
				} catch (MesaInexistenteException | ConjuntoMesasVazioException | IOException
						| CodigoItemInvalidoException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, "Mesa inválida");
				}
			}
		});
		getContentPane().add(btnEncerrar, "cell 1 13 5 1");
		
		JLabel lblNewLabel_1 = new JLabel("Cardápio");
		getContentPane().add(lblNewLabel_1, "cell 4 1,aligny baseline");
		
		JButton btnMostrarPedido = new JButton("Mostrar conta");
		btnMostrarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numMesa = textField_7.getText();
				try {
					FrameListarPedido fp = new FrameListarPedido(numMesa);
					fp.setVisible(true);
					fp.setSize(400,400);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(contentPane, "IO Exception");
				}
			}
		});
		getContentPane().add(btnMostrarPedido, "cell 4 6");
		
		textField_7 = new JTextField();
		getContentPane().add(textField_7, "cell 4 5");
		textField_7.setColumns(10);
		
		JLabel lblNumeroDaMesa = new JLabel("Mesa:");
		getContentPane().add(lblNumeroDaMesa, "cell 3 5");
		
		JLabel lblNewLabel = new JLabel("Visualizar conta parcial");
		getContentPane().add(lblNewLabel, "cell 4 4");
		
		
	}
	
	public static void main(String[] args) {
		FrameGarcom fg = new FrameGarcom();
		fg.setVisible(true);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Visualizar cardápio");
			
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
