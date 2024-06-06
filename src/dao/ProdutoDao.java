package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import util.DbUtil;

public class ProdutoDao {

	private Connection conn;

	public ProdutoDao() { // Construtor - Conecta com o banco qdo. instanciado
		conn = DbUtil.getConnection();
	}

	public void cadastrarProduto(Produto produto) {
		try {
			PreparedStatement prepstmt = conn
					.prepareStatement("INSERT INTO produto(nome,descricao,preco,quantidade) VALUES (?, ?, ?, ? )");
			prepstmt.setString(1, produto.getNome());
			prepstmt.setString(2, produto.getDescricao());
			prepstmt.setFloat(3, produto.getPreco());
			prepstmt.setInt(4, produto.getQuantidade());
			prepstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerProduto(int idproduto) {
		try {
			PreparedStatement prepstmt = conn.prepareStatement("DELETE FROM produto WHERE id=?");
			prepstmt.setInt(1, idproduto);
			prepstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarProduto(Produto produto) {
		try {
			PreparedStatement prepstmt = conn
					.prepareStatement("UPDATE produto SET nome=?, descricao=?, preco=?, quantidade=? WHERE id=?");
			prepstmt.setString(1, produto.getNome());
			prepstmt.setString(2, produto.getDescricao());
			prepstmt.setFloat(3, produto.getPreco());
			prepstmt.setInt(4, produto.getQuantidade());
			prepstmt.setInt(5, produto.getId());
			prepstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Produto> getAllProdutos() {
		List<Produto> listaProdutos = new ArrayList<Produto>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM produto");
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setDataCadastro(rs.getDate("dataCadastro"));
				listaProdutos.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaProdutos;
	}

	public Produto getProdutoById(int produtoid) {
		Produto produto = new Produto();
		try {
			PreparedStatement prepstmt = conn.prepareStatement("SELECT * FROM produto WHERE id=?");
			prepstmt.setInt(1, produtoid);
			ResultSet rs = prepstmt.executeQuery();

			if (rs.next()) {
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setDataCadastro(rs.getDate("dataCadastro"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produto;
	}

}
