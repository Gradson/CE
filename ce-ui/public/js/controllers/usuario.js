(function() {

	'use strict';

	angular.module('ceApp')
    	.controller('UsuarioController', function ($scope, usuarioService) {

    		$scope.usuario   = new usuarioService();
    		$scope.usuarios  = [];
    		$scope.mensagem = '';

    		listar();

    		function listar() {
    			usuarioService.query(
    				function(usuarios) {
						$scope.usuarios = usuarios;
    				}, 
    				function(erro) {
    					console.log(erro);
                        $scope.mensagem = erro.data.detail
    				});
    		};

    		$scope.submeter = function( ) {
                if ($scope.formulario.$valid) {
                $scope.usuario.$save()
                    .then(function() {
                        $scope.usuario  = new usuarioService();
                        $scope.mensagem = 'Usuario Cadastrado com sucesso';
                        todos();
                    }, function(erro) {
                        $scope.mensagem = erro.data.detail;
                    });
                }
    		};

            $scope.editar = function(usuario) {
                $scope.mensagem = usuario;
                $scope.usuario = usuario;
            };
            $scope.deletar = function(usuario) {
                $scope.usuario.$delete({usuarioId:usuario.id})
                    .then(function(){

                    })
                    .catch(function(erro){
                        $scope.mensagem=erro.data.detail;
                    });
            };

    });

})();