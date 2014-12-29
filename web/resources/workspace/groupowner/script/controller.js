GroupOwner.controller("ownerPage", ["$scope", "$http", function ($scope, $http) {

    $scope.groupId = 100;

    $http.get("/CM/settings/profile/getusers").success(function (data) {
        $scope.users = data;
    });

    $http.post("/CM/group/getgroupinvitations/" +  $scope.groupId).success(function (data) {
        $scope.invatationsGroup = data;
    });

    $http.post("/CM/group/getmembers/" + $scope.groupId).success(function (data) {
        $scope.members = data;
    });

    $scope.loadGroupInvitentions = function () {
        var data = $scope.groupId;
        $http.post("/CM/group/getgroupinvitations/" + data).success(function (data) {
            $scope.invatationsGroup = data;
        });
    };

    $scope.getMembers = function () {
        var data = $scope.groupIdForMembers;
        $http.post("/CM/group/getmembers/" + data).success(function (data) {
            $scope.members = data;
        });
    };

    $scope.inviteuser = function (idUser) {
        var data = {};
        data.profileId = idUser;
        $http.post("/CM/group/inviteuser/" + $scope.groupId, data).success(function (data) {

        });
    };

    $scope.deleteFromGroup = function (idMember) {
        var data = {};
        data.id = idMember;
        $http.post("/CM/group/deletefromgroup/" + $scope.groupId, data).success(function (data) {

        });
    };

    $scope.acceptusertogroup = function (idMember) {
        var data = {};
        data.id = idMember;
        $http.post("/CM/group/acceptusertogroup/" + $scope.groupId, data).success(function (data) {

        });
    };









}]);
