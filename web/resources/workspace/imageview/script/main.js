/**
 * Created by niko on 05.12.14.
 */
var Gallery = angular.module("Gallery", []);

Gallery.controller("screen", ["$scope", "$http", "$interval", function ($scope, $http, $interval) {
	$scope.init = function (galleryName) {
		$http.post("files/" + galleryName + ".json").success(function (data) {
			$scope.images = data;
			$scope.currentImage = $scope.images[0];
			$scope.index = 0;
		});
		$scope.intervalTime = localStorage.getItem("intervalTime") || 2000;
	};

	$scope.update = function () {
		$scope.currentImage = $scope.images[$scope.index];
	};

	$scope.prevImage = function () {
		$scope.index = ($scope.index > 0) ? $scope.index - 1 : $scope.images.length - 1;
		$scope.update();
	};

	$scope.nextImage = function () {
		$scope.index = ($scope.index < $scope.images.length - 1) ? $scope.index + 1 : 0;
		$scope.update();
	};

	$scope.slideShow = function (action, intervalTime) {
		$scope.intervalTime = intervalTime || localStorage.getItem("intervalTime") || 2000;
		localStorage.setItem("intervalTime", $scope.intervalTime);
		switch (action) {
			case "change":
			case "stop":
				$interval.cancel($scope.interval);
				$scope.interval = null;
				if (action == "stop") break;
			case "start":
				$scope.interval = $interval(function() {
					$scope.nextImage();
				}, $scope.intervalTime);
				break;
		}
	};

	$scope.initBG = function () {
		$scope.fullImage = false;
		$scope.color = localStorage.getItem("color") || "#fff";
		localStorage.setItem("color", $scope.color);
	};

	$scope.changeBG = function () {
		$scope.color = ($scope.color == "#fff") ? "#000" : "#fff";
		localStorage.setItem("color", $scope.color);
	}

	$scope.useAsBackground = function () {
		console.log($scope.currentImage);
	};

	$scope.keyPress = function ($event) {
		switch ($event.keyCode) {
			case 37:
				$scope.prevImage();
				break;
			case 39:
				$scope.nextImage();
				break;
		}
	};
}]);

Gallery.directive("ngChangeModel", function () {
	return {
		restrict: "A",
		require: "ngModel",
		link: function (scope, element, attrs, ngModel) {
			element.on("change", function () {
				scope.$apply(function () {
					//console.log(ngModel.$viewValue);
					//console.log(ngModel.$modelValue);
				});
			});
		}
	};
});