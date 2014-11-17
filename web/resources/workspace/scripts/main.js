/*jshint unused: vars */
require.config({
    paths: {
        //jquery
        'jquery': '/CM/resources/bower_components/jquery/dist/jquery',
        'modernizr': '/CM/resources/bower_components/modernizr/modernizr.js',
        //angular
        'angular' : '/CM/resources/bower_components/angular/angular.min',
        'angular-route': '/CM/resources/bower_components/angular-route/angular-route.min',
        'angular-cookies': '/CM/resources/bower_components/angular-cookies/angular-cookies.min',
        'angular-sanitize': '/CM/resources/bower_components/angular-sanitize/angular-sanitize.min',
        'angular-resource': '/CM/resources/bower_components/angular-resource/angular-resource.min',
        'angular-animate': '/CM/resources/bower_components/angular-animate/angular-animate.min',
        'angular-touch': '/CM/resources/bower_components/angular-touch/angular-touch.min',
        'angular-mocks': '/CM/resources/bower_components/angular-mocks/angular-mocks',
        //bootstrap
        'bootstrap': '/CM/resources/bower_components/bootstrap/dist/js/bootstrap.min',
        'ui.bootstrap': '/CM/resources/bower_components/angular-bootstrap/ui-bootstrap.min',
        'angular-strap': '/CM/resources/bower_components/angular-strap/dist/angular-strap.min'

    },
    shim: {
        'angular' : {'exports' : 'angular'},
        'angular-route': ['angular'],
        'angular-cookies': ['angular'],
        'angular-sanitize': ['angular'],
        'angular-resource': ['angular'],
        'angular-animate': ['angular'],
        'angular-touch': ['angular'],
        'angular-mocks': {
            deps: ['angular'],
            'exports': 'angular.mock'
        },
        'bootstrap': ['jquery'],
        'ui.bootstrap':['angular'],
        'angular-strap':['angular']
    },
    priority: ['angular']
});

//http://code.angularjs.org/1.2.1/docs/guide/bootstrap#overview_deferred-bootstrap
window.name = 'NG_DEFER_BOOTSTRAP!';

require([
    'jquery',
    'angular',
    'app',
    'angular-route',
    'angular-cookies',
    'angular-sanitize',
    'angular-resource',
    'angular-animate',
    'angular-touch',
    'bootstrap',
    'ui.bootstrap',
    'angular-strap'

], function($, angular, app, ngRoutes, ngCookies, ngSanitize, ngResource, ngAnimate, ngTouch, bootstrap, ui_bootstrap, angular_strap) {
    'use strict';
    /* jshint ignore:start */
    var $html = angular.element(document.getElementsByTagName('html')[0]);
    /* jshint ignore:end */
    angular.element().ready(function() {
        angular.resumeBootstrap([app.name]);
    });
});
