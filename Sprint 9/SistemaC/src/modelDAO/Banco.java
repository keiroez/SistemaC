package modelDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Agenda;
import model.Endereco;
import model.Funcionario;
import model.Paciente;

public class Banco {

	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultSet = null;

	/**
	 * 
	 * CONEXÃO
	 * 
	 * 
	 */

	public void conectar() {

		String servidor = "jdbc:mysql://localhost:3306/banco_clinica";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public boolean estaConectado() {

		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}

	public void desconectar() {

		try {
			this.connection.close();

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	/**
	 * 
	 * 
	 * VERIFICAÇÃO DE LOGIN
	 * 
	 * 
	 */

	public boolean validarLogin(String login, String senha) {

		try {

			String query = "SELECT * FROM funcionario WHERE login = '" + login + "';";
			this.resultSet = this.statement.executeQuery(query);

			if (resultSet.next()) {
				if (this.resultSet.getString("senha").equals(senha)) {
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return false;

	}

	public boolean loginIndisponivel(String login) {

		try {

			String query = "SELECT * FROM funcionario WHERE login = '" + login + "';";
			this.resultSet = this.statement.executeQuery(query);

			if (resultSet.next()) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return false;
	}

	/**
	 * 
	 * 
	 * INSERÇÃO, BUSCA E ALTERAÇÃO DE FUNCIONÁRIO
	 * 
	 * 
	 */

	public void cadastrarFuncionario(Funcionario func, int id) {

		try {

			String query = "INSERT INTO funcionario (nome, rg, cpf, telefone, login, senha, estado, cidade, rua, bairro, numeroEnd, ID) VALUES"
					+ " ('" + func.getNome() + "', '" + func.getRg() + "', '" + func.getCpf() + "', '"
					+ func.getTelefone() + "', '" + func.getLogin() + "', " + "'" + func.getSenha() + "', '"
					+ func.getEndereco().getEstado() + "', '" + func.getEndereco().getCidade() + "', '"
					+ func.getEndereco().getRua() + "', '" + func.getEndereco().getBairro() + "', '"
					+ func.getEndereco().getNumero() + "', '" + id + "');";
			this.statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public ArrayList<Funcionario> BuscaMedico() {

		ArrayList<Funcionario> funcs = new ArrayList<>();

		try {

			String query = "SELECT * FROM funcionario WHERE ID = 1;";
			this.resultSet = this.statement.executeQuery(query);

			while (resultSet.next()) {
				funcs.add(new Funcionario(this.resultSet.getString("nome"), this.resultSet.getString("rg"),
						this.resultSet.getString("cpf"), this.resultSet.getString("telefone"),
						this.resultSet.getString("login"), this.resultSet.getString("senha"),
						new Endereco(this.resultSet.getString("estado"), this.resultSet.getString("cidade"),
								this.resultSet.getString("bairro"), this.resultSet.getString("rua"),
								this.resultSet.getInt("numeroEnd"))));
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return funcs;

	}

	public Funcionario BuscaFuncionario(String cpf) {

		Funcionario func = null;

		try {

			String query = "SELECT * FROM funcionario WHERE cpf = '" + cpf + "';";
			this.resultSet = this.statement.executeQuery(query);

			if (resultSet.next()) {
				func = new Funcionario(this.resultSet.getString("nome"), this.resultSet.getString("rg"),
						this.resultSet.getString("cpf"), this.resultSet.getString("telefone"),
						this.resultSet.getString("login"), this.resultSet.getString("senha"),
						new Endereco(this.resultSet.getString("estado"), this.resultSet.getString("cidade"),
								this.resultSet.getString("bairro"), this.resultSet.getString("rua"),
								this.resultSet.getInt("numeroEnd")));
			}

			else {
				JOptionPane.showMessageDialog(null, "Cpf não cadastrado");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return func;

	}

	public Funcionario BuscaFuncionarioPorNome(String nome) {

		Funcionario func = null;

		try {

			String query = "SELECT * FROM funcionario WHERE nome = '" + nome + "';";
			this.resultSet = this.statement.executeQuery(query);

			if (resultSet.next()) {
				func = new Funcionario(this.resultSet.getString("nome"), this.resultSet.getString("rg"),
						this.resultSet.getString("cpf"), this.resultSet.getString("telefone"),
						this.resultSet.getString("login"), this.resultSet.getString("senha"),
						new Endereco(this.resultSet.getString("estado"), this.resultSet.getString("cidade"),
								this.resultSet.getString("bairro"), this.resultSet.getString("rua"),
								this.resultSet.getInt("numeroEnd")));
			}

			else {
				JOptionPane.showMessageDialog(null, "Nome não cadastrado");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return func;

	}

	public void alterarFuncionario(Funcionario func) {
		try {

			String query = "UPDATE funcionario Set nome = '" + func.getNome() + "', rg = '" + func.getRg()
					+ "', cpf = '" + func.getCpf() + "', " + "telefone = '" + func.getTelefone() + "', login = '"
					+ func.getLogin() + "', senha = '" + func.getSenha() + "', " + "estado = '"
					+ func.getEndereco().getEstado() + "', cidade = '" + func.getEndereco().getCidade() + "', "
					+ "rua = '" + func.getEndereco().getRua() + "', bairro = '" + func.getEndereco().getBairro() + "', "
					+ "numeroEnd = '" + func.getEndereco().getNumero() + "' ;";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Atualização realizada");

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public Funcionario buscaFuncionarioPorLoginESenha(String login, String senha) {

		Funcionario f = null;

		try {

			String query = "SELECT * FROM funcionario WHERE login = '" + login + "';";
			this.resultSet = this.statement.executeQuery(query);

			if (this.resultSet.next()) {

				if (this.resultSet.getString("senha").equals(senha)) {
					f = new Funcionario(resultSet.getString("nome"), resultSet.getString("rg"),
							resultSet.getString("cpf"), resultSet.getString("telefone"), login, senha,
							new Endereco(resultSet.getString("estado"), resultSet.getString("cidade"),
									resultSet.getString("bairro"), resultSet.getString("rua"),
									resultSet.getInt("numeroend")));
				}

			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return f;

	}

	public int buscaTipoFuncionario(String login, String senha) {

		int id = 0;

		try {

			String query = "SELECT * FROM funcionario WHERE login = '" + login + "';";
			this.resultSet = this.statement.executeQuery(query);

			if (this.resultSet.next()) {

				if (this.resultSet.getString("senha").equals(senha)) {
					id = resultSet.getInt("ID");
				}

			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return id;

	}

	/**
	 * 
	 * REMOÇÃO E CONSULTA DE FUNCIONÁRIO E PACIENTE
	 * 
	 * 
	 */

	public void removerUsuario(String cpf, String usuario) {

		try {
			String query = "DELETE FROM " + usuario + " WHERE cpf = '" + cpf + "';";
			this.statement.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public boolean cpfIsCadastro(String cpf, String pessoa) {

		try {

			String query = "SELECT * FROM " + pessoa + " WHERE cpf = '" + cpf + "';";
			this.resultSet = this.statement.executeQuery(query);

			if (resultSet.next()) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return false;
	}

	public boolean rgIsCadastro(String rg, String pessoa) {

		try {

			String query = "SELECT * FROM " + pessoa + " WHERE rg = '" + rg + "';";
			this.resultSet = this.statement.executeQuery(query);

			if (resultSet.next()) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return false;
	}

	/**
	 * 
	 * 
	 * INSERÇÃO, BUSCA E ALTERAÇÃO DE PACIENTE
	 * 
	 * 
	 */

	public void cadastrarPaciente(Paciente pac) {

		try {

			String query = "INSERT INTO paciente (nome, rg, cpf, telefone, estado, cidade, rua, bairro, numeroEnd) VALUES"
					+ " ('" + pac.getNome() + "', '" + pac.getRg() + "', '" + pac.getCpf() + "', '" + pac.getTelefone()
					+ "', " + "'" + pac.getEndereco().getEstado() + "', '" + pac.getEndereco().getCidade() + "', '"
					+ pac.getEndereco().getRua() + "', '" + pac.getEndereco().getBairro() + "', '"
					+ pac.getEndereco().getNumero() + "');";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro realizado");

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public Paciente BuscaPaciente(String cpf) {

		Paciente pac = null;

		try {

			String query = "SELECT * FROM paciente WHERE cpf = '" + cpf + "';";
			this.resultSet = this.statement.executeQuery(query);

			if (resultSet.next()) {
				pac = new Paciente(this.resultSet.getString("nome"), this.resultSet.getString("rg"),
						this.resultSet.getString("cpf"), this.resultSet.getString("telefone"),
						new Endereco(this.resultSet.getString("estado"), this.resultSet.getString("cidade"),
								this.resultSet.getString("bairro"), this.resultSet.getString("rua"),
								this.resultSet.getInt("numeroEnd")));
			}

			else {
				JOptionPane.showMessageDialog(null, "Cpf não cadastrado");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return pac;

	}

	public Paciente BuscaPacientePorNome(String nome) {

		Paciente pac = null;

		try {

			String query = "SELECT * FROM paciente WHERE nome = '" + nome + "';";
			this.resultSet = this.statement.executeQuery(query);

			if (resultSet.next()) {
				pac = new Paciente(this.resultSet.getString("nome"), this.resultSet.getString("rg"),
						this.resultSet.getString("cpf"), this.resultSet.getString("telefone"),
						new Endereco(this.resultSet.getString("estado"), this.resultSet.getString("cidade"),
								this.resultSet.getString("bairro"), this.resultSet.getString("rua"),
								this.resultSet.getInt("numeroEnd")));
			}

			else {
				JOptionPane.showMessageDialog(null, "Nome não cadastrado");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return pac;

	}

	public void alterarPaciente(Paciente pac) {
		try {

			String query = "UPDATE paciente Set nome = '" + pac.getNome() + "', rg = '" + pac.getRg() + "', cpf = '"
					+ pac.getCpf() + "', " + "telefone = '" + pac.getTelefone() + "', login = '" + "', " + "estado = '"
					+ pac.getEndereco().getEstado() + "', cidade = '" + pac.getEndereco().getCidade() + "', "
					+ "rua = '" + pac.getEndereco().getRua() + "', bairro = '" + pac.getEndereco().getBairro() + "', "
					+ "numeroEnd = '" + pac.getEndereco().getNumero() + "' ;";
			JOptionPane.showMessageDialog(null, "Atualização realizada");
			this.statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/**
	 * 
	 * 
	 * INSERÇÃO, BUSCA E ALTERAÇÃO DE AGENDA
	 * 
	 * 
	 */

	public void cadastrarAgenda(Agenda agd) {

		try {

			String query = "INSERT INTO agenda (cpfPaciente, cpfFuncionario, dataAgendamento, hora) VALUES" + " ('"
					+ agd.getPaciente().getCpf() + "', '" + agd.getFuncionario().getCpf() + "', '"
					+ agd.getDataConsulta() + "', '" + agd.getHorario() + "');";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Agendamento realizado");

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public ArrayList<Agenda> BuscaAgenda(String cpf) {

		ArrayList<Agenda> agd = new ArrayList<>();

		try {

			String query = "SELECT * FROM agenda " + "inner join paciente on agenda.cpfPaciente = paciente.cpf "
					+ "inner join funcionario on agenda.cpfFuncionario = funcionario.cpf "
					+ "WHERE agenda.cpfPaciente = '" + cpf + "' ORDER BY agenda.DATAAGENDAMENTO, agenda.HORA;";
			this.resultSet = this.statement.executeQuery(query);

			while (resultSet.next()) {
				agd.add(new Agenda(this.resultSet.getDate("dataAgendamento"), this.resultSet.getTime("hora"),
						new Paciente(this.resultSet.getString("paciente.nome"), this.resultSet.getString("paciente.rg"),
								this.resultSet.getString("paciente.cpf"), this.resultSet.getString("paciente.telefone"),
								new Endereco(this.resultSet.getString("paciente.estado"),
										this.resultSet.getString("paciente.cidade"),
										this.resultSet.getString("paciente.bairro"),
										this.resultSet.getString("paciente.rua"),
										this.resultSet.getInt("paciente.numeroEnd"))),
						new Funcionario(this.resultSet.getString("funcionario.nome"),
								this.resultSet.getString("funcionario.rg"), this.resultSet.getString("funcionario.cpf"),
								this.resultSet.getString("funcionario.telefone"),
								this.resultSet.getString("funcionario.login"), this.resultSet.getString("senha"),
								new Endereco(this.resultSet.getString("funcionario.estado"),
										this.resultSet.getString("funcionario.cidade"),
										this.resultSet.getString("funcionario.bairro"),
										this.resultSet.getString("funcionario.rua"),
										this.resultSet.getInt("funcionario.numeroEnd")))));
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return agd;

	}
	
	public ArrayList<Agenda> BuscaAgendamentos(String cpfFuncionario) {

		ArrayList<Agenda> agd = new ArrayList<>();

		try {

			String query = "SELECT * FROM agenda " + "inner join paciente on agenda.cpfPaciente = paciente.cpf "
					+ "inner join funcionario on agenda.cpfFuncionario = funcionario.cpf "
					+ "WHERE agenda.cpfFuncionario = '" + cpfFuncionario + "' ORDER BY agenda.DATAAGENDAMENTO, agenda.HORA;";
			this.resultSet = this.statement.executeQuery(query);

			while (resultSet.next()) {
				agd.add(new Agenda(this.resultSet.getDate("dataAgendamento"), this.resultSet.getTime("hora"),
						new Paciente(this.resultSet.getString("paciente.nome"), this.resultSet.getString("paciente.rg"),
								this.resultSet.getString("paciente.cpf"), this.resultSet.getString("paciente.telefone"),
								new Endereco(this.resultSet.getString("paciente.estado"),
										this.resultSet.getString("paciente.cidade"),
										this.resultSet.getString("paciente.bairro"),
										this.resultSet.getString("paciente.rua"),
										this.resultSet.getInt("paciente.numeroEnd"))),
						new Funcionario(this.resultSet.getString("funcionario.nome"),
								this.resultSet.getString("funcionario.rg"), this.resultSet.getString("funcionario.cpf"),
								this.resultSet.getString("funcionario.telefone"),
								this.resultSet.getString("funcionario.login"), this.resultSet.getString("senha"),
								new Endereco(this.resultSet.getString("funcionario.estado"),
										this.resultSet.getString("funcionario.cidade"),
										this.resultSet.getString("funcionario.bairro"),
										this.resultSet.getString("funcionario.rua"),
										this.resultSet.getInt("funcionario.numeroEnd")))));
			}
			
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return agd;

	}

	public boolean possuiAgendamentoNestaData(Date data) {

		try {

			String query = "SELECT DATAAGENDAMENTO FROM AGENDA WHERE DATAAGENDAMENTO = '" + data + "';";
			this.resultSet = this.statement.executeQuery(query);

			if (resultSet.next()) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return false;
	}
	
	
	

	public ArrayList<String> buscarHorariosAgendados(Date data) {

		ArrayList<String> horarios = new ArrayList<>();

		try {

			String query = "SELECT * FROM AGENDA WHERE DATAAGENDAMENTO = '" + data + "';";
			this.resultSet = this.statement.executeQuery(query);

			while (resultSet.next()) {
				horarios.add(resultSet.getTime("HORA").toString());
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return horarios;
	}

	public void alterarAgenda(Agenda agd) {
		try {

			String query = "UPDATE agenda Set cpfPaciente = '" + agd.getPaciente().getCpf() + "', cpfFuncionario= '"
					+ agd.getFuncionario().getCpf() + "', dataAgendamento = '" + agd.getDataConsulta() + "', hora = '"
					+ agd.getHorario() + "' ;";
			JOptionPane.showMessageDialog(null, "Atualização realizada");
			this.statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public ArrayList<String[]> buscarAgendamentosPorData(Date data) {

		ArrayList<String[]> agendamentos = new ArrayList<>();

		try {

			String query = "SELECT * FROM agenda " + "inner join paciente on agenda.cpfPaciente = paciente.cpf "
					+ "inner join funcionario on agenda.cpfFuncionario = funcionario.cpf "
					+ "WHERE agenda.DATAAGENDAMENTO = '" + data + "' ORDER BY agenda.HORA;";
			this.resultSet = this.statement.executeQuery(query);

			while (resultSet.next()) {
				String[] dados = { resultSet.getString("paciente.nome"), resultSet.getTime("HORA").toString(),
						resultSet.getString("funcionario.nome") };
				agendamentos.add(dados);
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return agendamentos;
	}

	public ArrayList<String[]> buscarAgendamentosPorCpf(String cpf) {

		ArrayList<String[]> agendamentos = new ArrayList<>();

		try {

			String query = "SELECT * FROM agenda " + "inner join paciente on agenda.cpfPaciente = paciente.cpf "
					+ "inner join funcionario on agenda.cpfFuncionario = funcionario.cpf "
					+ "WHERE agenda.cpfPaciente = '" + cpf + "' ORDER BY agenda.HORA;";
			this.resultSet = this.statement.executeQuery(query);

			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			while (resultSet.next()) {
				String[] dados = { resultSet.getString("paciente.nome"), resultSet.getTime("HORA").toString(),
						df.format(resultSet.getDate("DATAAGENDAMENTO")).toString(),
						resultSet.getString("funcionario.nome") };
				agendamentos.add(dados);
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return agendamentos;
	}

	public ArrayList<String[]> buscarConsultasDoDia(Date data, String cpf) {

		ArrayList<String[]> agendamentos = new ArrayList<>();

		try {

			String query = "SELECT * FROM agenda " + "inner join paciente on agenda.cpfPaciente = paciente.cpf "
					+ "inner join funcionario on agenda.cpfFuncionario = funcionario.cpf "
					+ "WHERE agenda.DATAAGENDAMENTO = '" + data + "' AND agenda.cpfFuncionario = '" + cpf
					+ "' ORDER BY agenda.HORA;";
			this.resultSet = this.statement.executeQuery(query);

			while (resultSet.next()) {

				String[] dados = { resultSet.getString("paciente.nome"), resultSet.getTime("HORA").toString() };
				agendamentos.add(dados);
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return agendamentos;
	}

	/**
	 * 
	 * 
	 * INSERÇÃO, BUSCA E ALTERAÇÃO DE PRONTUÁRIO
	 * 
	 * 
	 */

	public void inserirProntuario(String prontuario, String cpf, Date data, Time hora) {

		try {

			String update = "UPDATE AGENDA SET PRONTUARIOAGENDA = '" + prontuario + "' WHERE CPFPACIENTE = '" + cpf
					+ "' AND DATAAGENDAMENTO = '" + data + "' AND HORA = '" + hora + "' ;";
			this.statement.executeUpdate(update);
			JOptionPane.showMessageDialog(null, "Prontuário alterado com sucesso");

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	public String buscarProntuario(String cpf, Date data, Time hora) {

		String prontuario = "";

		try {

			String query = "SELECT PRONTUARIOAGENDA FROM AGENDA  WHERE CPFPACIENTE = '" + cpf
					+ "' AND DATAAGENDAMENTO = '" + data + "' AND HORA = '" + hora + "' ;";
			this.resultSet = this.statement.executeQuery(query);

			if (this.resultSet.next()) {
				prontuario = this.resultSet.getString("PRONTUARIOAGENDA");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return prontuario;

	}

}
