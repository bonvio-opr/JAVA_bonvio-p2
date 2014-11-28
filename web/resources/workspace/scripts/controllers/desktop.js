define([
		'angular'
	],
	function (angular) {
		'use strict';

		/**
		 * @ngdoc function
		 * @name DesktopCtrl
		 * @description
		 * # DesktopCtrl
		 * Controller of the generatorAngularRequireApp
		 */
		angular
			.module('DesktopCtrl', [
				'winDirective'

			])
			.controller('DesktopCtrl', ['$scope', '$http', '$sce', '$routeParams', '$rootScope', function ($scope, $http, $sce, $routeParams, $rootScope) {
				console.log('DesktopCtrl it work');

				localStorage.setItem("selectedURL", $routeParams.desktopId);

				console.log("selected selectedDesktopId: " + $routeParams.desktopId);

				localStorage.setItem("selectedDesktopId", $routeParams.desktopId);


				/**
				 * unit
				 */

				$http.get('getApplicationsById/' + $routeParams.desktopId).success(function (data) {
					localStorage.setItem('getApplicationsById', JSON.stringify(data));
					$scope.applicationUnits = data;
					console.log(data);

					$rootScope.applicationUnits = data;
				});

				// icon
				$scope.iconUpdate = function (unit) {
					delete unit.unitActive;
					$http.post('updateApplicationPosition/', unit).success(function (data) {
						localStorage.setItem('getApplicationsById', JSON.stringify(data));
					});
				};

				$scope.getWindow = function (unit) {
					$scope.applicationUrl = $sce.trustAsResourceUrl(unit.unitCode);

					$http.post('getwindow/' + unit.unitId, null).success(function (data) {
						console.log(data);
						$rootScope.applicationUnits[unit.unitId].windows.push(data);
					});
				};

				$rootScope.updateWindow = function (window) {
					window.isMax = parseInt(window.isMax);
					window.isMin = parseInt(window.isMin);
					$http.post('updatewindow/', window).success(function (data) {
						console.log("good - " + data);
					});
				};
				$scope.deleteWindow = function ($index, $parentIndex, window) {
					$rootScope.applicationUnits[$parentIndex].windows.splice($index, 1); // удаление на клиенте
					// удаление на сервере
					var data = {};
					data.windowId = window.windowId;
					$http.post('deletewindow/', data).success(function (data) {
						console.log("good - " + data);
					});
				};
			}]);

	});