<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>CRUD - Produto Servlet - JSP</title>
</head>
<body>
	<main class="container">
		<h1>Aplicação - Menu</h1>
		<br>
		<div class="grid">
			<a role="button" href="http://localhost:8080/AppProduto/ProdutoController?action=cadastrarProduto">
				Cadastrar Produto
			</a> 
			<a role="button" href="http://localhost:8080/AppProduto/ProdutoController?action=listarProdutos">
				Listar Produtos
			</a> 
			<a role="button" href="http://localhost:8080/AppProduto/UsuarioController?action=CadastrarUsuario">
				Cadastrar Usuário
			</a> 
			<a role="button" href="http://localhost:8080/AppProduto/UsuarioController?action=listarUsuarios">
				Listar Usuários
			</a> 
			<a role="button" href="http://localhost:8080/AppProduto/Login?action=logout">
				Sair/Logout
			</a>
		</div>
	</main>
</body>
</html>
