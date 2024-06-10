<% request.setAttribute("title", "Listar Produtos"); %>
<%@ include file="header.jsp" %>
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
					<th colspan=2>Ações</th>
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
							<a role="button" class="outline" href="ProdutoController?action=editarProduto&produtoid=<c:out value="${prod.id}"/>">
								Editar
							</a>
						</td>
						<td>
							<a role="button" class="outline secondary" href="ProdutoController?action=removerProduto&produtoid=<c:out value="${prod.id}"/>">
								Excluir
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a role="button" href="index.jsp">Menu Principal</a>
	</main>
<%@ include file="footer.jsp" %>