	/*jshint unused: vars */
define([
    'angular',
    //controllers
    'controllers/main',
    'controllers/desktop',
    'controllers/bar_top',
    'controllers/bar_bottom',

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

            'AboutCtrl',
            /*angJSDeps*/
            'ngCookies',
            'ngResource',
            'ngSanitize',
            'ngRoute',
            'ngAnimate',
            'ngTouch'
        ]
    )
        .config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {

            var partialsPath = 'resources/workspace/views';
            $routeProvider

                //AboutCtrl
                .when('/about', {
                    templateUrl: partialsPath+'/about.html',
                    controller: 'AboutCtrl'
                })

                //DesktopCtrl
                .when('/:desktopId', {
                    templateUrl: partialsPath+'/desktop.html',
                    controller: 'DesktopCtrl'
                })

                .otherwise({
                    redirectTo: '/'
                });
            //$locationProvider.html5Mode(true);
        }])


        .directive('draggable', function($document) {
            return function(scope, element, attr) {
                var startX = 0, startY = 0, x = 0, y = 0;
                element.css({
                    position: 'relative'
                });
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
