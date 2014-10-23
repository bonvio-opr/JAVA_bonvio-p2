/**
 * Created by Arti on 13.05.2014.
 */

define( ['jquery', 'knockout',
        "controls/units/groups-management/GroupsManagement"
    ],
    function ( $, ko, GroupsManagement) {
        function UnitManager(parentElem, code) {
            var self = this;
            var $c = $('div.unitdiv');
            self.parentUnit = parentElem;
            console.log(self.parentUnit);
            console.log('loading template for '+code);
            if (code === 'groupsManagement') {
                self.parentUnit.newUnit = new GroupsManagement($c);
            } else {
            }
        }

        return UnitManager;
    }
);







