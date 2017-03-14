package app;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.Controller;
import model.Agenda;
import model.Endereco;
import model.Funcionario;
import model.Paciente;
import modelDAO.Banco;
import view.TelaLogin;
import view.TelaMenuAtendente;
import view.TelaMenuMedico;

public class App {

	public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	public static ArrayList<java.util.Date> dt = new ArrayList<>();
	public static String[] dat = { "2016-11-15", "2016-11-19", "2016-11-10", "2016-11-27", "2016-12-13", "2016-12-07",
			"2016-12-25", "2016-12-05", "2017-01-09" };

	public static void main(String[] args) {

		funcionarios.add(new Funcionario("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111", "diogosousa",
				"admin", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100)));
		inserirUsuarioPadrao();
		//cadastrarFuncTeste();
		//cadastrarPacTeste();

		TelaLogin tl = new TelaLogin();

		new Controller(tl);

		for (String d : dat) {
			try {
				dt.add(df.parse(d));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

	}

	public static void validarLogin(String login, String senha, TelaLogin tl, boolean tlog) {
		boolean logado = false;
		Banco banco = new Banco();
		banco.conectar();

		if (banco.estaConectado()) {
			if (banco.buscaFuncionarioPorLoginESenha(login, senha) != null) {

				switch (banco.buscaTipoFuncionario(login, senha)) {
				case 1:
					new TelaMenuMedico(banco.buscaFuncionarioPorLoginESenha(login, senha));
					break;
				case 2:
					new TelaMenuAtendente(banco.buscaFuncionarioPorLoginESenha(login, senha));
					break;

				default:
					break;
				}

				tl.dispose();
				tlog = false;
				logado = true;
			}
		}

		if (!logado)
			JOptionPane.showMessageDialog(null, "Login ou senha inválido");

	}

	/**
	 * 
	 * 
	 * Métodos abaixo para teste de inserção no banco e consulta
	 * 
	 * 
	 */

	public static void inserirUsuarioPadrao() {

		Banco banco = new Banco();
		banco.conectar();

		if (banco.estaConectado()) {
			if (banco.buscaFuncionarioPorLoginESenha("admin", "admin") == null) {
				banco.cadastrarFuncionario(new Funcionario("Admin", "0000000", "000.000.000-00", "(000) 00000 - 0000",
						"admin", "admin", new Endereco("", "", "", "", 0)), 2);
			}

			banco.desconectar();
		}

	}

	public static void cadastrarFuncTeste() {
		Funcionario func1 = new Funcionario("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111",
				"diogosousa", "admin", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100));
		Funcionario func2 = new Funcionario("Izaquiel", "3333333", "333.333.333-33", "(333) 33333 - 3333", "izaquiel",
				"admin", new Endereco("Pernambuco (PE)", "Flores", "E", "F", 300));

		Banco bancoDeDados = new Banco();

		bancoDeDados.conectar();

		if (bancoDeDados.estaConectado()) {
			bancoDeDados.cadastrarFuncionario(func1, 1);
			bancoDeDados.cadastrarFuncionario(func2, 1);
		}

		bancoDeDados.desconectar();
	}

	public static Funcionario consultarFuncTeste() {
		Banco bancoDeDados = new Banco();
		Funcionario func = null;

		bancoDeDados.conectar();

		if (bancoDeDados.estaConectado()) {
			func = bancoDeDados.BuscaFuncionario("111.111.111-11");
			// Funcionario func2 =
			// bancoDeDados.BuscaFuncionario("333.333.333-33");
			// System.out.println("Funcionarios");
			// System.out.println(func.getNome()+" "+func.getCpf());
			// System.out.println(func2.getNome()+" "+func2.getCpf());
		}

		bancoDeDados.desconectar();
		return func;
	}

	public static void cadastrarPacTeste() {

		Paciente pac1 = new Paciente("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111",
				new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100));
		Paciente pac2 = new Paciente("Ivo", "222222", "222.222.222-22", "(222) 22222 - 2222",
				new Endereco("Pernambuco (PE)", "Triunfo", "C", "D", 200));
		Paciente pac3 = new Paciente("Izaquiel", "3333333", "333.333.333-33", "(333) 33333 - 3333",
				new Endereco("Pernambuco (PE)", "Flores", "E", "F", 300));

		Banco bancoDeDados = new Banco();

		bancoDeDados.conectar();

		if (bancoDeDados.estaConectado()) {
			bancoDeDados.cadastrarPaciente(pac1);
			bancoDeDados.cadastrarPaciente(pac2);
			bancoDeDados.cadastrarPaciente(pac3);
		}

		bancoDeDados.desconectar();
	}

	public static Paciente consultarPacTeste() {
		Banco bancoDeDados = new Banco();
		Paciente pac = null;
		// Paciente pac2=null;

		bancoDeDados.conectar();

		if (bancoDeDados.estaConectado()) {
			pac = bancoDeDados.BuscaPaciente("111.111.111-11");
			// pac2 = bancoDeDados.BuscaPaciente("333.333.333-33");
			// System.out.println("Paciente BD");
			// System.out.println(pac.getNome()+" "+pac.getCpf());
			// System.out.println(pac2.getNome()+" "+pac2.getCpf());
		}

		bancoDeDados.desconectar();
		return pac;
	}

	public static void cadastrarAgenda() {

		for (String d : dat) {
			try {
				dt.add(df.parse(d));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		Agenda agd1 = new Agenda(new Date(dt.get(3).getTime()), Funcionario.convercaoStringEmTime("08:00"),
				consultarPacTeste(), consultarFuncTeste());

		Banco bancoDeDados = new Banco();

		bancoDeDados.conectar();

		if (bancoDeDados.estaConectado()) {
			bancoDeDados.cadastrarAgenda(agd1);

		}

		bancoDeDados.desconectar();
	}

}
