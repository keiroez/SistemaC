package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;


public class TelaProntuario extends TelaInternal {

	private static final long serialVersionUID = 1L;
	private JTextArea campoTextArea;
	private JScrollPane scroll;
	private JLabel campoLabel, campoLabel1, cpf;
	private JButton salvarButton, editarButton, sairButton;
	private JLabel data, horario;
	private JComboBox<String> comboData, comboHorario;
	private JTextField campoCpf;
	private JButton pesquisar;
	private MaskFormatter m1;

	public TelaProntuario() {

		super("Prontuario");
		
		
		try {
			m1 = new MaskFormatter("###.###.###-##");
			
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		setSize(600, 400);
		setLayout(null);
		this.campoLabel = new JLabel("Prontuário selecionado:");
		this.campoLabel1 = new JLabel("Informe a data e o horário do prontuário desejado:");
		this.campoTextArea = new JTextArea();
		this.scroll = new JScrollPane(campoTextArea);
		data = new JLabel("Data: ");
		horario = new JLabel("Horário: ");
		comboData = new JComboBox<>();
		comboHorario = new JComboBox<>();
		cpf = new JLabel("CPF: ");
		campoCpf = new JFormattedTextField(m1);
		pesquisar = new JButton("Pesquisar");
		
		cpf.setBounds(50, 30, 100, 20);
		campoCpf.setBounds(150, 30, 150, 20);
		pesquisar.setBounds(310, 30, 100, 20);
		add(cpf);
		add(campoCpf);
		add(pesquisar);
		
		
		comboData.addItem("Selecione");
		comboHorario.addItem("Selecione");
		data.setBounds(150, 80, 100, 20);
		horario.setBounds(150, 100, 100, 20);
		comboData.setBounds(220, 80, 150, 20);
		comboHorario.setBounds(220, 100, 150, 20);
		
		campoLabel.setBounds(50, 130, 200, 20);
		campoLabel1.setBounds(50, 60, 300, 20);
		add(campoLabel);
		add(campoLabel1);
		
		add(data);
		add(horario);
		add(comboData);
		add(comboHorario);
		
		this.campoTextArea.setEditable(false);
		this.campoTextArea.setLineWrap(true);

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		scroll.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

		Container c = new Container();
		c.setLayout(new GridLayout(1, 2));
		c.setSize(500, 150);
		c.setLocation(50, 150);
		
		c.add(scroll);
		add(c);

		this.salvarButton = new JButton("Salvar");
		this.editarButton = new JButton("Editar");
		this.sairButton = new JButton("Sair");

		salvarButton.setBounds(50, 320, 100, 20);
		editarButton.setBounds(250, 320, 100, 20);
		sairButton.setBounds(450, 320, 100, 20);

		add(salvarButton);
		add(editarButton);
		add(sairButton);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	

	
	public JButton getSalvarButton() {
		return salvarButton;
	}

	public void setSalvarButton(JButton salvarButton) {
		this.salvarButton = salvarButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}

	public JLabel getCampoLabel1() {
		return campoLabel1;
	}


	public void setCampoLabel1(JLabel campoLabel1) {
		this.campoLabel1 = campoLabel1;
	}


	public JButton getEditarButton() {
		return editarButton;
	}


	public void setEditarButton(JButton editarButton) {
		this.editarButton = editarButton;
	}


	public JComboBox<String> getComboData() {
		return comboData;
	}


	public void setComboData(JComboBox<String> comboData) {
		this.comboData = comboData;
	}


	public JComboBox<String> getComboHorario() {
		return comboHorario;
	}


	public void setComboHorario(JComboBox<String> comboHorario) {
		this.comboHorario = comboHorario;
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

	
}
