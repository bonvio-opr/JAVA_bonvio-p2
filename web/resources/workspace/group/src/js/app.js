angular.module('BonvioGroups', [
    'ui.bootstrap',
    'ngRoute',
    'mobile-angular-ui',
    'BonvioGroups.controllers.Main',
    'BonvioGroups.controllers.Home'
])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/',  {
                templateUrl: '/CM/resources/workspace/group/src/templates/home.html',
                reloadOnSearch: false
            });
    }]);

