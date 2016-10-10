package view;

import javax.swing.JFrame;

import control.Controller;

public abstract class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private Controller controle;

	public Tela() {
		
		setSize(600, 400);
		setLocationRelativeTo(null);
		setLayout(null);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
