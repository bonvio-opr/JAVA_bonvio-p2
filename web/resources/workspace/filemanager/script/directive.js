FileManager.directive("contenteditable", function () {
	return {
		restrict: "A",
		require: "ngModel",
		link: function (scope, element, attrs, ngModel) {
			element.on("blur", function () {
				scope.$apply(function () {
					ngModel.$setViewValue(element.text());
					element.text(ngModel.$modelValue);
				});
			});
		}
	};
});

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