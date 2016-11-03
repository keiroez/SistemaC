package modelDAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Endereco;
import model.Funcionario;


public class Banco{
	
	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultSet = null;
	
	
	
	/**
	 * 
	 * CONEXÃO
	 * 
	 * 
	 */
	
	
	
	public void conectar(){
				
		String servidor = "jdbc:mysql://localhost:3306/banco_clinica";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}		
	}
	
	
	public boolean estaConectado(){
		
		if(this.connection != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void desconectar(){
		
		try {			
			this.connection.close();
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
	}
	
	
	/**
	 * 
	 * 
	 * VERIFICAÇÃO DE LOGIN
	 * 
	 * 
	 */
	
	
	public boolean validarLogin(String login, String senha){
		
		try {
						
			String query = "SELECT * FROM funcionario WHERE login = '"+ login + "';";
			this.resultSet = this.statement.executeQuery(query);
			
			
			if(resultSet.next()){				
				if(this.resultSet.getString("senha").equals(senha)){
					return true;
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		return false;
			
	}
	
	public boolean loginDisponivel(String login){
		
		
		try {		
			
			String query = "SELECT * FROM funcionario WHERE login = '"+login+"';";
			this.resultSet = this.statement.executeQuery(query);
						
			if(resultSet.next()){
				return true;
			}
			
							
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		return false;
	}
	
	
	/**
	 * 
	 * 
	 * INSERÇÃO E BUSCA  DE FUNCIONÁRIO
	 * 
	 * 
	 */
	
	public void cadastrarFuncionario(String nome, String rg, String cpf, String telefone, String login, String senha, String estado, String cidade, String rua, String bairro, int numero){
		
		try {
		
			String query = "INSERT INTO funcionario (nome, rg, cpf, telefone, login, senha, estado, cidade, rua, bairro, numero) VALUES ('"+nome+"', '" + rg + "', '"+cpf+"', '"+telefone+"', '"+login+"', '"+senha+"', '"+estado+"', '"+cidade+"', '"+rua+"', '"+bairro+"', '"+numero+"');";
			this.statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}	
	}
	
	
	
	public String [] BuscaFuncionario(String cpf){
		
		String nome = null, cpf1 = null, telefone = null;
		
		try {		
			
			String query = "SELECT * FROM funcionario WHERE cpf = '"+cpf+"';";
			this.resultSet = this.statement.executeQuery(query);
						
			if(resultSet.next()){
				nome = this.resultSet.getString("nome");
				cpf1 = this.resultSet.getString("cpf");
				telefone = this.resultSet.getString("telefone");
			}
			
			else{
				JOptionPane.showMessageDialog(null, "Cpf não cadastrado");
			}
			
			
					
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		return new String[]{nome, cpf1, telefone};
		
	}
	
	public Funcionario buscaFuncionarioPorLoginESenha(String login, String senha){
		
		
		try {
						
			String query = "SELECT * FROM funcionario WHERE login = '"+login+"';";
			this.resultSet = this.statement.executeQuery(query);
			
			this.resultSet.next();
		
			if(this.resultSet.getString("senha").equals(senha)){
				return new Funcionario(resultSet.getString("nome"), resultSet.getString("rg"), resultSet.getString("cpf"), resultSet.getString("telefone"), login, senha, new Endereco(resultSet.getString("estado"), resultSet.getString("cidade"), resultSet.getString("bairro"), resultSet.getString("rua"), resultSet.getInt("numero")));
			}
			
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		return null;
			
	}
	
	
	/**
	 * 
	 * REMOÇÃO E CONSULTA DE FUNCIONÁRIO E PACIENTE
	 * 
	 * 
	 */
	
	
	public void removerUsuario(String cpf, String usuario){
		
		try {			
			String query = "DELETE FROM "+usuario+" WHERE cpf = '"+cpf+"';";
			this.statement.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
			
						
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}		
	}
	
	public boolean cpfIsCadastro(String cpf, String pessoa){
		
		
		try {		
			
			String query = "SELECT * FROM "+pessoa+" WHERE cpf = '"+cpf+"';";
			this.resultSet = this.statement.executeQuery(query);
						
			if(resultSet.next()){
				return true;
			}
			
							
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		return false;
	}
	
	public boolean rgIsCadastro(String rg, String pessoa){
		
		
		try {		
			
			String query = "SELECT * FROM "+pessoa+" WHERE rg = '"+rg+"';";
			this.resultSet = this.statement.executeQuery(query);
						
			if(resultSet.next()){
				return true;
			}
			
							
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		return false;
	}
	
	
	
	
	/**
	 * 
	 * 
	 * INSERÇÃO E BUSCA DE PACIENTE
	 * 
	 * 
	 */
	
	
	
	public void cadastrarPaciente(String nome, String rg, String cpf, String telefone, String estado, String cidade, String rua, String bairro, int numero){
		
		try {
		
			String query = "INSERT INTO paciente (nome, rg, cpf, telefone, estado, cidade, rua, bairro, numero) VALUES ('"+nome+"', '" + rg + "', '"+cpf+"', '"+telefone+"', '"+estado+"', '"+cidade+"', '"+rua+"', '"+bairro+"', '"+numero+"');";
			this.statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}	
	}
	
		
	public String [] BuscaPaciente(String cpf){
		
		String nome = null, cpf1 = null, telefone = null;
		
		try {		
			
			String query = "SELECT * FROM paciente WHERE cpf = '"+cpf+"';";
			this.resultSet = this.statement.executeQuery(query);
						
			if(resultSet.next()){
				nome = this.resultSet.getString("nome");
				cpf1 = this.resultSet.getString("cpf");
				telefone = this.resultSet.getString("telefone");
			}
			
			else{
				JOptionPane.showMessageDialog(null, "Cpf não cadastrado");
			}
			
			
					
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		return new String[]{nome, cpf1, telefone};
		
	}
	
	
	

}
