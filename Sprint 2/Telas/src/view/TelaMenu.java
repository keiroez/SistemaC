package view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;

public class TelaMenu extends Tela {
	private JButton CadPacButton, CadFuncButton, agendaButton, buscaPacButton, buscaFuncButton, sairButton;
	
	public TelaMenu() {
		this.CadPacButton = new JButton("Cadastrar paciente");
		this.CadFuncButton = new JButton("Cadastrar Funcionario");
		this.agendaButton = new JButton("Agenda");
		this.buscaPacButton = new JButton("Buscar Paciente");
		this.buscaFuncButton = new JButton("Buscar Funcionario");
		this.sairButton = new JButton("Sair");
		
		Container c = new Container();
		c.setLayout(new GridLayout(7, 2));
		c.setSize(500, 400);
		c.setLocation(50, 20);
		c.add(CadPacButton);
		c.add(CadFuncButton);
		c.add(agendaButton);
		c.add(buscaPacButton);
		c.add(buscaFuncButton);
		c.add(sairButton);
		add(c);
		
		this.setVisible(true);
	}
}
