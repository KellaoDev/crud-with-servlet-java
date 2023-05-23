package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifgoiano.entidade.Usuario;

@WebServlet("/cadastrarUsuario")
public class CadastroUsuarioServlet extends HttpServlet {

	//Simular o banco de Dados
	private List<Usuario> lstDeUsuario;
	
	@Override
	public void init() throws ServletException {
		this.lstDeUsuario = new ArrayList<Usuario>();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String senha1 = req.getParameter("senha1");
		String senha2 = req.getParameter("senha2");
	
		//Verificar se as senhas sao iguais
		
		if(senha1.equals(senha2)) {
			Usuario usu = new Usuario();
			
			
			usu.setNome(req.getParameter("nameCrud"));
			usu.setEmail(req.getParameter("email"));
			usu.setSenha(req.getParameter("senha1"));
			
			lstDeUsuario.add(usu);
			//redirecionar o usuario para a pagina de login
			resp.sendRedirect("index.html");
		} else {
			//redirecionar o usuario para a mesma p�gina de cadastro do usuario
			req.getRequestDispatcher("usuarioCadastro.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("usuarios", lstDeUsuario);
		req.getRequestDispatcher("usuarioListagem.jsp").forward(req, resp);
	}
	
	
	@Override
	public void destroy() {
		this.lstDeUsuario.clear();
	}
}
