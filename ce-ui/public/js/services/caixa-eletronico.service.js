(function() {

	'use strict';

	angular.module('meusServicos')
	    .factory('caixaEletronicoService', ['$resource', function ($resource) {

	        return $resource('http://localhost:9001/ce-crud/api/caixa-eletronico/:params', {}, {});

	    }]);

})();