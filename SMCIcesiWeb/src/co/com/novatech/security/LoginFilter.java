package co.com.novatech.security;

//package co.com.skyline.fruitcomm.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//import co.com.skyline.fruitcomm.presentacion.UsuarioMB;

@WebFilter(filterName = "Login filter")
public class LoginFilter implements Filter {

	 
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		// HttpServletRequest request = (HttpServletRequest) req;
		// HttpSession session = request.getSession();
		// String loginURL = request.getContextPath() +
		// "/faces/Login/LoginView.xhtml";
		// String reqUri = request.getRequestURI();
		// if (reqUri.equals(loginURL)) {
		chain.doFilter(req, res);
		// }
		// UserCip usuario = (UserCip) session.getAttribute("usuarioSesion");
		// if (usuario == null) {
		// try {
		// session.invalidate();
		// } catch (Exception e) {
		// // System.out.println();
		// e.printStackTrace();
		// }
		// HttpServletResponse response = (HttpServletResponse) res;
		// response.getWriter().write("<script>");
		// response.getWriter().write("parent.location.replace('" + loginURL +
		// "');");
		// response.getWriter().write("</script>");
		// } else {
		// chain.doFilter(req, res);
		// }
	}

	 
	public void init(FilterConfig arg0) throws ServletException {
		// TODO init loginFilter

	}

	 
	public void destroy() {
		// TODO destroy LoginFilter

	}

}
