/**
 * Script en el cual se desarrola la logica del negocio para registrar y actualizar un empleado o un usuario usando angularjs
 * autor:Cristian Camilo Isaza - cristiac.isaza@udea.edu.co

 */

var modulo = angular.module('app');

modulo.controller('register',  function($rootScope,$scope,$state,usuario,empleado) {
	

    $scope.update = function(){

		var email = $scope.emailUpdate;
		var pass = $scope.passUpdate;
		var phone = $scope.phoneUpdate;
		var city = $scope.cityUpdate;
		var salary = $scope.salaryUpdate;
		var id = $rootScope.currentUser.id;
    
    	if($rootScope.currentUser.tipo == 'employee' ){
    		if(email ==null && pass ==null && salary ==null || email =='' && pass =='' && salary ==''){
			    $scope.resultado = 'debe llenar algun campo';
    		}else{
    			empleado.actualizar(id,email,pass,salary).success(function (data){
    				$scope.resultado = data;
    				$state.go('profile');
    			});
    		}
    	}else{
    		if(email ==null && pass ==null && phone ==null && city ==null || email =='' && pass =='' && phone =='' && city ==''){
    			    $scope.resultado = 'debe llenar algun campo';
        		}else{
        			usuario.actualizar(id,email,pass,phone,city).success(function (data){
        				$scope.resultado = data;
        				$state.go('profile');
        			});
        		}
    	}
     
    }
	
	
	$scope.register = function(){
		    var cedula = $scope.id;
			var name = $scope.name;
			var lastname = $scope.lastname;
			var email = $scope.email;
			var pass = $scope.pass;
			var phone = $scope.phone;
			var city = $scope.city;
			var salary = $scope.salary;
			var type = $scope.type;
			
			console.log(name);
			console.log(lastname);
			console.log(cedula);
			
            if (type == 'employee'){
	        	empleado.crear(cedula,name,lastname,salary,email,pass).success(function(data){
	        		if(data != ''){
	        			if(data.estado == 'true'){
	        				$state.go('login');
	        			}else{
	        				$scope.resultado = data.dato;
	        			}
                       console.log(data);
	        		}
	        	});
            }else{
	        	usuario.crear(cedula,name,lastname,phone,city,email,pass).success(function(data){
	        		if(data != ''){
	        			if(data.estado == 'true'){
	        				$state.go('login');
	        			}else{
	        				$scope.resultado = data.dato;
	        			}
	        		   console.log(data);
	        		}
	        	});
            }
        };
               
});

