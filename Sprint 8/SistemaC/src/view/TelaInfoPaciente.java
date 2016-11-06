package view;


import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

public class TelaInfoPaciente extends TelaInternal {

	private static final long serialVersionUID = 1L;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JLabel agendamentos;
	
	
	public TelaInfoPaciente() {
		super("Dados do paciente");
		
		agendamentos = new JLabel("Consultas agendadas:");
		agendamentos.setBounds(10, 30, 200, 20);
		add(agendamentos);
		
		preencherCabecalhoTabela();
		add(barraRolagem);

	}

	public void preencherCabecalhoTabela() {

		tabela = new JTable() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Nome", "Horário", "Data", "Funcionário"}));
		barraRolagem = new JScrollPane(barraRolagem);
		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		barraRolagem.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(10, 70, 575, 280);
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JLabel getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(JLabel agendamentos) {
		this.agendamentos = agendamentos;
	}

	

	
}
