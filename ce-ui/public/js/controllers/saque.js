(function() {

	'use strict';

	angular.module('ceApp')
    	.controller('SaqueController', function ($scope, saqueService, caixaEletronicoService, usuarioService) {

    		inicializar();

            function inicializar() {
                $scope.saque = new saqueService();

                $scope.usuarios  = [];
                $scope.caixas    = [];
                $scope.notas     = '';
                $scope.mensagem = '';

                listar();
            };

    		function listar() {
    			usuarioService.query(
    				function(usuarios) {
    					angular.forEach(usuarios, function(value, key){
    						$scope.usuarios.push(value.nome);
    					});
    				}, 
    				function(erro) {
    					console.log(erro);
    				});

    			caixaEletronicoService.query(
    				function(caixas) {
						angular.forEach(caixas, function(value, key){
    						$scope.caixas.push(value.nome);
    					});
    				}, 
    				function(erro) {
    					console.log(erro);
    				});
    		};

            $scope.submeter = function( ) {
                if ($scope.formulario.$valid) {
                $scope.saque.nomeUsuario = $scope.usuario;
                $scope.saque.nomeCaixa = $scope.caixa;

                 $scope.saque.$save()
                    .then(function(notas) {
                       inicializar();
                        $scope.mensagem = 'Saque realizado com sucesso';
                        $scope.notas = notas;
                    }, function(notas) {
                        $scope.notas = notas;
                    });
                }
            };
    });

})();