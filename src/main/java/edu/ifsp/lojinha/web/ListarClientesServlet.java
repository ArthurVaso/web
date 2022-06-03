package edu.ifsp.lojinha.web;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/listar")
public class ListarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.listAll();
		
		request.setAttribute("clientes", clientes);
		
		IWebContext ctx = new WebContext(request, response, getServletContext());
		TemplateEngine engine = TemplateManager.getEngine(getServletContext());
		
		response.setContentType("text/html;charset=UTF-8");
		
		engine.process("listar-clientes", ctx, response.getWriter());		
	}


}
