/**
 * Script en el cual se desarrola la logica del negocio para el manejo de los reportes usando angularjs
 * autor:Santiago Ramirez Acevedo- Santiago.ramireza@udea.edu.co

 */

var modulo = angular.module('app');


modulo.controller('reporte', function($rootScope,$scope,$state,reporte) {
	

        
        $scope.detalles = function(report){
        	if($rootScope.currentUser.tipo == 'employee'){
        	   $state.go('detallesReporte');
 	           $rootScope.report = report; 
        	}else{
	           $state.go('detallesReporteUsuario');
	           $rootScope.report = report;  
            }
        };
        
        $scope.actualizar = function(){
            reporte.actualizar($rootScope.report.id,$rootScope.currentUser.id,$scope.response).success(function (data){
                $state.go('verReportes');
            });
            
         };
         
        $scope.crear = function(){
        	var description = $scope.description;
        	var type = $scope.type;
        	var id = $rootScope.currentUser.id;
        	reporte.crear(description,type,id).success(function (data){
        		console.log(data);
        		$state.reload();
        		$scope.resultado = data;
        	});
        };
        
    	$scope.lista = [];
        if($rootScope.currentUser.tipo == 'employee'){
    	reporte.getReports().success(function (data){
    		$scope.lista = data;
    		if(data != null){
    			if(data.reporte.id){
      				size = 1;
      				}else{
  	    		    var size = Object.keys(data.reporte).length;
      				}
	             
	    		if(size > 1){
	    			    $scope.lista = data.reporte;
		    		    $scope.lista.forEach(function myFunction(item) {
		    			if(item.reportType.localeCompare('Peticion') == 0){
		    				item.class = 'success';
		    			}  
		    			if(item.reportType.localeCompare('Queja') == 0){
		    				item.class = 'danger';
		    			}  
		    			if(item.reportType.localeCompare('Reclamo') == 0){
		    				item.class = 'warning';
		    			}  
		    			if(item.reportType.localeCompare('Solicitud') == 0){
		    				item.class = 'info';
		    			}  
		    			var fecha = new Date(item.createDate);
		    			var fecha2 = fecha.toDateString();
		    			item.createDate = fecha2;
		    		    });
	    		}else{
	    			    $scope.lista = data;
		    			if($scope.lista.reporte.reportType.localeCompare('Peticion') == 0){
		    				$scope.lista.reporte.class = 'success';
		    			}  
		    			if($scope.lista.reporte.reportType.localeCompare('Queja') == 0){
		    				$scope.lista.reporte.class = 'danger';
		    			}  
		    			if($scope.lista.reporte.reportType.localeCompare('Reclamo') == 0){
		    				$scope.lista.reporte.class = 'warning';
		    			}  
		    			if($scope.lista.reporte.reportType.localeCompare('Solicitud') == 0){
		    				$scope.lista.reporte.class = 'info';
		    			}  
		    			var fecha = new Date($scope.lista.reporte.createDate);
		    			var fecha2 = fecha.toDateString();
		    			$scope.lista.reporte.createDate = fecha2;
	    		}
    		}else{$scope.vacio = true;}
    	});
      }else{
    	  reporte.getReportsbyUser($rootScope.currentUser.id).success(function (data){
      		$scope.lista = data;
      		if(data != null){
      			if(data.reporte.id){
      				size = 1;
      				}else{
  	    		    var size = Object.keys(data.reporte).length;
      				}
  	    		if(size > 1){
  	    			    $scope.lista = data.reporte;
  		    		    $scope.lista.forEach(function myFunction(item) {
  		    			if(item.reportType.localeCompare('Peticion') == 0){
  		    				item.class = 'success';
  		    			}  
  		    			if(item.reportType.localeCompare('Queja') == 0){
  		    				item.class = 'danger';
  		    			}  
  		    			if(item.reportType.localeCompare('Reclamo') == 0){
  		    				item.class = 'warning';
  		    			}  
  		    			if(item.reportType.localeCompare('Solicitud') == 0){
  		    				item.class = 'info';
  		    			}  
  		    			var fecha = new Date(item.createDate);
  		    			var fecha2 = fecha.toDateString();
  		    			item.createDate = fecha2;
  		    		    });
  	    		}else{
  	    			    $scope.lista = data;
  		    			if($scope.lista.reporte.reportType.localeCompare('Peticion') == 0){
  		    				$scope.lista.reporte.class = 'success';
  		    			}  
  		    			if($scope.lista.reporte.reportType.localeCompare('Queja') == 0){
  		    				$scope.lista.reporte.class = 'danger';
  		    			}  
  		    			if($scope.lista.reporte.reportType.localeCompare('Reclamo') == 0){
  		    				$scope.lista.reporte.class = 'warning';
  		    			}  
  		    			if($scope.lista.reporte.reportType.localeCompare('Solicitud') == 0){
  		    				$scope.lista.reporte.class = 'info';
  		    			}  
  		    			var fecha = new Date($scope.lista.reporte.createDate);
  		    			var fecha2 = fecha.toDateString();
  		    			$scope.lista.reporte.createDate = fecha2;
  	    		}
      		}else{$scope.vacio = true;}
      	}); 
      }
});

