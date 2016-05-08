angular.module('ceApp', ['minhasDiretivas','ngAnimate', 'ngRoute', 'ngResource', 'meusServicos'])
	.config(function($routeProvider, $locationProvider) {

		$locationProvider.html5Mode(true);

		$routeProvider.when('/principal', {
			templateUrl: 'partials/principal.html',
			controller: 'SaqueController'
		});

		$routeProvider.when('/usuario', {
			templateUrl: 'partials/usuario.html',
			controller: 'UsuarioController'
		});

		$routeProvider.when('/caixa', {
			templateUrl: 'partials/caixa.html',
			controller: 'CaixaController'
		});

		$routeProvider.otherwise({redirectTo: '/principal'});

	});