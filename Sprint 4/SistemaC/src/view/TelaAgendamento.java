package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TelaAgendamento extends Tela {

	private JLabel nome, cpf, data, horario;
	private JTextField campoNome, campoCpf, campoData, campoHorario;
	private JButton agendar;
	private MaskFormatter m1, m2, m3;
	
	public TelaAgendamento() {
		
		
		setTitle("Ageendamento de consulta");
		
		try {
			m1 = new MaskFormatter("###.###.###-##");
			m2 =  new MaskFormatter("##/##/####");
			m3 = new MaskFormatter("##:##");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		nome = new JLabel("Nome: ");
		cpf = new JLabel("CPF: ");
		data = new JLabel("Data: ");
		horario = new JLabel("Horário: ");

		campoNome = new JTextField(20);
		campoCpf = new JFormattedTextField(m1);
		campoData = new JFormattedTextField(m2);
		campoHorario = new JFormattedTextField(m3);
		
		
		
		agendar = new JButton("Agendar");

		Container c = new Container();
		c.setLayout(new GridLayout(4, 2));
		c.setSize(400, 100);
		c.setLocation(100, 100);
		c.add(nome);
		c.add(campoNome);
		c.add(cpf);
		c.add(campoCpf);
		c.add(data);
		c.add(campoData);
		c.add(horario);
		c.add(campoHorario);
		
		add(c);
		agendar.setBounds(250, 300, 100, 20);
		add(agendar);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	
	}
	
	
	
	
	
	
	public JLabel getNome() {
		return nome;
	}
	public void setNome(JLabel nome) {
		this.nome = nome;
	}
	public JLabel getCpf() {
		return cpf;
	}
	public void setCpf(JLabel cpf) {
		this.cpf = cpf;
	}
	public JLabel getData() {
		return data;
	}
	public void setData(JLabel data) {
		this.data = data;
	}
	public JTextField getCampoNome() {
		return campoNome;
	}
	public void setCampoNome(JTextField campoNome) {
		this.campoNome = campoNome;
	}
	public JTextField getCampoCpf() {
		return campoCpf;
	}
	public void setCampoCpf(JTextField campoCpf) {
		this.campoCpf = campoCpf;
	}
	public JTextField getCampoData() {
		return campoData;
	}
	public void setCampoData(JTextField campoData) {
		this.campoData = campoData;
	}
	public JButton getAgendar() {
		return agendar;
	}
	public void setAgendar(JButton agendar) {
		this.agendar = agendar;
	}






	public JTextField getCampoHorario() {
		return campoHorario;
	}






	public void setCampoHorario(JTextField campoHorario) {
		this.campoHorario = campoHorario;
	}
	
	
	
	
	
}
