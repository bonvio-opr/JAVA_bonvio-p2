define([
        'angular',
        //'directives/windows'
        'directives/itsADrag',
        'directives/drag',
        //'directives/resizeIt'
        'directives/resizable'
],
    function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name DesktopCtrl
     * @description
     * # DesktopCtrl
     * Controller of the generatorAngularRequireApp
     */
    angular
        .module('DesktopCtrl', [
            //'windows'
            //'drag',
            //'resizeIt',
            'itsADrag',
            'resizable'

        ])
        .controller('DesktopCtrl', ['$scope', '$http', '$sce', '$routeParams', function ($scope, $http, $sce, $routeParams) {
            console.log('DesktopCtrl it work');

            localStorage.setItem("selectedURL", $routeParams.desktopId);

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
            };

        }])
/*        .directive('resizable', function () {
         return {
         restrict: 'A',
         scope: {
         callback: '&onResize'
         },
         link: function postLink(scope, elem, attrs) {
         elem.resizable();
         elem.on('resizestop', function (evt, ui) {
         if (scope.callback) { scope.callback(); }
         });
         }
         };
         });*/
        /*.directive('resizeable',[function(){
            return {
                restrict : 'A',
                link : function(scope,el,attrs,ctrlr){
                    scope.obj = {
                        el : null,
                        id : null,
                        size : null // {width,height}
                    };

                    *//*** Setup ***//*

                    scope.obj.el = el; // save handle to element

                    if(angular.isDefined(attrs.id))
                        scope.obj.id = attrs.id;

                    var opts = (angular.isDefined(attrs.resizeable)) ? scope.$eval(attrs.resizeable) : {};

                    var evts = {
                        create : function(evt,ui){
                            scope.$apply(function(){
                                scope.$emit('resizeable.create',{obj: scope.obj});
                            });
                        }, // end create

                        start : function(evt,ui){
                            scope.$apply(function(){
                                scope.$emit('resizeable.start',{obj: scope.obj});
                            });
                        }, // end start

                        stop : function(evt,ui){
                            scope.$apply(function(){
                                scope.$emit('resizeable.stop',{'ui': ui});
                                scope.obj.size = angular.copy(ui.size);
                                console.log(scope.obj.size);
                            });
                        }, // end stop

                        resize : function(evt,ui){
                            scope.$apply(function(){
                                scope.$emit('resizeable.resizing');
                            });
                        } // end resize
                    }; // end evts

                    var options = angular.extend({},opts,evts);
                    el.resizable(options);

                    *//*** Listeners ***//*

                    scope.$on('resizeable.set.height',function(evt,params){
                        if(angular.isDefined(params.height))
                            el.css('height',parseInt(params.height) + 'px');
                    }); // end on(resizeable.set.height)

                    scope.$on('resizeable.set.width',function(evt,params){
                        if(angular.isDefined(params.width))
                            el.css('width',parseInt(params.width) + 'px');
                    }); // end on(resizeable.set.width

                    scope.$on('resizeable.reset.height',function(evt){
                        if(angular.isDefined(scope.obj.size))
                            el.css('height',scope.obj.size.height + 'px');
                    }); // end on(resizeable.reset.height)

                    scope.$on('resizeable.reset.width',function(evt){
                        if(angular.isDefined(scope.obj.size))
                            el.css('width',scope.obj.size.width + 'px');
                    }); // end on(resizeable.reset.width)
                } // end link
            }; // end return
        }]); // end resizeable*/
});