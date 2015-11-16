angular.module("gerenciador",[]);
		angular.module("gerenciador").controller("painelCtrl", function  ($scope, $http) {

			$scope.titulo = "Aguarde ser chamado";
			$scope.senhas = [];
			$scope.quantidade = 1;

			var intervalo = window.setInterval ( function () {
					$http.get("http://localhost:8080/gerente/todas-as-senhas").success(function (data) {
						if (data == undefined || !data){
							$scope.message = "Não há nimguém na fila";
							$scope.senhas = "";
						}else{
							$scope.message = "";
							$scope.senhas = data;
						}
				}).error(function (data, status) {
					$scope.message = "Aconteceu um problema: " + data;
				});
			}, 1000);
		});	    