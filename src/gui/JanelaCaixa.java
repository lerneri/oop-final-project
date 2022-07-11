package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class JanelaCaixa {

	private JFrame frmGerenciamentoDeRestaurante;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCaixa window = new JanelaCaixa();
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
	public JanelaCaixa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGerenciamentoDeRestaurante = new JFrame();
		frmGerenciamentoDeRestaurante.setTitle("Gerenciamento de Restaurante - Caixa");
		frmGerenciamentoDeRestaurante.setBounds(100, 100, 450, 300);
		frmGerenciamentoDeRestaurante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGerenciamentoDeRestaurante.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Bem-vindo, CAIXA!");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("Encerrar mesa");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_1, "cell 1 1,aligny baseline");
		
		JLabel lblNewLabel_2 = new JLabel("Mesa:");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		frmGerenciamentoDeRestaurante.getContentPane().add(comboBox, "cell 1 2,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Forma de pagamento:");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_3, "cell 0 3,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		frmGerenciamentoDeRestaurante.getContentPane().add(comboBox_1, "cell 1 3,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Valor recebido (R$):");
		frmGerenciamentoDeRestaurante.getContentPane().add(lblNewLabel_4, "cell 0 4,alignx trailing");
		
		textField = new JTextField();
		textField.setText("000.00");
		frmGerenciamentoDeRestaurante.getContentPane().add(textField, "cell 1 4,growx");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Emitir comprovante");
		frmGerenciamentoDeRestaurante.getContentPane().add(btnNewButton, "cell 1 5");
		
		JButton btnNewButton_1 = new JButton("Voltar à tela inicial");
		frmGerenciamentoDeRestaurante.getContentPane().add(btnNewButton_1, "cell 0 9");
	}

}
