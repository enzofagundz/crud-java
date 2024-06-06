package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import model.Usuario;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String FORM_LOGIN = "formLogin.jsp";
	private static String MENU_PRINCIPAL = "index.jsp";
	private UsuarioDao daousuario;

	public LoginController() {
		super();
		daousuario = new UsuarioDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String forwardJsp = "";
		String act = req.getParameter("action");

		if (act.equalsIgnoreCase("logout")) {
			HttpSession sessao = req.getSession();
			sessao.removeAttribute("usuarioLogado");
			forwardJsp = FORM_LOGIN;
		}

		resp.sendRedirect(forwardJsp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Recebe dados do Formulário de Login e Valida o Usuário
		req.setCharacterEncoding("UTF-8");
		String forwardJsp = "";

		String loginform = req.getParameter("login");
		String senhaform = req.getParameter("senha");
		Usuario usuario = daousuario.getUsuarioByLogin(loginform);

		HttpSession sessao = req.getSession();

		if (usuario.getNome() == null) { // Login Não Localizado
			// System.out.println("LoginController: NÃO existe Usuário com este Login:
			// "+loginform);
			sessao.setAttribute("loginform", loginform);
			forwardJsp = FORM_LOGIN;
		} else {
			if (!usuario.getSenha().equals(senhaform)) {// Senha NÃO Confere
				// System.out.println("LoginController: Senha informada NÃO Confere:
				// "+senhaform);
				sessao.setAttribute("loginform", loginform);
				forwardJsp = FORM_LOGIN;
			} else { // Usuário Autenticado
				// System.out.println("LoginController: Usuário LOCALIZADO e Senha Confere: " +
				// usuario.getNome() + ":"+usuario.getSenha());
				sessao.setAttribute("usuarioLogado", usuario.getLogin());
				sessao.setAttribute("usuario", usuario);
				forwardJsp = MENU_PRINCIPAL;
			}
		}

		resp.sendRedirect(forwardJsp);
	}
}
