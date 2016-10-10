package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

public class TelaBuscaPaciente extends Tela {

	private static final long serialVersionUID = 1L;
	private JLabel cpf;
	private JTextField campoCpf;
	private JButton pesquisar;
	private JTextArea campoTextArea;
	private JScrollPane scroll;
	private MaskFormatter m1;
	
	public TelaBuscaPaciente() {

		setTitle("Busca de Paciente");
		
		try {
			m1 = new MaskFormatter("###.###.###-##");
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		

		cpf = new JLabel("CPF: ");
		campoCpf = new JFormattedTextField(m1);

		pesquisar = new JButton("Pesquisar");

		Container c = new Container();
		c.setLayout(new GridLayout(1, 2));
		c.setSize(400, 20);
		c.setLocation(100, 50);
		c.add(cpf);
		c.add(campoCpf);

		add(c);
		pesquisar.setBounds(250, 300, 100, 20);
		add(pesquisar);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		this.campoTextArea = new JTextArea();
		
		this.scroll = new JScrollPane(campoTextArea);
		
		this.campoTextArea.setEditable(false);
		this.campoTextArea.setLineWrap(true);
		
		scroll.setVisible(false);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		scroll.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		Container c2 = new Container();
		c2.setLayout(new GridLayout(7, 2));
		c2.setSize(500, 800);
		c2.setLocation(50, 120);
		c2.add(scroll);
		add(c2);
		
		setVisible(true);

	}

	public JLabel getCpf() {
		return cpf;
	}

	public void setCpf(JLabel cpf) {
		this.cpf = cpf;
	}

	public JTextField getCampoCpf() {
		return campoCpf;
	}

	public void setCampoCpf(JTextField campoCpf) {
		this.campoCpf = campoCpf;
	}

	public JButton getPesquisar() {
		return pesquisar;
	}

	public void setPesquisar(JButton pesquisar) {
		this.pesquisar = pesquisar;
	}

	public JTextArea getCampoTextArea() {
		return campoTextArea;
	}

	public void setCampoTextArea(JTextArea campoTextArea) {
		this.campoTextArea = campoTextArea;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	
	
	

}
