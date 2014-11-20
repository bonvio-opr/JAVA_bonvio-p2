	/*jshint unused: vars */
define([
    'angular',
    'controllers/main',
    'controllers/desktop',
    'controllers/bar_top',
    'controllers/bar_bottom',
    'controllers/about',
    'directives/myCurrentTime'
]/*deps*/, function (angular, MainCtrl, DesktopCtrl, Bar_topCtrl, Bar_bottomCtrl, AboutCtrl)/*invoke*/ {
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
            'ngTouch',
            'myCurrentTime'
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
        }]);

});
