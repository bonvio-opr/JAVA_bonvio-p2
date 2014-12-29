(function() {
	'use strict';

	angular
			.module('app', [
				//'ngAria',
				'ngRoute',
				//'ngMaterial',
				//'ui.bootstrap',
				'lumx',
				'app.group',
				'app.dataService',
				'app.modalDirective'
			])
			.config(mainRoute);

	mainRoute.$inject = ['$routeProvider', '$locationProvider'];
	function mainRoute($routeProvider, $locationProvider) {
		var partialsPath = '/CM/resources/workspace/group/view';

		$routeProvider
				.when('/', {
					controller: 'groupCtrl',
					templateUrl: partialsPath + '/list.html'
				})
				.when('/view:groupId', {
					controller: 'singleGroupCtrl',
					templateUrl: partialsPath + '/single.html'
				})
				.when('/create', {
					controller: 'createGroupCtrl',
					templateUrl: partialsPath + '/single.html'
				})
				.otherwise({
					redirectTo: '/'
				});
		$locationProvider.html5Mode(false);
	}
})();