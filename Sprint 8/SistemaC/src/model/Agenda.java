package model;

import java.sql.Date;


public class Agenda {

	private Date dataConsulta;
	private String nomePaciente, nomeFuncionario;
	private String cpfPaciente, cpfFuncionario;
	private String horario;
	
	public Agenda(Date dataConsulta, String nomePaciente, String cpfPaciente, String nomeFuncionario, String cpfFuncionario, String horario) {
		super();
		this.dataConsulta = dataConsulta;
		this.nomePaciente = nomePaciente;
		this.cpfPaciente = cpfPaciente;
		this.nomeFuncionario = nomeFuncionario;
		this.cpfFuncionario = cpfFuncionario;
		this.horario = horario;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	
	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	
	
	
}
