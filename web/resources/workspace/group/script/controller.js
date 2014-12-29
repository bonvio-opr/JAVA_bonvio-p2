(function () {
	'use strict';

	angular
			.module('app.group', [])
			.controller('groupCtrl', groupCtrl)
			.controller('singleGroupCtrl', singleGroupCtrl)
			.controller('createGroupCtrl', createGroupCtrl)
			.controller('updateGroupCtrl', updateGroupCtrl);

	// список всех групп
	groupCtrl.$inject = ['$scope', 'dataService', 'LxDialogService'];
	function groupCtrl($scope, dataService, LxDialogService) {
		dataService.getGroups(function (data) {
			$scope.groups = {};
			data.forEach(function(item) {
				$scope.groups[item.groupId] = item;
			});
		});

		$scope.openDialog = function(dialogId, groupId) {
			LxDialogService.open(dialogId);
			$scope.groupId = groupId;
		};

		$scope.deleteGroup = function () {
			dataService.deleteGroup($scope.groupId, function() {
				delete $scope.groups[$scope.groupId];
			});
		};
	}

	// просмотр конкретной группы
	singleGroupCtrl.$inject = ['$scope', 'dataService', '$routeParams'];
	function singleGroupCtrl($scope, dataService, $routeParams) {
		$scope.disableEdit = true;
		$scope.title = "Просмотр группы";

		dataService.getGroup($routeParams.groupId, function (data) {
			$scope.item = data;
		});
	}

	// создание новой группы
	createGroupCtrl.$inject = ['$scope', 'dataService', '$location'];
	function createGroupCtrl($scope, dataService, $location) {
		$scope.title = "Создание группы";
		$scope.finishButton = "Создать";

		$scope.modifyGroup = function (item) {
			item.groupPicturePath = $scope.image;

			dataService.createGroup(item, function() {
				console.log("СОЗДАЛ!!!");
				$location.path("#/");
			});
		};

		$scope.upload = function(e) {
			console.log(e);
			$scope.image = e;
		};
	}

	// редатирование группы
	updateGroupCtrl.$inject = ['$scope', 'dataService', '$routeParams'];
	function updateGroupCtrl($scope, dataService, $routeParams) {
		$scope.disableEdit = false;

		dataService.getGroup($routeParams.groupId, function (data) {
			$scope.item = data;
		});

		$scope.title = "Редактирование группы";
		$scope.finishButton = "Сохранить";

		$scope.modifyGroup = function (item) {
			item.groupPicturePath = $scope.image;
			//dataService.createGroup(item, function() {
			//	console.log('created!1');
			//});
		};

		$scope.upload = function(e) {
			console.log(e);
			$scope.image = e;
		};
	}
})();


//Groups.controller("groupsPage", ["$scope", "$http", function ($scope, $http) {
//
//    $scope.items = 'Группы';
//
//
//    $scope.createGroup = function () {
//        var data = {};
//        data.groupName = $scope.groupName;
//        data.groupShortName = $scope.groupShortName;
//        data.groupInfo = $scope.groupInfo;
//
//        $http.post("/CM/group/createGroup", data).success(function (data) {
//            console.log("Group created");
//        });
//    };
//
//    $scope.searchGroup = function () {
//        var data = $scope.groupNameSearch;
//        $http.post("/CM/group/searchByName/" + data).success(function (data) {
//            $scope.groups = data;
//        });
//    };
//
//    $scope.deleteGroup = function (groupId) {
//        var data = groupId;
//        $http.post("/CM/group/deletegroup/" + groupId).success(function (data) {
//            console.log('group deleted=' + data);
//            $http.post("/CM/group/mygroups").success(function (data) {
//                $scope.groups = data;
//            });
//        });
//    };
//
//    $scope.getPointsByGroupId = function (groupId) {
//        var data = groupId;
//        $http.post("/CM/group/getpointsbygroupid/" + groupId).success(function (data) {
//            $scope.points = data;
//        });
//    };
//
//    $scope.createPoint = function () {
//        var data = {};
//        data.name = $scope.pointName;
//        data.description = $scope.pointDescription;
//        data.groupId = $scope.pointGroupId;
//
//        $http.post("/CM/group/createpoint", data).success(function (data) {
//            console.log("point created");
//        });
//    };
//
//    $scope.deletePoint = function (pointId) {
//
//        $http.post("/CM/group/deletepoint/" + pointId).success(function (data) {
//            console.log("point created");
//        });
//    };
//
//
//
//
//
//
//
//
//    $http.post("/CM/group/mygroups").success(function (data) {
//        $scope.groups = data;
//    });
//
//}]);
