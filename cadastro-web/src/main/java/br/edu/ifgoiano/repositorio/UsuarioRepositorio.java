package br.edu.ifgoiano.repositorio;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

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
	
	public Usuario consultarUsuarios(int id) {
		
		Usuario usuario = null;
		
		String sql = "select id, nome, email, senha from usuario WHERE id = ?";
		
		try (Connection conn = this.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				){
			pst.setInt(1, id);
			ResultSet resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				
				usuario = new Usuario();
				
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				//..demais campos	
			}
		} catch (Exception e) {
			System.out.println("Erro na consulta de usuários");
			e.printStackTrace();
		}
		return usuario;
	}

	
	public void editarUsuario(Usuario usuario) {
		
		String sql = "update usuario set nome = ?, email = ?, senha = ?" + " WHERE id = ?";
		
		try (Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement(sql)) {
			
			pst.setInt(4, usuario.getId());
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			
			//Executar o SQL
			pst.execute();
			
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na alteração de usuários");
			e.printStackTrace();
		}
	}
	
	public void excluirUsuario(Usuario usuario) {
		String sql = "delete from usuario where id = ?";
		
		try (Connection conn = this.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql))	{
			pst.setInt(1, usuario.getId());
			pst.execute();
			
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na exclusão de usuario");
			e.printStackTrace();
		}
	}
}
