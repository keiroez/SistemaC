package model;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
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
	
	public void addCidades(int indice, JComboBox<String> campoCidade) {

		campoCidade.removeAllItems();

		if (indice != 0) {
			campoCidade.addItem("...");
			for (String cidad : Dados.cidades[indice-1]) {
				campoCidade.addItem(cidad);
			}
		}

	}
	
	public void addEstados(JComboBox<String> campoEstado){
		
		for(String est: Dados.estados){
			campoEstado.addItem(est);
		}
		
	}

	public void cadastrarFuncionario(String nome, String rg, String cpf, String telefone, String login, String senha,
			String estado, String cidade, String rua, String bairro, String numero) {

		if (cpf.equals("") || nome.equals("") || rg.equals("") || telefone.equals("") || login.equals("")
				|| senha.equals("") || estado.equals("") || cidade.equals("") || rua.equals("") || bairro.equals("")
				|| numero.equals("")) {

			JOptionPane.showMessageDialog(null, "Campo n�o preenchido");
		}

		else {
			boolean cpfCad = false, loginCad = false, rgCad = false;
			Banco banco = new Banco();
			banco.conectar();
			
			if(banco.estaConectado()){
				if(banco.cpfIsCadastro(cpf, "funcionario")){
					cpfCad = true;
					JOptionPane.showMessageDialog(null, "Este CPF j� est� cadastrado no sistema");
				}
				if(banco.loginIndisponivel(login)){
					loginCad = true;
					JOptionPane.showMessageDialog(null, "Login indispon�vel");
				}
				if(banco.rgIsCadastro(rg, "funcionario")){
					rgCad = true;
					JOptionPane.showMessageDialog(null, "Este RG j� est� cadastrado no sistema");
				}
				
				if (!cpfCad && !loginCad && !rgCad) {
					banco.cadastrarFuncionario(new Funcionario(nome, rg, cpf, telefone, login, senha,
							new Endereco(estado, cidade, rua, bairro, Integer.parseInt(numero))));					
				}				
				
				banco.desconectar();
			}		
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
			boolean cpfCad = false, rgCad = false;
			Banco banco = new Banco();
			banco.conectar();
			
			if(banco.estaConectado()){
				if(banco.cpfIsCadastro(cpf, "paciente")){
					cpfCad = true;
					JOptionPane.showMessageDialog(null, "Este CPF j� est� cadastrado no sistema");
				}
				if(banco.rgIsCadastro(rg, "paciente")){
					rgCad = true;
					JOptionPane.showMessageDialog(null, "Este RG j� est� cadastrado no sistema");
				}
				if (!cpfCad && !rgCad) {
					banco.cadastrarPaciente(new Paciente(nome, rg, cpf, telefone,
							new Endereco(estado, cidade, rua, bairro, Integer.parseInt(numero))));
					
				}
				
				banco.desconectar();
			}
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

		for (int i = 0; i < App.funcionarios.size(); i++) {
			if (campoCpf.equals(App.funcionarios.get(i).getCpf())) {
				return true;
			}
		}
		return false;
	}

	public void pesquisarFuncionario(String campoCpf, JTable tabela) {

		if (!campoCpf.equals("   .   .   -  ")) {
			
			Banco banco = new Banco();
			banco.conectar();
			
			if(banco.estaConectado()){
				

				
				if(banco.cpfIsCadastro(campoCpf, "funcionario")){
					if (funcionarioBuscado(tabela, campoCpf)) {
						JOptionPane.showMessageDialog(null, "Busca j� foi realizada");
					} else {

						for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
							DefaultTableModel df = (DefaultTableModel) tabela.getModel();
							df.removeRow(j);
						}
						Funcionario f = banco.BuscaFuncionario(campoCpf);
						String[] dados = new String[] { f.getNome(),
								f.getCpf(), f.getTelefone() };
						DefaultTableModel df = (DefaultTableModel) tabela.getModel();
						df.addRow(dados);
						campoCpf = "";
						
					}					
				}else {
					for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
						DefaultTableModel df = (DefaultTableModel) tabela.getModel();
						df.removeRow(j);
					}
					JOptionPane.showMessageDialog(null, "Funcionario n�o encontrado");
					campoCpf = "";
				}
				
				banco.desconectar();
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

	public boolean funcionarioSelecionado(JTable tabela) {
		for (int i = 0; i < tabela.getRowCount(); i++) {
			if (tabela.isRowSelected(i)) {
				return true;
			}
		}

		return false;
	}

	public void removerFuncionario(JTable tabela) {

		if (funcionarioSelecionado(tabela)) {
			
			Banco banco = new Banco();
			banco.conectar();
			
			if(banco.estaConectado()){
				banco.removerUsuario((String) tabela.getValueAt(0, 1), "funcionario");
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.removeRow(tabela.getSelectedRow());
				
				banco.desconectar();
			}
			
		} else {
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

	public void pesquisarPaciente(String campoCpf, JTable tabela) {

		if (!campoCpf.equals("   .   .   -  ")) {
			
			Banco banco = new Banco();
			banco.conectar();
			
			if(banco.estaConectado()){
				if(banco.cpfIsCadastro(campoCpf, "paciente")){
					
					if (pacienteBuscado(tabela, campoCpf)) {
						JOptionPane.showMessageDialog(null, "Busca j� foi realizada");
					} 
					else {
					
						for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
							DefaultTableModel df = (DefaultTableModel) tabela.getModel();
							df.removeRow(j);
						}
						Paciente p = banco.BuscaPaciente(campoCpf);
						String[] dados = new String[] { p.getNome(),
						p.getCpf(), p.getTelefone()};
						
						DefaultTableModel df = (DefaultTableModel) tabela.getModel();
						df.addRow(dados);
						campoCpf = "";
					
					}
					
					banco.desconectar();
				}
				else {
					
					for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
							DefaultTableModel df = (DefaultTableModel) tabela.getModel();
							df.removeRow(j);
						}
						JOptionPane.showMessageDialog(null, "Paciente n�o encontrado");
						campoCpf = "";
					}
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

		if (pacienteSelecionado(tabela)) {
			
			Banco banco = new Banco();
			banco.conectar();
			
			if(banco.estaConectado()){
				
				banco.removerUsuario(tabela.getValueAt(0, 1).toString(), "paciente");
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.removeRow(tabela.getSelectedRow());
					
			}
			

		} else {
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
	
	
	public void agendarConsulta(String cpfPaciente, String cpfFuncionario, String data, String horario) {
		
		Banco banco = new Banco();
		banco.conectar();
		
		if(banco.estaConectado()){
			
			Paciente paciente = banco.BuscaPaciente(cpfPaciente);
			Funcionario funcionario = banco.BuscaFuncionario(cpfFuncionario);
			App.agendamento.add(new Agenda(data, horario, paciente, funcionario));
			JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso");			
			
			banco.desconectar();
			
		}
		
		

	}

	public boolean dataTemHorarioAgendado(java.util.Date data){
		
		for(Agenda a: App.agendamento){
			
			
			if(a.getDataConsulta().toString().equals(data.toString())){
				return true;
			}
		}
		
		return false;		
	}
	
	public ArrayList<String> horariosIndisponiveis(Date data){
		
		ArrayList<String> h = new ArrayList<>();
		
		for(Agenda a: App.agendamento){
			if(a.getDataConsulta().toString().equals(data.toString())){
				h.add(a.getHorario());
			}
		}
		
		return h;
	}
	
	public void carregarComboBox(Date data, JComboBox<Object> ItensHorario, String [] horas){
		
		if(dataTemHorarioAgendado(data)){
			
			
			ItensHorario.removeAllItems();
			
			for(String h: horas){
				ItensHorario.addItem(h);
			}

			
			for(String hr: horariosIndisponiveis(data)){
				
				for(int i = 0; i < ItensHorario.getItemCount(); i++){
					
					if(hr.equals(ItensHorario.getItemAt(i).toString())){
						((DefaultComboBoxModel<Object>) ItensHorario.getModel()).removeElementAt(i);
						
					}					
				}
			}					
		}
		
		else{
			ItensHorario.removeAllItems();
			
			for(String h: horas){
				ItensHorario.addItem(h);
			}
		}		
	}
	
	
	public void preencherTabelaAgendamentosPorData(JTable tabela, String data) {
		
		/*for(Agenda a:App.agendamento){
			
			if(data.equals(a.getDataConsulta().toString())){
				if(dataBuscado(tabela, data, a.getHorario())){
					
				}
				else{
					for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
						DefaultTableModel df = (DefaultTableModel) tabela.getModel();
						df.removeRow(j);
					}
					String[] dados = new String[] { a.getNomePaciente(),
							a.getHorario(), a.getDataConsulta().toString(), a.getNomeFuncionario()};
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.addRow(dados);
				}
			}
		}	*/	
	}
	
	public void preencherTabelaAgendamentos(JTable tabela, String cpf){
		
		for(Agenda a: App.agendamento){
			if(a.getPaciente().getCpf().equals(cpf)){
				String[] dados = new String[] { a.getPaciente().getNome(),
						a.getHorario(), a.getDataConsulta().toString(), a.getFuncionario().getNome()};
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.addRow(dados);
			}
		}
	}
	
	public boolean dataBuscado(JTable tabela, String data, String hora) {

		for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
			if (tabela.getValueAt(j, 2).equals(data) && tabela.getValueAt(j, 1).equals(hora)) {
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
	 * C�DIGOS DE BUSCA E EDI��O DE PRONTU�RIOS
	 * 
	 * 
	 * 
	 * 
	 */
	public void buscarProntuarioPorCpf(JComboBox<String> comboData, JTextField campoCpf){
		
		/*
		comboData.removeAllItems();
		comboData.addItem("...");
		
				
		for(Paciente p: App.pacientes){
			if(p.getCpf().equals(campoCpf.getText())){
				for(Prontuario pront: p.getProtuario()){
					comboData.addItem(pront.getData().toString());
				}
			}
		}*/
	}
	
	public void preencherComboHorario(JComboBox<String> comboHorario, String data, int indice){
		
		comboHorario.removeAllItems();
		comboHorario.addItem("...");
			
		for(Agenda g: App.agendamento){
			if(g.getDataConsulta().toString().equals(data)){
				comboHorario.addItem(g.getHorario());				
			}
		}		
	}
	
	public void inserirProntuario(JTextArea jta, String data, String hora, String cpf){
		jta.setText("");
		/*
		for(Paciente p: App.pacientes){
			for(Prontuario pr: p.getProtuario()){
				if(pr.getCpfPaciente().equals(cpf) && pr.getData().toString().equals(data) && pr.getHorario().equals(hora)){
					jta.setText(pr.getHistorico());
				}
			}
		}*/		
	}
	
	public void editarProtuario(String texto, String data, String hora, String cpf){
		/*
		for(Paciente p: App.pacientes){
			for(Prontuario pr: p.getProtuario()){
				if(pr.getCpfPaciente().equals(cpf) && pr.getData().toString().equals(data) && pr.getHorario().equals(hora)){
					pr.setHistorico(texto);
				}
			}
		}*/	
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
