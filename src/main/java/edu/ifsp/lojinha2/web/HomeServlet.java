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

import edu.ifsp.web.TemplateManager;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IWebContext ctx = new WebContext(request, response, getServletContext());
		TemplateEngine engine = TemplateManager.getEngine(getServletContext());
		
		response.setContentType("text/html;charset=UTF-8");
		
		engine.process("home", ctx, response.getWriter());
		
	}

}
