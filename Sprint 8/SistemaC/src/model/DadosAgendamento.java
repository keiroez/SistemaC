package model;


public class DadosAgendamento {

	private String nome;
	private String cpf;
	private String horario;
	private Prontuario prontuario;

	public DadosAgendamento(String nome, String cpf, String horario, Prontuario p) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.horario = horario;
		this.prontuario = p;
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

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}
}
