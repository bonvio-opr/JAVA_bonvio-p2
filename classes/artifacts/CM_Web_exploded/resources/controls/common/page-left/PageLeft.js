/**
 * Created by Arti on 29.04.2014.
 */

define( ['jquery', 'knockout',
        "text!./templates/page-left-template.html"],
    function ( $, ko, PageLeftTemplate) {
        function PageLeft( $container, parentElem  ) {
            var self = this;
            self.parentUnit = parentElem;
            self.$parentContainer = $container;
            self.$container = $( PageLeftTemplate );

            self.disabled = ko.observable(false);
            self.requireOpenedPane = ko.observable(false);
            self.selectedIndex = ko.observable(0);
        }

        PageLeft.prototype.bindModel = function() {
            var self = this;
            self.$parentContainer.append( self.$container );
            ko.applyBindings( self, self.$parentContainer[0] );
        };

        return PageLeft;
    }
);
