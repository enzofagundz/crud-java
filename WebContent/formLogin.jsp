
<%
request.setAttribute("title", "Login");
%>
<%@ include file="header.jsp"%>
<h1>Login</h1>
<form action="/AppProduto/Login" method="post">
	<fieldset>
		<label for="login">Usuário:</label><input type="text" id="login"
			name="login" value="${loginform}" /><label for="senha">Senha:</label><input
			type="password" id="senha" name="senha">
			<input role="button"
			type="submit" value="Entrar">
	</fieldset>
</form>
<%@ include file="footer.jsp"%>