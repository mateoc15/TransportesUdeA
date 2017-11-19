/**
 * Script en el cual se desarrola la logica del negocio en la que se autentica un usuario o un empleado usando angularjs
 * autor:Alejandro Isaza Delgado - alejandro.isazad@udea.edu.co

 */

var modulo = angular.module('app');

modulo.controller('login',  function($window,$rootScope,$scope,$state,empleado,usuario) {

	
    var userData = '';
    var employeeData = '';
    
	$scope.autenticar = function(){
            var user = $scope.usuario;
            var pass = $scope.pass;
            var primero = 'false';
        	empleado.autenticar(user,pass).success(function(data){
        		if(data != ''){
        		   employeeData = data;
	        		if (!(userData == '' || employeeData == '')){
	        			   if(primero == 'false'){
				        	   if (employeeData.estado === 'false' && userData.estado === 'false' ){
				        			$scope.resultado = data.dato;
				        			$scope.usuario =  "";
				        			$scope.pass = "";
				        		}else{
				        			if(employeeData.estado === 'true'){
						           		$window.sessionStorage.setItem('currentUser', JSON.stringify(employeeData));
						           		$rootScope.currentUser = data;
						           		$state.go('home');
					           		}else{
						           		$window.sessionStorage.setItem('currentUser', JSON.stringify(userData));
						           		$rootScope.currentUser = data;
						           		$state.go('home');
					           		}
				        		}
		        			   console.log(userData);
		        			   console.log(employeeData);
		        			   primero = 'true';
	        		   }
        		   }
	        		
        		}
        	});
        	usuario.autenticar(user,pass).success(function(data){
        		if(data != ''){
                   userData = data;
                   if (!(userData == '' || employeeData == '')){
                	   if(primero == 'false'){
				           if (employeeData.estado === 'false' && userData.estado === 'false' ){
				           		$scope.resultado = data.dato;
				           		$scope.usuario =  "";
				           		$scope.pass = "";
				           	}else{
				           		if(employeeData.estado === 'true'){
					           		$window.sessionStorage.setItem('currentUser', JSON.stringify(employeeData));
					           		$rootScope.currentUser = data;
					           		$state.go('home');
				           		}else{
					           		$window.sessionStorage.setItem('currentUser', JSON.stringify(userData));
					           		$rootScope.currentUser = data;
					           		$state.go('home');
				           		}
			
				           	}
	                	   console.log(userData);
	        			   console.log(employeeData);
	        			   primero = 'true';
                       }
                   }
        		}
        	});
        	 
        };
               
});
