angular.module("gerenciador",[]);
		angular.module("gerenciador").controller("clienteCtrl", function  ($scope, $http) {
			
			$scope.titulo = "Retire sua senha";
			$scope.senhas = [];
			$scope.quantidade = 1;
			$scope.teste = [];
			$scope.possuiSenha = false;
			
			$scope.minhaSenha = JSON.parse(localStorage.getItem("senha"));
			$scope.verificaSeFuiChamado = function(){
				 if   ( JSON.stringify(localStorage.getItem("senha")).length > 0 && localStorage.getItem("senha")) {
						$scope.minhaSenha = JSON.parse(localStorage.getItem("senha"));
				   } else {
					$scope.minhaSenha =   {
						   "id": 0,
						   "numero": 1,
						   "tipoSenha": "GERAL",
						   "mascaraSenha": "A0000"
						 }
				   }
	        		$http.post("http://localhost:8080/cliente/verifica-se-fui-chamado",$scope.minhaSenha).success(function(data, status){
	        			if (data.id == 0 ) {
							   $scope.minhaSenha.mascaraSenha = "A0000";
	        			}
				}).error(function(data, status){
			});
		};
			
			var intervalo = window.setInterval ( function () {
				$http.get("http://localhost:8080/gerente/todas-as-senhas").success(function (data) {
					if (data == undefined || !data){
						$scope.message = "Não há nimguém na fila";
						$scope.senhas = "";
						$scope.minhaSenha.mascaraSenha = "A0000";
						$scope.possuiSenha = false;
					}else{
						$scope.message = "";
						$scope.senhas = data;
					}
			}).error(function (data, status) {
				$scope.message = "Aconteceu um problema: " + data;
			});
		}, 1000);
			
			$scope.solicitarSenha = function(tipoSenha) {
				$http.get("http://localhost:8080/cliente/solicitar-senha?tipo="+tipoSenha).success(function (data) {
					$scope.minhaSenha = data;
					$scope.possuiSenha = true;
					localStorage.setItem("senha", JSON.stringify($scope.minhaSenha));
					$scope.teste = localStorage.getItem("senha");

			}).error(function (data, status) {
				$scope.message = "Aconteceu um problema: " + data;
			});
   		}
	});	    