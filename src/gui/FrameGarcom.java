package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import backend.*;

public class FrameGarcom extends JFrame {

	private JPanel contentPane;

	public FrameGarcom() {
		setTitle("Gerenciamento de Restaurante - Garçom garcom.nome");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][][][][][]"));
		
		JLabel mensagemBoasVindas = new JLabel("Bem-vindo, nomeGarçom!");
		getContentPane().add(mensagemBoasVindas, "cell 0 0");
		
		JLabel lblInserirPedido = new JLabel("Inserir pedido");
		getContentPane().add(lblInserirPedido, "cell 1 1");
		
		JComboBox comboBoxMesas = new JComboBox();
		getContentPane().add(comboBoxMesas, "flowx,cell 1 2,alignx left");
		
		JLabel lblItem = new JLabel("Item:");
		getContentPane().add(lblItem, "cell 0 3,alignx trailing");
		
		JTextField textField_2 = new JTextField();
		getContentPane().add(textField_2, "cell 1 3,alignx left");
		textField_2.setColumns(4);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		getContentPane().add(lblNewLabel_2, "cell 0 4,alignx trailing,aligny baseline");
		
		JTextField textField = new JTextField();
		getContentPane().add(textField, "cell 1 4");
		textField.setColumns(2);
		
		JButton btnNewButton = new JButton("Confirmar pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnNewButton, "cell 1 5");
		
		JLabel lblNewLabel_4 = new JLabel("Remover pedido");
		getContentPane().add(lblNewLabel_4, "cell 1 6");
		
		JLabel lblMesa2 = new JLabel("Mesa:");
		getContentPane().add(lblMesa2, "cell 0 2,alignx trailing");
		
		JLabel lblMesa = new JLabel("Mesa:");
		getContentPane().add(lblMesa, "cell 0 7,alignx trailing");
		
		JComboBox comboBox_3 = new JComboBox();
		getContentPane().add(comboBox_3, "cell 1 7");
		
		JLabel lblNewLabel_7 = new JLabel("Item:");
		getContentPane().add(lblNewLabel_7, "cell 0 8,alignx trailing");
		
		JTextField textField_3 = new JTextField();
		getContentPane().add(textField_3, "cell 1 8");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Quantidade:");
		getContentPane().add(lblNewLabel_8, "cell 0 9,alignx trailing");
		
		JTextField textField_1 = new JTextField();
		getContentPane().add(textField_1, "cell 1 9");
		textField_1.setColumns(2);
		
		JButton btnCancelar = new JButton("Cancelar pedido");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnCancelar, "cell 1 10");
		
		JLabel lblDirecionar = new JLabel("Direcionar para pagamento");
		getContentPane().add(lblDirecionar, "cell 1 11");
		
		JLabel lblMesa3 = new JLabel("Mesa:");
		getContentPane().add(lblMesa3, "cell 0 12,alignx trailing");
		
		JComboBox comboBoxMesas3 = new JComboBox();
		getContentPane().add(comboBoxMesas3, "cell 1 12");
		
		JButton btnEncerrar = new JButton("Encerrar mesa");
		getContentPane().add(btnEncerrar, "cell 1 13");
		
		
	}

}
