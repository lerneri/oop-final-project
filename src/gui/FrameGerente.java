package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

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
import restaurante.Mesa;
import excecoes.CodigoItemInvalidoException;
import excecoes.ConjuntoGarcomVazioException;
import excecoes.ConjuntoMesasVazioException;
import excecoes.GarcomInexistenteException;
import excecoes.GarcomJaPossuiMesaException;
import excecoes.CodigoGarcomInvalidoException;
import excecoes.CodigoGarcomJaExistenteException;
import excecoes.MesaInexistenteException;
import excecoes.MesaJaExistenteException;
import excecoes.NomeInvalidoException;
import excecoes.NumeroMesaInvalidoException;
import fachada.Fachada;
import garcom.Garcom;

public class FrameGerente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField tfRemoverMesa;

	public FrameGerente() {
		setTitle("Gerenciamento de Restaurante - Gerente");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[106px][:115px:115px,grow][37px][172px][][][][][]", "[14px][14px][22px][23px][23px][22px][23px][20px][23px][][][][][][][][][][][]"));

		JLabel mensagemBoasVindas = new JLabel("Bem-vindo, GERENTE!");
		getContentPane().add(mensagemBoasVindas, "cell 0 0,alignx center,aligny center");

		JLabel lblGerenciamentoSalao = new JLabel("Gerenciamento de salão");
		getContentPane().add(lblGerenciamentoSalao, "cell 1 1,alignx left,aligny center");
		
				JLabel lblGerenciamentoFuncionarios = new JLabel("Gerenciamento de funcionários");
				getContentPane().add(lblGerenciamentoFuncionarios, "cell 7 1,alignx center,aligny center");
								
										JLabel lblNewLabel_7 = new JLabel("Nova mesa:");
										getContentPane().add(lblNewLabel_7, "cell 0 3,alignx right,aligny center");
								
										JTextField textField_1 = new JTextField();
										getContentPane().add(textField_1, "cell 1 3,alignx left,aligny center");
										textField_1.setColumns(2);
		
				JLabel Nome1 = new JLabel("Nome:");
				getContentPane().add(Nome1, "cell 6 3,alignx right,aligny center");
		
				JTextField textField_2 = new JTextField();
				getContentPane().add(textField_2, "cell 7 3,alignx left,aligny center");
				textField_2.setColumns(10);
						
								JButton btnNewButton_2 = new JButton("Cadastrar mesa");
								btnNewButton_2.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										try {
											Mesa m = new Mesa(textField_1.getText());
											Fachada.getInstancia().getConjuntoMesas().inserirMesa(m);
											JOptionPane.showMessageDialog(contentPane, "Mesa inserida com sucesso!");
											textField_1.setText("");
										} catch (NumeroMesaInvalidoException e1) {
											JOptionPane.showMessageDialog(contentPane, "Numero da mesa deve conter apenas 2 números!");
										} catch (MesaJaExistenteException e1) {
											JOptionPane.showMessageDialog(contentPane, "Mesa já existente");
										} catch (IOException e1) {
											JOptionPane.showMessageDialog(contentPane, "IOException");
										} catch (CodigoItemInvalidoException e1) {
											JOptionPane.showMessageDialog(contentPane,
													"Codigo de algum item no Cardapio foi digitado incorretamente");
										}
									}
								});
								getContentPane().add(btnNewButton_2, "cell 1 4,alignx center,aligny center");
		
				JLabel lblNewLabel_11 = new JLabel("Código:");
				getContentPane().add(lblNewLabel_11, "cell 6 4,alignx right,aligny center");
		
				JPasswordField passwordField = new JPasswordField();
				passwordField.setColumns(4);
				getContentPane().add(passwordField, "cell 7 4,alignx left,aligny center");
		
				JButton btnNewButton_3 = new JButton("Cadastrar garçom");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (textField_2.getText().length() <= 3) {
							JOptionPane.showMessageDialog(contentPane, "Nome deve possuir mais de 3 letras");
						}
						try {
							Garcom g = new Garcom(textField_2.getText(), passwordField.getText());
							Fachada.getInstancia().getConjuntoGarcons().inserirGarcom(g);
							JOptionPane.showMessageDialog(contentPane, "Garçom inserido com sucesso!");
							textField_2.setText("");
							passwordField.setText("");
						} catch (CodigoGarcomJaExistenteException e1) {
							JOptionPane.showMessageDialog(contentPane, "Código do garçom já existe");
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(contentPane, "IO Exception");
						} catch (CodigoGarcomInvalidoException e1) {
							JOptionPane.showMessageDialog(contentPane, "Codigo do garçom deve possuir apenas 4 números!");
						} catch (CodigoItemInvalidoException e1) {
							JOptionPane.showMessageDialog(contentPane,"Codigo de algum item no Cardapio foi digitado incorretamente!");
						} catch (NomeInvalidoException e1) {
							JOptionPane.showMessageDialog(contentPane, "Nome do garçom deve possuir apenas letras e espaços!");
						}

					}
				});
				getContentPane().add(btnNewButton_3, "cell 7 5,alignx center,aligny center");
								
										JLabel lblNewLabel_5 = new JLabel("Mesa:");
										getContentPane().add(lblNewLabel_5, "cell 0 6,alignx trailing,aligny center");
						
								textField = new JTextField();
								getContentPane().add(textField, "cell 1 6,alignx left");
								textField.setColumns(2);
						
								JLabel lblNewLabel_6 = new JLabel("Garçom:");
								getContentPane().add(lblNewLabel_6, "cell 0 7,alignx trailing,aligny center");
				
						textField_3 = new JTextField();
						getContentPane().add(textField_3, "cell 1 7,growx");
						textField_3.setColumns(4);
		
				JLabel lblNewLabel_10 = new JLabel("Código:");
				getContentPane().add(lblNewLabel_10, "cell 6 7,alignx trailing,aligny center");
		
		textField_5 = new JTextField();
		getContentPane().add(textField_5, "cell 7 7,alignx left");
		textField_5.setColumns(4);
		
				JButton btnNewButton_4 = new JButton("Remover garçom");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String codigo = textField_5.getText();
						Garcom garcom;
						try {
							garcom = Fachada.getInstancia().getConjuntoGarcons().getGarcom(codigo);
							Fachada.getInstancia().getGerente().removerGarcom(garcom);
							textField_5.setText("");
							JOptionPane.showMessageDialog(contentPane, "Garcom removido com sucesso!");
						} catch (GarcomInexistenteException e1) {
							JOptionPane.showMessageDialog(contentPane, "Garcom inexistente");
						} catch (ConjuntoGarcomVazioException e1) {
							JOptionPane.showMessageDialog(contentPane, "Conjunto de garçons vazio!");
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(contentPane, "IO Exception");
						} catch (CodigoItemInvalidoException e1) {
							JOptionPane.showMessageDialog(contentPane, "Codigo de algum item no Cardapio foi digitado incorretamente");
						}
						
					}
				});
				
						JButton btnNewButton_1 = new JButton("Realocar garçom");
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String numeroMesa = textField.getText();
								String numeroGarcom = textField_3.getText();
								try {
									Fachada.getInstancia().getGerente().alocarGarcomMesa(numeroMesa, numeroGarcom);
									JOptionPane.showMessageDialog(contentPane, "Garcom Realocado com sucesso!");
									textField.setText("");
									textField_3.setText("");
								} catch (ConjuntoMesasVazioException e1) {
									JOptionPane.showMessageDialog(contentPane, "Conjunto de mesas vazio!");
								} catch (ConjuntoGarcomVazioException e1) {
									JOptionPane.showMessageDialog(contentPane, "Conjunto de garçons vazio!");
								} catch (GarcomInexistenteException e1) {
									JOptionPane.showMessageDialog(contentPane, "Garcom inexistente");
								} catch (MesaInexistenteException e1) {
									JOptionPane.showMessageDialog(contentPane, "Mesa inexistente");
								} catch (IOException e1) {
									JOptionPane.showMessageDialog(contentPane, "IO Exception");
								} catch (CodigoItemInvalidoException e1) {
									JOptionPane.showMessageDialog(contentPane,"Codigo de algum item no Cardapio foi digitado incorretamente");
								} catch (GarcomJaPossuiMesaException e1) {
									JOptionPane.showMessageDialog(contentPane,"Garçom já possui essa mesa");
								}
							}
						});
						getContentPane().add(btnNewButton_1, "cell 1 8,alignx center,aligny top");
				getContentPane().add(btnNewButton_4, "cell 7 8,alignx center,aligny center");
		
		
		JButton btnListarGarons = new JButton("Listar garçons");
		btnListarGarons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameListarGarcons fg = new FrameListarGarcons();
				fg.setSize(400, 400);
				fg.setVisible(true);
			}
		});
		
				JLabel lblMesa1 = new JLabel("Mesa:");
				getContentPane().add(lblMesa1, "cell 0 10,alignx trailing,aligny center");
		
				textField_4 = new JTextField();
				getContentPane().add(textField_4, "cell 1 10,alignx left");
				textField_4.setColumns(2);
		getContentPane().add(btnListarGarons, "cell 7 10,alignx center");
		
		JButton btnListarMesas = new JButton("Listar Mesas");
		btnListarMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameListarMesas fm = new FrameListarMesas();
				fm.setSize(400, 400);
				fm.setVisible(true);
			}
		});
		
		JButton btnRemoverMesa = new JButton("Remover mesa");
		btnRemoverMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeroMesa = tfRemoverMesa.getText();
				try {
					Mesa m = Fachada.getInstancia().getConjuntoMesas().getMesa(numeroMesa);
					Fachada.getInstancia().getConjuntoMesas().removerMesa(m);
					JOptionPane.showMessageDialog(contentPane, "Mesa removida com sucesso!");
					tfRemoverMesa.setText("");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(contentPane, "IOException");
				} catch (CodigoItemInvalidoException e1) {
					JOptionPane.showMessageDialog(contentPane,
							"Codigo de algum item no Cardapio foi digitado incorretamente");
				} catch (MesaInexistenteException e1) {
					JOptionPane.showMessageDialog(contentPane, "Mesa inexistente");
				} catch (ConjuntoMesasVazioException e1) {
					JOptionPane.showMessageDialog(contentPane, "Mesa inexistente");
				}
			}
		});
		
				JButton btnOcupar = new JButton("Ocupar mesa");
				btnOcupar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String s = textField_4.getText();
							Mesa m;
							m = Fachada.getInstancia().getConjuntoMesas().getMesa(s);
							if (m.isOcupada() == true) {
								JOptionPane.showMessageDialog(contentPane, "Mesa Já Ocupada");
								return;
							}
							m.setOcupada(true);
							JOptionPane.showMessageDialog(contentPane, "Mesa ocupada com sucesso!");
							textField_4.setText("");
						} catch (ConjuntoMesasVazioException e1) {
							JOptionPane.showMessageDialog(contentPane, "Conjunto de Mesas vazio");
						} catch (IOException e2) {
							JOptionPane.showMessageDialog(contentPane, "IO Exception");
						} catch (CodigoItemInvalidoException e2) {
							JOptionPane.showMessageDialog(contentPane,
									"Codigo de algum item no Cardapio foi digitado incorretamente");
						} catch (MesaInexistenteException e1) {
							JOptionPane.showMessageDialog(contentPane, "Mesa inexistente");
						}

					}
				});
				getContentPane().add(btnOcupar, "cell 1 11,alignx center,aligny center");
		
		JLabel lblRemoverMesa = new JLabel("Mesa:");
		getContentPane().add(lblRemoverMesa, "cell 0 13,alignx trailing");
		
		tfRemoverMesa = new JTextField();
		tfRemoverMesa.setColumns(2);
		getContentPane().add(tfRemoverMesa, "cell 1 13,alignx left");
		getContentPane().add(btnRemoverMesa, "cell 1 14,alignx center");
		getContentPane().add(btnListarMesas, "cell 1 16,alignx center");

	}
}
