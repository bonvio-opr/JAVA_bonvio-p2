Groups.controller("groupsPage", ["$scope", "$http", function ($scope, $http) {

    $scope.items = 'Группы';



	$scope.createGroup = function () {
        var data = {};
        data.groupName =  $scope.groupName;
        data.groupShortName = $scope.groupShortName;
        data.groupInfo = $scope.groupInfo;

		$http.post("/CM/group/createGroup", data).success(function (data) {
            console.log("Group created");
		});
	};

    $scope.searchGroup = function () {
        var data = $scope.groupNameSearch;
        $http.post("/CM/group/searchByName/" + data).success(function (data) {
            $scope.groups = data;
        });
    };

    $scope.deleteGroup = function (groupId) {
        var data = groupId;
        $http.post("/CM/group/deletegroup/" + groupId ).success(function (data) {
            console.log('group deleted=' + data);
            $http.post("/CM/group/mygroups").success(function (data) {
                $scope.groups = data;
            });

        });
    };







    $http.post("/CM/group/mygroups").success(function (data) {
        $scope.groups = data;
    });

}]);
