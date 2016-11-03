package model;

import java.sql.Date;

public class Prontuario {

	private String historico;
	private String cpfPaciente;
	private Date data;
	private String horario;
	

	

	public Prontuario(String historico, String cpfPaciente, Date data, String horario) {
	
		this.historico = historico;
		this.cpfPaciente = cpfPaciente;
		this.data = data;
		this.horario = horario;
	}
	
	

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	

}
