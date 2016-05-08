(function() {

	'use strict';

	angular.module('ceApp')
    	.controller('CaixaController', function ($scope, caixaEletronicoService) {

    		inicializar();
            listar();

			function inicializar() {

				$scope.caixa 		= new caixaEletronicoService();
    			$scope.caixas 		= [];
				$scope.mensagem 	= [];

				$scope.nota_cem 		= { nota:100, quantidade: 0 };
				$scope.nota_cinquenta	= { nota:50,  quantidade: 0 };
				$scope.nota_vinte		= { nota:20,  quantidade: 0 };
				$scope.nota_dez			= { nota:10,  quantidade: 0 };

				$scope.notas = [$scope.nota_cem, 
                                $scope.nota_cinquenta, 
                                $scope.nota_vinte, 
                                $scope.nota_dez];

			};
			
    		function listar() {
    			caixaEletronicoService.query(
    				function(caixas) {
						$scope.caixas = caixas;
    				}, 
    				function(erro) {
    					console.log(erro);
    				});
    		};


    		$scope.submeter = function( ) {

                if ($scope.formulario.$valid) {
               	$scope.caixa.notas = $scope.notas;
               	calcularSaldo();
                $scope.caixa.$save()
                    .then(function() {
                        inicializar();
                        $scope.mensagem = 'Usuario Cadastrado com sucesso';
                        listar();
                    }, function(erro) {
                        $scope.mensagem = erro.data.detail;
                    });
                }
    		};

            $scope.editar = function(caixa) {
                $scope.mensagem = '';
                $scope.caixa = caixa;
                $scope.nota_cem.quantidade = $scope.caixa.notas[0].quantidade;
                $scope.nota_cinquenta.quantidade = $scope.caixa.notas[1].quantidade;
                $scope.nota_vinte.quantidade = $scope.caixa.notas[2].quantidade;
                $scope.nota_dez.quantidade = $scope.caixa.notas[3].quantidade;
            };
            $scope.deletar = function(caixa) {
                $scope.caixa.$delete({caixaId:caixa.id})
                    .then(function() {
                        
                    }, function(erro) {
                        $scope.mensagem = erro.data.detail;
                    });
            };

    		function calcularSaldo() {
    			var notasCem 		= $scope.nota_cem.quantidade * $scope.nota_cem.nota;
    			var notasCinquenta 	= $scope.nota_cinquenta.quantidade * $scope.nota_cinquenta.nota;
				var notasCinquenta 	= $scope.nota_cinquenta.quantidade * $scope.nota_cinquenta.nota;
				var notasVinte 		= $scope.nota_vinte.quantidade * $scope.nota_vinte.nota;
				var notasDez		= $scope.nota_dez.quantidade * $scope.nota_dez.nota;

    			$scope.caixa.saldo = notasCem + notasCinquenta + notasVinte + notasDez;
    		};

    });

})();