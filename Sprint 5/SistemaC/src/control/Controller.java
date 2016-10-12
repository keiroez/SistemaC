package control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

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

public class Controller implements ActionListener, MouseListener{

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
			//tBPaciente.getPesquisar().addActionListener(this);
			tbpIsAtivo = true;			
		}
		
		if(e.getSource() == tMenu.getBuscaFuncButton()){
			
			tBFuncionario = new TelaBuscaFuncionario();
			//tBFuncionario.getPesquisar().addActionListener(this);
			tbfIsAtivo = true;			
		}
		
		if(e.getSource() == tMenu.getAgendaButton()){
			
			tAgendamento = new TelaAgendamento();
			tAgendamento.getAgendar().addActionListener(this);
			tAgendaIsAtivo = true;
			tAgendamento.getCalendario().getOk().addActionListener(this);
			tAgendamento.getCalendario().getCampoData().addMouseListener(this);
		}
		
		
		
		
		if(tfIsAtivo){
			
			if(e.getSource() == tFuncionario.getCadastrar()){
				
				tFuncionario.cadastrarFuncionario(tFuncionario.getCampoNome().getText(), tFuncionario.getCampoRg().getText(), tFuncionario.getCampoCpf().getText(), tFuncionario.getCampoTelefone().getText(), tFuncionario.getCampoLogin().getText(), tFuncionario.getCampoSenha().getText());
			}			
		}
		
		if(tpIsAtivo){
			
			if(e.getSource() == tPaciente.getCadastrar()){
				
				tPaciente.cadastrarPaciente(tPaciente.getCampoNome().getText(), tPaciente.getCampoRg().getText(), tPaciente.getCampoCpf().getText(), tPaciente.getCampoTelefone().getText(), new Prontuario(""));

			}		
		}
		
		if(tbpIsAtivo){
			if(e.getSource() == tBPaciente.getPesquisar()){
				
				for(int i = 0; i < App.pacientes.size(); i++){
					if(tBPaciente.getCampoCpf().getText().equals(App.pacientes.get(i))){
					}
				}

			}
		}
		
		
		if(tAgendaIsAtivo){
			
			if(e.getSource() == tAgendamento.getCalendario().getOk()){
				SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy"); //DEFINE FORMATO DE DATA  
			    String data = formato.format(tAgendamento.getCalendario().getCalendario().getDate());
			    tAgendamento.getCalendario().setCampoData(data);

				tAgendamento.getCalendario().getOk().setVisible(false);
				tAgendamento.getCalendario().getCalendario().setVisible(false);
			}	
			
			
			if(e.getSource() == tAgendamento.getAgendar()){
				
				if(!tAgendamento.campoVazio()){								
					
					if(tAgendamento.verificarCadastro()){
						
						if(tAgendamento.horarioDisponivel()){
							
							App.agendamento.add(new Agenda(tAgendamento.getCampoData().getText(), tAgendamento.getCampoNome().getText(), tAgendamento.getCampoCpf().getText(), tAgendamento.getCampoHorario().getText()));
							JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso");
						}
						
						else{
							JOptionPane.showMessageDialog(null, "Horário indisponível");
						}
						
						
					}
					
					else{
						JOptionPane.showMessageDialog(null, "Paciente não cadastrado");
					}
					
					
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


	@Override
	public void mouseClicked(MouseEvent e) {
		tAgendamento.getCalendario().getOk().setVisible(true);
		tAgendamento.getCalendario().getCalendario().setVisible(true);
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
