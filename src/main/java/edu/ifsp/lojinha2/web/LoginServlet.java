package edu.ifsp.lojinha2.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;

import edu.ifsp.lojinha2.modelo.Usuario;
import edu.ifsp.lojinha2.persistencia.UsuarioDAO;
import edu.ifsp.web.TemplateManager;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IWebContext ctx = new WebContext(request, response, getServletContext());
		TemplateEngine engine = TemplateManager.getEngine(getServletContext());
		
		response.setContentType("text/html;charset=UTF-8");
		
		engine.process("login", ctx, response.getWriter());
		
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.check(username, password);
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuario", usuario);
		
		response.sendRedirect("home");		
	}
}

