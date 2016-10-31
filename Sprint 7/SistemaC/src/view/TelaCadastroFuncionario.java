package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;


import model.Dados;


public class TelaCadastroFuncionario extends TelaInternal{

	private static final long serialVersionUID = 1L;

	private JLabel nome, rg, cpf, telefone, login, senha, estado, cidade, rua, bairro, numero;
	private JTextField campoNome, campoCpf, campoRg, campoTelefone, campoLogin, campoRua, campoBairro, campoNumero;
	private JButton cadastrar;
	private JPasswordField campoSenha;
	private MaskFormatter m1, m2;
	private JComboBox<String> campoEstado;
	private JComboBox<String> campoCidade;
	public TelaCadastroFuncionario() {
		super("Funcionario");

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
		campoEstado = new JComboBox<>();
		campoCidade = new JComboBox<>();
		campoRua = new JTextField(20);
		campoBairro = new JTextField(20);
		campoNumero = new JTextField(20);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {  
		     public void run() {  
		         campoNome.requestFocusInWindow();  
		     }  
		 });
		
		campoEstado.addItem("...");

		for (String e : Dados.estados) {
			campoEstado.addItem(e);
		}
		
		campoEstado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addCidades(campoEstado.getSelectedIndex());
			}
		});
		
		
		
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
		cadastrar.setBounds(250, 250, 100, 20);
		add(cadastrar);
	}
	
	
	public void addCidades(int indice) {

		campoCidade.removeAllItems();

		if (indice != 0) {
			campoCidade.addItem("...");
			for (String cidad : Dados.cidades[indice-1]) {
				campoCidade.addItem(cidad);
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


	public JTextField getCampoRua() {
		return campoRua;
	}


	public void setCampoRua(JTextField campoRua) {
		this.campoRua = campoRua;
	}


	public JTextField getCampoBairro() {
		return campoBairro;
	}


	public void setCampoBairro(JTextField campoBairro) {
		this.campoBairro = campoBairro;
	}


	public JTextField getCampoNumero() {
		return campoNumero;
	}


	public void setCampoNumero(JTextField campoNumero) {
		this.campoNumero = campoNumero;
	}


	public JComboBox<String> getCampoEstado() {
		return campoEstado;
	}


	public void setCampoEstado(JComboBox<String> campoEstado) {
		this.campoEstado = campoEstado;
	}


	public JComboBox<String> getCampoCidade() {
		return campoCidade;
	}


	public void setCampoCidade(JComboBox<String> campoCidade) {
		this.campoCidade = campoCidade;
	}
	
	
	
}
