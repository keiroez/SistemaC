package model;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
			campoCidade.addItem("Selecione");
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
			String estado, String cidade, String rua, String bairro, String numero, int id) {

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
							new Endereco(estado, cidade, rua, bairro, Integer.parseInt(numero))), id);	
					JOptionPane.showMessageDialog(null, "Cadastro realizado");
				}				
				
				banco.desconectar();
			}		
		}
	}
	
	public void carregarMedicosDisponiveis(JComboBox<String> medicos){
		
		Banco banco = new Banco();
		banco.conectar();
		
		if(banco.estaConectado()){
			
			for(Funcionario f : banco.BuscaMedico()){
				medicos.addItem(f.getNome());
			}
						
			banco.desconectar();
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
	
	
	public void agendarConsulta(String nomePaciente, String nomeFuncionario, Date data, String horario) {
		
		Banco banco = new Banco();
		banco.conectar();
		
		if(banco.estaConectado()){
			
			Paciente paciente = banco.BuscaPacientePorNome(nomePaciente);
			Funcionario funcionario = banco.BuscaFuncionarioPorNome(nomeFuncionario);
			banco.cadastrarAgenda(new Agenda(data, convercaoStringEmTime(horario), paciente, funcionario));
						
			banco.desconectar();
			
		}
	}

		
	public void carregarComboBox(Date data, JComboBox<Object> ItensHorario, String [] horas, String nomeFuncionario){
		
		Banco banco = new Banco();
		banco.conectar();
		
		if(banco.estaConectado()){
			
			
			if(banco.possuiAgendamentoNestaData(data)){
							
				ItensHorario.removeAllItems();
				
				for(String h: horas){
					ItensHorario.addItem(h);
				}
				
				ArrayList<Agenda> agd = banco.BuscaAgendamentos(banco.BuscaFuncionarioPorNome(nomeFuncionario).getCpf());
				ArrayList<String> horarios =  banco.buscarHorariosAgendados(data);
				
				for(Agenda agendamentos: agd){
					for(String horario: horarios){
						if(horario.equals(agendamentos.getHorario().toString())){
								removerHorariosIndisponiveis(ItensHorario, horario);
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
	
	
	public void removerHorariosIndisponiveis(JComboBox<Object> ItensHorario, String hora){
		
		for(int i = 0; i < ItensHorario.getItemCount(); i++){
			if(ItensHorario.getItemAt(i).toString().equals(hora)){
				((DefaultComboBoxModel<Object>) ItensHorario.getModel()).removeElementAt(i);
			}
		}		
		
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
		
		Banco banco = new Banco();
		banco.conectar();
		
		if(banco.estaConectado()){
			
			for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.removeRow(j);
			}
			
			ArrayList<String []> dados = banco.buscarAgendamentosPorCpf(cpf);
			
			for(String d[]: dados){
				
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.addRow(d);
				
			}
			
			banco.desconectar();
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
	
	public void buscarAgendamentosPorData(JTable tabela){
		
		Date data = new Date(System.currentTimeMillis());
						
		Banco banco = new Banco();
		banco.conectar();
		
		if(banco.estaConectado()){
			
									
			ArrayList<String[]> ag = banco.buscarAgendamentosPorData(new Date(data.getTime()));
			
			for(int i = 0; i < ag.size(); i++){
				DefaultTableModel d = (DefaultTableModel) tabela.getModel();
				d.addRow(ag.get(i));			
			}
			
			banco.desconectar();
		}
		
	}
	
	
	
	
	public void buscarAgendamentosPorMedico(JTable tabela){
		Date data = new Date(System.currentTimeMillis());
						
		Banco banco = new Banco();
		banco.conectar();
		
		if(banco.estaConectado()){
			
			for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.removeRow(j);
			}
			
			ArrayList<String[]> ag = banco.buscarConsultasDoDia(new Date(data.getTime()), this.getCpf());
			
			for(String [] agd : ag){
				DefaultTableModel d = (DefaultTableModel) tabela.getModel();
				d.addRow(agd);			
			}
			
			banco.desconectar();
		}
		
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
		
		
		
		Banco banco = new Banco();
		
		banco.conectar();
		
		if(banco.estaConectado()){
			
			ArrayList<Agenda> agd = banco.BuscaAgenda(campoCpf.getText());
			
			comboData.removeAllItems();
			comboData.addItem("...");
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			for(Agenda ag: agd){
				
				if(!itemJaEstaInserido(comboData, df.format(ag.getDataConsulta()).toString())){
					comboData.addItem(df.format(ag.getDataConsulta()).toString());
					
				}
				
			}
			
			
			banco.desconectar();
		}
		
	}
	
	public boolean itemJaEstaInserido(JComboBox<String> combo, String item){
		for(int i = 0; i < combo.getItemCount(); i++){
			if(combo.getItemAt(i).toString().equals(item)){
				return true;
			}
		}
		
		return false;
	}
	
	public void preencherComboHorario(JComboBox<String> comboHorario, String data, String cpf){
		
		Banco banco = new Banco();
		
		banco.conectar();
		
		if(banco.estaConectado()){
			
			ArrayList<Agenda> agd = banco.BuscaAgenda(cpf);
			
			comboHorario.removeAllItems();
			comboHorario.addItem("...");
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			
			for(Agenda ag: agd){
				if(df.format(ag.getDataConsulta()).toString().equals(data)){
					comboHorario.addItem(ag.getHorario().toString());
				}
			}
			
			
			banco.desconectar();
		}
		
		
	}
	
	public void exibirProntuario(JTextArea jta, String data, String hora, String cpf){
		
		
		Banco banco = new Banco();
		
		banco.conectar();
		
		if(banco.estaConectado()){
			
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date dt = null;
			
			try {
					
					dt = df.parse(data);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			Date data1 = new Date(dt.getTime());
			Time horario = convercaoStringEmTime(hora);
			
			jta.setText(banco.buscarProntuario(cpf, data1, horario));
			
			banco.desconectar();
		}		
	
	}
	
	public void editarProtuario(String texto, String data, String hora, String cpf){
		Banco banco = new Banco();
		
		banco.conectar();
		
		if(banco.estaConectado()){
			
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date dt = null;
			
			try {
				dt = df.parse(data);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Date data1 = new Date(dt.getTime());
			Time horario = convercaoStringEmTime(hora);
			
			banco.inserirProntuario(texto, cpf, data1, horario);
			
			banco.desconectar();
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
