/**
 * Created by niko on 05.12.14.
 */
var Gallery = angular.module("Gallery", []);

Gallery.controller("screen", ["$scope", "$http", "$interval", function ($scope, $http, $interval) {
	$scope.init = function () {
		//console.log(localStorage.getItem("imageviewer"));



		var mainImage = JSON.parse(localStorage.getItem("imageviewer"));

		$http.get("/CM/filemanager/getfolderbyparentid/" + mainImage.parentId).success(function (data) {
			$scope.images = [];
			var number = 0;
			data.forEach(function (element, index) {
				if (element.id == mainImage.id) {
					$scope.currentImage = data[index];
					console.log(index);
					$scope.index = number;
				}
				if (element.type == "jpg" || element.type == "png") {
					$scope.images.push(element);
					number++;
				}
			});
		});

		$scope.intervalTime = localStorage.getItem("intervalTime") || 2000;
	};

	$scope.fullImage = false;
	$scope.color = localStorage.getItem("color") || "#fff";
	localStorage.setItem("color", $scope.color);

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

	//$scope.initBG = function () {
	//	$scope.fullImage = false;
	//	$scope.color = localStorage.getItem("color") || "#fff";
	//	localStorage.setItem("color", $scope.color);
	//};

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