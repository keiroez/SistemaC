package view;

import java.awt.Color;
import java.awt.Container;

import java.awt.GridLayout;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaMenu extends Tela implements Runnable{
	private JButton CadPacButton, CadFuncButton, agendaButton, buscaPacButton, buscaFuncButton, sairButton;
	private JLabel logo;
	private String direcao;
	private int posX, posY;
	
	public TelaMenu() {
		
		direcao = "direita";
		logo = new JLabel(new ImageIcon("resource/logo.png"));
		logo.setBounds(0, 100, 153, 94);
		add(logo);
		
		getContentPane().setBackground(Color.BLACK);
		this.CadPacButton = new JButton("Cadastrar paciente");
		this.CadFuncButton = new JButton("Cadastrar Funcionario");
		this.agendaButton = new JButton("Agenda");
		this.buscaPacButton = new JButton("Buscar Paciente");
		this.buscaFuncButton = new JButton("Buscar Funcionario");
		this.sairButton = new JButton("Sair");
		
		Container c = new Container();
		c.setLayout(new GridLayout(7, 2, 20, 30));
		c.setSize(200, 400);
		c.setLocation(400, 20);
		c.add(CadPacButton);
		c.add(CadFuncButton);
		c.add(agendaButton);
		c.add(buscaPacButton);
		c.add(buscaFuncButton);
		c.add(sairButton);
		add(c);
		
		this.setVisible(true);
	}

	@Override
	public void run() {
					
			try {
				while(true){
					
					Thread.sleep(5);
					logo.setLocation(posX, posY);
					atualizarDirecao();
					logo.setLocation(posX, posY);
					
					if(direcao.equals("direita")){
						posX++;
					}
					if(direcao.equals("esquerda")){
						posX--;
					}
					
					if(direcao.equals("cima")){
						posY--;
					}
					
					if(direcao.equals("baixo")){
						posY++;
					}
					
					logo.setLocation(posX, posY);
					atualizarDirecao();
					logo.setLocation(posX, posY);
				} 
			}
			
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	}
	
	
	public void atualizarDirecao(){
		
		
		if(direcao.equals("direita")){
			if(posX >= 240){
				direcao = "baixo";
			}
		}
		
		if(direcao.equals("baixo")){
			if(posY >= 280){
				direcao = "esquerda";
			}
		}
		
		if(direcao.equals("esquerda")){
			if(posX <= 0){
				direcao = "cima";
			}
		}
		
		if(direcao.equals("cima")){
			if(posY <= 0){
				direcao = "direita";
			}
		}
			
	}
}
