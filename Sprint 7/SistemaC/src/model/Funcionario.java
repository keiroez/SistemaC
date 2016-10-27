package model;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.App;

public class Funcionario extends Pessoa {

	private String login, senha;

	public Funcionario(String nome, String rg, String cpf, String telefone, String login, String senha,
			Endereco endereco) {
		super(nome, rg, cpf, telefone, endereco);
		this.login = login;
		this.senha = senha;
	}

	public void cadastrarFuncionario(String nome, String rg, String cpf, String telefone, String login, String senha,
			String estado, String cidade, String rua, String bairro, String numero) {

		if (cpf.equals("") || nome.equals("") || rg.equals("") || telefone.equals("") || login.equals("")
				|| senha.equals("") || estado.equals("") || cidade.equals("") || rua.equals("") || bairro.equals("")
				|| numero.equals("")) {

			JOptionPane.showMessageDialog(null, "Campo não preenchido");
		}

		else {
			boolean cpfCad = false, loginCad = false, rgCad = false;

			for (int i = 0; i < App.funcionarios.size(); i++) {
				if (App.funcionarios.get(i).getCpf().equals(cpf)) {
					JOptionPane.showMessageDialog(null, "Este CPF já está cadastrado no sistema");
					cpfCad = true;
				}

				if (App.funcionarios.get(i).getLogin().equals(login)) {
					JOptionPane.showMessageDialog(null, "Login indisponível");
					loginCad = true;
				}

				if (App.funcionarios.get(i).getRg().equals(rg)) {
					JOptionPane.showMessageDialog(null, "Este RG já está cadastrado no sistema");
					rgCad = true;
				}
			}

			if (!cpfCad && !loginCad && !rgCad) {
				App.funcionarios.add(new Funcionario(nome, rg, cpf, telefone, login, senha,
						new Endereco(estado, cidade, rua, bairro, Integer.parseInt(numero))));
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
			}
		}

	}
	public void cadastrarPaciente(String nome, String rg, String cpf, String telefone, String estado, String cidade,
			String rua, String bairro, String numero) {

		if (cpf.equals("") || nome.equals("") || rg.equals("") || telefone.equals("") || estado.equals("")
				|| cidade.equals("") || rua.equals("") || bairro.equals("") || numero.equals("")) {

			JOptionPane.showMessageDialog(null, "Campo não preenchido");
		}

		else {

			boolean cpfIsCadastrado = false, rgIsCadastrado = false;

			for (int i = 0; i < App.pacientes.size(); i++) {
				if (App.pacientes.get(i).getCpf().equals(cpf)) {
					JOptionPane.showMessageDialog(null, "CPF já cadastrado");
					cpfIsCadastrado = true;
				}

				if (App.pacientes.get(i).getRg().equals(rg)) {
					JOptionPane.showMessageDialog(null, "RG já cadastrado");
					rgIsCadastrado = true;
				}
			}

			if (!cpfIsCadastrado && !rgIsCadastrado) {
				App.pacientes.add(new Paciente(nome, rg, cpf, telefone,
						new Endereco(estado, cidade, rua, bairro, Integer.parseInt(numero))));
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
			}
		}
	}
	public boolean funcionarioIsCadastrado(String campoCpf){
		
		for (int i = 0; i < App.funcionarios.size(); i++) {
			if (campoCpf.equals(App.funcionarios.get(i).getCpf())) {
				return true;
			}
		}		
		return false;
	}
	
