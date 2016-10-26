package view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import model.Paciente;

public class TelaProntuario extends TelaInternal {

	private static final long serialVersionUID = 1L;
	private JTextArea campoTextArea;
	private JScrollPane scroll;
	private JLabel campoLabel;
	private JButton salvarButton, cancelarButton, sairButton;

	public TelaProntuario() {

		super("Prontuario");

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void preencherProntuario(Paciente p) {

		campoTextArea.setText(p.getProtuario().getHistorico());

	}

	public JButton getSalvarButton() {
		return salvarButton;
	}

	public void setSalvarButton(JButton salvarButton) {
		this.salvarButton = salvarButton;
	}

	public JButton getCancelarButton() {
		return cancelarButton;
	}

	public void setCancelarButton(JButton cancelarButton) {
		this.cancelarButton = cancelarButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}

	public void setSairButton(JButton sairButton) {
		this.sairButton = sairButton;
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

	public JLabel getCampoLabel() {
		return campoLabel;
	}

	public void setCampoLabel(JLabel campoLabel) {
		this.campoLabel = campoLabel;
	}

}
