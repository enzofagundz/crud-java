<% request.setAttribute("title", "Listar Usuários"); %>
<%@ include file="header.jsp"%>
	<h1>Relatório de Usuários</h1>
	<table>
		<thead>
			<tr>
				<th>Login</th>
				<th>Nome</th>
				<th>Senha</th>
				<th>Email</th>
				<th>Permissão</th>
				<th colspan=2>Ação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td><c:out value="${usuario.login}"></c:out></td>
					<td><c:out value="${usuario.nome}"></c:out></td>
					<td><c:out value="${usuario.senha}"></c:out></td>
					<td><c:out value="${usuario.email}"></c:out></td>
					<td><c:out value="${usuario.permissao}"></c:out></td>
					<td><a role="button" class="outline"
						href="UsuarioController?action=editarUsuario&login=<c:out value="${usuario.login}"/>">Editar</a></td>
					<td><a role="button" class="outline secondary"
						href="UsuarioController?action=removerUsuario&login=<c:out value="${usuario.login}"/>">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<a role="button" href="index.jsp">Menu Principal</a>
<%@ include file="footer.jsp"%>
