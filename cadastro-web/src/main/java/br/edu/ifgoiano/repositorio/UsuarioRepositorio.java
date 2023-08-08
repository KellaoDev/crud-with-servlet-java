package br.edu.ifgoiano.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifgoiano.entidade.Usuario;

public class UsuarioRepositorio {

	private Connection getConnection() throws SQLException {
		return DriverManager.
				getConnection("jdbc:h2:~/usuariodb", "sa", "sa");
	}
	

	public List<Usuario> listarUsuarios() {
		List<Usuario> lstUsuarios = new ArrayList<Usuario>();
		
		String sql = "select id, nome, email, senha from usuario";
		
		try (Connection conn = this.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)
				){
			
			ResultSet resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				//..demais campos
				
				lstUsuarios.add(usuario);
			}
		} catch (Exception e) {
			System.out.println("Erro na consulta de usuários");
			e.printStackTrace();
		}
		return lstUsuarios;
	}


	public void inserirUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
		//Criar a SQL
		StringBuilder sql = new StringBuilder();
		sql.append("insert into usuario ");
		sql.append("(nome, email, senha) ");
		sql.append("values (?, ?, ?)");
		
		//Abrir uma conexão
		try (Connection conn = getConnection();
				PreparedStatement pst = conn.prepareStatement(sql.toString())) {
				pst.setString(1, usuario.getNome());
				pst.setString(2, usuario.getEmail());
				pst.setString(3, usuario.getSenha());
			
			//Executar o SQL
			pst.execute();
			
			conn.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na consulta de usuários");
			e.printStackTrace();
		}
		
	}
}
