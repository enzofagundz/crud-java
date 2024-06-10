package ws;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import dao.UsuarioDao;
import modelo.Usuario;

@WebService
public class UsuarioWS {
	private final UsuarioDao daoproduto = new UsuarioDao();

	@WebMethod
	public void cadastrarUsuario(String login, String nome, String senha, String email, String permissao) {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		usuario.setPermissao(permissao);
		daoproduto.cadastrarUsuario(usuario);
	}

	@WebMethod
	public void removerUsuario(String login) {
		daoproduto.removerUsuario(login);
	}

	@WebMethod
	public void atualizarUsuario(String login, String nome, String senha, String email, String permissao) {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		usuario.setPermissao(permissao);
		daoproduto.atualizarUsuario(usuario);
	}

	@WebMethod
	public List<Usuario> getAllUsuarios() {
		return daoproduto.getAllUsuarios();
	}

	@WebMethod
	public Usuario getUsuarioByLogin(String login) {
		return daoproduto.getUsuarioByLogin(login);
	}

	public static void main(String[] args) {
		UsuarioWS prodws = new UsuarioWS();
		String urlservico = "http://localhost:4568/usuariosws";
		System.out.println("Servico UsuarioWS executando na URL: " + urlservico);
		Endpoint.publish(urlservico, prodws);
	}
}
