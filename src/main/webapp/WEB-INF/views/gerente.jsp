


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html ng-app="navarro">
<head>
	<%@ page contentType="text/html; charset=UTF-8"%>
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value="/resources/css/custom.css" /> " /> 

  	
  	<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
	
	<script type="text/javascript">
		angular.module("navarro",[]);
		angular.module("navarro").controller("navarroCtrl", function  ($scope, $http) {

			$scope.titulo = "Senha Atual:";
			$scope.senhas = [];
			$scope.quantidade = 1;
			$scope.teste = [];
			


			//var intervalo = window.setInterval(carregarSenhas, 2000);
		
			$scope.proximaSenha = function() {
					$http.get("http://localhost:8080/gerente/proxima-senha").success(function (data) {
						if (data == undefined || !data){
							$scope.teste = "Não Há Nimgem Na Fila";
							$scope.teste = "";

						}else{
							$scope.teste = "";
							$scope.teste = data;

						}
				}).error(function (data, status) {
					$scope.message = "Aconteceu um problema: " + data;
				});
			}
			
			$scope.zerarSenhas = function() {
				$http.get("http://localhost:8080/gerente/zerar-contador").success(function (data) {
					$scope.message = "Painel Zerado com sucesso";

			}).error(function (data, status) {
				$scope.message = "Aconteceu um problema: " + data;
			});
		}

			
		});	    

		

	</script>

	
	<title>Angular JS @Navarro</title>

</head>
	
	<body ng-controller="navarroCtrl">
	
	
    
    <div class="jumbotron">
    	<div> <h2>{{titulo}}</h2> </div>
    	     {{message}}

     <table class="table table-striped">
  <tr>
       
        <th>Senha Atual:</th>
  </tr>
  <tr ng-repeat="senha in senhas | limitTo:quantidade">
  	    	
	
	<!--	<td ng-repeat="(key, value) in contato"> {{value}} </td> -->
  	
  		
  		<td class="form-control">{{senha.mascaraSenha}}</td>
 
  </tr>
      </table>

  			<button class="btn form-control btn-primary btn-lg" ng-click="proximaSenha()">Próxima Senha</button>
			<button class="btn form-control btn-primary btn-lg" ng-click="zerarSenhas()">Zerar contador Senhas</button>


    </div>
</body>
</html>



















 