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
			.module('DesktopCtrl', [])
			.controller('DesktopCtrl', ['$scope', '$http', '$sce', '$routeParams', '$rootScope', function ($scope, $http, $sce, $routeParams, $rootScope) {
				console.log('DesktopCtrl it work');
				localStorage.setItem("selectedURL", $routeParams.desktopId);
				console.log("selected selectedDesktopId: " + $routeParams.desktopId);
				localStorage.setItem("selectedDesktopId", $routeParams.desktopId);

				// получаем все приложения по desktopId
				$http.get('getApplicationsById/' + $routeParams.desktopId).success(function (data) {
					localStorage.setItem('getApplicationsById', JSON.stringify(data));
					$rootScope.applicationUnits = $scope.applicationUnits = data;
				});

				// получаем все окна по desktopId
				$http.get('getWindowsById/' + $routeParams.desktopId).success(function (data) {
					localStorage.setItem('getWindowsById', JSON.stringify(data));
					$rootScope.windowUnits = $scope.windowUnits = data;
				});








				//
				///**
				// * unit
				// */
				//$scope.allWindow = 0; // общее количество открытых окон
				//
				//$http.get('getApplicationsById/' + $routeParams.desktopId).success(function (data) {
				//	localStorage.setItem('getApplicationsById', JSON.stringify(data));
				//	$rootScope.applicationUnits = $scope.applicationUnits = data;
				//	for (var i = 0; i < $scope.applicationUnits.length; i++) {
				//		$scope.applicationUnits[i].applicationUrl = $sce.trustAsResourceUrl($scope.applicationUnits[i].unitCode);
				//		//$scope.allWindow += $scope.applicationUnits[i].windows.length; // общее количество открытых окон
				//	}
				//	//console.log("ALL FUCKING WINDOWS - ", $scope.allWindow); // общее количество открытых окон
				//});

				// icon
				$scope.iconUpdate = function (unit) {
					unit.unitActive = null;
					$http.post('updateApplicationPosition/', unit).success(function (data) {
						localStorage.setItem('getApplicationsById', JSON.stringify(data));
					});
				};

				$scope.getWindow = function (unit, parentIndex) {

					$scope.allWindow++; // общее количество открытых окон

					$rootScope.applicationUnits[parentIndex].applicationUrl = $sce.trustAsResourceUrl(unit.unitCode);

					$http.post('getwindow/' + unit.unitId, null).success(function (data) {
						console.log(data);
						$rootScope.applicationUnits[parentIndex].windows.push(data);
					});
				};

				$scope.createWindow = function (unitId) {
					//
				};

				$rootScope.updateWindow = function (window) {
					window.isMax = parseInt(window.isMax);
					window.isMin = parseInt(window.isMin);
					$http.post('updatewindow/', window).success(function (data) {
						console.log("good - " + data);
					});
				};
				$scope.deleteWindow = function ($index, $parentIndex, window) {
					$scope.allWindow--; // общее количество открытых окон

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