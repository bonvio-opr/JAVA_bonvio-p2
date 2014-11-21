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

    angular.module('resizeIt',[])

    /**
     jQuery UI resizable adds exact pixel width and heights to the element via a style tag.
     **/
        .directive('resizable',[function(){
            return {
                restrict : 'A',
                link : function(scope,el,attrs,ctrlr){
                    scope.obj = {
                        el : null,
                        id : null,
                        size : null // {width,height}s
                    };

                    /*** Setup ***/

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
                    //el.resizable(options);


                    /*** Listeners ***/

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
        }]); // end resizeable


});