package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import app.App;
import model.Paciente;
import model.Prontuario;

public class TelaCadastroPaciente extends Tela {

	private static final long serialVersionUID = 1L;
	private JLabel nome, rg, cpf, telefone;
	private JTextField campoNome, campoCpf, campoRg, campoTelefone;
	private JButton cadastrar;
	private MaskFormatter m1, m2;

	public TelaCadastroPaciente() {

		setTitle("Cadastro de Paciente");

		try {
			m1 = new MaskFormatter("###.###.###-##");
			m2 = new MaskFormatter("(###) ##### - ####");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		nome = new JLabel("Nome: ");
		rg = new JLabel("RG: ");
		cpf = new JLabel("CPF: ");
		telefone = new JLabel("Telefone: ");

		campoNome = new JTextField(20);
		campoRg = new JTextField(20);
		campoCpf = new JFormattedTextField(m1);
		campoTelefone = new JFormattedTextField(m2);

		cadastrar = new JButton("Cadastrar");

		Container c = new Container();
		c.setLayout(new GridLayout(4, 2));
		c.setSize(400, 100);
		c.setLocation(100, 100);
		c.add(nome);
		c.add(campoNome);
		c.add(rg);
		c.add(campoRg);
		c.add(cpf);
		c.add(campoCpf);
		c.add(telefone);
		c.add(campoTelefone);

		add(c);
		cadastrar.setBounds(250, 300, 100, 20);
		add(cadastrar);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	public void cadastrarPaciente(String nome, String rg, String cpf, String telefone, Prontuario prontuario) {

		if (cpf.equals("") || nome.equals("") || rg.equals("") || telefone.equals("")) {

			JOptionPane.showMessageDialog(null, "Campo não preenchido");
		}

		else {

			boolean cpfIsCadastrado = false, rgIsCadastrado = false;

			for (int i = 0; i < App.pacientes.size(); i++) {
				if (App.pacientes.get(i).getCpf().equals(cpf)) {
					JOptionPane.showMessageDialog(null, "CPF já cadastrado");
					cpfIsCadastrado = true;
				}

				if (App.pacientes.get(i).getRg().equals(rg)) {
					JOptionPane.showMessageDialog(null, "RG já cadastrado");
					rgIsCadastrado = true;
				}
			}

			if (!cpfIsCadastrado && !rgIsCadastrado) {
				App.pacientes.add(new Paciente(nome, rg, cpf, telefone, prontuario));
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
			}
		}
	}

	public JLabel getNome() {
		return nome;
	}

	public void setNome(JLabel nome) {
		this.nome = nome;
	}

	public JLabel getRg() {
		return rg;
	}

	public void setRg(JLabel rg) {
		this.rg = rg;
	}

	public JLabel getCpf() {
		return cpf;
	}

	public void setCpf(JLabel cpf) {
		this.cpf = cpf;
	}

	public JLabel getTelefone() {
		return telefone;
	}

	public void setTelefone(JLabel telefone) {
		this.telefone = telefone;
	}

	public JTextField getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(JTextField campoNome) {
		this.campoNome = campoNome;
	}

	public JTextField getCampoCpf() {
		return campoCpf;
	}

	public void setCampoCpf(JTextField campoCpf) {
		this.campoCpf = campoCpf;
	}

	public JTextField getCampoRg() {
		return campoRg;
	}

	public void setCampoRg(JTextField campoRg) {
		this.campoRg = campoRg;
	}

	public JTextField getCampoTelefone() {
		return campoTelefone;
	}

	public void setCampoTelefone(JTextField campoTelefone) {
		this.campoTelefone = campoTelefone;
	}

	public JButton getCadastrar() {
		return cadastrar;
	}

	public void setCadastrar(JButton cadastrar) {
		this.cadastrar = cadastrar;
	}

}
