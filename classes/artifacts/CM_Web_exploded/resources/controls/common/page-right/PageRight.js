/**
 * Created by Arti on 29.04.2014.
 */

define( ['jquery', 'knockout',
        "text!./templates/page-right-template.html"],
    function ( $, ko, PageRightTemplate) {
        function PageRight( $container  , parentElem) {
            var self = this;
            self.parentUnit = parentElem;
            self.$parentContainer = $container;
            self.$container = $( PageRightTemplate );
        }

        PageRight.prototype.bindModel = function() {
            var self = this;
            self.$parentContainer.append( self.$container );
            ko.applyBindings( self, self.$parentContainer[0] );
        };

        return PageRight;
    }
);
