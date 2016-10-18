package model;

public class Paciente extends Pessoa {

	private Prontuario protuario;

	public Paciente(String nome, String rg, String cpf, String telefone, Prontuario prontuario) {
		super(nome, rg, cpf, telefone);

		this.protuario = prontuario;

	}

	public Prontuario getProtuario() {
		return protuario;
	}

	public void setProtuario(Prontuario protuario) {
		this.protuario = protuario;
	}

}
