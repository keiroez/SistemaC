package model;

public class Prontuario {
	
	
	private String historico;
	private Paciente paciente;
	
	
	public Prontuario(String historico) {
		
		this.historico = historico;
		
	}


	public String getHistorico() {
		return historico;
	}


	public void setHistorico(String historico) {
		this.historico = historico;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	
	
	

}
