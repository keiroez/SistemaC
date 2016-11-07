package model;

import java.sql.Date;


public class Agenda {

	private int id;
	private String dataConsulta;
	private String horario;
	private Paciente paciente;
	private Funcionario funcionario;
	private String prontuario;
	
	public Agenda(String dataConsulta, String horario, Paciente paciente, Funcionario funcionario) {
		this.dataConsulta = dataConsulta;
		this.horario = horario;
		this.paciente = paciente;
		this.funcionario = funcionario;
	}

	


	public String getDataConsulta() {
		return dataConsulta;
	}




	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	
	
	
}
