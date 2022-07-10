package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class JanelaGarcom {

	private JFrame frmGerenciamentoDeRestaurante;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaGarcom window = new JanelaGarcom();
					window.frmGerenciamentoDeRestaurante.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaGarcom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGerenciamentoDeRestaurante = new JFrame();
		frmGerenciamentoDeRestaurante.setTitle("Gerenciamento de Restaurante - Garçom garcom.nome");
		frmGerenciamentoDeRestaurante.setBounds(100, 100, 450, 300);
		frmGerenciamentoDeRestaurante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenciamentoDeRestaurante.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Bem-vindo, nomeGarçom!");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_3 = new JLabel("Inserir pedido");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_3, "cell 1 1");
		
		JLabel lblNewLabel_1 = new JLabel("Mesa:");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		frmGerenciamentoDeRestaurante.getContentPane().add(comboBox, "flowx,cell 1 2,growx");
		
		JLabel lblNewLabel_5 = new JLabel("Item:");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_5, "cell 0 3,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		frmGerenciamentoDeRestaurante.getContentPane().add(comboBox_1, "cell 1 3,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_2, "cell 0 4,alignx trailing,aligny baseline");
		
		textField = new JTextField();
		frmGerenciamentoDeRestaurante.getContentPane().add(textField, "cell 1 4,growx");
		textField.setColumns(2);
		
		JButton btnNewButton = new JButton("Confirmar pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmGerenciamentoDeRestaurante.getContentPane().add(btnNewButton, "cell 1 5");
		
		JLabel lblNewLabel_4 = new JLabel("Remover pedido");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_4, "cell 1 6");
		
		JLabel lblNewLabel_6 = new JLabel("Mesa:");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_6, "cell 0 7,alignx trailing");
		
		JComboBox comboBox_3 = new JComboBox();
		frmGerenciamentoDeRestaurante.getContentPane().add(comboBox_3, "cell 1 7,growx");
		
		JLabel lblNewLabel_7 = new JLabel("Item:");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_7, "cell 0 8,alignx trailing");
		
		JComboBox comboBox_2 = new JComboBox();
		frmGerenciamentoDeRestaurante.getContentPane().add(comboBox_2, "cell 1 8,growx");
		
		JLabel lblNewLabel_8 = new JLabel("Qauntidade:");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_8, "cell 0 9,alignx trailing");
		
		textField_1 = new JTextField();
		frmGerenciamentoDeRestaurante.getContentPane().add(textField_1, "cell 1 9,growx");
		textField_1.setColumns(2);
		
		JButton btnNewButton_1 = new JButton("Cancelar pedido");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmGerenciamentoDeRestaurante.getContentPane().add(btnNewButton_1, "cell 1 10");
	}

}
