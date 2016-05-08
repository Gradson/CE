(function() {

	'use strict';

	angular.module('meusServicos')
	    .factory('usuarioService', ['$resource', function ($resource) {

	        return $resource('http://localhost:9001/ce-crud/api/usuario/:params', {}, {});

	    }]);

})();