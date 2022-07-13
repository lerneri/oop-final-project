package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import backend.*;
import excecoes.CodigoItemInvalidoException;
import excecoes.ConjuntoGarcomVazioException;
import excecoes.GarcomInexistenteException;
import excecoes.GarcomNaoPossuiMesaException;
import excecoes.ItemNaoExistenteException;
import excecoes.QuantidadeInvalidaException;

public class FrameGarcom extends JFrame {

	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public FrameGarcom() {
		setTitle("Gerenciamento de Restaurante - Garçom garcom.nome");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[][130px][grow][grow][grow]", "[][][][][][][][][][][][][][][][]"));
		
		JLabel mensagemBoasVindas = new JLabel("Bem-vindo, nomeGarçom!");
		getContentPane().add(mensagemBoasVindas, "cell 0 0");
		
		JLabel lblInserirPedido = new JLabel("Inserir pedido");
		getContentPane().add(lblInserirPedido, "cell 1 1 4 1");
		
		textField_4 = new JTextField();
		getContentPane().add(textField_4, "cell 1 2,growx");
		textField_4.setColumns(10);
		
		JLabel lblItem = new JLabel("Item:");
		getContentPane().add(lblItem, "cell 0 3,alignx trailing");
		
		JTextField textField_2 = new JTextField();
		getContentPane().add(textField_2, "cell 1 3");
		textField_2.setColumns(4);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		getContentPane().add(lblNewLabel_2, "cell 0 4,alignx trailing,aligny baseline");
		
		JTextField textField = new JTextField();
		getContentPane().add(textField, "cell 1 4 4 1");
		textField.setColumns(2);
		
		JButton btnNewButton = new JButton("Confirmar pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantidade = Integer.parseInt(textField.getText());
				String numeroMesa = textField_4.getText();
				String codigoItem = textField_2.getText();
				try {
					// FALTA COLOCAR O CODIGO DO GARÇOM QUE ESTÁ LOGADO
					Fachada.getInstancia().getConjuntoGarcons().getGarcom("CODIGO DO GARÇOM DO FRAME").adicionarPedido(numeroMesa, codigoItem, quantidade);
				} catch (ConjuntoGarcomVazioException e1) {
					JOptionPane.showMessageDialog(contentPane, "Conjunto de garçons está vazio!");
				} catch (GarcomNaoPossuiMesaException e1) {
					JOptionPane.showMessageDialog(contentPane, "Garçom não está responsável por esta mesa!");
				} catch (ItemNaoExistenteException e1) {
					JOptionPane.showMessageDialog(contentPane, "Código do Item não existe!");
				} catch (QuantidadeInvalidaException e1) {
					JOptionPane.showMessageDialog(contentPane, "A Quantidade deve ser maior que zero!");
				} catch (GarcomInexistenteException e1) {
					JOptionPane.showMessageDialog(contentPane, "Garçom não existe!");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(contentPane, "IO exception no arquivo do cardapio!");
				} catch (CodigoItemInvalidoException e1) {
					JOptionPane.showMessageDialog(contentPane, "Código de algum item inserido incorretamente no arquivo cardapio!");
				}
			}
		});
		getContentPane().add(btnNewButton, "cell 1 5 4 1");
		
		JLabel lblNewLabel_4 = new JLabel("Remover pedido");
		getContentPane().add(lblNewLabel_4, "cell 1 6 4 1");
		
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
		getContentPane().add(textField_3, "cell 1 8 4 1");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Quantidade:");
		getContentPane().add(lblNewLabel_8, "cell 0 9,alignx trailing");
		
		JTextField textField_1 = new JTextField();
		getContentPane().add(textField_1, "cell 1 9 4 1");
		textField_1.setColumns(2);
		
		JButton btnCancelar = new JButton("Cancelar pedido");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigoItem = textField_3.getText();
				String numeroMesa = textField_5.getText();
				try {
					int quantidade = Integer.parseInt(textField_1.getText());
					Fachada.getInstancia().getConjuntoGarcons().getGarcom("CODIGO DO GARÇOM DO FRAME").removerPedido(numeroMesa, codigoItem, quantidade);
				}catch (ConjuntoGarcomVazioException e1) {
					JOptionPane.showMessageDialog(contentPane, "Conjunto de garçons está vazio!");
				}catch (GarcomNaoPossuiMesaException e1) {
					JOptionPane.showMessageDialog(contentPane, "Garçom não está responsável por esta mesa!");
				} catch (ItemNaoExistenteException e1) {
					JOptionPane.showMessageDialog(contentPane, "Código do Item não existe!");
				} catch (QuantidadeInvalidaException e1) {
					JOptionPane.showMessageDialog(contentPane, "A quantidade digitada deve ser maior que zero!");
				} catch (GarcomInexistenteException e1) {
					JOptionPane.showMessageDialog(contentPane, "Garçom não existe!");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(contentPane, "IO exception no arquivo do cardapio!");
				} catch (CodigoItemInvalidoException e1) {
					JOptionPane.showMessageDialog(contentPane, "Código de algum item inserido incorretamente no arquivo cardapio!");
				}catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(contentPane, "A quantidade digitada deve ser um número maior que zero!");
				}
			}
		});
		getContentPane().add(btnCancelar, "cell 1 10 4 1");
		
		JLabel lblDirecionar = new JLabel("Direcionar para pagamento");
		getContentPane().add(lblDirecionar, "cell 1 11 4 1");
		
		JLabel lblMesa3 = new JLabel("Mesa:");
		getContentPane().add(lblMesa3, "cell 0 12,alignx trailing");
		
		textField_6 = new JTextField();
		getContentPane().add(textField_6, "cell 1 12,growx");
		textField_6.setColumns(10);
		
		JButton btnEncerrar = new JButton("Encerrar mesa");
		getContentPane().add(btnEncerrar, "cell 1 13 4 1");
		
		
	}
	
	public static void main(String[] args) {
		FrameGarcom fg = new FrameGarcom();
		fg.setVisible(true);
	}

}
