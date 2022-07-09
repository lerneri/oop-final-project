package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Janela {

	private JFrame frmGerenciamentoDeRestaurante;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
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
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGerenciamentoDeRestaurante = new JFrame();
		frmGerenciamentoDeRestaurante.setTitle("Gerenciamento de Restaurante");
		frmGerenciamentoDeRestaurante.setBounds(100, 100, 450, 300);
		frmGerenciamentoDeRestaurante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frmGerenciamentoDeRestaurante.getContentPane().setLayout(new MigLayout("", "[217px][grow][grow][217px]", "[130px][][][][][][130px]"));
		
		JLabel lblNewLabel = new JLabel("Bem-vindo! Selecione o funcionário atual:");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel, "cell 1 0,grow");
		
		JLabel label = new JLabel("");
		frmGerenciamentoDeRestaurante.getContentPane().add(label, "cell 3 0,grow");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 1;
		
		JLabel lblNewLabel_1 = new JLabel("Função");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_1, "cell 0 1,alignx trailing,growy");
		
		JComboBox comboBox = new JComboBox();
		frmGerenciamentoDeRestaurante.getContentPane().add(comboBox, "cell 1 1,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		textField = new JTextField();
		frmGerenciamentoDeRestaurante.getContentPane().add(textField, "cell 1 2,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Código de acesso");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_3, "cell 0 3,alignx trailing");
		
		passwordField = new JPasswordField();
		frmGerenciamentoDeRestaurante.getContentPane().add(passwordField, "cell 1 3,growx");
		
		JButton btnNewButton = new JButton("Login");
		frmGerenciamentoDeRestaurante.getContentPane().add(btnNewButton, "cell 1 5");
		
		JLabel label_1 = new JLabel("");
		frmGerenciamentoDeRestaurante.getContentPane().add(label_1, "cell 0 6,grow");
	}

}
