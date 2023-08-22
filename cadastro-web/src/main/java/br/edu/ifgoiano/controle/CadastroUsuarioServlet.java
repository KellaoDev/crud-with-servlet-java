package br.edu.ifgoiano.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet("/cadastrarUsuario")
public class CadastroUsuarioServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String senhaCadastro01 = req.getParameter("senhaCadastro01");
		String senhaCadastro02 = req.getParameter("senhaCadastro02");
	
		//Verificar se as senhas são iguais e criando usuário
		
		if(senhaCadastro01.equals(senhaCadastro02) && senhaCadastro01 != "" && senhaCadastro02 != "") {
			Usuario usuario = new Usuario();
			
			usuario.setNome(req.getParameter("nameCadastro"));
			usuario.setEmail(req.getParameter("emailCadastro"));
			usuario.setSenha(req.getParameter("senhaCadastro01"));
			
			UsuarioRepositorio repositorio = new UsuarioRepositorio();
			repositorio.inserirUsuario(usuario);
			
			//redirecionar o usuario para a pagina de login
			resp.sendRedirect("index.jsp");
		} else {
			//redirecionar o usuario para a mesma página de cadastro do usuario
			req.getRequestDispatcher("usuarioCadastro.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		
		req.setAttribute("usuarios", repositorio.listarUsuarios());
		
		req.getRequestDispatcher("usuarioListagem.jsp").forward(req, resp);
	}
}