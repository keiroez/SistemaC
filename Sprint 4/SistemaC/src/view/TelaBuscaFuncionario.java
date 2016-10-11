package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import app.App;
import model.Funcionario;

public class TelaBuscaFuncionario extends Tela {
	
	
	private static final long serialVersionUID = 1L;
	private JLabel cpf;
	private JTextField campoCpf;
	private JButton pesquisar;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private Object [][] dados;
	String [] colunas = {"Nome", "CPF", "Telefone"};

	public TelaBuscaFuncionario() {
		
		preencherTabela();
		
		setTitle("Busca de Funcionário");

		//cpf = new JLabel("CPF: ");
		//campoCpf = new JTextField(20);

		//pesquisar = new JButton("Pesquisar");

		Container c = new Container();
		c.setLayout(new GridLayout(1, 2));
		c.setSize(400, 20);
		c.setLocation(10, 10);
		//c.add(cpf);
		//c.add(campoCpf);
		
		
		add(barraRolagem);
		

		add(c);
		//pesquisar.setBounds(450, 10, 100, 20);
		//add(pesquisar);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public void preencherTabela(){
		this.dados = new Object[App.funcionarios.size()][3];
		int i=0;
		for(Funcionario func:App.funcionarios){
			dados[i][0]=func.getNome();
			dados[i][1]=func.getCpf();
			dados[i][2]=func.getTelefone();
			i++;
		}
		
		tabela = new JTable(dados, colunas);
		this.barraRolagem = new JScrollPane(barraRolagem);
		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		barraRolagem.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(10, 40, 575, 300);
	}
	

	public JLabel getCpf() {
		return cpf;
	}

	public void setCpf(JLabel cpf) {
		this.cpf = cpf;
	}

	public JTextField getCampoCpf() {
		return campoCpf;
	}

	public void setCampoCpf(JTextField campoCpf) {
		this.campoCpf = campoCpf;
	}

	public JButton getPesquisar() {
		return pesquisar;
	}

	public void setPesquisar(JButton pesquisar) {
		this.pesquisar = pesquisar;
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JScrollPane getBarraRolagem() {
		return barraRolagem;
	}

	public void setBarraRolagem(JScrollPane barraRolagem) {
		this.barraRolagem = barraRolagem;
	}

	public Object[][] getDados() {
		return dados;
	}

	public void setDados(Object[][] dados) {
		this.dados = dados;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}
	
	

}
