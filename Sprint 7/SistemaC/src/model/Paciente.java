package model;

public class Paciente extends Pessoa {

	private Prontuario protuario;

	public Paciente(String nome, String rg, String cpf, String telefone, Prontuario prontuario, Endereco endereco) {
		super(nome, rg, cpf, telefone, endereco);

		this.protuario = prontuario;

	}

	public Prontuario getProtuario() {
		return protuario;
	}

	public void setProtuario(Prontuario protuario) {
		this.protuario = protuario;
	}

}
