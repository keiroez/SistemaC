package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import app.App;
import model.Funcionario;
import view.TelaAgendamento;
import view.TelaBuscaAgendamentos;
import view.TelaBuscaFuncionario;
import view.TelaBuscaPaciente;
import view.TelaCadastroFuncionario;
import view.TelaCadastroPaciente;
import view.TelaInfoPaciente;
import view.TelaLogin;
import view.TelaMenu;
import view.TelaProntuario;

public class Controller implements ActionListener, KeyListener {

	private TelaCadastroPaciente tPaciente;
	private TelaCadastroFuncionario tFuncionario;
	private TelaBuscaPaciente tBPaciente;
	private TelaAgendamento tAgendamento;
	private TelaBuscaFuncionario tBFuncionario;
	private TelaProntuario tProntuario;
	private TelaBuscaAgendamentos tba;
	private TelaMenu tMenu;
	private TelaLogin tl;
	private Funcionario funcionario;
	private boolean tfIsAtivo, tpIsAtivo, tbpIsAtivo, tbfIsAtivo, tAgendaIsAtivo, tProntIsAtivo, tlog, tbaIsAtivo;

	public Controller(TelaMenu tMenu, Funcionario f) {

		this.tMenu = tMenu;
		this.funcionario = f;
	}

	public Controller(TelaLogin tl) {
		this.tl = tl;
		this.tl.getEntrar().addActionListener(this);
		this.tl.getSair().addActionListener(this);
		this.tl.getCampoSenha().addKeyListener(this);
		this.tl.getCampoLogin().addKeyListener(this);
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
				funcionario.addEstados(tPaciente.getCampoEstado());
				tPaciente.setVisible(true);
				tPaciente.getCadastrar().addActionListener(this);
				tPaciente.getCampoEstado().addActionListener(this);
				tMenu.jdPane.add(tPaciente);
				tpIsAtivo = true;
				tPaciente.moveToFront();
			}

			if (e.getSource() == tMenu.getJmCadFuncionario()) {
				tFuncionario = new TelaCadastroFuncionario();
				funcionario.addEstados(tFuncionario.getCampoEstado());
				tFuncionario.setVisible(true);
				tFuncionario.getCadastrar().addActionListener(this);
				tFuncionario.getCampoEstado().addActionListener(this);
				tMenu.jdPane.add(tFuncionario);
				tfIsAtivo = true;
				tFuncionario.moveToFront();
			}

			if (e.getSource() == tMenu.getJmBuscPaciente()) {
				tBPaciente = new TelaBuscaPaciente();
				tBPaciente.setVisible(true);
				tBPaciente.getPesquisar().addActionListener(this);
				tBPaciente.getRemover().addActionListener(this);
				tBPaciente.getAbrir().addActionListener(this);
				tMenu.jdPane.add(tBPaciente);
				tbpIsAtivo = true;
				tBPaciente.moveToFront();
			}

			if (e.getSource() == tMenu.getJmBuscFuncionario()) {
				tBFuncionario = new TelaBuscaFuncionario();
				tBFuncionario.setVisible(true);
				tBFuncionario.getPesquisar().addActionListener(this);
				tBFuncionario.getRemover().addActionListener(this);
				tMenu.jdPane.add(tBFuncionario);
				tbfIsAtivo = true;
				tBFuncionario.moveToFront();
			}

			if (e.getSource() == tMenu.getJmBuscProntuario()) {
				tProntuario = new TelaProntuario();
				tProntuario.getSairButton().addActionListener(this);
				tProntuario.getSalvarButton().addActionListener(this);
				tProntuario.getEditarButton().addActionListener(this);
				tProntuario.getPesquisar().addActionListener(this);
				tProntuario.getComboData().addActionListener(this);
				tProntuario.getComboHorario().addActionListener(this);
				tMenu.jdPane.add(tProntuario);
				tProntIsAtivo = true;
				tProntuario.moveToFront();
			}

			if (e.getSource() == tMenu.getJmAgendarConsulta()) {
				tAgendamento = new TelaAgendamento();
				tAgendamento.getCampoNomeFuncionario().setText(funcionario.getNome());
				tAgendamento.setVisible(true);
				tAgendamento.getAgendar().addActionListener(this);
				tAgendamento.getBuscaP().addActionListener(this);
				tAgendamento.getBuscaF().addActionListener(this);
				tAgendamento.getCarregarHorarios().addActionListener(this);

				tMenu.jdPane.add(tAgendamento);
				tAgendaIsAtivo = true;
				tAgendamento.moveToFront();

			}

