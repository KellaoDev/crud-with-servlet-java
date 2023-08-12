package br.edu.ifgoiano.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet("/usuarioAtualizar")
public class AtualizarUsuarioServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String senhaAtualizar01 = req.getParameter("senhaAtualizar01");
		String senhaAtualizar02 = req.getParameter("senhaAtualizar02");
		
		int userId = Integer.parseInt(req.getParameter("id")); 
		
		if(senhaAtualizar01.equals(senhaAtualizar02)) {
		Usuario usuario = new Usuario();
		
		usuario.setId(userId);
		usuario.setNome(req.getParameter("nameAtualizar"));
		usuario.setEmail(req.getParameter("emailAtualizar"));
		usuario.setSenha(req.getParameter("senhaAtualizar01"));
		
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		repositorio.editarUsuario(usuario);
		} else {
			//redirecionar o usuario para a mesma p�gina de atualizar usuario
			req.getRequestDispatcher("index.jsp").forward(req, resp);
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
