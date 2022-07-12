package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class FrameGerente extends JFrame {

	private JPanel contentPane;

	public FrameGerente() {
		setTitle("Gerenciamento de Restaurante - Gerente");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[106px][115px][37px][172px]", "[14px][14px][22px][23px][23px][22px][23px][20px][23px][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("Bem-vindo, GERENTE!");
		getContentPane().add(lblNewLabel_3, "cell 0 0,alignx center,aligny center");
		
		JLabel lblNewLabel_4 = new JLabel("Gerenciamento de salão");
		getContentPane().add(lblNewLabel_4, "cell 1 1,alignx left,aligny center");
		
		JLabel lblNewLabel_8 = new JLabel("Gerenciamento de funcionários");
		getContentPane().add(lblNewLabel_8, "cell 3 1,alignx center,aligny center");
		
		JLabel lblNewLabel_2 = new JLabel("Mesa:");
		getContentPane().add(lblNewLabel_2, "cell 0 2,alignx right,aligny center");
		
		JComboBox comboBox_4 = new JComboBox();
		getContentPane().add(comboBox_4, "cell 1 2,growx,aligny center");
		
		JLabel lblNewLabel_9 = new JLabel("Nome:");
		getContentPane().add(lblNewLabel_9, "cell 2 2,alignx right,aligny center");
		
		JTextField textField_2 = new JTextField();
		getContentPane().add(textField_2, "cell 3 2,growx,aligny center");
		textField_2.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Ocupar mesa");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnNewButton_6, "cell 1 3,alignx center,aligny center");
		
		JLabel lblNewLabel_11 = new JLabel("Código:");
		getContentPane().add(lblNewLabel_11, "cell 2 3,alignx right,aligny center");
		
		JPasswordField passwordField = new JPasswordField();
		getContentPane().add(passwordField, "cell 3 3,growx,aligny center");
		
		JLabel lblNewLabel_5 = new JLabel("Mesa:");
		getContentPane().add(lblNewLabel_5, "cell 0 4,alignx right,aligny center");
		
		JComboBox comboBox_1 = new JComboBox();
		getContentPane().add(comboBox_1, "cell 1 4,growx,aligny center");
		
		JButton btnNewButton_3 = new JButton("Cadastrar funcionário");
		getContentPane().add(btnNewButton_3, "cell 3 4,alignx center,aligny center");
		
		JLabel lblNewLabel_6 = new JLabel("Garçom:");
		getContentPane().add(lblNewLabel_6, "cell 0 5,alignx right,aligny center");
		
		JComboBox comboBox_2 = new JComboBox();
		getContentPane().add(comboBox_2, "cell 1 5,growx,aligny center");
		
		JLabel lblNewLabel_10 = new JLabel("Nome:");
		getContentPane().add(lblNewLabel_10, "cell 2 5,alignx center,aligny center");
		
		JComboBox comboBox_3 = new JComboBox();
		getContentPane().add(comboBox_3, "cell 3 5,growx,aligny center");
		
		JButton btnNewButton_1 = new JButton("Realocar garçom");
		getContentPane().add(btnNewButton_1, "cell 1 6,alignx center,aligny top");
		
		JButton btnNewButton_4 = new JButton("Remover funcionário");
		getContentPane().add(btnNewButton_4, "cell 3 6,alignx center,aligny center");
		
		JLabel lblNewLabel_7 = new JLabel("Nova mesa:");
		getContentPane().add(lblNewLabel_7, "cell 0 7,alignx right,aligny center");
		
		JTextField textField_1 = new JTextField();
		getContentPane().add(textField_1, "cell 1 7,growx,aligny center");
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Cadastrar mesa");
		getContentPane().add(btnNewButton_2, "cell 1 8,alignx center,aligny center");
		
		
	}

}
