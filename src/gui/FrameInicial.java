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

import excecoes.CodigoGarcomInvalidoException;
import excecoes.CodigoItemInvalidoException;
import excecoes.ConjuntoGarcomVazioException;
import excecoes.GarcomInexistenteException;
import excecoes.NomeInvalidoException;
import fachada.Fachada;
import garcom.Garcom;

import javax.swing.SwingConstants;
import java.awt.Component;

public class FrameInicial extends JFrame {

	private JPanel contentPane;

	public FrameInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Gerenciamento de Restaurante");
		setBounds(100, 100, 800, 600);

		getContentPane().setLayout(new MigLayout("", "[217px][grow][grow]", "[130px][][][][][][130px]"));

		JLabel mensagemBoasVindas = new JLabel("Bem-vindo! Selecione o funcion�rio atual:");
		getContentPane().add(mensagemBoasVindas, "cell 1 0,alignx center,growy");

		JLabel lblFuncao = new JLabel("Fun��o");
		getContentPane().add(lblFuncao, "cell 0 1,alignx trailing,growy");

		String[] funcoes = { "Gerente", "Caixa", "Gar�om" };
		JComboBox comboBoxFuncao = new JComboBox(funcoes);
		getContentPane().add(comboBoxFuncao, "cell 1 1,growx");

		JLabel lblNome = new JLabel("Nome");
		getContentPane().add(lblNome, "cell 0 2,alignx trailing");

		JTextField textNome = new JTextField();
		getContentPane().add(textNome, "cell 1 2,growx");
		textNome.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("C�digo de acesso");
		getContentPane().add(lblNewLabel_3, "cell 0 3,alignx trailing");

		JPasswordField passwordCodigo = new JPasswordField();
		passwordCodigo.setColumns(4);
		getContentPane().add(passwordCodigo, "cell 1 3,growx");

		JButton btnLogin = new JButton("Login");
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux = comboBoxFuncao.getSelectedItem().toString();
				if (aux.equalsIgnoreCase("Gerente") == true) {
					String codigo = passwordCodigo.getText();
					if (codigo.equals("3030") == true) {
						Janela j = new Janela();
						j.getFrameGerente().setVisible(true);
						JButton btnVoltar = new JButton("Voltar");
						btnVoltar.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								j.getFrameGerente().setVisible(false);
							}

						});
						j.getFrameGerente().getContentPane().add(btnVoltar, "cell 0 25,alignx center,aligny center");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Login inv�lido");
					}
				} else if (aux == "Gar�om") {
					String nome = textNome.getText();
					String codigo = passwordCodigo.getText();

					Garcom garcom;
					try {
						
						garcom = Fachada.getInstancia().getConjuntoGarcons().getGarcom(codigo);
						if (nome.equals(garcom.getNome())) {
							Janela j = new Janela();
							j.getFrameGarcom().setTitle("Gerenciamento de Restaurante - Gar�om " + garcom.getNome());
							j.getFrameGarcom().setVisible(true);
							j.getFrameGarcom().setGarcomFrame(codigo);
							JLabel mensagemBoasVindas = new JLabel("Bem-vindo, " + garcom.getNome()+ "!");
							JButton btnVoltar = new JButton("Voltar");
							btnVoltar.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent e) {
									j.getFrameGarcom().setVisible(false);
								}

							});
							j.getFrameGarcom().getContentPane().add(mensagemBoasVindas, "cell 0 0");
							j.getFrameGarcom().getContentPane().add(btnVoltar, "cell 0 16,alignx center,aligny center");
							
						}else {
							JOptionPane.showMessageDialog(contentPane, "Nome gar�om inv�lido");
						}
					} catch (GarcomInexistenteException e1) {
						JOptionPane.showMessageDialog(contentPane, "Garcom inexistente");
					} catch (ConjuntoGarcomVazioException e1) {
						JOptionPane.showMessageDialog(contentPane, "Conjunto gar�om vazio");
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(contentPane, "IO exception");
					} catch (CodigoItemInvalidoException e1) {
						JOptionPane.showMessageDialog(contentPane, "C�digo de algum item inv�lido no card�pio");
					}

				} else if (aux.equalsIgnoreCase("Caixa") == true) {
					String codigo = passwordCodigo.getText();
					if (codigo.equals("0000")) {
						Janela j = new Janela();
						j.getFrameCaixa().setVisible(true);
						JButton btnVoltar = new JButton("Voltar");
						btnVoltar.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								j.getFrameCaixa().setVisible(false);
							}

						});
						j.getFrameCaixa().getContentPane().add(btnVoltar, "cell 0 16,alignx center");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Login inv�lido");
					}
				}
			}
		});
		getContentPane().add(btnLogin, "cell 1 5,alignx center");

	}

}
