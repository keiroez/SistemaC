package model;

import javax.swing.JOptionPane;

import app.App;

public class Funcionario extends Pessoa{

	
	private String login, senha;
	
	public Funcionario(String nome, String rg, String cpf, String telefone, String login, String senha) {
		super(nome, rg, cpf, telefone);
		this.login = login;
		this.senha = senha;
	}
	
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
