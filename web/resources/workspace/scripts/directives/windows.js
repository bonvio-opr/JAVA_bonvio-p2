/**
 * Created by mil on 20.11.2014.
 */
define([
    'angular',
    'angular-animate',
    'directives/itsADrag',
    'directives/resizeIt'
], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name draggable
     * @description
     * # draggable
     * Controller of the generatorAngularRequireApp
     */

    angular.module('windows',[
        'ngAnimate',
        'itsADrag',
        'resizeIt'
    ])
        .directive('window',['$animate',function($animate){
            return {
                restrict : 'E',
                transclude : true,
                replace : true,
                templateUrl : '/tmpls/window',
                scope : {
                    id : '@id',
                    title : '@title'
                },
                link : function(scope,el,attr){
                    scope.minimized = false;

                    /** Methods **/
                    scope.minimize = function(){
                        scope.minimized = !scope.minimized;

                        if(angular.equals(scope.minimized,true)){
                            $animate.addClass(el,'minimize');
                        }else{
                            $animate.removeClass(el,'minimize');
                        }
                    }; // end minimize

                } // end link
            }; // end return
        }]) // end window

        .run(['$templateCache',function($templateCache){
            $templateCache.put('/tmpls/window',
                '<div class="floating-window" id="{{id}}"  draggable="{handle: \'div.panel-heading\',opacity: 0.5}">' +
                    '<div class="panel panel-primary" resizeable="{handles: \'se\', alsoResize: \'#windowBodyContent\'}">' +
                        '<div class="panel-heading cursor-move" id="windowHeading">' +
                            '<span class="pull-right">' +
                                '<a type="button" id="windowMinimizeBtn" class="btn btn-primary btn-xs" ng-click="minimize()">' +
                                    '<span class="glyphicon" ng-class="{false: \'glyphicon-chevron-up\',true: \'glyphicon-chevron-down\'}[minimized]"></span>' +
                                '</a>' +
                            '</span>' +
                            '<span>' +
                                '<big>{{title}}</big>' +
                            '</span>' +
                        '</div>' +
                        '<div id="windowBody">' +
                            '<div class="panel-body" id="windowBodyContent" ng-transclude></div>' +
                            '<div class="panel-footer">' +
                                '<small>&nbsp;</small>' +
                                '<span class="pull-right glyphicon glyphicon-resize-full ui-resizable-handle ui-resizable-se"></span>' +
                            '</div>' +
                        '</div>' +
                    '</div>' +
                '</div>');
        }]); // end windows

});