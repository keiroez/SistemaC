package calendario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;



public class Cal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JCalendar calendario = new JCalendar();
	JButton exibir = new JButton("Exibir");
	JButton minimizar = new JButton("Minimizar");
	
	public Cal() {
		setSize(320, 340);
		setLayout(null);
		exibir.setBounds(10, 10, 70, 20);
		add(exibir);
		minimizar.setBounds(150, 10, 100, 20);
		add(minimizar);
		calendario.setVisible(false);
		calendario.setBounds(10, 40, 300, 300);
		add(calendario);
		
		
		
		exibir.addActionListener(this);
		minimizar.addActionListener(this);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exibir){
			calendario.setVisible(true);
		}
		
		if(e.getSource() == minimizar){
			calendario.setVisible(false);
		}
		
	}
	
	
	
}
