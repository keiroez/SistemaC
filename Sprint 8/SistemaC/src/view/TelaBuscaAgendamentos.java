package view;

import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;


public class TelaBuscaAgendamentos extends TelaInternal {

	private static final long serialVersionUID = 1L;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JTextField campoData;
	private JLabel dataLabel;
	private JButton buscar;
	private MaskFormatter m1;
	
	public TelaBuscaAgendamentos() {
		super("Busca de Agendamentos");
		
		try {
			m1 = new MaskFormatter("##/##/####");

		} catch (ParseException e) {

			e.printStackTrace();
		}

		dataLabel = new JLabel("Data: ");
		campoData = new JFormattedTextField(m1);
		buscar = new JButton("Buscar");

		dataLabel.setBounds(90, 20, 60, 20);
		campoData.setBounds(160, 20, 100, 20);
		buscar.setBounds(270, 20, 100, 20);
		add(dataLabel);
		add(campoData);
		add(buscar);

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

		}, new String[] { "Paciente", "Horário", "Data", "Funcionário"}));
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

	public JTextField getCampoData() {
		return campoData;
	}

	public void setCampoData(JTextField campoData) {
		this.campoData = campoData;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}
	
	
	
	

}
