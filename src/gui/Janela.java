package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
		
	}


}
