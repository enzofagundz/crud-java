package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import util.DbUtil;

public class UsuarioDao {
	private Connection conn;

	public UsuarioDao() { // Construtor - Conecta com o banco qdo. instanciado
		conn = DbUtil.getConnection();
	}

	public void cadastrarUsuario(Usuario usuario) {
		try {
			PreparedStatement prepstmt = conn
					.prepareStatement("INSERT INTO usuario(login,nome,senha,email,permissao) VALUES (?, ?, ?, ?, ? )");
			prepstmt.setString(1, usuario.getLogin());
			prepstmt.setString(2, usuario.getNome());
			prepstmt.setString(3, usuario.getSenha());
			prepstmt.setString(4, usuario.getEmail());
			prepstmt.setString(5, usuario.getPermissao());
			prepstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarUsuario(Usuario usuario) {
		try {
			PreparedStatement prepstmt = conn
					.prepareStatement("UPDATE usuario SET nome=?, senha=?, email=?, permissao=? WHERE login=?");
			prepstmt.setString(1, usuario.getNome());
			prepstmt.setString(2, usuario.getSenha());
			prepstmt.setString(3, usuario.getEmail());
			prepstmt.setString(4, usuario.getPermissao());
			prepstmt.setString(5, usuario.getLogin());
			prepstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerUsuario(String login) {
		try {
			PreparedStatement prepstmt = conn.prepareStatement("DELETE FROM usuario WHERE login=?");
			prepstmt.setString(1, login);
			prepstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> getAllUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPermissao(rs.getString("permissao"));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaUsuarios;
	}

	public Usuario getUsuarioByLogin(String login) {
		Usuario usuario = new Usuario();
		try {
			PreparedStatement prepstmt = conn.prepareStatement("SELECT * FROM usuario WHERE login=?");
			prepstmt.setString(1, login);
			ResultSet rs = prepstmt.executeQuery();

			if (rs.next()) {
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPermissao(rs.getString("permissao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
}
