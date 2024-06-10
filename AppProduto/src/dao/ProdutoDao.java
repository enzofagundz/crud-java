package dao;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;
import ws.ProdutoWSProxy;

public class ProdutoDao {
	private final ProdutoWSProxy wsproduto;
	
	public ProdutoDao() {
		this.wsproduto = new ProdutoWSProxy();
	}

	public void cadastrarProduto(Produto produto) {
		try {
			wsproduto.cadastrarProduto(produto.getNome(), produto.getDescricao(), Float.toString(produto.getPreco()), Integer.toString(produto.getQuantidade()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void removerProduto(int idproduto) {
		try {
			wsproduto.removerProduto(Integer.toString(idproduto));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void atualizarProduto(Produto produto) {
		try {
			ws.Produto prod = new ws.Produto();
			prod.setId(produto.getId());
			prod.setNome(produto.getNome());
			prod.setDescricao(produto.getDescricao());
			prod.setPreco(produto.getPreco());
			prod.setQuantidade(produto.getQuantidade());
			wsproduto.atualizarProduto(Integer.toString(produto.getId()), produto.getNome(), produto.getDescricao(), Float.toString(produto.getPreco()), Integer.toString(produto.getQuantidade()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public List<Produto> getAllProdutos() {
		List<Produto> listaProdutos = new ArrayList<Produto>();
		try {
			ws.Produto[] prods = wsproduto.getAllProdutos();

			for (int i = 0; i < prods.length; i++) {
				Produto produto = new Produto();
				produto.setId(prods[i].getId());
				produto.setNome(prods[i].getNome());
				produto.setDescricao(prods[i].getDescricao());
				produto.setPreco(prods[i].getPreco());
				produto.setQuantidade(prods[i].getQuantidade());
				produto.setDataCadastro(prods[i].getDataCadastro().getTime());
				listaProdutos.add(produto);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return listaProdutos;
	}

	public Produto getProdutoById(int produtoid) {
		Produto produto = new Produto();
		try {
			ws.Produto prod = wsproduto.getProdutoById(Integer.toString(produtoid));
			produto.setId(prod.getId());
			produto.setNome(prod.getNome());
			produto.setDescricao(prod.getDescricao());
			produto.setPreco(prod.getPreco());
			produto.setQuantidade(prod.getQuantidade());
			produto.setDataCadastro(prod.getDataCadastro().getTime());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return produto;
	}
}
