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
import view.TelaMenuAtendente;
import view.TelaMenuMedico;
import view.TelaProntuario;

public class Controller implements ActionListener, KeyListener {
	
	private TelaCadastroPaciente tPaciente;
	private TelaCadastroFuncionario tFuncionario;
	private TelaBuscaPaciente tBPaciente;
	private TelaAgendamento tAgendamento;
	private TelaBuscaFuncionario tBFuncionario;
	private TelaProntuario tProntuario;
	private TelaBuscaAgendamentos tba;
	private TelaLogin tl;
	private TelaMenuAtendente tMenuAtendente;
	private TelaMenuMedico tMenuMedico;
	private Funcionario funcionario;
	private boolean tfIsAtivo, tpIsAtivo, tbpIsAtivo, tbfIsAtivo, tAgendaIsAtivo, tProntIsAtivo, tlog, tbaIsAtivo, menuAtendente, menuMedico;
	

	public Controller(TelaMenuAtendente tMenuAtendente, Funcionario f) {
		
		this.tMenuAtendente = tMenuAtendente;
		this.funcionario = f;
		menuAtendente = true;
		funcionario.buscarAgendamentosPorData(tMenuAtendente.getTabela());
	}
	
	public Controller(TelaMenuMedico tMenuMedico, Funcionario f) {
		
		this.tMenuMedico = tMenuMedico;
		this.funcionario = f;		
		menuMedico = true;
		funcionario.buscarAgendamentosPorMedico(tMenuMedico.getTabela());
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
			if(menuAtendente){
				
				if (e.getSource() == tMenuAtendente.getJmSair()){
					tMenuAtendente.dispose();
					tl = new TelaLogin();
					new Controller(tl);
				}
				
				if (e.getSource() == tMenuAtendente.getJmCadCliente()) {
					tPaciente = new TelaCadastroPaciente();
					funcionario.addEstados(tPaciente.getCampoEstado());
					tPaciente.setVisible(true);
					tPaciente.getCadastrar().addActionListener(this);
					tPaciente.getCampoEstado().addActionListener(this);
					tMenuAtendente.jdPane.add(tPaciente);
					tpIsAtivo = true;
					tPaciente.moveToFront();
				}

				if (e.getSource() == tMenuAtendente.getJmCadFuncionario()) {
					tFuncionario = new TelaCadastroFuncionario();
					funcionario.addEstados(tFuncionario.getCampoEstado());
					tFuncionario.setVisible(true);
					tFuncionario.getCadastrar().addActionListener(this);
					tFuncionario.getCampoEstado().addActionListener(this);
					tMenuAtendente.jdPane.add(tFuncionario);
					tfIsAtivo = true;
					tFuncionario.moveToFront();
				}

				
				if (e.getSource() == tMenuAtendente.getJmAgendarConsulta()) {
					tAgendamento = new TelaAgendamento();
					
					funcionario.carregarMedicosDisponiveis(tAgendamento.getCampoNomeMedicos());
					tAgendamento.setVisible(true);
					tAgendamento.getAgendar().addActionListener(this);
					tAgendamento.getBuscaP().addActionListener(this);
					tAgendamento.getCarregarHorarios().addActionListener(this);

					tMenuAtendente.jdPane.add(tAgendamento);
					tAgendaIsAtivo = true;
					tAgendamento.moveToFront();

				}

				if (e.getSource() == tMenuAtendente.getJmAgBus()) {
					tba = new TelaBuscaAgendamentos();
					tba.setVisible(true);
					tMenuAtendente.jdPane.add(tba);

					tba.getBuscar().addActionListener(this);
					tbaIsAtivo = true;
					tba.moveToFront();
				}

				if (tfIsAtivo) {

					if (e.getSource() == tFuncionario.getCadastrar() && tFuncionario.getCampoCidade().getSelectedItem() != null && (tFuncionario.getAtendente().isSelected() || tFuncionario.getMedico().isSelected())) {

						
						if(tFuncionario.getAtendente().isSelected()){
							funcionario.cadastrarFuncionario(tFuncionario.getCampoNome().getText(),
									tFuncionario.getCampoRg().getText(), tFuncionario.getCampoCpf().getText(),
									tFuncionario.getCampoTelefone().getText(), tFuncionario.getCampoLogin().getText(),
									tFuncionario.getCampoSenha().getText(),
									tFuncionario.getCampoEstado().getSelectedItem().toString(),
									tFuncionario.getCampoCidade().getSelectedItem().toString(),
									tFuncionario.getCampoRua().getText(), tFuncionario.getCampoBairro().getText(),
									tFuncionario.getCampoNumero().getText(), 2);
						}else{
							funcionario.cadastrarFuncionario(tFuncionario.getCampoNome().getText(),
									tFuncionario.getCampoRg().getText(), tFuncionario.getCampoCpf().getText(),
									tFuncionario.getCampoTelefone().getText(), tFuncionario.getCampoLogin().getText(),
									tFuncionario.getCampoSenha().getText(),
									tFuncionario.getCampoEstado().getSelectedItem().toString(),
									tFuncionario.getCampoCidade().getSelectedItem().toString(),
									tFuncionario.getCampoRua().getText(), tFuncionario.getCampoBairro().getText(),
									tFuncionario.getCampoNumero().getText(), 1);
						}
						
						
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

				
				if (tAgendaIsAtivo) {

					if (e.getSource() == tAgendamento.getBuscaP()) {

						tBPaciente = new TelaBuscaPaciente();
						tBPaciente.setVisible(true);
						tBPaciente.getPesquisar().addActionListener(this);
						tMenuAtendente.jdPane.add(tBPaciente);
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


					if (e.getSource() == tAgendamento.getCarregarHorarios()
							&& tAgendamento.getDataCalendario().getDate() != null) {

						funcionario.carregarComboBox(new Date(tAgendamento.getDataCalendario().getDate().getTime()),
								tAgendamento.getItensHorario(), tAgendamento.getHoras(), tAgendamento.getCampoNomeMedicos().getSelectedItem().toString());

					}

					if (e.getSource() == tAgendamento.getAgendar()) {

						if (!tAgendamento.campoVazio()) {
							funcionario.agendarConsulta(tAgendamento.getCampoNomePaciente().getText(), tAgendamento.getCampoNomeMedicos().getSelectedItem().toString(),
									new java.sql.Date(tAgendamento.getDataCalendario().getDate().getTime()),
									tAgendamento.getItensHorario().getSelectedItem().toString());
							tAgendamento.getDataCalendario().setDate(null);
							tAgendamento.getItensHorario().removeAllItems();
							tMenuAtendente.limparTabela();
							funcionario.buscarAgendamentosPorData(tMenuAtendente.getTabela());

						}

						else {
							JOptionPane.showMessageDialog(null, "Campo não preenchido");
						}

					}
				}
			}
		
			if(menuMedico){
				
				if (e.getSource() == tMenuMedico.getJmSair()){
					tMenuMedico.dispose();
					tl = new TelaLogin();
					new Controller(tl);
				}
				
				if (e.getSource() == tMenuMedico.getJmBuscProntuario()) {
					tProntuario = new TelaProntuario();
					tProntuario.getSairButton().addActionListener(this);
					tProntuario.getSalvarButton().addActionListener(this);
					tProntuario.getEditarButton().addActionListener(this);
					tProntuario.getPesquisar().addActionListener(this);
					tProntuario.getComboData().addActionListener(this);
					tProntuario.getComboHorario().addActionListener(this);
					tMenuMedico.jdPane.add(tProntuario);
					tProntIsAtivo = true;
					tProntuario.moveToFront();
				}

				
				if (e.getSource() == tMenuMedico.getJmAgBus()) {
					tba = new TelaBuscaAgendamentos();
					tba.setVisible(true);
					tMenuMedico.jdPane.add(tba);

					tba.getBuscar().addActionListener(this);
					tbaIsAtivo = true;
					tba.moveToFront();
				}
				
				if (e.getSource() == tMenuMedico.getJmBuscPaciente()) {
					tBPaciente = new TelaBuscaPaciente();
					tBPaciente.setVisible(true);
					
					tBPaciente.getAbrir().addActionListener(this);
					tBPaciente.getPesquisar().addActionListener(this);
					
					tMenuMedico.jdPane.add(tBPaciente);
					tbpIsAtivo = true;
					tBPaciente.moveToFront();
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
						tMenuMedico.getJdPane().add(t);
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
							funcionario.preencherTabelaAgendamentosPorData(tba.getTabela(), new Date(data.getTime()));
						} catch (ParseException e1) {
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
									tProntuario.getCampoCpf().getText());
						}
					}

					if (e.getSource() == tProntuario.getComboHorario()) {
						if (tProntuario.getComboHorario().getSelectedIndex() > 0) {
							funcionario.exibirProntuario(tProntuario.getCampoTextArea(),
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

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
