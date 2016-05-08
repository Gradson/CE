(function() {

	'use strict';

	angular.module('meusServicos')
	    .factory('saqueService', ['$resource', function ($resource) {

	        return $resource('http://localhost:9002/ce-core/api/saque/:params', {}, {
	        	'update': {
	        		method: "PUT"
	        	}
	        });

	    }]);

})();