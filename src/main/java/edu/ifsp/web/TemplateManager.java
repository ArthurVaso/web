package edu.ifsp.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@WebListener
public class TemplateManager implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 

    }

    public void contextInitialized(ServletContextEvent sce)  {
    	final ServletContext servletContext = sce.getServletContext();
    	TemplateEngine engine = buildEngine(servletContext);
    	
    	servletContext.setAttribute("templateEngine", engine);
    	servletContext.log("TemplateEngine pronto");
    }

    public static TemplateEngine getEngine(ServletContext servletContext) {
		TemplateEngine engine = (TemplateEngine)servletContext
				.getAttribute("templateEngine");
		
		if (engine == null) {
			throw new IllegalStateException("TemplateEngine é nulo");			
		}
		
		return engine;
    }
    
	private TemplateEngine buildEngine(ServletContext servletContext) {
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContext);
		resolver.setSuffix(".html");
		resolver.setPrefix("/WEB-INF/templates/");
		resolver.setTemplateMode(TemplateMode.HTML);
		
		/* Em produção, deve ser true */
		resolver.setCacheable(false);
		
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(resolver);
		return engine;
	}

    
}
