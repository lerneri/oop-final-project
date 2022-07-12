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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class FrameInicial extends JFrame {

	private JPanel contentPane;

	public FrameInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Gerenciamento de Restaurante");
		setBounds(100, 100, 800, 600);
		
		getContentPane().setLayout(new MigLayout("", "[217px][grow][grow][217px]", "[130px][][][][][][130px]"));
		
		JLabel mensagemBoasVindas = new JLabel("Bem-vindo! Selecione o funcionário atual:");
		getContentPane().add(mensagemBoasVindas, "cell 1 0,grow");
	
		JLabel lblFuncao = new JLabel("Função");
		getContentPane().add(lblFuncao, "cell 0 1,alignx trailing,growy");
		
		String[] funcoes = { "Gerente", "Caixa", "Garçom" };
		JComboBox comboBoxFuncao = new JComboBox(funcoes);
		getContentPane().add(comboBoxFuncao, "cell 1 1,growx");
		
		JLabel lblNome = new JLabel("Nome");
		getContentPane().add(lblNome, "cell 0 2,alignx trailing");
		
		JTextField textNome = new JTextField();
		getContentPane().add(textNome, "cell 1 2,growx");
		textNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Código de acesso");
		getContentPane().add(lblNewLabel_3, "cell 0 3,alignx trailing");
		
		JPasswordField passwordCodigo = new JPasswordField();
		getContentPane().add(passwordCodigo, "cell 1 3,growx");
		
		
	}
	

}
