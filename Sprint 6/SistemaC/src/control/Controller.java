package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import app.App;
import model.Agenda;
import model.Prontuario;
import view.TelaAgendamento;
import view.TelaBuscaFuncionario;
import view.TelaBuscaPaciente;
import view.TelaCadastroFuncionario;
import view.TelaCadastroPaciente;
import view.TelaMenu;
import view.TelaProntuario;

public class Controller implements ActionListener {

	private TelaCadastroPaciente tPaciente;
	private TelaCadastroFuncionario tFuncionario;
	private TelaBuscaPaciente tBPaciente;
	private TelaAgendamento tAgendamento;
	private TelaBuscaFuncionario tBFuncionario;
	private TelaMenu tMenu;
	private boolean tfIsAtivo, tpIsAtivo, tbpIsAtivo, tbfIsAtivo, tAgendaIsAtivo;

	public Controller(TelaMenu tMenu) {
		this.tMenu = tMenu;

		this.tMenu.getCadFuncButton().addActionListener(this);
		this.tMenu.getCadPacButton().addActionListener(this);
		this.tMenu.getBuscaPacButton().addActionListener(this);
		this.tMenu.getBuscaFuncButton().addActionListener(this);
		this.tMenu.getAgendaButton().addActionListener(this);
		this.tMenu.getSairButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == tMenu.getCadFuncButton()) {

			tFuncionario = new TelaCadastroFuncionario();
			tFuncionario.getCadastrar().addActionListener(this);
			tfIsAtivo = true;
		}

		if (e.getSource() == tMenu.getCadPacButton()) {

			tPaciente = new TelaCadastroPaciente();
			tPaciente.getCadastrar().addActionListener(this);
			tpIsAtivo = true;
		}

		if (e.getSource() == tMenu.getBuscaPacButton()) {

			tBPaciente = new TelaBuscaPaciente();
			tBPaciente.getPesquisar().addActionListener(this);
			tBPaciente.getRemover().addActionListener(this);
			tBPaciente.getAbrir().addActionListener(this);
			tbpIsAtivo = true;
		}

		if (e.getSource() == tMenu.getBuscaFuncButton()) {

			tBFuncionario = new TelaBuscaFuncionario();
			tBFuncionario.getPesquisar().addActionListener(this);
			tbfIsAtivo = true;
		}

		if (e.getSource() == tMenu.getAgendaButton()) {

			tAgendamento = new TelaAgendamento();
			tAgendamento.getAgendar().addActionListener(this);
			tAgendamento.getBuscaP().addActionListener(this);
			tAgendamento.getBuscaF().addActionListener(this);
			tAgendaIsAtivo = true;

		}

		if (tfIsAtivo) {

			if (e.getSource() == tFuncionario.getCadastrar()) {

				tFuncionario.cadastrarFuncionario(tFuncionario.getCampoNome().getText(),
						tFuncionario.getCampoRg().getText(), tFuncionario.getCampoCpf().getText(),
						tFuncionario.getCampoTelefone().getText(), tFuncionario.getCampoLogin().getText(),
						tFuncionario.getCampoSenha().getText());
			}
		}

		if (tpIsAtivo) {

			if (e.getSource() == tPaciente.getCadastrar()) {

				tPaciente.cadastrarPaciente(tPaciente.getCampoNome().getText(), tPaciente.getCampoRg().getText(),
						tPaciente.getCampoCpf().getText(), tPaciente.getCampoTelefone().getText(), new Prontuario(""));

			}
		}

		if (tbpIsAtivo) {
			if (e.getSource() == tBPaciente.getPesquisar()) {
				
				tBPaciente.pesquisarPaciente();

				
			}

			if (e.getSource() == tBPaciente.getRemover()) {

				tBPaciente.removerPaciente();

			}

			if (e.getSource() == tBPaciente.getAbrir()) {

				for (int i = 0; i < App.pacientes.size(); i++) {
					if (App.pacientes.get(i).getCpf().equals(tBPaciente.getCampoCpf().getText())) {
						TelaProntuario tp = new TelaProntuario();
						tp.preencherProntuario(App.pacientes.get(i));
						int x = i;
						tp.getSalvarButton().addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								App.pacientes.get(x).getProtuario().setHistorico(tp.getCampoTextArea().getText());

							}
						});

						tp.getSairButton().addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								tp.dispose();

							}
						});
					}
				}

			}
		}

		if (tbfIsAtivo) {
			if (e.getSource() == tBFuncionario.getPesquisar()) {
				tBFuncionario.pesquisarFuncionario();
			}
			
			if(e.getSource() == tBFuncionario.getRemover()){
				tBFuncionario.removerFuncionario();
			}
		}

		if (tAgendaIsAtivo) {
			
			if (e.getSource() == tAgendamento.getBuscaP()) {
				tBPaciente = new TelaBuscaPaciente();
				tBPaciente.getAbrir().setText("Selecionar");
				tBPaciente.getAbrir().setBounds(250, 330, 100, 20);
				tBPaciente.getRemover().setVisible(false);
				tBPaciente.getAbrir().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						tAgendamento.getCampoNomePaciente().setText((String) tBPaciente.getTabela().getValueAt(0, 0));
						tAgendamento.setCpfPaciente((String) tBPaciente.getTabela().getValueAt(0, 1));
						tBPaciente.dispose();
						
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

									if (tBPaciente.pacienteBuscado()) {

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
			
			if (e.getSource() == tAgendamento.getBuscaF()){
				
				tBFuncionario = new TelaBuscaFuncionario();
				tBFuncionario.getRemover().setText("Selecionar");
				tBFuncionario.getRemover().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						tAgendamento.getCampoNomeFuncionario().setText((String) tBFuncionario.getTabela().getValueAt(0, 0));
						tBFuncionario.dispose();
						
					}
				});
				
				tBFuncionario.getPesquisar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						for (int i = 0; i < App.funcionarios.size(); i++) {
							if (tBFuncionario.getCampoCpf().getText().equals(App.funcionarios.get(i).getCpf())) {

								if (tBFuncionario.funcionarioBuscado()) {

								} else {
									String[] dados = new String[] { App.funcionarios.get(i).getNome(),
											App.funcionarios.get(i).getCpf(), App.funcionarios.get(i).getTelefone() };
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

					

						if (tAgendamento.horarioDisponivel()) {

							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

							App.agendamento.add(new Agenda(df.format(tAgendamento.getDataCalendario().getDate()),
									tAgendamento.getCampoNomePaciente().getText(), tAgendamento.getCpfPaciente(),
									tAgendamento.getItensHorario().getSelectedItem().toString()));
							
							tAgendamento.editarProntuario("\n\n\nConsulta - Dr "+tAgendamento.getCampoNomeFuncionario().getText()+"\n\n\nData: "
									+ df.format(tAgendamento.getDataCalendario().getDate())+"\n"
											+ "Horário: "+tAgendamento.getItensHorario().getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso");

							System.out.println(tAgendamento.getItensHorario().getSelectedItem().toString());
							System.out.println(df.format(tAgendamento.getDataCalendario().getDate()));
						}

						else {
							JOptionPane.showMessageDialog(null, "Horário indisponível");
						}

					
				}

				else {
					JOptionPane.showMessageDialog(null, "Campo não preenchido");
				}

			}
		}

		if (e.getSource() == tMenu.getSairButton()) {
			System.exit(0);
		}

	}

}
