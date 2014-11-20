/**
 * Created by mil on 20.11.2014.
 */

define(['angular'], function (angular) {
    'use strict';

    /**
     * @ngdoc function
     * @name draggable
     * @description
     * # draggable
     * Controller of the generatorAngularRequireApp
     */
    /***** Draggable Library *****/

    angular.module('itsADrag',[])

    /**
     Possible element attributes:
     1.  template
     2.  id
     3.  options - json of jquery ui draggable options
     4.  group
     5.  placeholder
     **/
        .directive('draggable',[function(){
            return {
                restrict : 'AE',
                link : function(scope,el,attrs){
                    scope.minimized = false;
                    // draggable object properties
                    scope.obj = {
                        id : null,
                        content : '',
                        group : null
                    };
                    scope.placeholder = false;

                    /*** Setup ***/

                    scope.obj.content = el.html(); // store object's content

                    if(angular.isDefined(attrs.id))
                        scope.obj.id = attrs.id;

                    if(angular.isDefined(attrs.placeholder))
                        scope.placeholder = scope.$eval(attrs.placeholder);

                    // options for jQuery UI's draggable method
                    var opts = (angular.isDefined(attrs.draggable)) ? scope.$eval(attrs.draggable) : {};

                    if(angular.isDefined(attrs.group)){
                        scope.obj.group = attrs.group;
                        opts.stack = '.' + attrs.group;
                    }

                    // event handlers
                    var evts = {
                        start : function(evt,ui){
                            if(scope.placeholder) // ui.helper is jQuery object
                                ui.helper.wrap('<div class="dragging"></div>');

                            scope.$apply(function(){ // emit event in angular context
                                scope.$emit('draggable.started',{obj: scope.obj});
                            }); // end $apply
                        }, // end start

                        drag : function(evt){
                            scope.$apply(function(){ // emit event in angular context
                                scope.$emit('draggable.dragging');
                            }); // end $apply
                        }, // end drag

                        stop : function(evt,ui){
                            if(scope.placeholder)
                                ui.helper.unwrap();

                            scope.$apply(function(){ // emit event in angular context
                                scope.$emit('draggable.stopped');
                            }); // end $apply
                        } // end stop
                    }; // end evts

                    // combine options and events
                    var options = angular.extend({},opts,evts);
                    el.draggable(options); // make element draggable
                } // end link
            }; // end return
        }]) // end draggable

        .run(['$templateCache',function($templateCache){
            $templateCache.put('/tmpls/draggable/default','<div ng-transclude></div>');
        }]); // end itsADrag.run
});