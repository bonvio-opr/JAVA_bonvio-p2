(function () {
	'use strict';

	angular
			.module('app.group', [])
			.controller('groupCtrl', groupCtrl)
			.controller('singleGroupCtrl', singleGroupCtrl)
			.controller('createGroupCtrl', createGroupCtrl);

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
			dataService.deleteGroup($scope.groupId, function(data) {
				delete $scope.groups[$scope.groupId];
			});
		};
	}

	// просмотр конкретной группы
	singleGroupCtrl.$inject = ['$scope', 'dataService', '$routeParams'];
	function singleGroupCtrl($scope, dataService, $routeParams) {
		$scope.title = "Просмотр группы";

		dataService.getGroup($routeParams.groupId, function (data) {
			$scope.item = data;
		});
	}

	// создание новой группы
	createGroupCtrl.$inject = ['$scope', 'dataService'];
	function createGroupCtrl($scope, dataService) {
		//console.log('createGroupCtrl start');
		$scope.title = "Создание группы";

		$scope.createGroup = function (item) {
			item.groupPicturePath = $scope.image;
			dataService.createGroup(item, function() {
				console.log('created!1');
			});
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