package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import app.App;
import model.Funcionario;
import model.Paciente;

public class TelaBuscaPaciente extends Tela {

	private static final long serialVersionUID = 1L;
	private JLabel cpf;
	private JTextField campoCpf;
	private JButton pesquisar;
	private MaskFormatter m1;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private Object [][] dados;
	String [] colunas = {"Nome", "CPF", "Telefone"};
	
	
	public TelaBuscaPaciente() {

		setTitle("Busca de Paciente");
		
		preencherTabela();
		
		try {
			m1 = new MaskFormatter("###.###.###-##");
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		

		cpf = new JLabel("CPF: ");
		campoCpf = new JFormattedTextField(m1);

		pesquisar = new JButton("Pesquisar");

		Container c = new Container();
		c.setLayout(new GridLayout(1, 2));
		c.setSize(400, 20);
		c.setLocation(10, 10);
		c.add(cpf);
		c.add(campoCpf);
	
		add(barraRolagem);

		add(c);
		pesquisar.setBounds(450, 10, 100, 20);
		add(pesquisar);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Container c2 = new Container();
		c2.setLayout(new GridLayout(7, 2));
		c2.setSize(500, 800);
		c2.setLocation(50, 120);
		add(c2);
		
		setVisible(true);

	}
	
	public void preencherTabela(){
		this.dados = new Object[App.pacientes.size()][3];
		int i=0;
		for(Paciente pac:App.pacientes){
			dados[i][0]=pac.getNome();
			dados[i][1]=pac.getCpf();
			dados[i][2]=pac.getTelefone();
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

	public MaskFormatter getM1() {
		return m1;
	}

	public void setM1(MaskFormatter m1) {
		this.m1 = m1;
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
