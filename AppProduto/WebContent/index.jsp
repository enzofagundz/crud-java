<% request.setAttribute("title", "CRUD Produto Servlet"); %>
<%@ include file="header.jsp" %>
	<main class="container">
		<h1>Aplica��o - Menu</h1>
		<br>
		<div class="grid">
			<a role="button" href="http://localhost:8080/AppProduto/ProdutoController?action=cadastrarProduto">
				Cadastrar Produto
			</a> 
			<a role="button" href="http://localhost:8080/AppProduto/ProdutoController?action=listarProdutos">
				Listar Produtos
			</a> 
			<a role="button" href="http://localhost:8080/AppProduto/UsuarioController?action=CadastrarUsuario">
				Cadastrar Usu�rio
			</a> 
			<a role="button" href="http://localhost:8080/AppProduto/UsuarioController?action=listarUsuarios">
				Listar Usu�rios
			</a> 
			<a role="button" href="http://localhost:8080/AppProduto/Login?action=logout">
				Sair/Logout
			</a>
		</div>
	</main>
<%@ include file="footer.jsp" %>