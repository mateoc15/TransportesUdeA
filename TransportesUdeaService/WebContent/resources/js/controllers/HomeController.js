/**
 * Script en el cual se desarrola la logica del negocio usando angularjs
 * autor:Alejandro Isaza Delgado - alejandro.isazad@udea.edu.co

 */

var modulo = angular.module('app');

modulo.controller('HomeController', ['$scope','usuario', function($scope,usuario) {
     
		$scope.lista = [];
	
//		usuario.getUsers().then(function (data){
//			$scope.lista = data.data.usuario;
//		});

}]);
