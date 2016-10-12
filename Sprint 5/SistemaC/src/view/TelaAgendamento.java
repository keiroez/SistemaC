package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import app.App;
import model.Calendario;

public class TelaAgendamento extends Tela {

	private static final long serialVersionUID = 1L;
	private JLabel nome, cpf, data, horario;
	private JTextField campoNome, campoCpf, campoData, campoHorario;
	private JButton agendar;
	private MaskFormatter m1, m2, m3;
	private Calendario calendario;
	private JMenu menu;
	private JComboBox ItensHorario;
	
	public TelaAgendamento() {
		
		
		setTitle("Ageendamento de consulta");
		
		try {
			m1 = new MaskFormatter("###.###.###-##");
			m2 =  new MaskFormatter("##/##/####");
			m3 = new MaskFormatter("##:##");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		ItensHorario = new JComboBox<>();
		
				
		for(int i = 9; i <= 15; i++){
			for(int j = 0; j<60; j+=20){
				
				if(i<15) {
					if(j==0) ItensHorario.addItem(""+i+":"+""+j+"0");
					else ItensHorario.addItem(""+i+":"+""+j);
				}
				if(i==15 && j == 0){
					ItensHorario.addItem(""+i+":"+""+j+"0");
				}
				
			}
		}
		
		nome = new JLabel("Nome: ");
		cpf = new JLabel("CPF: ");
		data = new JLabel("Data: ");
		horario = new JLabel("Horário: ");

		campoNome = new JTextField(20);
		campoCpf = new JFormattedTextField(m1);
		calendario = new Calendario();
		
		
		
		agendar = new JButton("Agendar");

		Container c = new Container();
		c.setLayout(new GridLayout(2, 2));
		c.setSize(400, 40);
		c.setLocation(100, 50);
		c.add(nome);
		c.add(campoNome);
		c.add(cpf);
		c.add(campoCpf);
		

		
		
		add(c);
		
		ItensHorario.setBounds(300, 110, 70, 20);
		add(ItensHorario);
		data.setBounds(100, 50, 100, 100);
		calendario.setBounds(300, 80, 220, 240);
		add(calendario);
		add(data);
		agendar.setBounds(250, 340, 100, 20);
		add(agendar);
		horario.setBounds(100, 70, 100, 100);
		add(horario);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	
	}
	
	
	public boolean verificarCadastro(){
		
		for(int i = 0; i < App.pacientes.size(); i++){
		
			if(campoCpf.getText().equals(App.pacientes.get(i).getCpf())){
				return true;
			}
		}
				
		return false;
	}
	
	
	public boolean horarioDisponivel(){
		
		for(int i = 0; i < App.agendamento.size(); i++){
			
			if(campoData.getText().equals(App.agendamento.get(i).getDataConsulta()) && campoHorario.getText().equals(App.agendamento.get(i).getHorario())){
				return false;
			}
		}		
		
		return true;
	}
	
	
	public boolean campoVazio(){
		
		if(!campoNome.getText().equals("") && !campoCpf.getText().equals("  .   .   -  ") && !campoData.getText().equals("  /  /    ") && !campoHorario.getText().equals("  :  ")){
			return false;
		}
		
		else{
			return true;
		}
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


	public JLabel getHorario() {
		return horario;
	}


	public void setHorario(JLabel horario) {
		this.horario = horario;
	}


	public Calendario getCalendario() {
		return calendario;
	}


	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	
	
	
	
	
}
