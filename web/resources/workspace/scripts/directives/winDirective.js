/**
 * Created by Niko on 27.11.2014.
 */
define(["angular"], function (angular) {
	"use strict";

	angular.module("winDirective", [])
		.directive("winDraggable", ["$document", function ($document) {
			return {
				restrict: "A",
				link: function (scope, element, attribute) {
					var style = window.getComputedStyle(element[0]), startX, startY,
						overlay = angular.element(element[0].querySelector("div.overlay"));
					element.on("mousedown", mousedown);
					function mousedown(event) {
						console.log("winDraggable is work");
						if (!event.target.classList.contains("winResizableBlock")) {
							startX = event.pageX - parseInt(style["left"] || 0);
							startY = event.pageY - parseInt(style["top"] || 0);
							overlay.css("display", "block");
							$document.bind("mousemove", mousemove);
							$document.bind("mouseup", mouseup);
						}
					}

					function mousemove(event) {
						element.css("left", (event.pageX - startX) + "px");
						element.css("top", (event.pageY - startY) + "px");
					}

					function mouseup(event) {
						overlay.css("display", "none");
						$document.unbind("mousemove", mousemove);
						$document.unbind("mouseup", mouseup);
					}
				}
			};
		}])
		.directive("winResizable", ["$document", function ($document) {
			return {
				link: function (scope, element, attribute) {
					var style = window.getComputedStyle(element[0]), startX, startY,
						overlay = angular.element(element[0].querySelector("div.overlay"));
					element.on("mousedown", mousedown);
					function mousedown(event) {
						console.log("winResizable is work");
						if (event.target.classList.contains("winResizableBlock")) {
							startX = event.pageX - parseInt(style["width"] || 0);
							startY = event.pageY - parseInt(style["height"] || 0);
							overlay.css("display", "block");
							$document.bind("mousemove", mousemove);
							$document.bind("mouseup", mouseup);
						}

						function mousemove(event) {
							element.css("width", (event.pageX - startX) + "px");
							element.css("height", (event.pageY - startY) + "px");
						}

						function mouseup(event) {
							overlay.css("display", "none");
							$document.unbind("mousemove", mousemove);
							$document.unbind("mouseup", mouseup);
						}
					}
				}
			};
		}]);
});