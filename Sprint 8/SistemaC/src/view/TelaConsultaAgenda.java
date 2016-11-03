package view;



import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import app.App;
import model.Agenda;


public class TelaConsultaAgenda extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTable tabela;
	private JScrollPane barraRolagem;
	
	
	public TelaConsultaAgenda() {
		
		preencherCabecalhoTabela();
		setSize(800,600);
		add(barraRolagem);
		setVisible(true);
		
	}
	
	
	public void preencherCabecalhoTabela() {
		
		String [] colunas = {"Nome", "Horario", "Data", "Funcionario"};
		
		Object [][] dados = new Object[App.agendamento.size()][4];
		int i=0;
		for(Agenda agd:App.agendamento){
			
			dados[i][0]=agd.getNomePaciente();
			dados[i][1] = agd.getHorario();  
			dados[i][2]=agd.getDataConsulta();
			dados[i][3]= agd.getNomeFuncionario();
			i++;
		}
				
		tabela = new JTable(dados, colunas){
			
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
			
		};

		barraRolagem = new JScrollPane(barraRolagem);
		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		barraRolagem.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(10, 40, 575, 280);
	}

	public JTable getTabela() {
		return tabela;
	}


	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}


	public JScrollPane getBarraRolagem() {
		return barraRolagem;
	}


	public void setBarraRolagem(JScrollPane barraRolagem) {
		this.barraRolagem = barraRolagem;
	}

}
