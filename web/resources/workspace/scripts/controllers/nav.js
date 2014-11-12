define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name NavCtrl
     * @description
     * # NavCtrl
     * Controller of the generatorAngularRequireApp
     */
    angular.module('NavCtrl', [])
        .controller('NavCtrl', ['$scope', '$location', function ($scope, $location) {
            console.log('navCtrl it work');

            //CurrentUserCredentials
            $scope.CurrentUserCredentials = JSON.parse(localStorage.getItem('CurrentUserCredentials'));

            //CurrentUserWorkspaces
            var CurrentUserWorkspaces = JSON.parse(localStorage.getItem('CurrentUserWorkspaces'));

            var CurrentUserPrivateWorkspaces = [],
                CurrentUserAdditionWorkspaces = [];

            for (var i=0; i<CurrentUserWorkspaces.length; i++){
                if (CurrentUserWorkspaces[i].wsType == "p"){
                    CurrentUserPrivateWorkspaces.push(CurrentUserWorkspaces[i]);
                } else {
                    CurrentUserAdditionWorkspaces.push(CurrentUserWorkspaces[i]);
                }
            }

            $scope.CurrentUserPrivateWorkspaces = CurrentUserPrivateWorkspaces;
            $scope.CurrentUserAdditionWorkspaces = CurrentUserAdditionWorkspaces;

        }]);
});
