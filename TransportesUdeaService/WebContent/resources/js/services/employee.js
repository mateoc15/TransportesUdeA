/**
 * Script en el cual se desarrola la logica del negocio para el manejo de los reportes usando angularjs
 * autor:Santiago Ramirez Acevedo- Santiago.ramireza@udea.edu.co

 */


var modulo = angular.module('app');

modulo.service('empleado',function($http){
	
	var url = 'http://localhost:8080/ProyectoTransportesUdeaService/rest/employee';
	
    this.getEmployees = function(){
          return $http.get(url+"/listar");
       }

	this.autenticar = function(usuario,pass){
		var hola = $http({
			method: 'POST',
			url: url+'/login',
			params:{
				user: usuario,
				pass: pass
			}
		});
		return hola;
		
	}
	
    this.crear = function(id,name,lastname,salary,email,pass){
 	   var req = {
 			   method: 'POST',
 			   url: url+'/crear',
 			   params: { 
 				   cedula: id,
 				   nombre: name,
 				   apellidos: lastname,
 				   salario: salary,
 				   email: email,
 				   password : pass
 			          }
 			   }
			return $http(req);
    }
    
    this.actualizar = function(id,email,pass,salary){
  	   var req = {
  			   method: 'POST',
  			   url: url+'/crear',
  			   params: { 
  				   salary: salary,
  				   email: email,
  				   pass : pass,
  				   id: id
  			          }
  			   }
 			return $http(req);
     }
});