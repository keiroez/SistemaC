package model;

public class Agenda {

	private String dataConsulta;
	private String nome;
	private String cpf;
	private String horario;
		
	public Agenda(String dataConsulta, String nome, String cpf, String horario) {
		super();

		this.dataConsulta = dataConsulta;
		this.nome = nome;
		this.cpf = cpf;
		this.horario = horario;
	}
	
	

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
