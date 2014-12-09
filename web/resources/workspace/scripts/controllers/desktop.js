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
			.controller('DesktopCtrl', ['$scope', '$http', '$sce', '$routeParams', '$rootScope', '$window', function ($scope, $http, $sce, $routeParams, $rootScope, $window) {
				console.log('DesktopCtrl it work');
				localStorage.setItem("selectedURL", $routeParams.desktopId);
				console.log("selected selectedDesktopId: " + $routeParams.desktopId);
				localStorage.setItem("selectedDesktopId", $routeParams.desktopId);

				// получаем все приложения по desktopId
				$http.get('getApplicationsById/' + $routeParams.desktopId).success(function (data) {
					localStorage.setItem('getApplicationsById', JSON.stringify(data));
					$rootScope.applicationUnits = $scope.applicationUnits = data;
				});

				$scope.maxZIndex = 10;

				// получаем все окна по desktopId
				$http.get('getWindowsById/' + $routeParams.desktopId).success(function (data) {
					localStorage.setItem('getWindowsById', JSON.stringify(data));
					for (var i = 0; i < data.length; i++) {
						data[i].zIndex = $scope.maxZIndex++;
					}

					$rootScope.windowUnits = $scope.windowUnits = data;
					if (parseInt(data.length || 0) > 0) {
						$scope.maxZIndex = ($scope.windowUnits[$scope.windowUnits.length - 1].zIndex) + 1;
					}
					//console.log(windowUnits);
					//console.log($scope.maxZIndex);
					//console.log(data);
				});

				window.addEventListener("message", listener);
				function listener(event) {
					event.data.window.zIndex = $scope.maxZIndex++;
					$scope.windowUnits.push(event.data.window);

					//IMAGE
					var data = {id: event.data.file.id, parentId: event.data.file.parentId};
					localStorage.setItem("imageviewer", JSON.stringify(data));







					//window.top.postMessage(bigData, "*");
					//console.log();

					//$window.$apply(function () {
					//	console.log($window.top.frames['imageview']);
					//	//console.log('1', window.top.frames['imageview']);
					//});
				}








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
					$http.post('updateApplicationPosition/', unit).success(function (data) {
						localStorage.setItem('getApplicationsById', JSON.stringify(data));
					});
				};

				//$scope.getWindow = function (unit, parentIndex) {
                //
				//	$scope.allWindow++; // общее количество открытых окон
                //
				//	$rootScope.applicationUnits[parentIndex].applicationUrl = $sce.trustAsResourceUrl(unit.unitCode);
                //
				//	$http.post('getwindow/' + unit.unitId, null).success(function (data) {
				//		console.log(data);
				//		//$rootScope.applicationUnits[parentIndex].windows.push(data);
				//	});
				//};

				// ОКОШКИ
				$scope.createWindow = function (unitId) {
					$http.post('getwindow/' + parseInt(unitId), null).success(function (data) {
						data.zIndex = $scope.maxZIndex++;
						$scope.windowUnits.push(data);
						//$rootScope.applicationUnits[parentIndex].windows.push(data);
					});
				};
				$scope.deleteWindow = function (windowId, $index) {
					$http.post('deletewindow/', {windowId: windowId}).success(function (data) {
						$scope.windowUnits.splice($index, 1);
					});
				};





				$rootScope.updateWindow = function (window) {
					console.log("ТОЧКА!");
					window.isMax = parseInt(window.isMax);
					window.isMin = parseInt(window.isMin);
					$http.post('updatewindow/', window).success(function (data) {
						console.log("good - " + data);
					});
				};

			}]);
	});