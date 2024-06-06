
<%
request.setAttribute("title", "Cadastrar/Editar Usuários");
%>
<%@ include file="header.jsp"%>

<%
if (request.getParameter("action").equalsIgnoreCase("editarUsuario")) {
	request.setAttribute("action", 1);
} else {
	request.setAttribute("action", 2);
}
%>

<c:if test="${action == 1}">
	<h1>Editar Usuário</h1>
</c:if>
<c:if test="${action == 2}">
	<h1>Cadastrar Usuário</h1>
</c:if>

<form action="UsuarioController" method="post">
	<fieldset>
		<c:if test="${action == 1}">
			<label for="login">Login:</label>

			<input type="text" readonly="readonly" id="login" name="login"
				value="<c:out value="${usuario.login}" />" />

			<input type="hidden" id="action" name="action" value="editar" />
		</c:if>
		<c:if test="${action == 2}">
			<label for="login">Login:</label>

			<input type="text" id="login" name="login"
				value="<c:out value="${usuario.login}" />" />

			<input type="hidden" id="action" name="action" value="cadastrar" />
		</c:if>
		<label for="nome">Nome:</label> <input type="text" id="nome"
			name="nome" size="80" value="<c:out value="${usuario.nome}" />" /> <label
			for="senha">Senha:</label> <input type="text" id="senha" name="senha"
			size="80" value="<c:out value="${usuario.senha}" />" /> <label
			for="email">Email:</label> <input type="text" id="email" name="email"
			size="80" value="<c:out value="${usuario.email}" />" /> <label
			for="permissao">Tipo de Permissão</label> <select name="permissao"
			id="permissao">
			<option value="Selecione">Selecione</option>
			<option value="Admin">Administrador</option>
			<option value="Normal">Normal</option>
			<option value="Leitura">Somente Leitura</option>
	</fieldset>
	</select> <input role="button" type="submit" value="Salvar">
</form>
<%@ include file="footer.jsp"%>
