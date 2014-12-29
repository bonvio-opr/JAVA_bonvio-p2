Members.controller("memberPage", ["$scope", "$http", function ($scope, $http) {


    $http.post("/CM/group/getuserinvitations").success(function (data) {
        $scope.invatations = data;
    });




    $scope.loadGroupInvitentions = function () {

        var data = $scope.groupId;
        console.log(data);
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






    $scope.items = 'Группы';




}]);
