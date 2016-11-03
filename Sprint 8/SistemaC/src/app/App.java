package app;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.Controller;
import model.Agenda;
import model.Endereco;
import model.Funcionario;
import model.Paciente;

import view.TelaLogin;
import view.TelaMenu;




public class App {

	public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	public static ArrayList<Agenda> agendamento = new ArrayList<Agenda>();

	public static void main(String[] args) {
		
		TelaLogin tl = new TelaLogin();
		
		new Controller(tl);
		
		
		
		pacientes.add(new Paciente("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100)));
		pacientes.add(new Paciente("Ivo", "222222", "222.222.222-22", "(222) 22222 - 2222", new Endereco("Pernambuco (PE)", "Triunfo", "C", "D", 200)));
		pacientes.add(new Paciente("Izaquiel", "3333333", "333.333.333-33", "(333) 33333 - 3333", new Endereco("Pernambuco (PE)", "Flores", "E", "F", 300)));
		
		funcionarios.add(new Funcionario("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111", "diogosousa", "admin", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100)));
		funcionarios.add(new Funcionario("Ivo", "222222", "222.222.222-22", "(222) 22222 - 2222", "ivosouza", "admin", new Endereco("Pernambuco (PE)", "Triunfo", "C", "D", 200)));
		funcionarios.add(new Funcionario("Izaquiel", "3333333", "333.333.333-33", "(333) 33333 - 3333", "izaquiel", "admin", new Endereco("Pernambuco (PE)", "Flores", "E", "F", 300)));
		
		agendamento.add(new Agenda(new Date(2016-10-28), "José Diogo", "111.111.111-11", "José Diogo", "111.111.111-11", "09:20"));
		agendamento.add(new Agenda(new Date(2016-11-01), "José Diogo", "111.111.111-11", "Izaquiel", "333.333.333-33", "11:20"));
		agendamento.add(new Agenda(new Date(2016-12-23), "José Diogo", "111.111.111-11", "Ivo", "222.222.222-22", "14:40"));
		agendamento.add(new Agenda(new Date(2016-11-15), "Ivo", "222.222.222-22", "José Diogo", "111.111.111-11", "10:20"));
		agendamento.add(new Agenda(new Date(2016-12-12), "Ivo", "222.222.222-22", "Izaquiel", "333.333.333-33", "12:40"));
		agendamento.add(new Agenda(new Date(2016-11-21), "Ivo", "222.222.222-22", "Izaquiel", "333.333.333-33", "13:00"));
		agendamento.add(new Agenda(new Date(2016-11-28), "Izaquiel", "333.333.333-33", "José Diogo", "111.111.111-11", "14:20"));
		agendamento.add(new Agenda(new Date(2016-12-05), "Izaquiel", "333.333.333-33", "Ivo", "222.222.222-22", "09:20"));
		agendamento.add(new Agenda(new Date(2016-10-29), "Izaquiel", "333.333.333-33", "José Diogo", "111.111.111-11", "12:40"));
		
	}
	
	
	public static void validarLogin (String login, String senha, TelaLogin tl, boolean tlog){
		boolean logado = false;
		for(int i = 0; i < funcionarios.size(); i++){
			if(funcionarios.get(i).getLogin().equals(login) && funcionarios.get(i).getSenha().equals(senha)){
				tl.dispose();
				tlog = false;
				
				new TelaMenu(funcionarios.get(i));
				
				//tAgd.setVisible(true);
				
				//tM.jdPane.add(tAgd);
				
				logado = true;
			}
		}
		
		if(!logado)
			JOptionPane.showMessageDialog(null, "Login ou senha inválido");
		
	}
	
	
}
