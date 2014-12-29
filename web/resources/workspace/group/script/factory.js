(function () {
    'use strict';

    angular
        .module('app.dataService', [])
        .factory('dataService', dataService);

    dataService.$inject = ['$http'];
    function dataService($http) {
        return {
            createGroup: createGroup,
            getGroup: getGroup,
            getGroups: getGroups,
            getMembers: getMembers,
            deleteGroup: deleteGroup
        };

        function createGroup(data, callback) {
            console.log(data);
            $http.post("/CM/group/createGroup", data).success(callback);
        }

        function getGroup(groupId, callback) {
            return $http.post("/CM/group/getgroupbyid/" + groupId).success(callback);
        }

        function getGroups(callback) {
            return $http.post("/CM/group/mygroups").success(callback);
        }

        function deleteGroup(groupId, callback) {
            return $http.post("/CM/group/deletegroup/" + groupId).success(callback);
        }

        function getMembers(groupId, callback) {
            $http.post("/CM/group/getmembers/" + groupId).success(callback);
        }
    }
})();