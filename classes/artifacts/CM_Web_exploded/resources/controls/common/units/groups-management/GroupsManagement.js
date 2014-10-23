/**
 * Created by Arti on 13.05.2014.
 */

define( ['jquery', 'knockout',
        "text!./templates/groups-management-template.html"],
    function ( $, ko, GroupsManagementTemplate) {
        function GroupsManagement($cont) {
            var self = this;
            console.log($cont);
            self.$parentContainer = $($cont);
            self.$container = $( GroupsManagementTemplate );
            self.requests = {/**/};
        }

        GroupsManagement.prototype.bindModel = function() {
            var self = this;
            self.$parentContainer.append(self.$container);
            ko.applyBindings( self, self.$parentContainer[0] );
        };

        return GroupsManagement;
    }
);
