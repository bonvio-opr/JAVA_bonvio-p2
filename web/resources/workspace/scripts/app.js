	/*jshint unused: vars */
define([
    'angular',
    //controllers
    'controllers/main',
    'controllers/desktop',
    'controllers/bar_top',
    'controllers/bar_bottom',
    'controllers/nav',
    'controllers/content',
    'controllers/dashboard',
    'controllers/application',
    'controllers/about'
]/*deps*/, function (angular, MainCtrl, DesktopCtrl, Bar_topCtrl, Bar_bottomCtrl, NavCtrl, ContentCtrl, DashboardCtrl, ApplicationCrtl, AboutCtrl)/*invoke*/ {
    'use strict';

    /**
     * @ngdoc overview
     * @name p2DashboardApp
     * @description
     * # p2DashboardApp
     *
     * Main module of the application.
     */
    return angular
        .module('p2DashboardApp', [
            'MainCtrl',
            'DesktopCtrl',
            'Bar_topCtrl',
            'Bar_bottomCtrl',
            'NavCtrl',
            'ContentCtrl',
            'DashboardCtrl',
            'ApplicationCtrl',
            'AboutCtrl',
            /*angJSDeps*/
            'ngCookies',
            'ngResource',
            'ngSanitize',
            'ngRoute',
            'ngAnimate',
            'ngTouch'/*,
            'ui.bootstrap'*/
        ]
    )
        .config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {

            var partialsPath = 'resources/workspace/views';
            $routeProvider

                //DesktopCtrl
                .when('/:desktopId', {
                    templateUrl: partialsPath+'/desktop.html',
                    controller: 'DesktopCtrl'
                })

                //AboutCtrl
                .when('/about', {
                    templateUrl: partialsPath+'/about.html',
                    controller: 'AboutCtrl'
                })
/*                //DashboardCtrl
                .when('/:wsId', {
                    templateUrl: partialsPath+'/dashboard.html',
                    controller: 'DashboardCtrl'

                })
                //ApplicationCtrl
                .when('/:wsId/frame/:unitIndex', {
                    templateUrl: partialsPath+'/application.html',
                    controller: 'ApplicationCtrl'

                })*/

                .otherwise({
                    redirectTo: '/'
                });
            //$locationProvider.html5Mode(true);
        }])


        .directive('draggable', function($document) {
            return function(scope, element, attr) {
                var startX = 0, startY = 0, x = 0, y = 0;
                /*element.css({
                    position: 'relative',
                    border: '1px solid red',
                    backgroundColor: 'lightgrey',
                    cursor: 'pointer',
                    display: 'block',
                    width: '65px'
                });*/
                element.on('mousedown', function(event) {
                    // Prevent default dragging of selected content
                    event.preventDefault();
                    startX = event.screenX - x;
                    startY = event.screenY - y;
                    $document.on('mousemove', mousemove);
                    $document.on('mouseup', mouseup);
                });

                function mousemove(event) {
                    y = event.screenY - startY;
                    x = event.screenX - startX;
                    element.css({
                        top: y + 'px',
                        left:  x + 'px'
                    });
                }

                function mouseup() {
                    $document.off('mousemove', mousemove);
                    $document.off('mouseup', mouseup);
                }
            };
        });

});
