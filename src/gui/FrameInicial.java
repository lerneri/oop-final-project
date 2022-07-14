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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import backend.*;
import excecoes.CodigoGarcomInvalidoException;
import excecoes.CodigoItemInvalidoException;
import excecoes.ConjuntoGarcomVazioException;
import excecoes.GarcomInexistenteException;
import excecoes.NomeInvalidoException;

import javax.swing.SwingConstants;
import java.awt.Component;

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
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux = comboBoxFuncao.getSelectedItem().toString();
				if(aux.equalsIgnoreCase("Gerente") == true) {
					String codigo = passwordCodigo.getText();
					if(codigo.equals("3030")==true) {
						Janela j = new Janela();
						j.getFrameGerente().setVisible(true);
						JButton btnVoltar = new JButton("Voltar");
						btnVoltar.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								j.getFrameGerente().setVisible(false);
							}
						
						});
						j.getFrameGerente().add(btnVoltar, "cell 0 10,alignx center,aligny center");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Login inválido");
					}
				} 
				else if(aux == "Garçom") {
					String nome = textNome.getText();
					String codigo = passwordCodigo.getText(); 
					try {
						Garcom garcom = Fachada.getInstancia().getConjuntoGarcons().getGarcom(codigo);
						if(nome.equals(garcom.getNome())==true) {
							Janela j = new Janela();
							j.getFrameGarcom().setVisible(true);
							JButton btnVoltar = new JButton("Voltar");
							btnVoltar.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent e) {
									j.getFrameGarcom().setVisible(false);
								}
							
							});
							j.getFrameGarcom().add(btnVoltar, "cell 0 16,alignx center,aligny center");
						}
					} catch (GarcomInexistenteException | ConjuntoGarcomVazioException | IOException
							| CodigoItemInvalidoException e1) {
						JOptionPane.showMessageDialog(contentPane, "Login inválido");
					}
				}
				else if(aux.equalsIgnoreCase("Caixa") == true){
					String codigo = passwordCodigo.getText(); 
					if(codigo.equals("0000")) {
						Janela j = new Janela();
						j.getFrameCaixa().setVisible(true);
						JButton btnVoltar = new JButton("Voltar");
						btnVoltar.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								j.getFrameCaixa().setVisible(false);
							}
						
						});
						j.getFrameCaixa().add(btnVoltar, "cell 0 10,alignx center,aligny center");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Login inválido");
					}
				}
			}
		});
		getContentPane().add(btnLogin, "cell 1 5,alignx center");
		
		
	}
	

}
