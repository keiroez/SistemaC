package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import app.App;
import model.Paciente;

public class TelaBuscaPaciente extends Tela {

	private static final long serialVersionUID = 1L;
	private JLabel cpf;
	private JTextField campoCpf;
	private JButton pesquisar, remover, abrir;
	private MaskFormatter m1;
	private JTable tabela;
	private JScrollPane barraRolagem;

	public TelaBuscaPaciente() {

		setTitle("Busca de Paciente");

		preencherCabecalhoTabela();

		try {
			m1 = new MaskFormatter("###.###.###-##");

		} catch (ParseException e) {

			e.printStackTrace();
		}

		cpf = new JLabel("CPF: ");
		campoCpf = new JFormattedTextField(m1);

		pesquisar = new JButton("Pesquisar");
		remover = new JButton("Remover");
		abrir = new JButton("Abrir");

		Container c = new Container();
		c.setLayout(new GridLayout(1, 2));
		c.setSize(400, 20);
		c.setLocation(10, 10);
		c.add(cpf);
		c.add(campoCpf);

		add(barraRolagem);

		add(c);
		pesquisar.setBounds(450, 10, 100, 20);
		add(pesquisar);
		remover.setBounds(170, 330, 100, 20);
		add(remover);
		abrir.setBounds(300, 330, 100, 20);
		add(abrir);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	public boolean pacienteBuscado() {

		for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
			
			for(Paciente p: App.pacientes){
				if (tabela.getValueAt(j, 1).equals(p.getCpf())) {
					return true;
				}
			}
			
		}

		return false;

	}

	public void preencherCabecalhoTabela() {

		tabela = new JTable();
		tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Nome", "CPF", "Telefone" }));

		barraRolagem = new JScrollPane(barraRolagem);
		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		barraRolagem.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(10, 40, 575, 280);
	}
	
	public boolean pacienteIsCadastrado(){
		
		for (int i = 0; i < App.pacientes.size(); i++) {
			if (campoCpf.getText().equals(App.pacientes.get(i).getCpf())) {
				return true;
			}
		}
		
		return false;
	}
	
	public void pesquisarPaciente(){
		
		if(!campoCpf.getText().equals("   .   .   -  ")){
			
			if(pacienteIsCadastrado()){
				for (int i = 0; i < App.pacientes.size(); i++) {
					if (campoCpf.getText().equals(App.pacientes.get(i).getCpf())) {

						if (pacienteBuscado()){
							JOptionPane.showMessageDialog(null, "Busca já foi realizada");
						} else {
							
							for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
								DefaultTableModel df = (DefaultTableModel) tabela.getModel();
								df.removeRow(j);
							}
							
							String[] dados = new String[] { App.pacientes.get(i).getNome(),
							App.pacientes.get(i).getCpf(), App.pacientes.get(i).getTelefone() };
							DefaultTableModel df = (DefaultTableModel) tabela.getModel();
							df.addRow(dados);
							campoCpf.setText("");
							break;
						}					
					}			
				}
			}else{
				for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.removeRow(j);
				}				
				JOptionPane.showMessageDialog(null, "Paciente não encontrado");	
				campoCpf.setText("");			
			}			
		}
			
		else{
			for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
				DefaultTableModel df = (DefaultTableModel) tabela.getModel();
				df.removeRow(j);
			}
			
			JOptionPane.showMessageDialog(null, "Campo cpf não preenchido");
		}
		
	}
	
	public boolean pacienteSelecionado(){
		for(int i = 0; i < tabela.getRowCount(); i++){
			if(tabela.isRowSelected(i)){
				return true;
			}
		}
		
		return false;
	}
	
	public void removerPaciente(){
		
		if(pacienteSelecionado()){
			
			for (int i = 0; i < App.pacientes.size(); i++) {
				if (App.pacientes.get(i).getCpf().equals(tabela.getValueAt(0, 1))) {
					String nome = App.pacientes.get(i).getNome();
					App.pacientes.remove(i);
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.removeRow(tabela.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Paciente "+nome+" removido com sucesso");
					break;
				}
			}
			
			
		}
		else{
			JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado");
		}
		
		
	}



	public JLabel getCpf() {
		return cpf;
	}

	public void setCpf(JLabel cpf) {
		this.cpf = cpf;
	}

	public JTextField getCampoCpf() {
		return campoCpf;
	}

	public void setCampoCpf(JTextField campoCpf) {
		this.campoCpf = campoCpf;
	}

	public JButton getPesquisar() {
		return pesquisar;
	}

	public void setPesquisar(JButton pesquisar) {
		this.pesquisar = pesquisar;
	}

	public MaskFormatter getM1() {
		return m1;
	}

	public void setM1(MaskFormatter m1) {
		this.m1 = m1;
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

	public JButton getRemover() {
		return remover;
	}

	public void setRemover(JButton remover) {
		this.remover = remover;
	}

	public JButton getAbrir() {
		return abrir;
	}

	public void setAbrir(JButton abrir) {
		this.abrir = abrir;
	}

}
