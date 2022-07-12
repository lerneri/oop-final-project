package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Janela {

	private FrameInicial frameInicial;
	private FrameCaixa frameCaixa;
	private FrameGerente frameGerente;
	private FrameGarcom frameGarcom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela janela = new Janela();
					janela.frameInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameInicial = new FrameInicial();
		frameCaixa = new FrameCaixa();
		frameGerente = new FrameGerente();
		frameGarcom = new FrameGarcom();
	}

}
