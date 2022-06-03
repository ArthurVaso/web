package edu.ifsp.lojinha2.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;

import edu.ifsp.lojinha2.modelo.Cliente;
import edu.ifsp.lojinha2.persistencia.ClienteDAO;
import edu.ifsp.web.TemplateManager;

@WebServlet("/cadastrar")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IWebContext ctx = new WebContext(request, response, getServletContext());
		TemplateEngine engine = TemplateManager.getEngine(getServletContext());
		
		response.setContentType("text/html;charset=UTF-8");
		
		engine.process("cadastro", ctx, response.getWriter());
		
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
	
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
				
		ClienteDAO dao = new ClienteDAO();
		dao.save(cliente);
				
	}

}
