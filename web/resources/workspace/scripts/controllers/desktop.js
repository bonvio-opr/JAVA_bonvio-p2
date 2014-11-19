define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name DesktopCtrl
     * @description
     * # DesktopCtrl
     * Controller of the generatorAngularRequireApp
     */
    angular.module('DesktopCtrl', ['ngSanitize'])
        .controller('DesktopCtrl', ['$scope', '$http', '$sce', '$routeParams', function ($scope, $http, $sce, $routeParams) {
            console.log('DesktopCtrl it work');

            console.log("selected selectedDesktopId: "+$routeParams.desktopId);

            localStorage.setItem("selectedDesktopId", $routeParams.desktopId);



            if (localStorage.getItem("applicationStatus") == undefined){
                var applicationStatus = [{
                    desktopId: $routeParams.desktopId,
                    apps: [{
                        code: "/F200",
                        loaded: 0,
                        windowState: "maxi"
                    }]

                }];

                localStorage.setItem("applicationStatus", JSON.stringify(applicationStatus));
            }


            $scope.desktopId = $routeParams.desktopId;

            $http.get('getApplicationsById/'+$routeParams.desktopId).success(function(data) {
                localStorage.setItem('getApplicationsById', JSON.stringify(data));
                $scope.applicationUnits = data;
            });

            $scope.toggleApplicationOpen = function(data){

                $scope.applicationUrl = $sce.trustAsResourceUrl(data);

                var openedApp = JSON.parse(localStorage.getItem("applicationStatus"));

                for (var i=0; i<openedApp.length; i++){
                    if (openedApp[i].desktopId == localStorage.getItem("selectedDesktopId")){

                        if (openedApp[i].apps[0].code == "/F200" ){
                            openedApp[i].apps[0].code = data;
                            openedApp[i].apps[0].loaded = 1;
                        } else {
                            openedApp[i].apps.push({
                                code: data,
                                loaded: 1,
                                windowState: "maxi"
                            });
                        }

                    }
                }

                localStorage.setItem("applicationStatus", JSON.stringify(openedApp));
                $scope.windowShow = data;
            }

            //var selectedWsUnits = JSON.parse(localStorage.getItem("selectedWsUnits"));

            //$scope.applicationUrl = $sce.trustAsResourceUrl(selectedWsUnits[$routeParams.unitIndex].unitCode);

        }]);
});