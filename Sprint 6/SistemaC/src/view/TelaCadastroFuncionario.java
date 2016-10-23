package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import app.App;
import model.Endereco;
import model.Funcionario;

public class TelaCadastroFuncionario extends Tela {

	private static final long serialVersionUID = 1L;

	private JLabel nome, rg, cpf, telefone, login, senha, estado, cidade, rua, bairro, numero;
	private JTextField campoNome, campoCpf, campoRg, campoTelefone, campoLogin, campoEstado, campoCidade, campoRua, campoBairro, campoNumero;
	private JButton cadastrar;
	private JPasswordField campoSenha;
	private MaskFormatter m1, m2;

	public TelaCadastroFuncionario() {

		setTitle("Cadastro de Funcionário");

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
		login = new JLabel("Login: ");
		senha = new JLabel("Senha: ");
		estado = new JLabel("Estado: ");
		cidade = new JLabel("Cidade: ");
		rua  = new JLabel("Rua: ");
		bairro = new JLabel("Bairro: ");
		numero = new JLabel("Número: ");

		campoNome = new JTextField(20);
		campoRg = new JTextField(20);
		campoCpf = new JFormattedTextField(m1);
		campoTelefone = new JFormattedTextField(m2);
		campoLogin = new JTextField(20);
		campoSenha = new JPasswordField(20);
		campoEstado = new JTextField(20);
		campoCidade = new JTextField(20);
		campoRua = new JTextField(20);
		campoBairro = new JTextField(20);
		campoNumero = new JTextField(20);
		
		cadastrar = new JButton("Cadastrar");

		Container c = new Container();
		c.setLayout(new GridLayout(11, 2));
		c.setSize(400, 220);
		c.setLocation(100, 30);
		c.add(nome);
		c.add(campoNome);
		c.add(rg);
		c.add(campoRg);
		c.add(cpf);
		c.add(campoCpf);
		c.add(telefone);
		c.add(campoTelefone);
		c.add(estado);
		c.add(campoEstado);
		c.add(cidade);
		c.add(campoCidade);
		c.add(rua);
		c.add(campoRua);
		c.add(bairro);
		c.add(campoBairro);
		c.add(numero);
		c.add(campoNumero);
		c.add(login);
		c.add(campoLogin);
		c.add(senha);
		c.add(campoSenha);

		add(c);
		cadastrar.setBounds(250, 300, 100, 20);
		add(cadastrar);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	public void cadastrarFuncionario(String nome, String rg, String cpf, String telefone, String login, String senha) {

		if (cpf.equals("") || nome.equals("") || rg.equals("") || telefone.equals("") || login.equals("")
				|| senha.equals("") || campoEstado.getText().equals("") || campoCidade.getText().equals("") || campoRua.getText().equals("") || campoBairro.getText().equals("") || campoNumero.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo não preenchido");
		}

		else {
			boolean cpfCad = false, loginCad = false, rgCad = false;

			for (int i = 0; i < App.funcionarios.size(); i++) {
				if (App.funcionarios.get(i).getCpf().equals(cpf)) {
					JOptionPane.showMessageDialog(null, "Este CPF já está cadastrado no sistema");
					cpfCad = true;
				}

				if (App.funcionarios.get(i).getLogin().equals(login)) {
					JOptionPane.showMessageDialog(null, "Login indisponível");
					loginCad = true;
				}

				if (App.funcionarios.get(i).getRg().equals(rg)) {
					JOptionPane.showMessageDialog(null, "Este RG já está cadastrado no sistema");
					rgCad = true;
				}
			}

			if (!cpfCad && !loginCad && !rgCad) {
				App.funcionarios.add(new Funcionario(nome, rg, cpf, telefone, login, senha, new Endereco(campoEstado.getText(), campoCidade.getText(), campoRua.getText(), campoBairro.getText(), Integer.parseInt(campoNumero.getText()))));
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

	public void setCampoSenha(JPasswordField campoSenha) {
		this.campoSenha = campoSenha;
	}

}
