<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Cadastrar/Editar Produto</title>
</head>
<body>
	<% 
		if (request.getParameter("action").equalsIgnoreCase("editarProduto")){
			request.setAttribute("action", 1);
		}
		else{
			request.setAttribute("action", 2);
		}
	%>
<main class="container">
	
		<c:if test="${action == 1}">
			<h1>Editar Produto</h1>
		</c:if>
		<c:if test="${action == 2}">
			<h1>Cadastrar Produto</h1>
		</c:if>
	
		<form action="ProdutoController" method="post">
			<fieldset>
				<c:if test="${action == 1}">
					<label for="id">Id do Produto:
						<input type="text" readonly="readonly" id="id" name="id"
							value="<c:out value="${produto.id}" />" />
					</label>
				</c:if>
				<label for="nome">
					Nome do Produto:
					<input type="text" id="nome" name="nome" value="<c:out value="${produto.nome}" />" />
				</label>
				<label for="descricao">
					Descrição:
					<input type="text" id="descricao" name="descricao" value="<c:out value="${produto.descricao}" />" /> 
				</label>
				<label for="preco">
					Preço R$:
					<input type="text" name="preco" value="<c:out value="${produto.preco}" />" /> 
				</label>
				<label for="quantidade">
					Quantidade:
					<input type="number" name="quantidade" value="<c:out value="${produto.quantidade}" />" /> 
				</label>
			</fieldset>
			<button type="submit">
				Salvar
			</button>
		</form>
</main>
</body>
</html>
