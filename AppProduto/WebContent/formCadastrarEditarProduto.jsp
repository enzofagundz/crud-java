<% request.setAttribute("title", "Cadastrar/Editar Produto"); %>
<%@ include file="header.jsp" %>
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
					Descri��o:
					<input type="text" id="descricao" name="descricao" value="<c:out value="${produto.descricao}" />" /> 
				</label>
				<label for="preco">
					Pre�o R$:
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
<%@ include file="footer.jsp" %>