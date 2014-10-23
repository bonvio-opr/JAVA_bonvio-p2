/**
 * Created by Arti on 29.04.2014.
 */

define( ['jquery', 'knockout',
        "text!./templates/page-footer-template.html"],
    function ( $, ko, PageFooterTemplate) {
        function PageFooter( $container, parentElem  ) {
            var self = this;
            self.parentUnit = parentElem;
            self.$parentContainer = $container;
            self.$container = $( PageFooterTemplate );

            /*self.getFooterPlateClass = ko.computed(function(state) {
                if(state===1) {
                    self.parentUnit.currentWs.valueHasMutated();
                    return 'active';
                } else if(state===0) {
                    self.parentUnit.currentWs.valueHasMutated();
                    return 'inactive';
                } else return 'inactive ';
            });*/
        }

        PageFooter.prototype.bindModel = function() {
            var self = this;
            self.$parentContainer.append( self.$container );
            ko.applyBindings( self, self.$parentContainer[0] );
        };

        return PageFooter;
    }
);
