package model;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.App;
import modelDAO.Banco;


public class Funcionario extends Pessoa {

	private String login, senha;

	public Funcionario(String nome, String rg, String cpf, String telefone, String login, String senha,
			Endereco endereco) {
		super(nome, rg, cpf, telefone, endereco);
		this.login = login;
		this.senha = senha;
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * 
	 * C�DIGOS DE CADASTRO DE FUNCION�RIOS
	 * 
	 * 
	 * 
	 * 
	 */
	
	

	public void cadastrarFuncionario(String nome, String rg, String cpf, String telefone, String login, String senha,
			String estado, String cidade, String rua, String bairro, String numero) {

		if (cpf.equals("") || nome.equals("") || rg.equals("") || telefone.equals("") || login.equals("")
				|| senha.equals("") || estado.equals("") || cidade.equals("") || rua.equals("") || bairro.equals("")
				|| numero.equals("")) {

			JOptionPane.showMessageDialog(null, "Campo n�o preenchido");
		}

		else {
			
			Banco bancoDeDados = new Banco();
			
			bancoDeDados.conectar();
			
			boolean cpfCad = false, loginCad = false, rgCad = false;

			
				if (bancoDeDados.cpfIsCadastro(cpf, "funcionario")) {
					JOptionPane.showMessageDialog(null, "Este CPF j� est� cadastrado no sistema");
					cpfCad = true;
				}

				if (bancoDeDados.loginDisponivel(login)) {
					JOptionPane.showMessageDialog(null, "Login indispon�vel");
					loginCad = true;
				}

				if (bancoDeDados.rgIsCadastro(rg, "funcionario")) {
					JOptionPane.showMessageDialog(null, "Este RG j� est� cadastrado no sistema");
					rgCad = true;
				
			}

			if (!cpfCad && !loginCad && !rgCad) {
				
				
				
				if(bancoDeDados.estaConectado()){
					
					bancoDeDados.cadastrarFuncionario(nome, rg, cpf, telefone, login, senha, estado, cidade, rua, bairro, Integer.parseInt(numero));
					
					
					
				}
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
			}
			
			bancoDeDados.desconectar();
		}
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * 
	 * C�DIGOS DE CADASTRO DE PACIENTES
	 * 
	 * 
	 * 
	 * 
	 */
	

	public void cadastrarPaciente(String nome, String rg, String cpf, String telefone, String estado, String cidade,
			String rua, String bairro, String numero) {

		if (cpf.equals("") || nome.equals("") || rg.equals("") || telefone.equals("") || estado.equals("")
				|| cidade.equals("") || rua.equals("") || bairro.equals("") || numero.equals("")) {

			JOptionPane.showMessageDialog(null, "Campo n�o preenchido");
		}

		else {
			
			Banco bancoDeDados = new Banco();
			
			bancoDeDados.conectar();
			boolean cpfIsCadastrado = false, rgIsCadastrado = false;
		
				if (bancoDeDados.cpfIsCadastro(cpf, "paciente")) {
					JOptionPane.showMessageDialog(null, "CPF j� cadastrado");
					cpfIsCadastrado = true;
				}

				if (bancoDeDados.rgIsCadastro(rg, "paciente")) {
					JOptionPane.showMessageDialog(null, "RG j� cadastrado");
					rgIsCadastrado = true;
				}
			

			if (!cpfIsCadastrado && !rgIsCadastrado) {
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
				bancoDeDados.cadastrarPaciente(nome, rg, cpf, telefone, estado, cidade, rua, bairro, Integer.parseInt(numero));
			}
			
			bancoDeDados.desconectar();
		}
	}

	
	/**
	 * 
	 * 
	 * 
	 * 
	 * C�DIGOS DE BUSCA E REMO��O DE FUNCION�RIOS
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	public boolean funcionarioIsCadastrado(String campoCpf) {

		Banco bancoDeDados = new Banco();
		
		bancoDeDados.conectar();
		
		if(bancoDeDados.cpfIsCadastro(campoCpf, "funcionario")){
			bancoDeDados.desconectar();
			return true;
		}
		
		return false;
	}

	public void pesquisarFuncionario(String campoCpf, JTable tabela) {
		
		Banco bancoDeDados = new Banco();
		
		bancoDeDados.conectar();

		if (!campoCpf.equals("   .   .   -  ")) {

			if (funcionarioIsCadastrado(campoCpf)) {
				if (bancoDeDados.cpfIsCadastro(campoCpf, "funcionario")) {

					if (funcionarioBuscado(tabela, campoCpf)) {
						JOptionPane.showMessageDialog(null, "Busca j� foi realizada");
					} else {

						for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
							DefaultTableModel df = (DefaultTableModel) tabela.getModel();
							df.removeRow(j);
						}

						String[] dados = bancoDeDados.BuscaFuncionario(campoCpf); 
						DefaultTableModel df = (DefaultTableModel) tabela.getModel();
						df.addRow(dados);
						campoCpf = "";
					}
				}
			} else {
				for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.removeRow(j);
				}
				JOptionPane.showMessageDialog(null, "Funcionario n�o encontrado");
				campoCpf = "";
			}			
		}

		else {
			for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.removeRow(j);
			}

			JOptionPane.showMessageDialog(null, "Campo cpf n�o preenchido");
		}
		
		bancoDeDados.desconectar();

	}

	public boolean funcionarioSelecionado(JTable tabela) {
		for (int i = 0; i < tabela.getRowCount(); i++) {
			if (tabela.isRowSelected(i)) {
				return true;
			}
		}

		return false;
	}

	public void removerFuncionario(JTable tabela) {

		Banco bancoDeDados = new Banco();
		
		bancoDeDados.conectar();
		
			if (funcionarioSelecionado(tabela)) {
	
				if (bancoDeDados.cpfIsCadastro(tabela.getValueAt(0, 1).toString(), "funcionario")) {
					
					bancoDeDados.removerUsuario(tabela.getValueAt(0, 1).toString(), "funcionario");
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.removeRow(tabela.getSelectedRow());
				
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Nenhum funcion�rio selecionado");
			}
			
			bancoDeDados.desconectar();
	}

	public boolean funcionarioBuscado(JTable tabela, String campoCpf) {

		for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
			if (tabela.getValueAt(j, 1).equals(campoCpf)) {
				return true;
			}
		}

		return false;

	}
	
	
	/**
	 * 
	 * 
	 * 
	 * 
	 * C�DIGOS DE BUSCA, EDI��O E REMO��O DE PACIENTES
	 * 
	 * 
	 * 
	 * 
	 */
	
	

	public boolean pacienteBuscado(JTable tabela, String campoCpf) {

		for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
			if (tabela.getValueAt(j, 1).equals(campoCpf)) {
				return true;
			}
		}

		return false;

	}

	public boolean pacienteIsCadastrado(String campoCpf) {

		Banco bancoDeDados = new Banco();
		bancoDeDados.conectar();
		
			if (bancoDeDados.cpfIsCadastro(campoCpf, "paciente")) {
				bancoDeDados.desconectar();
				return true;
			
			}

		return false;
	}

	public void pesquisarPaciente(String campoCpf, JTable tabela) {
		
		Banco bancoDeDados = new Banco();
		bancoDeDados.conectar();
		
		if (!campoCpf.equals("   .   .   -  ")) {

			if (pacienteIsCadastrado(campoCpf)) {
				
					if (bancoDeDados.cpfIsCadastro(campoCpf, "paciente")) {

						if (pacienteBuscado(tabela, campoCpf)) {
							JOptionPane.showMessageDialog(null, "Busca j� foi realizada");
						} else {

							for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
								DefaultTableModel df = (DefaultTableModel) tabela.getModel();
								df.removeRow(j);
							}

							String[] dados = bancoDeDados.BuscaPaciente(campoCpf);
							DefaultTableModel df = (DefaultTableModel) tabela.getModel();
							df.addRow(dados);
							campoCpf = "";
						
						}
					}
				
			} else {
				for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.removeRow(j);
				}
				JOptionPane.showMessageDialog(null, "Paciente n�o encontrado");
				campoCpf = "";
			}
		}

