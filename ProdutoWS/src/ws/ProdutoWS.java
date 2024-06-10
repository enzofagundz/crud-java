package ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import dao.ProdutoDao;
import modelo.Produto;

@WebService
public class ProdutoWS {

	private ProdutoDao daoproduto = new ProdutoDao();

	@WebMethod
	public void cadastrarProduto(String nome, String descricao, String preco, String quantidade) {
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setQuantidade(Integer.parseInt(quantidade));
		produto.setPreco(Float.parseFloat(preco));
		daoproduto.cadastrarProduto(produto);
	}

	@WebMethod
	public void removerProduto(String produtoid) {
		daoproduto.removerProduto(Integer.parseInt(produtoid));
	}

	@WebMethod
	public void atualizarProduto(String produtoid, String nome, String descricao, String preco, String quantidade) {
		Produto produto = new Produto();
		produto.setId(Integer.parseInt(produtoid));
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setPreco(Float.parseFloat(preco));
		produto.setQuantidade(Integer.parseInt(quantidade));
		daoproduto.atualizarProduto(produto);
	}

	@WebMethod
	public List<Produto> getAllProdutos() {
		return daoproduto.getAllProdutos();
	}

	@WebMethod
	public Produto getProdutoById(String produtoid) {
		return daoproduto.getProdutoById(Integer.parseInt(produtoid));
	}

	public static void main(String[] args) {
		ProdutoWS prodws = new ProdutoWS();
		String urlservico = "http://localhost:4567/produtows";
		System.out.println("Servico ProdutoWS executando na URL: " + urlservico);
		Endpoint.publish(urlservico, prodws);
	}

}
