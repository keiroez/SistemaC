package view;



import javax.swing.JDesktopPane;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control.Controller;
import model.Funcionario;

public class TelaMenu extends Tela{

	private static final long serialVersionUID = 1L;
	private JMenuBar jmPrincipal = new JMenuBar();
	private JMenu jmCadastro = new JMenu("Cadastros");
	private JMenu jmBusca = new JMenu("Busca");
	private JMenu jmAgenda = new JMenu("Agenda");
	private JMenuItem jmCadCliente = new JMenuItem("Cadastrar Paciente");
	private JMenuItem jmCadFuncionario = new JMenuItem("Cadastrar Funcionário");
	private JMenuItem jmBuscPaciente = new JMenuItem("Buscar Paciente");
	private JMenuItem jmBuscFuncionario = new JMenuItem("Buscar Funcionário");
	private JMenuItem jmAgendarConsulta = new JMenuItem("Agendar consulta");
	private JMenuItem jmConsultarAgendamento = new JMenuItem("Consultar Agendamentos");
	public JDesktopPane jdPane = new JDesktopPane();
	private Controller controle;
	
	
	public TelaMenu(Funcionario f) {
		controle = new Controller(this, f);
		getContentPane().add(jdPane);
		
		jmPrincipal.add(jmCadastro);
		jmPrincipal.add(jmBusca);
		jmPrincipal.add(jmAgenda);
		
		jmCadastro.add(jmCadCliente);
		jmCadastro.add(jmCadFuncionario);
		jmBusca.add(jmBuscPaciente);
		jmBusca.add(jmBuscFuncionario);
		jmAgenda.add(jmAgendarConsulta);
		jmAgenda.add(jmConsultarAgendamento);
		
		setJMenuBar(jmPrincipal);
		
		jmCadCliente.addActionListener(controle);
		jmCadFuncionario.addActionListener(controle);
		jmBuscPaciente.addActionListener(controle);
		jmBuscFuncionario.addActionListener(controle);
		jmAgendarConsulta.addActionListener(controle);
		jmConsultarAgendamento.addActionListener(controle);
		
		
		setVisible(true);
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

	public JMenuItem getJmBuscPaciente() {
		return jmBuscPaciente;
	}

	public void setJmBuscPaciente(JMenuItem jmBuscPaciente) {
		this.jmBuscPaciente = jmBuscPaciente;
	}

	public JMenuItem getJmBuscFuncionario() {
		return jmBuscFuncionario;
	}

	public void setJmBuscFuncionario(JMenuItem jmBuscFuncionario) {
		this.jmBuscFuncionario = jmBuscFuncionario;
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

	public JMenuItem getJmConsultarAgendamento() {
		return jmConsultarAgendamento;
	}

	public void setJmConsultarAgendamento(JMenuItem jmConsultarAgendamento) {
		this.jmConsultarAgendamento = jmConsultarAgendamento;
	}
}
