/**
 * Script en el cual se desarrola la logica del negocio usando angularjs
 * autor:Alejandro Isaza Delgado - alejandro.isazad@udea.edu.co

 */

var modulo = angular.module('app',['ui.router']);


modulo.config(function($stateProvider, $urlRouterProvider){
	$stateProvider
	.state('home',{
		url: '/home',
		templateUrl: '../resources/views/home.html',
		controller: 'HomeController',
		controllerAs : 'home',
		data: {
	        requireLogin: false,
	        employee: true ,
	        user: true 
	      }
	})
	.state('login',{
		url:'/login',
		templateUrl: '../resources/views/login.html',
		controller: 'login',
		data: {
	        requireLogin: false,
	        employee: false ,
	        user: false 
	      }
	})
	.state('register',{
		url:'/register',
		templateUrl: '../resources/views/register.html',
		controller: 'register',
		data: {
	        requireLogin: false,
	        employee: true ,
	        user: true 
	      }
	})
	.state('requiere',{
		url:'/requiere',
		templateUrl: '../resources/views/requiereLogin.html',
		controller: 'login',
		data: {
	        requireLogin: true ,
	        employee: false ,
	        user: true 
	      }
	})
	.state('verReportes',{
		url:'/verReportes',
		templateUrl: '../resources/views/verReportes.html',
		controller: 'reporte',
		data: {
	        requireLogin: true ,
	        employee: true ,
	        user: false 
	      }
	})
	.state('crearReporte',{
		url:'/crearReporte',
		templateUrl: '../resources/views/crearReporte.html',
		controller: 'reporte',
		data: {
	        requireLogin: true ,
	        employee: false ,
	        user: true 
	      }
	})
	.state('detallesReporte',{
		url:'/detallesReporte',
		templateUrl: '../resources/views/detallesReporte.html',
		controller: 'reporte',
		data: {
	        requireLogin: true ,
	        employee: true ,
	        user: false 
	      }
	})
		.state('verReportesUsuario',{
		url:'/verReportesUsuario',
		templateUrl: '../resources/views/verReportesUsuario.html',
		controller: 'reporte',
		data: {
	        requireLogin: true ,
	        employee: false ,
	        user: true 
	      }
	})
	.state('detallesReporteUsuario',{
		url:'/detallesReporteUsuario',
		templateUrl: '../resources/views/detallesReporteUsuario.html',
		controller: 'reporte',
		data: {
	        requireLogin: true ,
	        employee: false ,
	        user: true 
	      }
	})
	.state('profile',{
		url:'/profile',
		templateUrl: '../resources/views/profile.html',
		controller: 'register',
		data: {
	        requireLogin: true ,
	        employee: true ,
	        user: true 
	      }
	});


	$urlRouterProvider.otherwise('/home');
});


modulo.run(function ($rootScope,$state,$window) {

	  $rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
	    var requireLogin = toState.data.requireLogin;
	    
	    
	    var hola = JSON.parse($window.sessionStorage.getItem('currentUser'));
	    if(hola!=null){
	     $rootScope.currentUser = hola;
	    }
	    
	    
	    if (requireLogin) {
			if((typeof $rootScope.currentUser === 'undefined' || $rootScope.currentUser === '')){
			  event.preventDefault();
			  $state.go('login');
			}else{
				if ($rootScope.currentUser.tipo == 'employee' && !toState.data.employee) {
					event.preventDefault();
					  $state.go('login');
				    }
				if ($rootScope.currentUser.tipo == 'user' && !toState.data.user) {
					event.preventDefault();
					  $state.go('login');
				    }
			}
	    }else{
	    	if(!(typeof $rootScope.currentUser === 'undefined' || $rootScope.currentUser === '')){
	    		if ($rootScope.currentUser.tipo == 'employee' && !toState.data.employee) {
					event.preventDefault();
					  $state.go('home');
				    }
				if ($rootScope.currentUser.tipo == 'user' && !toState.data.user) {
					event.preventDefault();
					  $state.go('home');
				    }
				}	
	    }

	
	    
	    if (typeof $rootScope.currentUser === 'undefined' || $rootScope.currentUser === '') {
		      $rootScope.header='offline';
		    }else{
		    	if ($rootScope.currentUser.tipo === 'employee') {
				      $rootScope.header='employee';
				    }else{
				      $rootScope.header='user';
				    }
		    }
	  });
	  
	  $rootScope.logout = function(){
		  $window.sessionStorage.removeItem('currentUser');
		  $rootScope.currentUser = '';
		  $state.go('login');
		  //$rootScope.header=true;
	  }

 });

    
