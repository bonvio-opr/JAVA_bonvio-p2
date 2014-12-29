(function () {
	'use strict';

	angular
			.module('app.group', [])
			.controller('groupCtrl', groupCtrl)
			.controller('singleGroupCtrl', singleGroupCtrl)
			.controller('createGroupCtrl', createGroupCtrl)
			.controller('updateGroupCtrl', updateGroupCtrl);

	// список всех групп
	groupCtrl.$inject = ['$scope', 'dataService'];
	function groupCtrl($scope, dataService) {
		dataService.getGroups(function (data) {
			$scope.groups = {};
			data.forEach(function(item) {
				$scope.groups[item.groupId] = item;
			});
		});

		$scope.actionModal = function (modalType, modalId) {
			switch (modalType) {
				case 'delete':
					dataService.deleteGroup(modalId, function() {
						delete $scope.groups[modalId];
					});
			}
		};
	}

	/////////////////////////////////////////
	// просмотр конкретной группы ///////////
	/////////////////////////////////////////
	singleGroupCtrl.$inject = ['$scope', 'dataService', '$routeParams'];
	function singleGroupCtrl($scope, dataService, $routeParams) {
		$scope.disableEdit = true;
		$scope.title = "Просмотр группы";

		// показ группы
		dataService.getGroup($routeParams.groupId, function (data) {
			$scope.item = data;
		});
		// показ участников
		dataService.getMembers($routeParams.groupId, function (data) {
			$scope.members = {};
			data.forEach(function(item) {
				$scope.members[item.id] = item;
			});
		});
		// показать кандидатов
		dataService.getGroupInvite($routeParams.groupId, function (data) {
			$scope.inviters = {};
			data.forEach(function(item) {
				$scope.inviters[item.id] = item;
			});
		});

		// экшены модального окна
		$scope.actionModal = function (modalType, modalId) {
			console.log(modalType);
			switch (modalType) {
				case 'deleteM':
					dataService.deleteFromGroup($routeParams.groupId, modalId, function () {
						delete $scope.members[modalId];
						console.log('ЭТОТ НЕХОРОШИЙ ЧЕЛОВЕК УДАЛЕН УЖЖЖЖЖЖЖЖЖЕ!');
					});
					break;
				case 'deleteI':
					dataService.deleteFromGroup($routeParams.groupId, modalId, function () {
						delete $scope.inviters[modalId];
						console.log('ЭТОТ НЕХОРОШИЙ ЧЕЛОВЕК УДАЛЕН B LF:T DDLLDDDDD УЖЖЖЖЖЖЖЖЖЕ!');
					});
					break;
				case 'accept':
						dataService.migrateInviteToMember($routeParams.groupId, modalId, function () {
							$scope.members[modalId] = $scope.inviters[modalId]; // ВСТАВИТЬ
							delete $scope.inviters[modalId]; // УДАЛИТЬ
							console.log('МОЯ ПРИЯЛИ');
						});
					break;
				default:
					console.log('Я работаю но не видно моего мадольности!');
			}
		}
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
