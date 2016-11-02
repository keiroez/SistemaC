package model;

import java.util.ArrayList;

public class Disponibilidade {
	
	private String data;
	private String [] horas = {"09:00", "09:20", "09:40", "10:00", "10:20", "10:40", "11:00", "11:20", "11:40", "12:00", "12:20", "12:40", "13:00", "13:20", "13:40", "14:00", "14:20", "14:40", "15:00"};
	private ArrayList<String> horarios;
	
	
	public Disponibilidade(String data) {
		
		this.data = data;
		horarios = new ArrayList<>();
		
		for(int i = 0; i < horas.length; i++){
			horarios.add(horas[i]);
		}
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public ArrayList<String> getHorarios() {
		return horarios;
	}


	public void setHorarios(ArrayList<String> horarios) {
		this.horarios = horarios;
	}
	
	
	
	
	
	
}
