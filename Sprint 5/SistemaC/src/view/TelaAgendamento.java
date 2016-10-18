package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import app.App;


public class TelaAgendamento extends Tela {

	private static final long serialVersionUID = 1L;
	private JLabel nome, cpf, data, horario;
	private JTextField campoNome, campoCpf;
	private JButton agendar;
	private MaskFormatter m1;
	private JComboBox<Object> ItensHorario;
	private JDateChooser dataCalendario;
	
	public TelaAgendamento() {
		
		
		setTitle("Ageendamento de consulta");
		
		try {
			m1 = new MaskFormatter("###.###.###-##");
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
		
		dataCalendario = new JDateChooser();
		
		
		
		
		agendar = new JButton("Agendar");

		Container c = new Container();
		c.setLayout(new GridLayout(3, 2));
		c.setSize(400, 60);
		c.setLocation(100, 50);
		c.add(nome);
		c.add(campoNome);
		c.add(cpf);
		c.add(campoCpf);
		c.add(data);
		c.add(dataCalendario);
		

		
		
		add(c);
		
		ItensHorario.setBounds(300, 110, 70, 20);
		add(ItensHorario);
		data.setBounds(100, 50, 100, 100);
		
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
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		for(int i = 0; i < App.agendamento.size(); i++){
			
			if(df.format(dataCalendario.getDate()).equals(App.agendamento.get(i).getDataConsulta()) && ItensHorario.getSelectedItem().toString().equals(App.agendamento.get(i).getHorario())){
				return false;
			}
		}		
		
		return true;
	}
	
	
	public boolean campoVazio(){
		
		if(!campoNome.getText().equals("") && !campoCpf.getText().equals("  .   .   -  ") && !dataCalendario.getDate().toString().equals("") && !ItensHorario.getSelectedItem().toString().equals("")){
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
	public JButton getAgendar() {
		return agendar;
	}
	public void setAgendar(JButton agendar) {
		this.agendar = agendar;
	}

	public JLabel getHorario() {
		return horario;
	}

	public void setHorario(JLabel horario) {
		this.horario = horario;
	}


	public JDateChooser getDataCalendario() {
		return dataCalendario;
	}


	public void setDataCalendario(JDateChooser dataCalendario) {
		this.dataCalendario = dataCalendario;
	}


	public JComboBox<Object> getItensHorario() {
		return ItensHorario;
	}


	public void setItensHorario(JComboBox<Object> itensHorario) {
		ItensHorario = itensHorario;
	}

	

	
}
