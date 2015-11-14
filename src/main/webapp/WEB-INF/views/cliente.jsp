
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value="/resources/css/custom.css" />"/> 
	

</head>
<body>


	<div class="jumbotron">
		<h1>Bem Vindo Ao Banco </h1>
		<p>...</p>
		<p>
			<a class="btn form-control btn-primary btn-lg" href="painel/home" role="button">Painel Publico</a>
			<a class="btn form-control btn-primary btn-lg" href="gerente/home" role="button">Gerente</a>
		</p>
	</div>




</body>
</html>