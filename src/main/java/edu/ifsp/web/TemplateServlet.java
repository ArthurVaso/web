package edu.ifsp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import edu.ifsp.lojinha2.modelo.Cliente;

@WebServlet("/template")
public class TemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TemplateEngine engine = TemplateManager.getEngine(getServletContext());
		
		
		IWebContext ctx = new WebContext(request, response, getServletContext());
		
		Cliente cliente = new Cliente();
		cliente.setNome("Doug Funnie");
		cliente.setEmail("doug@jumbo.com");
		
		request.setAttribute("cliente", cliente);
		
		response.setContentType("text/html;charset=UTF-8");
		engine.process("home", ctx, response.getWriter());
		
	}


}










