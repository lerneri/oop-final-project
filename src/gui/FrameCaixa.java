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
	
	//Tela referente ao caixa do restaurante

	private JPanel contentPane;

	public FrameCaixa() {
		setTitle("Gerenciamento de Restaurante - Caixa");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][]"));
		
		JLabel mensagemBoasVindas = new JLabel("Bem-vindo, CAIXA!");
		getContentPane().add(mensagemBoasVindas, "cell 0 0");
		
		//Seleção de mesa para emissão de pagamento
		
		JLabel lblEncerrarMesa = new JLabel("Encerrar mesa");
		getContentPane().add(lblEncerrarMesa, "cell 1 1,aligny baseline");
		
		JLabel lblMesa = new JLabel("Mesa:");
		getContentPane().add(lblMesa, "cell 0 2,alignx trailing");
		
		JComboBox comboBoxMesas = new JComboBox();
		getContentPane().add(comboBoxMesas, "cell 1 2");
		
		//Formas de pagamento
		
		String[] pagamentos = { "Crédito", "Débito", "Espécie", "PIX", "Cheque" };
		
		JLabel lblPagamentos = new JLabel("Forma de pagamento:");
		getContentPane().add(lblPagamentos, "cell 0 3,alignx trailing");
		
		JComboBox comboBoxPagamento = new JComboBox(pagamentos);
		getContentPane().add(comboBoxPagamento, "cell 1 3");
		
		JLabel lblValor = new JLabel("Valor recebido (R$):");
		getContentPane().add(lblValor, "cell 0 4,alignx trailing");
		
		JTextField valor = new JTextField();
		valor.setText("000.00");
		getContentPane().add(valor, "cell 1 4");
		valor.setColumns(10);
		
		//Emissão de comprovante
		
		JButton btnComprovante = new JButton("Emitir comprovante");
		getContentPane().add(btnComprovante, "cell 1 5");
		
		//Voltar ao frame de login
		
		JButton btnVoltar = new JButton("Voltar à tela inicial");
		getContentPane().add(btnVoltar, "cell 0 9");
		
	}

}
