<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css" />

<title>
	Listar Produtos
</title>
</head>
<body>
	<main class="container">
		<h1>
			Relatório de Produtos
		</h1>
		<table>
			<thead>
				<tr>
					<th></th>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Preço</th>
					<th>Qtde</th>
					<th>Data Cadastro</th>
					<th colspan=2>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtos}" var="prod">
					<tr>
						<td>
							<c:out value="${prod.id}"></c:out>
						</td>
						<td>
							<c:out value="${prod.nome}"></c:out>
						</td>
						<td>
							<c:out value="${prod.descricao}"></c:out>
						</td>
						<fmt:setLocale value="pt_BR" />
						<td>
							<fmt:formatNumber value="${prod.preco}" type="currency" />
						</td>
						<td><c:out value="${prod.quantidade}"></c:out></td>
						<td>
							<fmt:formatDate pattern="dd/MM/yyyy" value="${prod.dataCadastro}" />
						</td>
						<td>
							<a href="ProdutoController?action=editarProduto&produtoid=<c:out value="${prod.id}"/>">
								Editar
							</a>
						</td>
						<td>
							<a href="ProdutoController?action=removerProduto&produtoid=<c:out value="${prod.id}"/>">
								Excluir
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a role="button" href="index.jsp">Menu Principal</a>
	</main>
</body>
</html>
