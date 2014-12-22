angular.module('BonvioGroups.controllers.Main', [])

    .controller('MainController', function($scope){

        //
        // 'Scroll' screen
        //
        var scrollItems = [];

        for (var i=1; i<=10; i++) {
            scrollItems.push('Item ' + i);
        }

        $scope.scrollItems = scrollItems;

        $scope.bottomReached = function() {
            alert('Congrats you scrolled to the end of the list!');
        }





    });



