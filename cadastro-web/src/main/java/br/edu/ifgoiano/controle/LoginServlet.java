package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = (req.getParameter("nome"));
		String password = (req.getParameter("senha"));
		String email = (req.getParameter("email"));
		
		
		String html = new String();
		html = "<html><body><h1>Login Realizado com Sucesso!</h1></body></html>";
		
		PrintWriter writer = resp.getWriter();
		writer.println(html);
		
	}
}

