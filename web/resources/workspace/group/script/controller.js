Groups.controller("groupsPage", ["$scope", "$http", function ($scope, $http) {

    $scope.items = 'Группы';


    $scope.createGroup = function () {
        var data = {};
        data.groupName = $scope.groupName;
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
        $http.post("/CM/group/deletegroup/" + groupId).success(function (data) {
            console.log('group deleted=' + data);
            $http.post("/CM/group/mygroups").success(function (data) {
                $scope.groups = data;
            });
        });
    };

    $scope.getPointsByGroupId = function (groupId) {
        var data = groupId;
        $http.post("/CM/group/getpointsbygroupid/" + groupId).success(function (data) {
            $scope.points = data;
        });
    };

    $scope.createPoint = function () {
        var data = {};
        data.name = $scope.pointName;
        data.description = $scope.pointDescription;
        data.groupId = $scope.pointGroupId;

        $http.post("/CM/group/createpoint", data).success(function (data) {
            console.log("point created");
        });
    };

    $scope.deletePoint = function (pointId) {

        $http.post("/CM/group/deletepoint/" + pointId).success(function (data) {
            console.log("point created");
        });
    };








    $http.post("/CM/group/mygroups").success(function (data) {
        $scope.groups = data;
    });

}]);
