package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JCalendar;



public class Calendario extends JPanel implements MouseListener, ActionListener{

	private static final long serialVersionUID = 1L;
	private JCalendar calendario;
	private JButton ok;
	private JTextField campoData;
	private MaskFormatter m2;
	
		
	
	public Calendario() {
		
		setSize(200, 180);
		setLayout(null);
		

		try {
			
			m2 =  new MaskFormatter("##/##/####");
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		calendario = new JCalendar();
		
		
	
		campoData = new JFormattedTextField(m2);
		campoData.setBounds(0, 10, 200, 20);
		add(campoData);
		calendario.setVisible(false);
		calendario.setBounds(50, 30, 150, 150);
		add(calendario);
		ok = new JButton("Ok");
		ok.setBounds(70, 190, 50, 20);
		add(ok);
		ok.setVisible(false);
		
		campoData.addMouseListener(this);
		ok.addActionListener(this);
		
		
		setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
//		if(arg0.getSource() == ok){
//			ok.setVisible(false);
//			calendario.setVisible(false);
//		}		
	}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
//			calendario.setVisible(true);
//			ok.setVisible(true);	
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	
	public JCalendar getCalendario() {
		return calendario;
	}



	public void setCalendario(JCalendar calendario) {
		this.calendario = calendario;
	}



	public JButton getOk() {
		return ok;
	}



	public void setOk(JButton ok) {
		this.ok = ok;
	}



	public JTextField getCampoData() {
		return campoData;
	}



	public void setCampoData(String data) {
		this.campoData.setText(data);
	}



	

	
	
}
