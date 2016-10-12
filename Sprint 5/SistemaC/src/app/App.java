package app;

import java.util.ArrayList;

import control.Controller;
import model.Agenda;
import model.Funcionario;
import model.Paciente;

import view.TelaMenu;

public class App{
	
	public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	public static ArrayList<Agenda> agendamento = new ArrayList<Agenda>();
	
	public static void main(String[] args) {
		TelaMenu tm = new TelaMenu();
		new Thread(tm).start();
		new Controller(tm);
		
	}
}
