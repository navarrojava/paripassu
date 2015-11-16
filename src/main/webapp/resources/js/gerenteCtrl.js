	angular.module("gerenciador",[]);
		angular.module("gerenciador").controller("gerenteCtrl", function  ($scope, $http) {

			$scope.titulo = "Painel de senhas";
			$scope.senhas = [];
			$scope.quantidade = 1;
			$scope.teste = [];
			
			var intervalo = window.setInterval ( function () {
				$http.get("http://localhost:8080/gerente/todas-as-senhas").success(function (data) {
					if (!data){
						$scope.message = "Não há ninguém na fila";
						$scope.senhas = [];
					}else{
						$scope.message = "";
						$scope.senhas = data;
					}
			}).error(function (data, status) {
				$scope.message = "Aconteceu um problema: " + data;
			});
		}, 1000);

			$scope.proximaSenha = function() {
					$http.get("http://localhost:8080/gerente/proxima-senha").success(function (data) {
						if (!data){
							$scope.teste = "Não há ninguém na fila";
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
				$scope.message = "Painel zerado com sucesso";
			}).error(function (data, status) {
				$scope.message = "Aconteceu um problema: " + data;
			});
		}
	});	   