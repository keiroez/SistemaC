package app;

import java.util.ArrayList;

import control.Controller;
import model.Funcionario;
import model.Paciente;
import view.TelaMenu;

public class App {
	
	public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	public static ArrayList<Funcionario> funciomarios = new ArrayList<Funcionario>();
	
	
	public static void main(String[] args) {
		TelaMenu tm = new TelaMenu();
		new Thread(tm).start();
		new Controller(tm);
	
	}
}
