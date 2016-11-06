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
import view.TelaMenu;




public class App {

	public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	public static ArrayList<Agenda> agendamento = new ArrayList<Agenda>();
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	public static ArrayList<java.util.Date> dt = new ArrayList<>();
	public static String [] dat = {"2016-11-15", "2016-11-19", "2016-11-10", "2016-11-27", "2016-12-13", "2016-12-07", "2016-12-25", "2016-12-05", "2017-01-09"};
	
		
	public static void main(String[] args){
		
		TelaLogin tl = new TelaLogin();
		
		new Controller(tl);
		
		for(String d: dat){
			try {
				dt.add(df.parse(d));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		pacientes.add(new Paciente("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100)));
		pacientes.add(new Paciente("Ivo", "222222", "222.222.222-22", "(222) 22222 - 2222", new Endereco("Pernambuco (PE)", "Triunfo", "C", "D", 200)));
		pacientes.add(new Paciente("Izaquiel", "3333333", "333.333.333-33", "(333) 33333 - 3333", new Endereco("Pernambuco (PE)", "Flores", "E", "F", 300)));
		
		funcionarios.add(new Funcionario("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111", "diogosousa", "admin", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100)));
		funcionarios.add(new Funcionario("Ivo", "222222", "222.222.222-22", "(222) 22222 - 2222", "ivosouza", "admin", new Endereco("Pernambuco (PE)", "Triunfo", "C", "D", 200)));
		funcionarios.add(new Funcionario("Izaquiel", "3333333", "333.333.333-33", "(333) 33333 - 3333", "izaquiel", "admin", new Endereco("Pernambuco (PE)", "Flores", "E", "F", 300)));
		
		agendamento.add(new Agenda(new Date(dt.get(0).getTime()), "09:20", new Paciente("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100)), new Funcionario("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111", "diogosousa", "admin", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100))));
		//agendamento.add(new Agenda(new Date(dt.get(1).getTime()), "José Diogo", "111.111.111-11", "Izaquiel", "333.333.333-33", "11:20"));
		//agendamento.add(new Agenda(new Date(dt.get(2).getTime()), "José Diogo", "111.111.111-11", "Ivo", "222.222.222-22", "14:40"));
		///agendamento.add(new Agenda(new Date(dt.get(3).getTime()), "Ivo", "222.222.222-22", "José Diogo", "111.111.111-11", "10:20"));
		//agendamento.add(new Agenda(new Date(dt.get(4).getTime()), "Ivo", "222.222.222-22", "Izaquiel", "333.333.333-33", "12:40"));
		//agendamento.add(new Agenda(new Date(dt.get(5).getTime()), "Ivo", "222.222.222-22", "Izaquiel", "333.333.333-33", "13:00"));
		//agendamento.add(new Agenda(new Date(dt.get(6).getTime()), "Izaquiel", "333.333.333-33", "José Diogo", "111.111.111-11", "14:20"));
		//agendamento.add(new Agenda(new Date(dt.get(7).getTime()), "Izaquiel", "333.333.333-33", "Ivo", "222.222.222-22", "09:20"));
		//agendamento.add(new Agenda(new Date(dt.get(8).getTime()), "Izaquiel", "333.333.333-33", "José Diogo", "111.111.111-11", "12:40"));
		
		//pacientes.get(0).getProtuario().add(new Prontuario("Consulta realizada às 09:20\n\n\nResultado: ******", "111.111.111-11", new Date(dt.get(0).getTime()), "09:20"));
		//pacientes.get(0).getProtuario().add(new Prontuario("Consulta realizada às 11:20\n\n\nResultado: ******", "111.111.111-11", new Date(dt.get(1).getTime()), "11:20"));

		
	}
	
	
	public static void validarLogin (String login, String senha, TelaLogin tl, boolean tlog){
		boolean logado = false;
		for(int i = 0; i < funcionarios.size(); i++){
			if(funcionarios.get(i).getLogin().equals(login) && funcionarios.get(i).getSenha().equals(senha)){
				tl.dispose();
				tlog = false;
				
				new TelaMenu(funcionarios.get(i));
				logado = true;
			}
		}
		
		if(!logado)
			JOptionPane.showMessageDialog(null, "Login ou senha inválido");
		
	}
	
	/**
	 * 
	 * 
	 * Métodos abaixo para teste de inserção no banco e consulta
	 * 
	 * 
	 */
	
	public static void cadastrarFuncTeste(){
		Funcionario func1 = new Funcionario("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111", "diogosousa", "admin", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100));
		Funcionario func2 =new Funcionario("Izaquiel", "3333333", "333.333.333-33", "(333) 33333 - 3333", "izaquiel", "admin", new Endereco("Pernambuco (PE)", "Flores", "E", "F", 300));
		
		Banco bancoDeDados = new Banco();

		bancoDeDados.conectar();

		if(bancoDeDados.estaConectado()){
				bancoDeDados.cadastrarFuncionario(func1);
				bancoDeDados.cadastrarFuncionario(func2);
			}
		
		bancoDeDados.desconectar();
	}
	
	public static void consultarFuncTeste(){
		Banco bancoDeDados = new Banco();

		bancoDeDados.conectar();

		if(bancoDeDados.estaConectado()){
				Funcionario func = bancoDeDados.BuscaFuncionario("111.111.111-11");
				Funcionario func2 = bancoDeDados.BuscaFuncionario("333.333.333-33");
				System.out.println("Funcionarios");
				System.out.println(func.getNome()+"  "+func.getCpf());
				System.out.println(func2.getNome()+"  "+func2.getCpf());
			}
		
		bancoDeDados.desconectar();
	}
	
	
	public static void cadastrarPacTeste(){
		
		Paciente pac1 = new Paciente("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100));
		Paciente pac2 =new Paciente("Ivo", "222222", "222.222.222-22", "(222) 22222 - 2222", new Endereco("Pernambuco (PE)", "Triunfo", "C", "D", 200));
		Paciente pac3 =new Paciente("Izaquiel", "3333333", "333.333.333-33", "(333) 33333 - 3333", new Endereco("Pernambuco (PE)", "Flores", "E", "F", 300));
		
		Banco bancoDeDados = new Banco();

		bancoDeDados.conectar();

		if(bancoDeDados.estaConectado()){
				bancoDeDados.cadastrarPaciente(pac1);
				bancoDeDados.cadastrarPaciente(pac2);
				bancoDeDados.cadastrarPaciente(pac3);
			}
		
		bancoDeDados.desconectar();
	}
	
	public static void consultarPacTeste(){
		Banco bancoDeDados = new Banco();

		bancoDeDados.conectar();

		if(bancoDeDados.estaConectado()){
				Paciente pac = bancoDeDados.BuscaPaciente("111.111.111-11");
				Paciente pac2 = bancoDeDados.BuscaPaciente("333.333.333-33");
				System.out.println("Paciente BD");
				System.out.println(pac.getNome()+"  "+pac.getCpf());
				System.out.println(pac2.getNome()+"  "+pac2.getCpf());
			}
		
		bancoDeDados.desconectar();
	}
	

	
}
