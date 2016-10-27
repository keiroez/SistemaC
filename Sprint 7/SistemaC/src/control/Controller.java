package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import app.App;
import model.Agenda;
import model.Funcionario;
import view.TelaAgendamento;
import view.TelaBuscaFuncionario;
import view.TelaBuscaPaciente;
import view.TelaCadastroFuncionario;
import view.TelaCadastroPaciente;
import view.TelaLogin;
import view.TelaMenu;


public class Controller implements ActionListener {

	private TelaCadastroPaciente tPaciente;
	private TelaCadastroFuncionario tFuncionario;
	private TelaBuscaPaciente tBPaciente;
	private TelaAgendamento tAgendamento;
	private TelaBuscaFuncionario tBFuncionario;
	private TelaMenu tMenu;
	private TelaLogin tl;
	private Funcionario funcionario;
	private boolean tfIsAtivo, tpIsAtivo, tbpIsAtivo, tbfIsAtivo, tAgendaIsAtivo, tlog;

	public Controller(TelaMenu tMenu, Funcionario f) {
		this.tMenu = tMenu;
		this.funcionario = f;

	}

	public Controller(TelaLogin tl) {
		this.tl = tl;
		tl.getEntrar().addActionListener(this);
		tl.getSair().addActionListener(this);
		tlog = true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		if (tlog) {
			if (e.getSource() == tl.getSair()) {
				System.exit(0);
			}

			if (e.getSource() == tl.getEntrar()) {
				App.validarLogin(tl.getCampoLogin().getText(), tl.getCampoSenha().getText(), tl, tlog);
			}
		}

		else {
			if (e.getSource() == tMenu.getJmCadCliente()) {
				tPaciente = new TelaCadastroPaciente();
				tPaciente.setVisible(true);
				tPaciente.getCadastrar().addActionListener(this);
				tMenu.jdPane.add(tPaciente);
				tpIsAtivo = true;
			}

			if (e.getSource() == tMenu.getJmCadFuncionario()) {
				tFuncionario = new TelaCadastroFuncionario();
				tFuncionario.setVisible(true);
				tFuncionario.getCadastrar().addActionListener(this);
				tMenu.jdPane.add(tFuncionario);
				tfIsAtivo = true;
			}

			if (e.getSource() == tMenu.getJmBuscPaciente()) {
				tBPaciente = new TelaBuscaPaciente();
				tBPaciente.setVisible(true);
				tBPaciente.getPesquisar().addActionListener(this);
				tBPaciente.getRemover().addActionListener(this);
				tBPaciente.getAbrir().addActionListener(this);
				tMenu.jdPane.add(tBPaciente);
				tbpIsAtivo = true;
			}

			if (e.getSource() == tMenu.getJmBuscFuncionario()) {
				tBFuncionario = new TelaBuscaFuncionario();
				tBFuncionario.setVisible(true);
				tBFuncionario.getPesquisar().addActionListener(this);
				tMenu.jdPane.add(tBFuncionario);
				tbfIsAtivo = true;
			}

			if (e.getSource() == tMenu.getJmAgendarConsulta()) {
				tAgendamento = new TelaAgendamento();
				tAgendamento.setVisible(true);
				tAgendamento.getAgendar().addActionListener(this);
				tAgendamento.getBuscaP().addActionListener(this);
				tAgendamento.getBuscaF().addActionListener(this);
				tMenu.jdPane.add(tAgendamento);
				tAgendaIsAtivo = true;
				new Thread(tAgendamento).start();

			}

			if (tfIsAtivo) {

				if (e.getSource() == tFuncionario.getCadastrar()) {

					funcionario.cadastrarFuncionario(tFuncionario.getCampoNome().getText(),
							tFuncionario.getCampoRg().getText(), tFuncionario.getCampoCpf().getText(),
							tFuncionario.getCampoTelefone().getText(), tFuncionario.getCampoLogin().getText(),
							tFuncionario.getCampoSenha().getText(),
							tFuncionario.getCampoEstado().getSelectedItem().toString(),
							tFuncionario.getCampoCidade().getSelectedItem().toString(),
							tFuncionario.getCampoRua().getText(), tFuncionario.getCampoBairro().getText(),
							tFuncionario.getCampoNumero().getText());
				}
			}

			if (tpIsAtivo) {

				if (e.getSource() == tPaciente.getCadastrar()) {

					funcionario.cadastrarPaciente(tPaciente.getCampoNome().getText(), tPaciente.getCampoRg().getText(),
							tPaciente.getCampoCpf().getText(), tPaciente.getCampoTelefone().getText(),
							tPaciente.getCampoEstado().getSelectedItem().toString(),
							tPaciente.getCampoCidade().getSelectedItem().toString(), tPaciente.getCampoRua().getText(),
							tPaciente.getCampoBairro().getText(), tPaciente.getCampoNumero().getText());
				
				}
			}

			if (tbpIsAtivo) {
				if (e.getSource() == tBPaciente.getPesquisar()) {

					funcionario.pesquisarPaciente(tBPaciente.getCampoCpf().getText(), tBPaciente.getTabela());

				}

				if (e.getSource() == tBPaciente.getRemover()) {

					funcionario.removerPaciente(tBPaciente.getTabela());

				}

				if (e.getSource() == tBPaciente.getAbrir()) {


				}
			}

			if (tbfIsAtivo) {
				if (e.getSource() == tBFuncionario.getPesquisar()) {
					funcionario.pesquisarFuncionario(tBFuncionario.getCampoCpf().getText(), tBFuncionario.getTabela());
				}

				if (e.getSource() == tBFuncionario.getRemover()) {
					funcionario.removerFuncionario(tBFuncionario.getTabela());
				}
			}

			if (tAgendaIsAtivo) {

				if (e.getSource() == tAgendamento.getBuscaP()) {

					tBPaciente = new TelaBuscaPaciente();
					tBPaciente.setVisible(true);
					tBPaciente.getPesquisar().addActionListener(this);
					tMenu.jdPane.add(tBPaciente);
					tAgendamento.setVisible(false);

					tBPaciente.getAbrir().setText("Selecionar");
					tBPaciente.getAbrir().setBounds(250, 330, 100, 20);
					tBPaciente.getRemover().setVisible(false);
					tBPaciente.getAbrir().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							tAgendamento.getCampoNomePaciente()
									.setText((String) tBPaciente.getTabela().getValueAt(0, 0));
							tAgendamento.setCpfPaciente((String) tBPaciente.getTabela().getValueAt(0, 1));
							tAgendamento.setVisible(true);
							tBPaciente.setVisible(false);

						}
					});

					tBPaciente.getRemover().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							tBPaciente.dispose();

						}
					});

					tBPaciente.getPesquisar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							for (int i = 0; i < App.pacientes.size(); i++) {
								if (tBPaciente.getCampoCpf().getText().equals(App.pacientes.get(i).getCpf())) {

									if (funcionario.pacienteBuscado(tBPaciente.getTabela())) {

									} else {
										String[] dados = new String[] { App.pacientes.get(i).getNome(),
												App.pacientes.get(i).getCpf(), App.pacientes.get(i).getTelefone() };
										DefaultTableModel df = (DefaultTableModel) tBPaciente.getTabela().getModel();
										df.addRow(dados);
									}
								}
							}
						}

					});

				}

				if (e.getSource() == tAgendamento.getBuscaF()) {

					tBFuncionario = new TelaBuscaFuncionario();
					tBFuncionario.setVisible(true);
					tBFuncionario.getPesquisar().addActionListener(this);
					tMenu.jdPane.add(tBFuncionario);
					tAgendamento.setVisible(false);

					tBFuncionario.getRemover().setText("Selecionar");
					tBFuncionario.getRemover().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							tAgendamento.getCampoNomeFuncionario()
									.setText((String) tBFuncionario.getTabela().getValueAt(0, 0));
							tAgendamento.setVisible(true);
							tBFuncionario.dispose();
						}
					});

					tBFuncionario.getPesquisar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							for (int i = 0; i < App.funcionarios.size(); i++) {
								if (tBFuncionario.getCampoCpf().getText().equals(App.funcionarios.get(i).getCpf())) {

									if (funcionario.funcionarioBuscado(tBFuncionario.getTabela(), tBFuncionario.getCampoCpf().getText())) {

									} else {
										String[] dados = new String[] { App.funcionarios.get(i).getNome(),
												App.funcionarios.get(i).getCpf(),
												App.funcionarios.get(i).getTelefone() };
										DefaultTableModel df = (DefaultTableModel) tBFuncionario.getTabela().getModel();
										df.addRow(dados);
									}
								}
							}

						}
					});

				}

				if (e.getSource() == tAgendamento.getAgendar()) {

					if (!tAgendamento.campoVazio()) {

						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						App.agendamento.add(new Agenda(df.format(tAgendamento.getDataCalendario().getDate()),
								tAgendamento.getCampoNomePaciente().getText(), tAgendamento.getCpfPaciente(),
								tAgendamento.getItensHorario().getSelectedItem().toString()));

						JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso");
						tAgendamento.removerItemComboBox(df.format(tAgendamento.getDataCalendario().getDate()),
								tAgendamento.getItensHorario().getSelectedItem().toString());
						tAgendamento.limparCampoData();
						new Thread(tAgendamento).start();

					}

					else {
						JOptionPane.showMessageDialog(null, "Campo não preenchido");
					}

				}
			}
		}

	}

	public TelaCadastroPaciente gettPaciente() {
		return tPaciente;
	}

	public void settPaciente(TelaCadastroPaciente tPaciente) {
		this.tPaciente = tPaciente;
	}

	public TelaCadastroFuncionario gettFuncionario() {
		return tFuncionario;
	}

	public void settFuncionario(TelaCadastroFuncionario tFuncionario) {
		this.tFuncionario = tFuncionario;
	}

	public TelaBuscaPaciente gettBPaciente() {
		return tBPaciente;
	}

	public void settBPaciente(TelaBuscaPaciente tBPaciente) {
		this.tBPaciente = tBPaciente;
	}

	public TelaAgendamento gettAgendamento() {
		return tAgendamento;
	}

	public void settAgendamento(TelaAgendamento tAgendamento) {
		this.tAgendamento = tAgendamento;
	}

	public TelaBuscaFuncionario gettBFuncionario() {
		return tBFuncionario;
	}

	public void settBFuncionario(TelaBuscaFuncionario tBFuncionario) {
		this.tBFuncionario = tBFuncionario;
	}

	public TelaMenu gettMenu() {
		return tMenu;
	}

	public void settMenu(TelaMenu tMenu) {
		this.tMenu = tMenu;
	}

	public boolean isTfIsAtivo() {
		return tfIsAtivo;
	}

	public void setTfIsAtivo(boolean tfIsAtivo) {
		this.tfIsAtivo = tfIsAtivo;
	}

	public boolean isTpIsAtivo() {
		return tpIsAtivo;
	}

	public void setTpIsAtivo(boolean tpIsAtivo) {
		this.tpIsAtivo = tpIsAtivo;
	}

	public boolean isTbpIsAtivo() {
		return tbpIsAtivo;
	}

	public void setTbpIsAtivo(boolean tbpIsAtivo) {
		this.tbpIsAtivo = tbpIsAtivo;
	}

	public boolean isTbfIsAtivo() {
		return tbfIsAtivo;
	}

	public void setTbfIsAtivo(boolean tbfIsAtivo) {
		this.tbfIsAtivo = tbfIsAtivo;
	}

	public boolean istAgendaIsAtivo() {
		return tAgendaIsAtivo;
	}

	public void settAgendaIsAtivo(boolean tAgendaIsAtivo) {
		this.tAgendaIsAtivo = tAgendaIsAtivo;
	}

}
