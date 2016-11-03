package view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;



public class TelaAgendamento extends TelaInternal{

	private static final long serialVersionUID = 1L;
	private JLabel nomePaciente, nomeFuncionario, data, horario;
	private JTextField campoNomePaciente, campoNomeFuncionario;
	private JButton agendar, carregarHorarios;
	private JComboBox<Object> ItensHorario;
	private JDateChooser dataCalendario;
	private ImageIcon image;
	private JButton buscaP, buscaF;
	private String cpfPaciente, cpfFuncionario;
	private String [] horas = {"09:00", "09:20", "09:40", "10:00", "10:20", "10:40", "11:00", "11:20", "11:40", "12:00", "12:20", "12:40", "13:00", "13:20", "13:40", "14:00", "14:20", "14:40", "15:00"};
	
	
	public TelaAgendamento() {
		super("Agendamento de consulta");
		
		
		ItensHorario = new JComboBox<>();
		
		nomePaciente = new JLabel("Paciente: ");
		nomeFuncionario = new JLabel("Funcionário: ");
		data = new JLabel("Data: ");
		horario = new JLabel("Horário: ");

		campoNomePaciente = new JTextField(20);
		campoNomePaciente.setEditable(false);
		campoNomeFuncionario = new JTextField(20);
		campoNomeFuncionario.setEditable(false);
		
		dataCalendario = new JDateChooser();
		
		image = new ImageIcon("resource/busca.png");
		buscaP = new JButton(image);
		buscaF = new JButton(image);
		
		agendar = new JButton("Agendar");
		carregarHorarios = new JButton("Carregar horários");

		Container c = new Container();
		c.setLayout(new GridLayout(3, 2));
		c.setSize(400, 60);
		c.setLocation(100, 50);
		c.add(nomePaciente);
		c.add(campoNomePaciente);
		c.add(nomeFuncionario);
		c.add(campoNomeFuncionario);
		c.add(data);
		
		
		add(c);
		dataCalendario.setBounds(300, 90, 220, 20);
		add(dataCalendario);
		ItensHorario.setBounds(300, 110, 70, 20);
		add(ItensHorario);
		carregarHorarios.setBounds(380, 110, 140, 20);
		add(carregarHorarios);
		
		data.setBounds(100, 50, 100, 100);
		
		agendar.setBounds(250, 320, 100, 20);
		add(agendar);
		horario.setBounds(100, 70, 100, 100);
		add(horario);
		
		buscaP.setBounds(500, 50, 20, 20);
		add(buscaP);
		buscaF.setBounds(500, 70, 20, 20);
		add(buscaF);
		
		
		
		setVisible(true);
		
		
	}
	
	
	public boolean campoVazio(){
		
		if(!campoNomePaciente.getText().equals("") && !dataCalendario.getDate().toString().equals("") && !ItensHorario.getSelectedItem().toString().equals("")){
			return false;
		}
		
		else{
			return true;
		}
	}
	
		
	public String getCpfPaciente() {
		return cpfPaciente;
	}



	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}



	public String getCpfFuncionario() {
		return cpfFuncionario;
	}



	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}



	public JButton getBuscaP() {
		return buscaP;
	}



	public void setBuscaP(JButton buscaP) {
		this.buscaP = buscaP;
	}



	public JButton getBuscaF() {
		return buscaF;
	}



	public void setBuscaF(JButton buscaF) {
		this.buscaF = buscaF;
	}



	public JLabel getNomePaciente() {
		return nomePaciente;
	}



	public void setNomePaciente(JLabel nomePaciente) {
		this.nomePaciente = nomePaciente;
	}



	public JLabel getNomeFuncionario() {
		return nomeFuncionario;
	}



	public void setNomeFuncionario(JLabel nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}



	public JLabel getData() {
		return data;
	}
	public void setData(JLabel data) {
		this.data = data;
	}


	public JTextField getCampoNomePaciente() {
		return campoNomePaciente;
	}



	public void setCampoNomePaciente(JTextField campoNomePaciente) {
		this.campoNomePaciente = campoNomePaciente;
	}



	public JTextField getCampoNomeFuncionario() {
		return campoNomeFuncionario;
	}



	public void setCampoNomeFuncionario(JTextField campoNomeFuncionario) {
		this.campoNomeFuncionario = campoNomeFuncionario;
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

	
		
	public JButton getCarregarHorarios() {
		return carregarHorarios;
	}


	public void setCarregarHorarios(JButton carregarHorarios) {
		this.carregarHorarios = carregarHorarios;
	}


	public String[] getHoras() {
		return horas;
	}


	public void setHoras(String[] horas) {
		this.horas = horas;
	}

	

	

	
}
