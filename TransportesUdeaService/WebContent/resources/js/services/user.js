/**
 * Script en el cual se desarrola la logica del negocio para registrar y actualizar un empleado o un usuario usando angularjs
 * autor: Santiago Ramirez Acevedo- Santiago.ramireza@udea.edu.co

 */

var modulo = angular.module('app');

modulo.service('usuario',function($http){
	
	var url = 'http://localhost:8080/ProyectoTransportesUdeaService/rest/user'
       
	   this.getUsers = function(){
          return $http.get(url+"/listar");
       }

       this.autenticar = function(email,pass){
    	   var req = {
    			   method: 'POST',
    			   url: url+'/login',
    			   params: { user: email , pass: pass }
    			  }
    	   
			return $http(req);
       }
       
       this.crear = function(id,name,lastname,phone,city,email,pass){
    	   var req = {
    			   method: 'POST',
    			   url: url+'/crear',
    			   params: { 
    				   cedula: id,
    				   nombre: name,
    				   apellidos: lastname,
    				   phone : phone,
    				   city : city,
    				   email: email,
    				   password : pass
    			          }
    			   }
			return $http(req);
       }
       
       this.actualizar = function(id,email,pass,phone,city){
    	   var req = {
    			   method: 'PUT',
    			   url: url+'/actualizar',
    			   params: { 
    				   phone : phone,
    				   city : city,
    				   email: email,
    				   pass : pass,
    				   id : id
    			          }
    			   }
			return $http(req);
       }

});