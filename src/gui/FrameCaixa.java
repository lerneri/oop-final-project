package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FrameCaixa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCaixa frmCaixa = new FrameCaixa();
					frmCaixa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameCaixa() {
		setTitle("Gerenciamento de Restaurante - Caixa");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Bem-vindo, CAIXA!");
		getContentPane().add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("Encerrar mesa");
		getContentPane().add(lblNewLabel_1, "cell 1 1,aligny baseline");
		
		JLabel lblNewLabel_2 = new JLabel("Mesa:");
		getContentPane().add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		getContentPane().add(comboBox, "cell 1 2");
		
		JLabel lblNewLabel_3 = new JLabel("Forma de pagamento:");
		getContentPane().add(lblNewLabel_3, "cell 0 3,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		getContentPane().add(comboBox_1, "cell 1 3");
		
		JLabel lblNewLabel_4 = new JLabel("Valor recebido (R$):");
		getContentPane().add(lblNewLabel_4, "cell 0 4,alignx trailing");
		
		JTextField textField = new JTextField();
		textField.setText("000.00");
		getContentPane().add(textField, "cell 1 4");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Emitir comprovante");
		getContentPane().add(btnNewButton, "cell 1 5");
		
		JButton btnNewButton_1 = new JButton("Voltar à tela inicial");
		getContentPane().add(btnNewButton_1, "cell 0 9");
	}

}
