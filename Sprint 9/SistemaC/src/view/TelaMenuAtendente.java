package view;


import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import control.Controller;
import model.Funcionario;

public class TelaMenuAtendente extends Tela {

	private static final long serialVersionUID = 1L;
	private JMenuBar jmPrincipal = new JMenuBar();
	private JMenu jmCadastro = new JMenu("Cadastros");
	private JMenu jmBusca = new JMenu("Busca");
	private JMenu jmAgenda = new JMenu("Agenda");
	private JMenu jmOpcoes = new JMenu("Opções");
	private JMenuItem jmCadCliente = new JMenuItem("Cadastrar Paciente");
	private JMenuItem jmCadFuncionario = new JMenuItem("Cadastrar Funcionário");
	private JMenuItem jmAgendarConsulta = new JMenuItem("Agendar consulta");
	private JMenuItem jmAgBus = new JMenuItem("Buscar Agendamentos");
	private JMenuItem jmSair = new JMenuItem("Sair");
	private JPanel jp = new JPanel();
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JLabel titulo;

	public JDesktopPane jdPane = new JDesktopPane();
	private Controller controle;

	public TelaMenuAtendente(Funcionario f) {
		preencherCabecalhoTabela();
		controle = new Controller(this, f);
		getContentPane().add(jdPane);
		jmPrincipal.add(jmOpcoes);
		jmPrincipal.add(jmCadastro);
		jmPrincipal.add(jmBusca);
		jmPrincipal.add(jmAgenda);
		jdPane.setBounds(0, 0, this.getWidth(), this.getHeight());

		titulo = new JLabel("Consultas do dia");
		titulo.setBounds(35, 0, 300, 40);
		titulo.setFont(new Font("Serif", 30, 30));
		barraRolagem.setBounds(0, 40, 300, this.getHeight()-40);
		jp.setLayout(null);
		jp.setBounds(this.getWidth() - 300, 0, 300, this.getHeight());
		jp.add(titulo);
		jp.add(barraRolagem);
		
		jdPane.add(jp);
		
		jmCadastro.add(jmCadCliente);
		jmCadastro.add(jmCadFuncionario);
		jmBusca.add(jmAgBus);
		jmAgenda.add(jmAgendarConsulta);
		jmOpcoes.add(jmSair);

		setJMenuBar(jmPrincipal);

		jmCadCliente.addActionListener(controle);
		jmCadFuncionario.addActionListener(controle);
		jmAgendarConsulta.addActionListener(controle);
		jmAgBus.addActionListener(controle);
		jmSair.addActionListener(controle);
		setVisible(true);
	}

	public void preencherCabecalhoTabela() {

		tabela = new JTable() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		
		tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Paciente", "Horário", "Médico" }));
		barraRolagem = new JScrollPane(barraRolagem);
		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		barraRolagem.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(10, 70, 575, 280);
	}
	
	public void limparTabela(){
		for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
			DefaultTableModel df = (DefaultTableModel) tabela.getModel();
			df.removeRow(j);
		}
		preencherCabecalhoTabela();	
		jp.remove(barraRolagem);
		barraRolagem.setBounds(0, 40, 300, this.getHeight()-40);
		jp.add(barraRolagem);
	}

	public JMenuItem getJmAgBus() {
		return jmAgBus;
	}

	public void setJmAgBus(JMenuItem jmAgBus) {
		this.jmAgBus = jmAgBus;
	}

	public JMenuBar getJmPrincipal() {
		return jmPrincipal;
	}

	public void setJmPrincipal(JMenuBar jmPrincipal) {
		this.jmPrincipal = jmPrincipal;
	}

	public JMenu getJmCadastro() {
		return jmCadastro;
	}

	public void setJmCadastro(JMenu jmCadastro) {
		this.jmCadastro = jmCadastro;
	}

	public JMenuItem getJmCadCliente() {
		return jmCadCliente;
	}

	public void setJmCadCliente(JMenuItem jmCadCliente) {
		this.jmCadCliente = jmCadCliente;
	}

	public JMenuItem getJmCadFuncionario() {
		return jmCadFuncionario;
	}

	public void setJmCadFuncionario(JMenuItem jmCadFuncionario) {
		this.jmCadFuncionario = jmCadFuncionario;
	}

	public JDesktopPane getJdPane() {
		return jdPane;
	}

	public void setJdPane(JDesktopPane jdPane) {
		this.jdPane = jdPane;
	}

	public JMenu getJmBusca() {
		return jmBusca;
	}

	public void setJmBusca(JMenu jmBusca) {
		this.jmBusca = jmBusca;
	}

	public Controller getControle() {
		return controle;
	}

	public void setControle(Controller controle) {
		this.controle = controle;
	}

	public JMenu getJmAgenda() {
		return jmAgenda;
	}

	public void setJmAgenda(JMenu jmAgenda) {
		this.jmAgenda = jmAgenda;
	}

	public JMenuItem getJmAgendarConsulta() {
		return jmAgendarConsulta;
	}

	public void setJmAgendarConsulta(JMenuItem jmAgendarConsulta) {
		this.jmAgendarConsulta = jmAgendarConsulta;
	}

	public JMenu getJmOpcoes() {
		return jmOpcoes;
	}

	public void setJmOpcoes(JMenu jmOpcoes) {
		this.jmOpcoes = jmOpcoes;
	}

	public JMenuItem getJmSair() {
		return jmSair;
	}

	public void setJmSair(JMenuItem jmSair) {
		this.jmSair = jmSair;
	}

	public JPanel getJp() {
		return jp;
	}

	public void setJp(JPanel jp) {
		this.jp = jp;
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

}
