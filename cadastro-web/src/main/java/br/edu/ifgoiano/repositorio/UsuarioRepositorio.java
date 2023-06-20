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

	public static Connection conn;
	public UsuarioRepositorio() {
		try {
			conn = DriverManager.
					getConnection("jdbc:h2:~/usuariodb", "sa", "sa");
			//Verificar a verificação realizada com sucesso na console
			System.out.println("Conexão realizada com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro na conexão com o banco de dados.");
			e.printStackTrace();
		}
	}

	public List<Usuario> listarUsuarios() {
		List<Usuario> lstUsuarios = new ArrayList<Usuario>();
		
		String sql = "select id, nome, email, senha, data_nascimento from usuario";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			
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
}
