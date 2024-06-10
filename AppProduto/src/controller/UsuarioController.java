package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import modelo.Usuario;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LISTAR_USUARIOS = "listarUsuarios.jsp";
	private static String FORM_CAD_EDIT_USUARIO = "formCadastrarEditarUsuario.jsp";
	private UsuarioDao daousuario;

	public UsuarioController() {
		super();
		daousuario = new UsuarioDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forwardJsp = "";
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if (action.equalsIgnoreCase("listarUsuarios")) {
			forwardJsp = LISTAR_USUARIOS;
			req.setAttribute("usuarios", daousuario.getAllUsuarios());
		} else if (action.equalsIgnoreCase("editarUsuario")) {
			forwardJsp = FORM_CAD_EDIT_USUARIO;
			String login = req.getParameter("login");
			Usuario usuario = daousuario.getUsuarioByLogin(login);
			req.setAttribute("usuario", usuario);
		} else if (action.equalsIgnoreCase("removerUsuario")) {
			String login = req.getParameter("login");
			daousuario.removerUsuario(login);
			forwardJsp = LISTAR_USUARIOS;
			req.setAttribute("usuarios", daousuario.getAllUsuarios());
		} else { // action = cadastrarUsuario
			forwardJsp = FORM_CAD_EDIT_USUARIO;
		}

		RequestDispatcher view = req.getRequestDispatcher(forwardJsp);
		view.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Recebe dados do Formulário de Cadastro ou Edição de Usuario
		req.setCharacterEncoding("UTF-8");
		Usuario usuario = new Usuario();
		usuario.setLogin(req.getParameter("login"));
		usuario.setNome(req.getParameter("nome"));
		usuario.setSenha(req.getParameter("senha"));
		usuario.setEmail(req.getParameter("email"));
		usuario.setPermissao(req.getParameter("permissao"));

		String action = req.getParameter("action");
		if (action.equalsIgnoreCase("cadastrar")) // Novo Usuario- chamar Cadastrar
		{
			// Validação: Verifica se já existe um usuário com este Login
			if (daousuario.getUsuarioByLogin(usuario.getLogin()).getLogin() != null) {
				System.out.println("UsuarioController: Já existe um usuário com este Login: " + usuario.getLogin());
			} else {
				daousuario.cadastrarUsuario(usuario);
			}
		} else // Editando um Usuario - chamar Atualizar
		{
			daousuario.atualizarUsuario(usuario);
		}

		req.setAttribute("usuarios", daousuario.getAllUsuarios());
		RequestDispatcher view = req.getRequestDispatcher(LISTAR_USUARIOS);
		view.forward(req, resp);

	}

}
