package control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import app.App;
import model.Agenda;
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
			
			if(e.getSource() == tAgendamento.getAgendar()){
				
				if(!tAgendamento.campoVazio()){								
					
					if(tAgendamento.verificarCadastro()){
						
						if(tAgendamento.horarioDisponivel()){
							
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							
							App.agendamento.add(new Agenda(df.format(tAgendamento.getDataCalendario().getDate()), tAgendamento.getCampoNome().getText(), tAgendamento.getCampoCpf().getText(), tAgendamento.getItensHorario().getSelectedItem().toString()));
							JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso");
							
							
							
							System.out.println(tAgendamento.getItensHorario().getSelectedItem().toString());
							System.out.println(df.format(tAgendamento.getDataCalendario().getDate()));
						}
						
						else{
							JOptionPane.showMessageDialog(null, "Hor�rio indispon�vel");
						}
						
						
					}
					
					else{
						JOptionPane.showMessageDialog(null, "Paciente n�o cadastrado");
					}
					
					
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Campo n�o preenchido");
				}
				
				
			}
		}
		
		
		if(e.getSource() == tMenu.getSairButton()){
			System.exit(0);
		}
		
	}


}
