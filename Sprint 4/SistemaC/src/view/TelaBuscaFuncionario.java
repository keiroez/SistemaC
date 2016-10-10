package view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaBuscaFuncionario extends Tela {
	
	
	private static final long serialVersionUID = 1L;
	private JLabel cpf;
	private JTextField campoCpf;
	private JButton pesquisar;

	public TelaBuscaFuncionario() {

		setTitle("Busca de Funcionário");

		cpf = new JLabel("CPF: ");
		campoCpf = new JTextField(20);

		pesquisar = new JButton("Pesquisar");

		Container c = new Container();
		c.setLayout(new GridLayout(1, 2));
		c.setSize(400, 20);
		c.setLocation(100, 150);
		c.add(cpf);
		c.add(campoCpf);

		add(c);
		pesquisar.setBounds(250, 300, 100, 20);
		add(pesquisar);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

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
	
	

}
