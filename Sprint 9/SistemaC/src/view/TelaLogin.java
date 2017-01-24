package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel login, senha;
	private JTextField campoLogin;
	private JPasswordField campoSenha;
	private JButton entrar, sair;
	private JLabel logo;

	public TelaLogin() {
		setSize(600, 400);

		login = new JLabel("Login: ");
		login.setForeground(Color.WHITE);
		senha = new JLabel("Senha: ");
		senha.setForeground(Color.WHITE);
		campoLogin = new JTextField(20);
		campoSenha = new JPasswordField(20);
		logo = new JLabel(new ImageIcon("resource/logo.png"));
		entrar = new JButton("Entrar");
		sair = new JButton("Sair");

		setLayout(null);
		Container c = new Container();
		c.setSize(200, 40);
		c.setLocation(200, 270);

		c.setLayout(new GridLayout(2, 2));
		c.add(login);
		c.add(campoLogin);
		c.add(senha);
		c.add(campoSenha);

		add(c);

		sair.setBounds(190, 350, 100, 20);
		entrar.setBounds(310, 350, 100, 20);
		logo.setBounds(0, 0, 600, 400);

		add(sair);
		add(entrar);
		add(logo);

		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
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

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public void setCampoSenha(JPasswordField campoSenha) {
		this.campoSenha = campoSenha;
	}

	public JButton getEntrar() {
		return entrar;
	}

	public void setEntrar(JButton entrar) {
		this.entrar = entrar;
	}

	public JButton getSair() {
		return sair;
	}

	public void setSair(JButton sair) {
		this.sair = sair;
	}

}
