package br.edu.ifgoiano.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet("/atualizarUsuario")
public class AtualizarUsuarioServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.valueOf(req.getParameter("id")); 

		String senhaAtualizar02 = req.getParameter("senhaAtualizar02");
		
		Usuario usuario = new Usuario();
		
		usuario.setId(userId);
		usuario.setNome(req.getParameter("nameAtualizar"));
		usuario.setEmail(req.getParameter("emailAtualizar"));
		usuario.setSenha(req.getParameter("senhaAtualizar01"));
		
		if(usuario.getSenha().equals(senhaAtualizar02)) {
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		repositorio.editarUsuario(usuario);
		
		resp.sendRedirect("cadastrarUsuario");
		} else {
			String mensagem = usuario.getNome().concat(", as senhas informadas não são iguais!");
			
			req.setAttribute("mensagem", mensagem);
			req.setAttribute("usuario", usuario);
			//redirecionar o usuario para a mesma p�gina de atualizar usuario
			req.getRequestDispatcher("usuarioAtualizar.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(req.getParameter("id")); 
		
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		
		req.setAttribute("usuario", repositorio.consultarUsuarios(userId));
		
		req.getRequestDispatcher("usuarioAtualizar.jsp").forward(req, resp);
	}
}
