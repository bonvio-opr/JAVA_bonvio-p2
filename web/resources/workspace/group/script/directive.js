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
			var modalAttr = $scope.$eval(attr.modalWindow);

			$scope.modalId = modalAttr.modalId;
			$scope.modalBtnOk = modalAttr.modalBtnOk;
			$scope.modalBtnCancel = modalAttr.modalBtnCancel;
			$scope.modalTitle = modalAttr.modalTitle;
			$scope.modalContent = modalAttr.modalContent;
			$scope.modalName = modalAttr.modalName;


			$element.on('click', elementClick);

			//console.log(modalAttr);

			function elementClick() {
				LxDialogService.open($scope.modalId);
				//console.log('Энэ падаю, все впарадке');
			}

			//
			//console.log(modalAttr);
			//
			//
			//
			//var attr = ;
			//$scope.id = $element.attr('id');
			//$scope.name = attr.name;
			//$scope.action = attr.action;
			//$scope.titleModal = attr.title;
			//$scope.contentModal = attr.content;
			////console.log($element.attr('id'));
			//$element.on('click', elementClick);
			//
			//function elementClick () {
			//	LxDialogService.open('modal');
			//}
		}
	}
})();