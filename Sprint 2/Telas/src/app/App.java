package app;

import java.util.ArrayList;


import model.Funcionario;
import model.Paciente;
import view.TelaAgendamento;

public class App {
	
	public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public static void main(String[] args) {

		new TelaAgendamento();
		//TelaMenu tm = new TelaMenu();
		//new Thread(tm).start();
		
	}

}
