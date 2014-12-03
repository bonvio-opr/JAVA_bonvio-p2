define([
	'angular',
	'directives/winDirective',
	'directives/updateCoord'
], function (angular) {
	'use strict';

	/**
	 * @ngdoc function
	 * @name MainCtrl
	 * @description
	 * # MainCtrl
	 * Controller of the p2DashboardApp
	 */
	angular.module('MainCtrl', [
		'winDirective',
		'updateCoord'
	])

		.controller('MainCtrl', ['$scope', '$location', '$http', '$sce', '$routeParams', "$rootScope", function ($scope, $location, $http, $sce, $routeParams, $rootScope) {

			$rootScope.applicationUnits = null;
			$rootScope.updateWindow = null;

			console.log('MainCtrl it work');

			$scope.$on('ngRepeatFinished', function(scope, element, attrs){
				alert("FINISH");
			});

		}]);// endMainCtrl

});