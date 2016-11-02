package model;

import java.util.ArrayList;

public class Agenda {

	private String dataConsulta;
	private ArrayList<DadosAgendamento> agend;

	public Agenda(String dataConsulta, String nome, String cpf, String horario, Prontuario p) {

		this.dataConsulta = dataConsulta;
		agend = new ArrayList<>();
		agend.add(new DadosAgendamento(nome, cpf, horario, p));

	}

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public ArrayList<DadosAgendamento> getAgend() {
		return agend;
	}

	public void setAgend(ArrayList<DadosAgendamento> agend) {
		this.agend = agend;
	}

}
