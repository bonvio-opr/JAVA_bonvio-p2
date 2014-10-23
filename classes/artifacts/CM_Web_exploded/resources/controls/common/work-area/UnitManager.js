/**
 * Created by Arti on 13.05.2014.
 */

define( ['jquery', 'knockout',
        'controls/units/group-management/GroupManagement'
//        , 'controls/units/group-management/MyProfile'
    ],
    function ( $, ko,
               GroupManagement
//               , MyProfile
        ) {
        function UnitManager( parentElem  ) {
            var self = this;
            self.parentUnit = parentElem;
        }

        UnitManager.prototype.getUnitInstanceByUnitName = function(unitName) {
            var self = this;
            var $container = $('.unitdiv')[0];
            var newUnit;
            console.log(unitName);
            switch(unitName) {
                case 'groupsManagement':
                {
                    newUnit = new GroupManagement($container);
                    console.log(newUnit);
                    newUnit.bindModel();
                    return;
                }
                default:
                    return null;
            }
        };

        return UnitManager;
    }
);
