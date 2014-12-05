FileManager.directive("ngFocus", function () {
	return {
		restrict: "A",
		link: function (scope, element, attribute) {
			scope.$watch(attribute.ngFocus, function () {
				element[0].focus();
			});
		}
	};
});