package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Janela {

	private FrameInicial frameInicial;
	private FrameCaixa frameCaixa;
	private FrameGerente frameGerente;
	private FrameGarcom frameGarcom;

	/**
	 * Lança a aplicação
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela janela = new Janela();
					janela.frameInicial.setVisible(true);
					janela.frameCaixa.setVisible(false);
					janela.frameGerente.setVisible(false);
					janela.frameGarcom.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Inicializa a aplicação
	 */
	public Janela() {
		//Inicializa os frames
		frameInicial = new FrameInicial();
		frameCaixa = new FrameCaixa();
		frameGerente = new FrameGerente();
		frameGarcom = new FrameGarcom();
		
		//TODO: Tratamento de eventos para troca entre frames
		
		JButton btnVoltar = new JButton("Voltar à tela inicial");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameInicial.setVisible(true);
			}
		});
		if(frameGarcom.isVisible()){
			frameGarcom.getContentPane().add(btnVoltar, "cell 0 15");
			}
		
	}
	
	
	

	public FrameInicial getFrameInicial() {
		return frameInicial;
	}

	public FrameCaixa getFrameCaixa() {
		return frameCaixa;
	}

	public FrameGerente getFrameGerente() {
		return frameGerente;
	}

	public FrameGarcom getFrameGarcom() {
		return frameGarcom;
	}
}
