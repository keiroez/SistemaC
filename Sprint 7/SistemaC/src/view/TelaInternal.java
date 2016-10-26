package view;

import javax.swing.JInternalFrame;

public class TelaInternal extends JInternalFrame {
	public TelaInternal(String nomeTela) {
		super(nomeTela, true, true, true, true);
		setLayout(null);
		setSize(600,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
