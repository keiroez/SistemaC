package view;


import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class TelaAgendamento extends TelaInternal {

	private static final long serialVersionUID = 1L;
	private JLabel nomePaciente, nomeFuncionario, data, horario;
	private JTextField campoNomePaciente;
	private JButton agendar, carregarHorarios;
	private JComboBox<Object> ItensHorario;
	private JDateChooser dataCalendario;
	private ImageIcon image;
	private JComboBox<String> campoNomeMedicos;
	private JButton buscaP;
	private String[] horas = { "09:00:00", "09:20:00", "09:40:00", "10:00:00", "10:20:00", "10:40:00", "11:00:00",
			"11:20:00", "11:40:00", "12:00:00", "12:20:00", "12:40:00", "13:00:00", "13:20:00", "13:40:00", "14:00:00",
			"14:20:00", "14:40:00", "15:00:00" };
	
	
	public TelaAgendamento() {
		super("Agendamento de consulta");

		ItensHorario = new JComboBox<>();

		nomePaciente = new JLabel("Paciente: ");
		nomeFuncionario = new JLabel("Médico: ");
		data = new JLabel("Data: ");
		horario = new JLabel("Horário: ");

		campoNomePaciente = new JTextField(20);
		campoNomeMedicos = new JComboBox<>();
		campoNomeMedicos.addItem("Selecione");
		campoNomeMedicos.setSize(220, 20);

		dataCalendario = new JDateChooser();
		dataCalendario.setMinSelectableDate(new Date());
		
		image = new ImageIcon("resource/busca.png");
		buscaP = new JButton(image);

		agendar = new JButton("Agendar");
		carregarHorarios = new JButton("Carregar horários");

		nomePaciente.setBounds(100, 50, 200, 20);
		campoNomePaciente.setBounds(300, 50, 200, 20);
		nomeFuncionario.setBounds(100, 75, 200, 20);
		campoNomeMedicos.setBounds(300, 75, 220, 20);
		data.setBounds(100, 100, 200, 20);
		
		
		add(nomePaciente);
		add(campoNomePaciente);
		add(nomeFuncionario);
		add(campoNomeMedicos);
		add(data);

		
		dataCalendario.setBounds(300, 100, 220, 20);
		add(dataCalendario);
		ItensHorario.setBounds(300, 125, 70, 20);
		add(ItensHorario);
		carregarHorarios.setBounds(380, 125, 140, 20);
		add(carregarHorarios);

		

		agendar.setBounds(250, 300, 100, 20);
		add(agendar);
		horario.setBounds(100, 85, 100, 100);
		add(horario);

		buscaP.setBounds(500, 50, 20, 20);
		add(buscaP);

		setVisible(true);

	}

	public boolean campoVazio() {

		if (!campoNomePaciente.getText().equals("") && !dataCalendario.getDate().toString().equals("")
				&& !ItensHorario.getSelectedItem().toString().equals("")) {
			return false;
		}

		else {
			return true;
		}
	}

	public JButton getBuscaP() {
		return buscaP;
	}

	public void setBuscaP(JButton buscaP) {
		this.buscaP = buscaP;
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

	public JComboBox<String> getCampoNomeMedicos() {
		return campoNomeMedicos;
	}

	public void setCampoNomeMedicos(JComboBox<String> campoNomeMedicos) {
		this.campoNomeMedicos = campoNomeMedicos;
	}
	
	
}