		else {
			for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.removeRow(j);
			}

			JOptionPane.showMessageDialog(null, "Campo cpf n�o preenchido");
		}

	}

	public boolean pacienteSelecionado(JTable tabela) {
		for (int i = 0; i < tabela.getRowCount(); i++) {
			if (tabela.isRowSelected(i)) {
				return true;
			}
		}

		return false;
	}

	public void removerPaciente(JTable tabela) {
		
		Banco bancoDeDados = new Banco();
		
		bancoDeDados.conectar();
		
	
			if (pacienteSelecionado(tabela)) {
	
				if (bancoDeDados.cpfIsCadastro(tabela.getValueAt(0, 1).toString(), "paciente")) {
					
					bancoDeDados.removerUsuario(tabela.getValueAt(0, 1).toString(), "paciente");
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.removeRow(tabela.getSelectedRow());
				
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
			}

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * C�DIGOS DE AGENDAMENTO DE CONSULTA
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	public void agendarConsulta(String nome, String cpf, String data, String horario) {
		/*Banco bancoDeDados = new Banco();
		bancoDeDados.conectar();
		bancoDeDados.inserirAgendamento(data, nome, cpf, horario);
		bancoDeDados.desconectar();
	*/
	}

	

	
	/**
	 * 
	 * 
	 * 
	 * 
	 * C�DIGOS DE BUSCA E EDI��O DE PRONTU�RIOS
	 * 
	 * 
	 * 
	 * 
	 */
	public void buscarProntuarioPorCpf(JComboBox<String> comboData, JTextField campoCpf){
		comboData.removeAllItems();
		comboData.addItem("...");
				
		for(Agenda ag: App.agendamento){
			for(DadosAgendamento da: ag.getAgend()){
				if(da.getCpf().equals(campoCpf.getText())){
					comboData.addItem(ag.getDataConsulta());
				}
			}
		}	
	}
	
	public void preencherComboHorario(JComboBox<String> comboHorario, String data){
				
		for(Agenda g: App.agendamento){
			if(g.getDataConsulta().equals(data)){
				comboHorario.removeAllItems();
				comboHorario.addItem("...");
				
				for(DadosAgendamento da: g.getAgend()){
					comboHorario.addItem(da.getHorario());
				}
			}
		}		
	}
	
	public void inserirProntuario(JTextArea jta, String data, String hora){
		
		for(Agenda a: App.agendamento){
			if(a.getDataConsulta().equals(data)){
				for(DadosAgendamento da: a.getAgend()){
					if(da.getHorario().equals(hora)){
						jta.setText(da.getProntuario().getHistorico());
					}
				}
			}
		}
		
	}
	
	
	
	/**
	 * 
	 * 
	 * 
	 * 
	 * ENCAPSULAMENTO
	 * 
	 * 
	 * 
	 * 
	 */
	
	

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
