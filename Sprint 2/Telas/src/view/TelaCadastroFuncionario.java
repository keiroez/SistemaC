package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TelaCadastroFuncionario extends Tela {

	private static final long serialVersionUID = 1L;

	private JLabel nome, rg, cpf, telefone, login, senha;
	private JTextField campoNome, campoCpf, campoRg, campoTelefone, campoLogin, campoSenha;
	private JButton cadastrar;
	private MaskFormatter m1, m2;
	
	public TelaCadastroFuncionario() {

		setTitle("Cadastro de Funcionário");

		try {
			m1 = new MaskFormatter("###.###.###-##");
			m2 =  new MaskFormatter("(###) ##### - ####");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		nome = new JLabel("Nome: ");
		rg = new JLabel("RG: ");
		cpf = new JLabel("CPF: ");
		telefone = new JLabel("Telefone: ");
		login = new JLabel("Login: ");
		senha = new JLabel("Senha: ");

		campoNome = new JTextField(20);
		campoRg = new JTextField(20);
		campoCpf = new JFormattedTextField(m1);
		campoTelefone = new JFormattedTextField(m2);
		campoLogin = new JTextField(20);
		campoSenha = new JTextField(20);

		cadastrar = new JButton("Cadastrar");

		Container c = new Container();
		c.setLayout(new GridLayout(6, 2));
		c.setSize(400, 150);
		c.setLocation(100, 100);
		c.add(nome);
		c.add(campoNome);
		c.add(rg);
		c.add(campoRg);
		c.add(cpf);
		c.add(campoCpf);
		c.add(telefone);
		c.add(campoTelefone);
		c.add(login);
		c.add(campoLogin);
		c.add(senha);
		c.add(campoSenha);

		add(c);
		cadastrar.setBounds(250, 300, 100, 20);
		add(cadastrar);

		setVisible(true);

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

	public JLabel getLogin() {
		return login;
	}

	public void setLogin(JLabel login) {
		this.login = login;
	}

	public JLabel getSenha() {
		return senha;
	}

	public void setSenha(JLabel senha) {
		this.senha = senha;
	}

	public JTextField getCampoLogin() {
		return campoLogin;
	}

	public void setCampoLogin(JTextField campoLogin) {
		this.campoLogin = campoLogin;
	}

	public JTextField getCampoSenha() {
		return campoSenha;
	}

	public void setCampoSenha(JTextField campoSenha) {
		this.campoSenha = campoSenha;
	}

}
