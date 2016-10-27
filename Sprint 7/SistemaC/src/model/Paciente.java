package model;

import java.util.ArrayList;

public class Paciente extends Pessoa {

	private ArrayList<Prontuario> protuario;

	public Paciente(String nome, String rg, String cpf, String telefone, Endereco endereco) {
		super(nome, rg, cpf, telefone, endereco);
		
		this.protuario = new ArrayList<>();

	}

	public ArrayList<Prontuario> getProtuario() {
		return protuario;
	}

	public void setProtuario(ArrayList<Prontuario> protuario) {
		this.protuario = protuario;
	}
	
	

	

}
