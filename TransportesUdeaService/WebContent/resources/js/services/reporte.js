/**
 * Script en el cual se desarrola la logica del negocio usando angularjs
 * autor:Alejandro Isaza Delgado - alejandro.isazad@udea.edu.co

 */


var modulo = angular.module('app');

modulo.service('reporte',function($http){
	
	var url = 'http://localhost:8080/ProyectoTransportesUdeaService/rest/report'
       
	   this.getReports = function(){
          return $http.get(url+"/listar");
       }
	
		this.getReportsbyUser = function(id){
			var req = {
	    			   params: { 
	    				         user: id
	    				       }
	    			  }
	        return $http.get(url+"/listarUser",req);
	     }

       this.actualizar = function(id,employee,response){
    	   var req = {
    			   method: 'PUT',
    			   url: url+'/actualizar',
    			   params: { 
    				         id: id,
    				         employee: employee,
    				         response: response
    				       }
    			  }
    	   console.log('servicio');
    	   console.log(id);
    	   console.log(employee);
    	   console.log(response);
			return $http(req);
       }
       
       this.crear = function(description,reportType,user){
    	   var req = {
    			   method: 'POST',
    			   url: url+'/crear',
    			   params: { 
    				   description: description,
    				   reportType: reportType,
    				   user: user
    			          }
    			   }
			return $http(req);
       }

});