			if (e.getSource() == tMenu.getJmAgBus()) {
				tba = new TelaBuscaAgendamentos();
				tba.setVisible(true);
				tMenu.jdPane.add(tba);

				tba.getBuscar().addActionListener(this);
				tbaIsAtivo = true;
				tba.moveToFront();
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

				if (e.getSource() == tFuncionario.getCampoEstado()) {
					funcionario.addCidades(tFuncionario.getCampoEstado().getSelectedIndex(),
							tFuncionario.getCampoCidade());
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

				if (e.getSource() == tPaciente.getCampoEstado()) {
					funcionario.addCidades(tPaciente.getCampoEstado().getSelectedIndex(), tPaciente.getCampoCidade());
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
					TelaInfoPaciente t = new TelaInfoPaciente();
					t.setVisible(true);
					tMenu.getJdPane().add(t);
					t.moveToFront();
					funcionario.preencherTabelaAgendamentos(t.getTabela(), tBPaciente.getCampoCpf().getText());
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

			if (tbaIsAtivo) {
				if (e.getSource() == tba.getBuscar()) {
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					
					try {
						java.util.Date data = df.parse(tba.getCampoData().getText());
						funcionario.preencherTabelaAgendamentosPorData(tba.getTabela(), new Date(data.getTime()) );
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					

				}
			}

			if (tProntIsAtivo) {

				if (e.getSource() == tProntuario.getPesquisar()) {
					funcionario.buscarProntuarioPorCpf(tProntuario.getComboData(), tProntuario.getCampoCpf());
				}

				if (e.getSource() == tProntuario.getComboData()) {

					if (tProntuario.getComboData().getSelectedIndex() > 0) {
						funcionario.preencherComboHorario(tProntuario.getComboHorario(),
								tProntuario.getComboData().getSelectedItem().toString(),
								tProntuario.getComboData().getSelectedIndex());
					}
				}

				if (e.getSource() == tProntuario.getComboHorario()) {
					if (tProntuario.getComboHorario().getSelectedIndex() > 0) {
						funcionario.inserirProntuario(tProntuario.getCampoTextArea(),
								tProntuario.getComboData().getSelectedItem().toString(),
								tProntuario.getComboHorario().getSelectedItem().toString(),
								tProntuario.getCampoCpf().getText());
					}
				}

				if (e.getSource() == tProntuario.getEditarButton()) {
					tProntuario.getCampoTextArea().setEditable(true);
				}

				if (e.getSource() == tProntuario.getSalvarButton()) {
					funcionario.editarProtuario(tProntuario.getCampoTextArea().getText(),
							tProntuario.getComboData().getSelectedItem().toString(),
							tProntuario.getComboHorario().getSelectedItem().toString(),
							tProntuario.getCampoCpf().getText());
				}

				if (e.getSource() == tProntuario.getSairButton()) {
					tProntuario.dispose();
				}

				if (e.getSource() == tProntuario.getSalvarButton()) {

				}
			}

			if (tAgendaIsAtivo) {

				if (e.getSource() == tAgendamento.getDataCalendario().getCalendarButton()) {

				}

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
							
							if (funcionario.pacienteBuscado(tBPaciente.getTabela(),
									tBPaciente.getCampoCpf().getText())) {
								if (funcionario.pacienteSelecionado(tBPaciente.getTabela())) {
									tAgendamento.getCampoNomePaciente()
									.setText((String) tBPaciente.getTabela().getValueAt(0, 0));
									tAgendamento.setCpfPaciente((String) tBPaciente.getTabela().getValueAt(0, 1));
									tAgendamento.setVisible(true);
									tBPaciente.setVisible(false);
								} else {
									JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Busca não realizada");
							}
							
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

							funcionario.pesquisarPaciente(tBPaciente.getCampoCpf().getText(), tBPaciente.getTabela());

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

							if (funcionario.funcionarioBuscado(tBFuncionario.getTabela(),
									tBFuncionario.getCampoCpf().getText())) {
								if (funcionario.funcionarioSelecionado(tBFuncionario.getTabela())) {
									tAgendamento.getCampoNomeFuncionario()
											.setText((String) tBFuncionario.getTabela().getValueAt(0, 0));
									tAgendamento.setVisible(true);
									tBFuncionario.dispose();
								} else {
									JOptionPane.showMessageDialog(null, "Nenhum funcionário selecionado");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Busca não realizada");
							}
							
						}
					});

					tBFuncionario.getPesquisar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							funcionario.pesquisarFuncionario(tBFuncionario.getCampoCpf().getText(),
									tBFuncionario.getTabela());

						}
					});

				}

				if (e.getSource() == tAgendamento.getCarregarHorarios()
						&& tAgendamento.getDataCalendario().getDate() != null) {

					funcionario.carregarComboBox(new Date(tAgendamento.getDataCalendario().getDate().getTime()),
							tAgendamento.getItensHorario(), tAgendamento.getHoras());

				}

				if (e.getSource() == tAgendamento.getAgendar()) {

					if (!tAgendamento.campoVazio()) {

						funcionario.agendarConsulta(tAgendamento.getCpfPaciente(), funcionario.getCpf(), new java.sql.Date(tAgendamento.getDataCalendario().getDate().getTime()), tAgendamento.getItensHorario().getSelectedItem().toString());
						tAgendamento.getDataCalendario().setDate(null);
						tAgendamento.getItensHorario().removeAllItems();

					}

					else {
						JOptionPane.showMessageDialog(null, "Campo não preenchido");
					}

				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void keyPressed(KeyEvent e) {
		if (tlog) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				App.validarLogin(tl.getCampoLogin().getText(), tl.getCampoSenha().getText(), tl, tlog);

			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
