<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de gerenciamento de senhas</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet" href="<c:url value="/resources/css/custom.css" />" />
</head>
<body>
	<div class="jumbotron">
		<h2>Seja Bem vindo </h2>
		<h4>Sistema de gerenciamento de senhas</h4>
		<p>
		  	<a class="btn btn-primary btn-block" href="painel/home" role="button">Painel Público</a>
			<a class="btn btn-primary btn-block" href="gerente/home" role="button">Painel Gerente</a>
		</p>
	</div>
</body>
</html>