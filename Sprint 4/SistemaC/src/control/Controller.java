package control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import app.App;
import model.Agenda;
import model.Funcionario;
import model.Paciente;
import model.Prontuario;
import view.TelaAgendamento;
import view.TelaBuscaFuncionario;
import view.TelaBuscaPaciente;
import view.TelaCadastroFuncionario;
import view.TelaCadastroPaciente;
import view.TelaMenu;

public class Controller implements ActionListener{

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

		
		if(e.getSource() == tMenu.getCadFuncButton()){
			
			tFuncionario = new TelaCadastroFuncionario();	
			tFuncionario.getCadastrar().addActionListener(this);
			tfIsAtivo = true;
		}
		
		if(e.getSource() == tMenu.getCadPacButton()){
			
			tPaciente = new TelaCadastroPaciente();		
			tPaciente.getCadastrar().addActionListener(this);
			tpIsAtivo = true;
		}
		
		if(e.getSource() == tMenu.getBuscaPacButton()){
			
			tBPaciente = new TelaBuscaPaciente();
			tBPaciente.getPesquisar().addActionListener(this);
			tbpIsAtivo = true;			
		}
		
		if(e.getSource() == tMenu.getBuscaFuncButton()){
			
			tBFuncionario = new TelaBuscaFuncionario();
			tBFuncionario.getPesquisar().addActionListener(this);
			tbfIsAtivo = true;			
		}
		
		if(e.getSource() == tMenu.getAgendaButton()){
			
			tAgendamento = new TelaAgendamento();
			tAgendamento.getAgendar().addActionListener(this);
			tAgendaIsAtivo = true;			
		}
		
		
		
		
		if(tfIsAtivo){
			
			if(e.getSource() == tFuncionario.getCadastrar()){
				
				if(tFuncionario.getCampoCpf().getText().equals("") || tFuncionario.getCampoNome().getText().equals("") || tFuncionario.getCampoRg().getText().equals("") || tFuncionario.getCampoTelefone().getText().equals("") || tFuncionario.getCampoLogin().getText().equals("") || tFuncionario.getCampoSenha().getText().equals("")){
					
					JOptionPane.showMessageDialog(null, "Campo não preenchido");
				}
				
				else{
					boolean cpfCad = false, loginCad = false, rgCad = false;
					
					for(int i = 0; i < App.funcionarios.size(); i++){
						if(App.funcionarios.get(i).getCpf().equals(tFuncionario.getCampoCpf().getText())){
							JOptionPane.showMessageDialog(null, "Este CPF já está cadastrado no sistema");
							cpfCad = true;
						}
						
						if(App.funcionarios.get(i).getLogin().equals(tFuncionario.getCampoLogin().getText())){
							JOptionPane.showMessageDialog(null, "Login indisponível");
							loginCad = true;
						}
						
						if(App.funcionarios.get(i).getRg().equals(tFuncionario.getCampoRg().getText())){
							JOptionPane.showMessageDialog(null, "Este RG já está cadastrado no sistema");
							rgCad = true;
						}
					}

					if(!cpfCad && !loginCad && !rgCad){
						App.funcionarios.add(new Funcionario(tFuncionario.getCampoNome().getText(), tFuncionario.getCampoRg().getText(), tFuncionario.getCampoCpf().getText(), tFuncionario.getCampoTelefone().getText(), tFuncionario.getCampoLogin().getText(), tFuncionario.getCampoSenha().getText()));
						JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
					}
				}
			}
			
		}
		
		if(tpIsAtivo){
			
			if(e.getSource() == tPaciente.getCadastrar()){
				
				if(e.getSource() == tPaciente.getCadastrar()){
					
					
					if(tPaciente.getCampoCpf().getText().equals("") || tPaciente.getCampoNome().getText().equals("") || tPaciente.getCampoRg().getText().equals("") || tPaciente.getCampoTelefone().getText().equals("")){
						
						JOptionPane.showMessageDialog(null, "Campo não preenchido");
					}
					
					else{
						
						boolean cpfIsCadastrado = false;
						
						for(int i = 0; i < App.pacientes.size(); i++){
							if(App.pacientes.get(i).getCpf().equals(tPaciente.getCampoCpf().getText())){
								JOptionPane.showMessageDialog(null, "CPF já cadastrado");
								cpfIsCadastrado = true;
							}
						}
						
						if(!cpfIsCadastrado){
							App.pacientes.add(new Paciente(tPaciente.getCampoNome().getText(), tPaciente.getCampoRg().getText(), tPaciente.getCampoCpf().getText(), tPaciente.getCampoTelefone().getText(), new Prontuario("")));
							JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
						}
						
					}	
				}
			}
			
			
		
		}
		
		if(tbpIsAtivo){
			if(e.getSource() == tBPaciente.getPesquisar()){
				
				for(int i = 0; i < App.pacientes.size(); i++){
					if(tBPaciente.getCampoCpf().getText().equals(App.pacientes.get(i))){
						tBPaciente.getCampoTextArea().append(App.pacientes.get(i).getNome());
						
					}
				}
				tBPaciente.getScroll().setVisible(true);
			}
		}
		
		
		if(tAgendaIsAtivo){
			if(e.getSource() == tAgendamento.getAgendar()){
				
				
				if(!tAgendamento.getCampoCpf().getText().equals("") && !tAgendamento.getCampoNome().getText().equals("") && !tAgendamento.getCampoHorario().getText().equals("") && !tAgendamento.getCampoData().getText().equals("")){
								
					App.agendamento.add(new Agenda(tAgendamento.getCampoData().getText(), tAgendamento.getCampoNome().getText(), tAgendamento.getCampoCpf().getText(), tAgendamento.getCampoHorario().getText()));
					JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso");

					
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Campo não preenchido");
				}
				
				
			}
		}
		
		
		if(e.getSource() == tMenu.getSairButton()){
			System.exit(0);
		}
		
	}

}
