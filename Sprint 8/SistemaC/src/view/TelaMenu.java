package view;

import javax.swing.JDesktopPane;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import control.Controller;
import model.Funcionario;

public class TelaMenu extends Tela {

	private static final long serialVersionUID = 1L;
	private JMenuBar jmPrincipal = new JMenuBar();
	private JMenu jmCadastro = new JMenu("Cadastros");
	private JMenu jmBusca = new JMenu("Busca");
	private JMenu jmAgenda = new JMenu("Agenda");
	private JMenu jmAtendimento = new JMenu("Atendimento");
	private JMenuItem jmCriarPront = new JMenuItem("Prontuário");
	private JMenuItem jmCadCliente = new JMenuItem("Cadastrar Paciente");
	private JMenuItem jmCadFuncionario = new JMenuItem("Cadastrar Funcionário");
	private JMenuItem jmBuscPaciente = new JMenuItem("Buscar Paciente");
	private JMenuItem jmBuscFuncionario = new JMenuItem("Buscar Funcionário");
	private JMenuItem jmBuscProntuario = new JMenuItem("Buscar Prontuário");
	private JMenuItem jmAgendarConsulta = new JMenuItem("Agendar consulta");
	private JMenuItem jmConsultarAgendamento = new JMenuItem("Consultar Agendamentos");
	public JDesktopPane jdPane = new JDesktopPane();
	private Controller controle;
	private TelaConsultaAgenda painelAgenda = new TelaConsultaAgenda();

	public TelaMenu(Funcionario f) {
		controle = new Controller(this, f);
		getContentPane().add(jdPane);
		jmPrincipal.add(jmAtendimento);
		jmPrincipal.add(jmCadastro);
		jmPrincipal.add(jmBusca);
		jmPrincipal.add(jmAgenda);

		jmAtendimento.add(jmCriarPront);
		jmCadastro.add(jmCadCliente);
		jmCadastro.add(jmCadFuncionario);
		jmBusca.add(jmBuscPaciente);
		jmBusca.add(jmBuscFuncionario);
		jmBusca.add(jmBuscProntuario);
		jmAgenda.add(jmAgendarConsulta);
		// jmAgenda.add(jmConsultarAgendamento);

		setJMenuBar(jmPrincipal);

		jmCadCliente.addActionListener(controle);
		jmCadFuncionario.addActionListener(controle);
		jmBuscPaciente.addActionListener(controle);
		jmBuscFuncionario.addActionListener(controle);
		jmAgendarConsulta.addActionListener(controle);
		jmConsultarAgendamento.addActionListener(controle);
		jmBuscProntuario.addActionListener(controle);

		jdPane.add(painelAgenda);

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

	public JMenuItem getJmBuscProntuario() {
		return jmBuscProntuario;
	}

	public void setJmBuscProntuario(JMenuItem jmBuscProntuario) {
		this.jmBuscProntuario = jmBuscProntuario;
	}

	public JMenu getJmAtendimento() {
		return jmAtendimento;
	}

	public void setJmAtendimento(JMenu jmAtendimento) {
		this.jmAtendimento = jmAtendimento;
	}

	public JMenuItem getJmCriarPront() {
		return jmCriarPront;
	}

	public void setJmCriarPront(JMenuItem jmCriarPront) {
		this.jmCriarPront = jmCriarPront;
	}

	public TelaConsultaAgenda getPainelAgenda() {
		return painelAgenda;
	}

	public void setPainelAgenda(TelaConsultaAgenda painelAgenda) {
		this.painelAgenda = painelAgenda;
	}
	

}
