package model;

import java.sql.Date;
import java.sql.Time;
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
	 * CÓDIGOS DE CADASTRO DE FUNCIONÁRIOS
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

			JOptionPane.showMessageDialog(null, "Campo não preenchido");
		}

		else {
			boolean cpfCad = false, loginCad = false, rgCad = false;
			Banco banco = new Banco();
			banco.conectar();
			
			if(banco.estaConectado()){
				if(banco.cpfIsCadastro(cpf, "funcionario")){
					cpfCad = true;
					JOptionPane.showMessageDialog(null, "Este CPF já está cadastrado no sistema");
				}
				if(banco.loginIndisponivel(login)){
					loginCad = true;
					JOptionPane.showMessageDialog(null, "Login indisponível");
				}
				if(banco.rgIsCadastro(rg, "funcionario")){
					rgCad = true;
					JOptionPane.showMessageDialog(null, "Este RG já está cadastrado no sistema");
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
	 * CÓDIGOS DE CADASTRO DE PACIENTES
	 * 
	 * 
	 * 
	 * 
	 */
	

	public void cadastrarPaciente(String nome, String rg, String cpf, String telefone, String estado, String cidade,
			String rua, String bairro, String numero) {

		if (cpf.equals("") || nome.equals("") || rg.equals("") || telefone.equals("") || estado.equals("")
				|| cidade.equals("") || rua.equals("") || bairro.equals("") || numero.equals("")) {

			JOptionPane.showMessageDialog(null, "Campo não preenchido");
		}

		else {
			boolean cpfCad = false, rgCad = false;
			Banco banco = new Banco();
			banco.conectar();
			
			if(banco.estaConectado()){
				if(banco.cpfIsCadastro(cpf, "paciente")){
					cpfCad = true;
					JOptionPane.showMessageDialog(null, "Este CPF já está cadastrado no sistema");
				}
				if(banco.rgIsCadastro(rg, "paciente")){
					rgCad = true;
					JOptionPane.showMessageDialog(null, "Este RG já está cadastrado no sistema");
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
	 * CÓDIGOS DE BUSCA E REMOÇÃO DE FUNCIONÁRIOS
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
						JOptionPane.showMessageDialog(null, "Busca já foi realizada");
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
					JOptionPane.showMessageDialog(null, "Funcionario não encontrado");
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

			JOptionPane.showMessageDialog(null, "Campo cpf não preenchido");
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
	 * CÓDIGOS DE BUSCA, EDIÇÃO E REMOÇÃO DE PACIENTES
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
						JOptionPane.showMessageDialog(null, "Busca já foi realizada");
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
						JOptionPane.showMessageDialog(null, "Paciente não encontrado");
						campoCpf = "";
					}
				}
			}
		else {
			for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.removeRow(j);
			}

		JOptionPane.showMessageDialog(null, "Campo cpf não preenchido");
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
	 * CÓDIGOS DE AGENDAMENTO DE CONSULTA
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	public void agendarConsulta(String cpfPaciente, String cpfFuncionario, Date data, String horario) {
		
		Banco banco = new Banco();
		banco.conectar();
		
		if(banco.estaConectado()){
			
			Paciente paciente = banco.BuscaPaciente(cpfPaciente);
			Funcionario funcionario = banco.BuscaFuncionario(cpfFuncionario);
			banco.cadastrarAgenda(new Agenda(data, convercaoStringEmTime(horario), paciente, funcionario));
						
			banco.desconectar();
			
		}
	}

		
	public void carregarComboBox(Date data, JComboBox<Object> ItensHorario, String [] horas){
		
		Banco banco = new Banco();
		banco.conectar();
		
		if(banco.estaConectado()){
			
			
			if(banco.possuiAgendamentoNestaData(data)){
							
				ItensHorario.removeAllItems();
				
				for(String h: horas){
					ItensHorario.addItem(h);
				}
				
				for(String hr: banco.buscarHorariosAgendados(data)){
					
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
		
		banco.desconectar();		
				
	}
	
	@SuppressWarnings("deprecation")
	public static Time convercaoStringEmTime(String horario){
		
		String tempH = "", tempM = "", tempS = "";
		
		int hora, minuto, segundo;
		
		for(int i = 0; i < horario.length(); i++){
			
			if(horario.charAt(i) != ':'){
				if(i<2){
					tempH += horario.charAt(i);
				}
				if(i>2 && i <5){
					tempM += horario.charAt(i);
				}
				if(i > 5 && i <8){
					tempS += horario.charAt(i);
				}
				
			}			
		}
			
		hora = Integer.parseInt(tempH);
		minuto = Integer.parseInt(tempM);
		segundo = Integer.parseInt(tempS);
				
		return new Time(hora, minuto, segundo);
		
	}
	
	
	public void preencherTabelaAgendamentosPorData(JTable tabela, Date data) {
		
		Banco banco = new Banco();
		banco.conectar();
		
		if(banco.estaConectado()){
			
			for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.removeRow(j);
			}
			ArrayList<String[]> dados = banco.buscarAgendamentosPorData(data);
			
			
			for(String[] d: dados){
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.addRow(d);
			}
			
			
		}
		
		banco.desconectar();
		
	}
	
	public void preencherTabelaAgendamentos(JTable tabela, String cpf){
		
		for(Agenda a: App.agendamento){
			if(a.getPaciente().getCpf().equals(cpf)){
				String[] dados = new String[] { a.getPaciente().getNome(),
						a.getHorario().toString(), a.getDataConsulta().toString(), a.getFuncionario().getNome()};
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
	 * CÓDIGOS DE BUSCA E EDIÇÃO DE PRONTUÁRIOS
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
				comboHorario.addItem(g.getHorario().toString());				
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
