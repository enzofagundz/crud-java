package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;

import modelo.Usuario;
import ws.UsuarioWSProxy;

public class UsuarioDao {
	private final UsuarioWSProxy wsusuario;

	public UsuarioDao() {
		this.wsusuario = new UsuarioWSProxy();
	}

	public void cadastrarUsuario(Usuario usuario) {
		try {
			wsusuario.cadastrarUsuario(usuario.getLogin(), usuario.getNome(), usuario.getSenha(), usuario.getEmail(), usuario.getPermissao());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void removerUsuario(String login) {
		try {
			wsusuario.removerUsuario(login);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void atualizarUsuario(Usuario usuario) {
		try {
			ws.Usuario usu = new ws.Usuario();
			usu.setLogin(usuario.getLogin());
			usu.setNome(usuario.getNome());
			usu.setSenha(usuario.getSenha());
			usu.setEmail(usuario.getEmail());
			usu.setPermissao(usuario.getPermissao());
			wsusuario.atualizarUsuario(usuario.getLogin(), usuario.getNome(), usuario.getSenha(), usuario.getEmail(), usuario.getPermissao());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> getAllUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			ws.Usuario[] usus = wsusuario.getAllUsuarios();

			for (int i = 0; i < usus.length; i++) {
				Usuario usuario = new Usuario();
				usuario.setLogin(usus[i].getLogin());
				usuario.setNome(usus[i].getNome());
				usuario.setSenha(usus[i].getSenha());
				usuario.setEmail(usus[i].getEmail());
				usuario.setPermissao(usus[i].getPermissao());
				listaUsuarios.add(usuario);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return listaUsuarios;
	}

	public Usuario getUsuarioByLogin(String login) {
		Usuario usuario = new Usuario();
		try {
			ws.Usuario usu = wsusuario.getUsuarioByLogin(login);
			usuario.setLogin(usu.getLogin());
			usuario.setNome(usu.getNome());
			usuario.setSenha(usu.getSenha());
			usuario.setEmail(usu.getEmail());
			usuario.setPermissao(usu.getPermissao());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
