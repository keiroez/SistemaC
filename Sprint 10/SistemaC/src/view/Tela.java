package view;

import javax.swing.JFrame;

public abstract class Tela extends JFrame {

	private static final long serialVersionUID = 1L;

	public Tela() {
		setSize(800, 600);
		this.getContentPane().setLayout(null);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
