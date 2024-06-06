package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDao;
import model.Produto;

@WebServlet("/ProdutoController")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LISTAR_PRODUTOS = "listarProdutos.jsp";
	private static String FORM_CAD_EDIT_PRODUTO = "formCadastrarEditarProduto.jsp";
	private ProdutoDao daoprod;

	public ProdutoController() {
		super();
		daoprod = new ProdutoDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forwardJsp = "";
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if (action.equalsIgnoreCase("listarProdutos")) {
			forwardJsp = LISTAR_PRODUTOS;
			req.setAttribute("produtos", daoprod.getAllProdutos());
		} else if (action.equalsIgnoreCase("editarProduto")) {
			forwardJsp = FORM_CAD_EDIT_PRODUTO;
			int produtoid = Integer.parseInt(req.getParameter("produtoid"));
			Produto produto = daoprod.getProdutoById(produtoid);
			req.setAttribute("produto", produto);
		} else if (action.equalsIgnoreCase("removerProduto")) {
			int produtoid = Integer.parseInt(req.getParameter("produtoid"));
			daoprod.removerProduto(produtoid);
			forwardJsp = LISTAR_PRODUTOS;
			req.setAttribute("produtos", daoprod.getAllProdutos());
		} else { // action = cadastrarProduto
			forwardJsp = FORM_CAD_EDIT_PRODUTO;
		}

		RequestDispatcher view = req.getRequestDispatcher(forwardJsp);
		view.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Recebe dados do Formulário de Cadastro ou Edição de Produto
		req.setCharacterEncoding("UTF-8");
		Produto produto = new Produto();
		produto.setNome(req.getParameter("nome"));
		produto.setDescricao(req.getParameter("descricao"));
		produto.setPreco(Float.parseFloat(req.getParameter("preco")));
		produto.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));

		String produtoid = req.getParameter("id");
		if (produtoid == null || produtoid.isEmpty()) // Novo Produto - chamar Cadastrar
		{
			daoprod.cadastrarProduto(produto);
		} else // Editando um Produto - chamar Atualizar
		{
			produto.setId(Integer.parseInt(produtoid));
			daoprod.atualizarProduto(produto);
		}

		req.setAttribute("produtos", daoprod.getAllProdutos());
		RequestDispatcher view = req.getRequestDispatcher(LISTAR_PRODUTOS);
		view.forward(req, resp);

	}
}