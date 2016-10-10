package control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.App;
import model.Paciente;
import model.Prontuario;
import view.TelaCadastroPaciente;

public class Controller implements ActionListener{

	private TelaCadastroPaciente tPaciente;
	
	
	
	
	
	public Controller(TelaCadastroPaciente tPaciente) {
		
		this.tPaciente = tPaciente;
		this.tPaciente.getCadastrar().addActionListener(this);
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == tPaciente.getCadastrar()){
			
			
			if(tPaciente.getCampoCpf().getText().equals("") || tPaciente.getCampoNome().getText().equals("") || tPaciente.getCampoRg().getText().equals("") || tPaciente.getCampoTelefone().getText().equals("")){
				
				JOptionPane.showMessageDialog(null, "Campo não preenchido");
			}
			
			else{
				
				App.pacientes.add(new Paciente(tPaciente.getCampoNome().getText(), tPaciente.getCampoRg().getText(), tPaciente.getCampoCpf().getText(), tPaciente.getCampoTelefone().getText(), new Prontuario("")));
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
			}
			
			
			
		}
		
	}

}
