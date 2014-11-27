define(['angular'], function (angular) {
	'use strict';

	/**
	 * @ngdoc function
	 * @name MainCtrl
	 * @description
	 * # MainCtrl
	 * Controller of the p2DashboardApp
	 */
	angular.module('MainCtrl', [])

		.controller('MainCtrl', ['$scope', '$location', '$http', '$sce', '$routeParams', "$rootScope", function ($scope, $location, $http, $sce, $routeParams, $rootScope) {

			$rootScope.applicationUnits = null;
			$rootScope.updateWindow = null;

			console.log('MainCtrl it work');

		}]).directive("toggleMenu", [function () {
			return {
				restrict: "A",
				link: function (scope, element, attribute) {
					element.on("mousedown", function (event) {
						if (event.target.classList.contains("menu_trigger")) {
							scope.$apply(function () {
								scope.showMenu = !scope.showMenu;
							});
						} else {
							scope.$apply(function () {
								scope.showMenu = false;
							});
						}
					});
				}
			};
		}]);// endMainCtrl

});