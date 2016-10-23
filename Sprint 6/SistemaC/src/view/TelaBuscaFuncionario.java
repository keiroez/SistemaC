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

public class TelaBuscaFuncionario extends Tela {

	private static final long serialVersionUID = 1L;
	private JLabel cpf;
	private JTextField campoCpf;
	private JButton pesquisar, remover;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private MaskFormatter m1;

	public TelaBuscaFuncionario() {

		setTitle("Busca de Funcionário");

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
		remover.setBounds(250, 330, 100, 20);
		add(remover);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public boolean funcionarioBuscado() {

		for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
			if (tabela.getValueAt(j, 1).equals(campoCpf.getText())) {
				return true;
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
	
	
	public boolean funcionarioIsCadastrado(){
		
		for (int i = 0; i < App.funcionarios.size(); i++) {
			if (campoCpf.getText().equals(App.funcionarios.get(i).getCpf())) {
				return true;
			}
		}		
		return false;
	}
	
	public void pesquisarFuncionario(){
		
		if(!campoCpf.getText().equals("   .   .   -  ")){
			
			if(funcionarioIsCadastrado()){
				for (int i = 0; i < App.funcionarios.size(); i++) {
					if (campoCpf.getText().equals(App.funcionarios.get(i).getCpf())) {

						if (funcionarioBuscado()){
							JOptionPane.showMessageDialog(null, "Busca já foi realizada");
						} else {
							
							for (int j = 0; j < tabela.getModel().getRowCount(); j++) {
								DefaultTableModel df = (DefaultTableModel) tabela.getModel();
								df.removeRow(j);
							}
							
							String[] dados = new String[] { App.funcionarios.get(i).getNome(),
							App.funcionarios.get(i).getCpf(), App.funcionarios.get(i).getTelefone() };
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
				JOptionPane.showMessageDialog(null, "Funcionario não encontrado");	
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
	
	
	public boolean funcionarioSelecionado(){
		for(int i = 0; i < tabela.getRowCount(); i++){
			if(tabela.isRowSelected(i)){
				return true;
			}
		}
		
		return false;
	}
	
	
	public void removerFuncionario(){
		
		if(funcionarioSelecionado()){
			
			for (int i = 0; i < App.funcionarios.size(); i++) {
				if (App.funcionarios.get(i).getCpf().equals(tabela.getValueAt(0, 1))) {
					App.funcionarios.remove(i);
					DefaultTableModel df = (DefaultTableModel) tabela.getModel();
					df.removeRow(tabela.getSelectedRow());
					break;
				}
			}			
		}
		else{
			JOptionPane.showMessageDialog(null, "Nenhum funcionario selecionado");
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

}