	public void pesquisarFuncionario(String campoCpf, JTable tabela){
		
		if(!campoCpf.equals("   .   .   -  ")){
			
			if(funcionarioIsCadastrado(campoCpf)){
				for (int i = 0; i < App.funcionarios.size(); i++) {
					if (campoCpf.equals(App.funcionarios.get(i).getCpf())) {

						if (funcionarioBuscado(tabela, campoCpf)){
							JOptionPane.showMessageDialog(null, "Busca já foi realizada");
						} else {
							
							for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
								DefaultTableModel df = (DefaultTableModel) tabela.getModel();
								df.removeRow(j);
							}
							
							String[] dados = new String[] { App.funcionarios.get(i).getNome(),
							App.funcionarios.get(i).getCpf(), App.funcionarios.get(i).getTelefone() };
							DefaultTableModel df = (DefaultTableModel) tabela.getModel();
							df.addRow(dados);
							campoCpf = "";
							break;
						}					
					}			
				}
			}else{
				for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.removeRow(j);
				}				
				JOptionPane.showMessageDialog(null, "Funcionario não encontrado");	
				campoCpf = "";			
			}			
		}
			
		else{
			for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.removeRow(j);
			}
			
			JOptionPane.showMessageDialog(null, "Campo cpf não preenchido");
		}
		
	}
	
	
	public boolean funcionarioSelecionado(JTable tabela){
		for(int i = 0; i < tabela.getRowCount(); i++){
			if(tabela.isRowSelected(i)){
				return true;
			}
		}
		
		return false;
	}
	
	
	public void removerFuncionario(JTable tabela){
		
		if(funcionarioSelecionado(tabela)){
			
			for (int i = 0; i < App.funcionarios.size(); i++) {
				if (App.funcionarios.get(i).getCpf().equals(tabela.getValueAt(0, 1))) {
					App.funcionarios.remove(i);
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.removeRow(tabela.getSelectedRow());
					break;
				}
			}			
		}
		else{
			JOptionPane.showMessageDialog(null, "Nenhum funcionario selecionado");
		}		
	}


	public boolean funcionarioBuscado(JTable tabela, String campoCpf) {

		for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
			if (tabela.getValueAt(j, 1).equals(campoCpf)) {
				return true;
			}
		}

		return false;

	}
	
	public boolean pacienteBuscado(JTable tabela) {

		for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
			
			for(Paciente p: App.pacientes){
				if (tabela.getValueAt(j, 1).equals(p.getCpf())) {
					return true;
				}
			}
			
		}

		return false;

	}

	
	
	public boolean pacienteIsCadastrado(String campoCpf){
		
		for (int i = 0; i < App.pacientes.size(); i++) {
			if (campoCpf.equals(App.pacientes.get(i).getCpf())) {
				return true;
			}
		}
		
		return false;
	}
	
	public void pesquisarPaciente(String campoCpf, JTable tabela){
		
		if(!campoCpf.equals("   .   .   -  ")){
			
			if(pacienteIsCadastrado(campoCpf)){
				for (int i = 0; i < App.pacientes.size(); i++) {
					if (campoCpf.equals(App.pacientes.get(i).getCpf())) {

						if (pacienteBuscado(tabela)){
							JOptionPane.showMessageDialog(null, "Busca já foi realizada");
						} else {
							
							for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
								DefaultTableModel df = (DefaultTableModel) tabela.getModel();
								df.removeRow(j);
							}
							
							String[] dados = new String[] { App.pacientes.get(i).getNome(),
							App.pacientes.get(i).getCpf(), App.pacientes.get(i).getTelefone() };
							DefaultTableModel df = (DefaultTableModel) tabela.getModel();
							df.addRow(dados);
							campoCpf = "";
							break;
						}					
					}			
				}
			}else{
				for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.removeRow(j);
				}				
				JOptionPane.showMessageDialog(null, "Paciente não encontrado");	
				campoCpf = "";			
			}			
		}
			
		else{
			for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.removeRow(j);
			}
			
			JOptionPane.showMessageDialog(null, "Campo cpf não preenchido");
		}
		
	}
	
	public boolean pacienteSelecionado(JTable tabela){
		for(int i = 0; i < tabela.getRowCount(); i++){
			if(tabela.isRowSelected(i)){
				return true;
			}
		}
		
		return false;
	}
	
	public void removerPaciente(JTable tabela){
		
		if(pacienteSelecionado(tabela)){
			
			for (int i = 0; i < App.pacientes.size(); i++) {
				if (App.pacientes.get(i).getCpf().equals(tabela.getValueAt(0, 1))) {
					String nome = App.pacientes.get(i).getNome();
					App.pacientes.remove(i);
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.removeRow(tabela.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Paciente "+nome+" removido com sucesso");
					break;
				}
			}
			
			
		}
		else{
			JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
		}
		
		
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
