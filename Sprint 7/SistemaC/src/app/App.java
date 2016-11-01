package app;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.Controller;
import model.Agenda;
import model.Disponibilidade;
import model.Endereco;
import model.Funcionario;
import model.Paciente;
import model.Prontuario;
import view.TelaCadastroPaciente;
import view.TelaConsultaAgenda;
import view.TelaLogin;
import view.TelaMenu;



public class App {

	public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	public static ArrayList<Agenda> agendamento = new ArrayList<Agenda>();
	public static ArrayList<Disponibilidade> disp = new ArrayList<>();

	public static void main(String[] args) {
		
		TelaLogin tl = new TelaLogin();
		
		new Controller(tl);
		
		
		
		pacientes.add(new Paciente("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100)));
		pacientes.add(new Paciente("Ivo", "222222", "222.222.222-22", "(222) 22222 - 2222", new Endereco("Pernambuco (PE)", "Triunfo", "C", "D", 200)));
		pacientes.add(new Paciente("Izaquiel", "3333333", "333.333.333-33", "(333) 33333 - 3333", new Endereco("Pernambuco (PE)", "Flores", "E", "F", 300)));
		
		funcionarios.add(new Funcionario("José Diogo", "1111111", "111.111.111-11", "(111) 11111 - 1111", "diogosousa", "admin", new Endereco("Paraíba (PB)", "Princesa Isabel", "A", "B", 100)));
		funcionarios.add(new Funcionario("Ivo", "222222", "222.222.222-22", "(222) 22222 - 2222", "ivosouza", "admin", new Endereco("Pernambuco (PE)", "Triunfo", "C", "D", 200)));
		funcionarios.add(new Funcionario("Izaquiel", "3333333", "333.333.333-33", "(333) 33333 - 3333", "izaquiel", "admin", new Endereco("Pernambuco (PE)", "Flores", "E", "F", 300)));
		
		agendamento.add(new Agenda("28/10/2016", "José Diogo", "111.111.111-11", "09:20", new Prontuario("Consulta - 28/10/2016\n\nHorário: 09:20\nPaciente: José Diogo\nFuncionário: Ivo")));
		agendamento.add(new Agenda("01/11/2016", "José Diogo", "111.111.111-11", "11:20", new Prontuario("Consulta - 01/11/2016\n\nHorário: 11:40\nPaciente: José Diogo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("23/12/2016", "José Diogo", "111.111.111-11", "14:40", new Prontuario("Consulta - 23/12/2016\n\nHorário: 14:40\nPaciente: José Diogo\nFuncionário: Ivo")));
		agendamento.add(new Agenda("15/11/2016", "Ivo", "222.222.222-22", "10:20", new Prontuario("Consulta - 15/11/2016\n\nHorário: 10:20\nPaciente: Ivo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("12/12/2016", "Ivo", "222.222.222-22", "12:40", new Prontuario("Consulta - 12/12/2016\n\nHorário: 12:40\nPaciente: Ivo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("21/11/2016", "Ivo", "222.222.222-22", "13:00", new Prontuario("Consulta - 21/11/2016\n\nHorário: 13:00\nPaciente: Ivo\nFuncionário: José Diogo")));
		agendamento.add(new Agenda("28/11/2016", "Izaquiel", "333.333.333-33", "14:20", new Prontuario("Consulta - 28/11/2016\n\nHorário: 14:20\nPaciente: Izaquiel\nFuncionário: Ivo")));
		agendamento.add(new Agenda("05/12/2016", "Izaquiel", "333.333.333-33", "09:20", new Prontuario("Consulta - 05/12/2016\n\nHorário: 09:20\nPaciente: Izaquiel\nFuncionário: José Diogo")));
		agendamento.add(new Agenda("29/10/2016", "Izaquiel", "333.333.333-33", "12:40", new Prontuario("Consulta - 29/10/2016\n\nHorário: 12:40\nPaciente: Izaquiel\nFuncionário: José Diogo")));
		
		agendamento.add(new Agenda("28/10/2016", "José Diogo", "111.111.111-11", "09:20", new Prontuario("Consulta - 28/10/2016\n\nHorário: 09:20\nPaciente: José Diogo\nFuncionário: Ivo")));
		agendamento.add(new Agenda("01/11/2016", "José Diogo", "111.111.111-11", "11:20", new Prontuario("Consulta - 01/11/2016\n\nHorário: 11:40\nPaciente: José Diogo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("23/12/2016", "José Diogo", "111.111.111-11", "14:40", new Prontuario("Consulta - 23/12/2016\n\nHorário: 14:40\nPaciente: José Diogo\nFuncionário: Ivo")));
		agendamento.add(new Agenda("15/11/2016", "Ivo", "222.222.222-22", "10:20", new Prontuario("Consulta - 15/11/2016\n\nHorário: 10:20\nPaciente: Ivo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("12/12/2016", "Ivo", "222.222.222-22", "12:40", new Prontuario("Consulta - 12/12/2016\n\nHorário: 12:40\nPaciente: Ivo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("21/11/2016", "Ivo", "222.222.222-22", "13:00", new Prontuario("Consulta - 21/11/2016\n\nHorário: 13:00\nPaciente: Ivo\nFuncionário: José Diogo")));
		agendamento.add(new Agenda("28/11/2016", "Izaquiel", "333.333.333-33", "14:20", new Prontuario("Consulta - 28/11/2016\n\nHorário: 14:20\nPaciente: Izaquiel\nFuncionário: Ivo")));
		agendamento.add(new Agenda("05/12/2016", "Izaquiel", "333.333.333-33", "09:20", new Prontuario("Consulta - 05/12/2016\n\nHorário: 09:20\nPaciente: Izaquiel\nFuncionário: José Diogo")));
		agendamento.add(new Agenda("29/10/2016", "Izaquiel", "333.333.333-33", "12:40", new Prontuario("Consulta - 29/10/2016\n\nHorário: 12:40\nPaciente: Izaquiel\nFuncionário: José Diogo")));
		
		agendamento.add(new Agenda("28/10/2016", "José Diogo", "111.111.111-11", "09:20", new Prontuario("Consulta - 28/10/2016\n\nHorário: 09:20\nPaciente: José Diogo\nFuncionário: Ivo")));
		agendamento.add(new Agenda("01/11/2016", "José Diogo", "111.111.111-11", "11:20", new Prontuario("Consulta - 01/11/2016\n\nHorário: 11:40\nPaciente: José Diogo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("23/12/2016", "José Diogo", "111.111.111-11", "14:40", new Prontuario("Consulta - 23/12/2016\n\nHorário: 14:40\nPaciente: José Diogo\nFuncionário: Ivo")));
		agendamento.add(new Agenda("15/11/2016", "Ivo", "222.222.222-22", "10:20", new Prontuario("Consulta - 15/11/2016\n\nHorário: 10:20\nPaciente: Ivo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("12/12/2016", "Ivo", "222.222.222-22", "12:40", new Prontuario("Consulta - 12/12/2016\n\nHorário: 12:40\nPaciente: Ivo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("21/11/2016", "Ivo", "222.222.222-22", "13:00", new Prontuario("Consulta - 21/11/2016\n\nHorário: 13:00\nPaciente: Ivo\nFuncionário: José Diogo")));
		agendamento.add(new Agenda("28/11/2016", "Izaquiel", "333.333.333-33", "14:20", new Prontuario("Consulta - 28/11/2016\n\nHorário: 14:20\nPaciente: Izaquiel\nFuncionário: Ivo")));
		agendamento.add(new Agenda("05/12/2016", "Izaquiel", "333.333.333-33", "09:20", new Prontuario("Consulta - 05/12/2016\n\nHorário: 09:20\nPaciente: Izaquiel\nFuncionário: José Diogo")));
		agendamento.add(new Agenda("29/10/2016", "Izaquiel", "333.333.333-33", "12:40", new Prontuario("Consulta - 29/10/2016\n\nHorário: 12:40\nPaciente: Izaquiel\nFuncionário: José Diogo")));
		
		agendamento.add(new Agenda("28/10/2016", "José Diogo", "111.111.111-11", "09:20", new Prontuario("Consulta - 28/10/2016\n\nHorário: 09:20\nPaciente: José Diogo\nFuncionário: Ivo")));
		agendamento.add(new Agenda("01/11/2016", "José Diogo", "111.111.111-11", "11:20", new Prontuario("Consulta - 01/11/2016\n\nHorário: 11:40\nPaciente: José Diogo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("23/12/2016", "José Diogo", "111.111.111-11", "14:40", new Prontuario("Consulta - 23/12/2016\n\nHorário: 14:40\nPaciente: José Diogo\nFuncionário: Ivo")));
		agendamento.add(new Agenda("15/11/2016", "Ivo", "222.222.222-22", "10:20", new Prontuario("Consulta - 15/11/2016\n\nHorário: 10:20\nPaciente: Ivo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("12/12/2016", "Ivo", "222.222.222-22", "12:40", new Prontuario("Consulta - 12/12/2016\n\nHorário: 12:40\nPaciente: Ivo\nFuncionário: Izaquiel")));
		agendamento.add(new Agenda("21/11/2016", "Ivo", "222.222.222-22", "13:00", new Prontuario("Consulta - 21/11/2016\n\nHorário: 13:00\nPaciente: Ivo\nFuncionário: José Diogo")));
		agendamento.add(new Agenda("28/11/2016", "Izaquiel", "333.333.333-33", "14:20", new Prontuario("Consulta - 28/11/2016\n\nHorário: 14:20\nPaciente: Izaquiel\nFuncionário: Ivo")));
		agendamento.add(new Agenda("05/12/2016", "Izaquiel", "333.333.333-33", "09:20", new Prontuario("Consulta - 05/12/2016\n\nHorário: 09:20\nPaciente: Izaquiel\nFuncionário: José Diogo")));
		agendamento.add(new Agenda("29/10/2016", "Izaquiel", "333.333.333-33", "12:40", new Prontuario("Consulta - 29/10/2016\n\nHorário: 12:40\nPaciente: Izaquiel\nFuncionário: José Diogo")));
		
	}
	
	
	public static void validarLogin (String login, String senha, TelaLogin tl, boolean tlog){
		boolean logado = false;
		for(int i = 0; i < funcionarios.size(); i++){
			if(funcionarios.get(i).getLogin().equals(login) && funcionarios.get(i).getSenha().equals(senha)){
				tl.dispose();
				tlog = false;
				TelaMenu tM = new TelaMenu(funcionarios.get(i));
				
				TelaConsultaAgenda tAgd = new TelaConsultaAgenda();
				//tAgd.setVisible(true);
				
				//tM.jdPane.add(tAgd);
				
				logado = true;
			}
		}
		
		if(!logado)
			JOptionPane.showMessageDialog(null, "Login ou senha inválido");
		
	}
	
	
}
