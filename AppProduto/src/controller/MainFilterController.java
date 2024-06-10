package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class MainFilterController implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// System.out.println("Dentro do Filtro------->");

		HttpServletRequest req = (HttpServletRequest) request;

		// System.out.println("Usuario: " +
		// req.getSession().getAttribute("usuarioLogado"));
		// System.out.println("Servlet Path " + req.getServletPath());

		if (req.getSession().getAttribute("usuarioLogado") == null) { // Ainda NÃO Autenticou
			if ((!req.getServletPath().contains("formLogin.jsp")) && (!req.getServletPath().contains("/Login"))) {
				HttpServletResponse resp = (HttpServletResponse) response;
				// System.out.println("No if Vai dar o sendRedirect para login.jsp");
				resp.sendRedirect("formLogin.jsp");
			}
		}
		// Se chegar aqui é porque o usuário já se Autenticou
		// pass the request along the filter chain
		// System.out.println("No else - vai executar o chain.doFilter()");
		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
