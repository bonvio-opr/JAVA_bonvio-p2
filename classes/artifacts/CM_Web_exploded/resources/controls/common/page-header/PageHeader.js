/**
 * Created by Arti on 29.04.2014.
 */

define( ['jquery', 'knockout',
        "text!./templates/page-header-template.html"],
    function ( $, ko, PageHeaderTemplate) {
        function PageHeader( $container , parentElem  ) {
            var self = this;
            self.parentUnit = parentElem;
            self.$parentContainer = $container;
            self.$container = $( PageHeaderTemplate );
        }

        PageHeader.prototype.bindModel = function() {
            var self = this;
            self.$parentContainer.append( self.$container );
            ko.applyBindings( self, self.$parentContainer[0] );
        };

        return PageHeader;
    }
);
