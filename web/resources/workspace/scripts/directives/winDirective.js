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
		}])
		.directive("winZIndex", ["$document", function ($document) {
			return {
				link: function (scope, element, attribute) {
					element.on("mousedown", mousedown);

					function mousedown(event) {
						element[0].parentNode.parentNode.parentNode.appendChild(element[0].parentNode.parentNode);
						//var attr = scope.$eval(attribute.winZIndex);
						//element.css("z-index", "2" + attr.winCount);
						////console.log("zBEFORE - " + element.css("z-index"));
						//$document.bind("mouseup", mouseup);
					}

					function mouseup(event) {
						//console.log("zAFTER - " + element.css("z-index"));
					}
				}
			};
		}])




		.directive("desktopAllocate", ["$document", function ($document) {
			return {
				link: function (scope, element, attribute) {
					var draggableClass = attribute.desktopAllocate; // получаем класс для draggable
					element.on("mousedown", mouseDown);
					var copy = element;

					function mouseDown(event) {
						if (event.target.classList.contains(draggableClass)) { // draggable block
							element = angular.element(event.target);
							element.param = {};
							draggableDown(event);
						} else { // not draggable block
							if (event.target.getAttribute("id") == "desktop") {
								element = angular.element(document.querySelector("div.desktop-allocate"));
								element.param = {};
								allocateDown(event);
							}
						}
					}

					function allocateDown(event) {
						var block = copy[0].querySelectorAll("." + draggableClass);
						for (var i = 0; i < block.length; i++) block[i].classList.remove("selected");
						element.css({
							"left": (element.param.x1 = event.pageX) + "px",
							"top": (element.param.y1 = event.pageY) + "px"
						});
						$document.bind("mousemove", allocateMove);
						$document.bind("mouseup", allocateUp);
					}

					function allocateMove(event) {
						var block = copy[0].querySelectorAll("." + draggableClass);
						if (event.pageX < element.param.x1) element.css("left", event.pageX + "px");
						if (event.pageY < element.param.y1) element.css("top", event.pageY + "px");

						element.css({
							"width": Math.abs(event.pageX - element.param.x1) + "px",
							"height": Math.abs(event.pageY - element.param.y1) + "px"
						});
					}

					function allocateUp(event) {
						var block = copy[0].querySelectorAll("." + draggableClass);
						element.param.width = parseInt(element.css("width"));
						element.param.height = parseInt(element.css("height"));
						element.param.x2 = element.param.x1;

						if (event.pageX > element.param.x1) element.param.x2 = element.param.x1 + element.param.width;
						else element.param.x1 = element.param.x2 - element.param.width;
						element.param.y2 = element.param.y1;

						if (event.pageY > element.param.y1) element.param.y2 = element.param.y1 + element.param.height;
						else element.param.y1 = element.param.y2 - element.param.height;

						for (var i = 0, temp, check = []; i < block.length; i++) {
							block[i].computedStyle = getComputedStyle(block[i]);
							temp = parseInt(block[i].computedStyle.left);
							check[0] = element.param.x1 < temp; // x1 меньше x объекта
							check[1] = element.param.x2 > temp + parseInt(block[i].computedStyle.width);
							temp = parseInt(block[i].computedStyle.top);
							check[2] = element.param.y1 < temp; // y1 меньше y объекта
							check[3] = element.param.y2 > temp + parseInt(block[i].computedStyle.height);
							if (check[0] && check[1] && check[2] && check[3]) block[i].classList.add("selected");
						}

						element.css({
							"left": "0",
							"top": "0",
							"width": "0",
							"height": "0"
						});
						$document.unbind("mousemove", allocateMove);
						$document.unbind("mouseup", allocateUp);
					}

					var blockX = [], blockY = [];

					function draggableDown(event) {
						var block = copy[0].querySelectorAll("." + draggableClass);
						element[0].computedStyle = getComputedStyle(element[0]);
						element.param.x1 = parseInt(element[0].computedStyle.left || 0);
						element.param.y1 = parseInt(element[0].computedStyle.top || 0);
						element.param.startX = event.pageX - element.param.x1;
						element.param.startY = event.pageY - element.param.y1;

						for (var i = 0; i < block.length; i++) {
							block[i].computedStyle = getComputedStyle(block[i]);
							blockX[i] = parseInt(block[i].computedStyle.left || 0);
							blockY[i] = parseInt(block[i].computedStyle.top || 0);
						}

						$document.bind("mousemove", draggableMove);
						$document.bind("mouseup", draggableUp);
					}

					function draggableMove(event) {
						var block = copy[0].querySelectorAll("." + draggableClass);
						element.param.x2 = (event.pageX - element.param.startX);
						element.param.y2 = (event.pageY - element.param.startY);
						element.css("left", element.param.x2 + "px");
						element.css("top", element.param.y2 + "px");

						var diffX = element.param.x2 - element.param.x1;
						var diffY = element.param.y2 - element.param.y1;

						for (var i = 0; i < block.length; i++) {
							if (block[i].classList.contains("selected")) {
								block[i].style.left = (blockX[i] + diffX) + "px";
								block[i].style.top = (blockY[i] + diffY) + "px";
							}
						}
					}

					function draggableUp() {
						var block = copy[0].querySelectorAll("." + draggableClass);
						for (var i = 0; i < block.length; i++) block[i].classList.remove("selected");
						$document.unbind("mousemove", draggableMove);
						$document.unbind("mouseup", draggableUp);
					}
				}
			};
		}]);
});