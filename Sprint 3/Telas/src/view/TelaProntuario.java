package view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class TelaProntuario extends Tela {
	private JTextArea campoTextArea;
	private JScrollPane scroll;
	private JLabel campoLabel;
	private JButton salvarButton, cancelarButton, sairButton;
	
	public TelaProntuario() {
		
		setTitle("Prontuario");
		
		this.campoLabel = new JLabel("Preencha o prontuário abaixo:");
		this.campoTextArea = new JTextArea();
		
		this.scroll = new JScrollPane(campoTextArea);
		
		this.campoTextArea.setEditable(true);
		this.campoTextArea.setLineWrap(true);
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		scroll.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		Container c = new Container();
		c.setLayout(new GridLayout(7, 2));
		c.setSize(500, 800);
		c.setLocation(50, 20);
		c.add(campoLabel);
		c.add(scroll);
		add(c);
		
		this.salvarButton = new JButton("Salvar");
		this.cancelarButton = new JButton("Cancelar");
		this.sairButton = new JButton("Sair");
		
		salvarButton.setBounds(50, 300, 100, 50);
		cancelarButton.setBounds(250, 300, 100, 50);
		sairButton.setBounds(450, 300, 100, 50);
		
		add(salvarButton);
		add(cancelarButton);
		add(sairButton);
		setVisible(true);
	}
}
