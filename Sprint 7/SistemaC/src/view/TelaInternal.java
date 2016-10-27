package view;

import javax.swing.JInternalFrame;

public class TelaInternal extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	public TelaInternal(String nomeTela) {
		super(nomeTela, true, true, true, true);
		setLayout(null);
		setLocation(100, 50);
		setSize(600,400);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		
	}
}
