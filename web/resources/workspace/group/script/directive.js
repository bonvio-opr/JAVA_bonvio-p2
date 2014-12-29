(function () {
	'use strict';

	angular
			.module('app.modalDirective', [])
			.directive('modalWindow', modalWindow);

	modalWindow.$inject = ['LxDialogService'];
	function modalWindow(LxDialogService) {
		return {
			link: link,
			templateUrl: "/CM/resources/workspace/group/view/modalTemplate.html"
		};

		function link($scope, $element, attr) {
			var attr = $scope.$eval(attr.modalWindow);
			$scope.id = $element.attr('id');
			$scope.name = attr.name;
			$scope.action = attr.action;
			$scope.titleModal = attr.title;
			$scope.contentModal = attr.content;
			//console.log($element.attr('id'));
			$element.on('click', elementClick);

			function elementClick () {
				LxDialogService.open('modal');
			}
		}
	}
})();