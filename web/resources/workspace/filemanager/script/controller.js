var root = "root";

FileManager.controller("screen", ["$scope", "$http", function ($scope, $http) {
	$scope.files = {};

	$scope.openFile = function (file) {
		$http.post("/CM/getApplicationByExt/" + file.type).success(function (data) {
			var bigData = {
				'window': data,
				'file': file
			};
			window.top.postMessage(bigData, "*");
		});
	};

	$scope.init = function (side, file) {
		$http.get("/CM/filemanager/getfolderbyparentid/" + file.id).success(function (data) {
			$scope.files[side] = data; // получаем файлы и папки
			if (data.length == 0) {
				data.push({});
				data[0].parentId = file.id;
			}
		});
	};

	$scope.open = function (side, file) {
		$scope.nav[side].push({
			id: file.id,
			name: file.name
		});
		$scope.init(side, file);
	};

	$scope.action = function (name, side, file, index) {
		var inversionSide = side == "left" ? "right" : "left";
		var buffer = null;
		switch (name) {
			case 'move': // WORKING!
				buffer = $scope.files[side][index]; // перемещаем файл/папку в буфер
				buffer.parentId = $scope.files[inversionSide][0].parentId; // меняем родительский Id
				$scope.files[side].splice(index, 1); // вырезаем
				$scope.files[inversionSide].push(buffer); // добавляем на другую сторону
				$http.post('/CM/filemanager/updatefolder', file).success(function (data) { // обновляем на сервере
					console.log('move ok', data);
				});
				break;
			case "copy":
				//buffer = $scope.files[side][index];
				//buffer.parentId = localStorage[inversionSide + "Id"];
				//$scope.files[inversionSide].push(buffer);
				//console.log(buffer);
				break;
			case "delete": // WORKING!
				console.log($scope.files[side][index].id);
				$http.get("/CM/filemanager/deletefolder/" + $scope.files[side][index].id).success(function (data) {
					console.log(data);
				});
				$scope.files[side].splice(index, 1);
				break;
			case 'create': // WORKING!
				file = {name: 'Новая папка', type: 'folder', parentId: $scope.files[side][0].parentId};
				$http.post('/CM/filemanager/addfolder', file).success(function (data) {
					buffer = file;
					buffer.id = data;
					$scope.files[side].push(buffer);
				});
				break;
			case 'upload':
				//console.log('upload');
				break;
		}
	};


	// формирование пути и выстраивание навигации
	var leftHome = {id: 0, name: 'home'};
	var rightHome = {id: 0, name: 'home'};
	$scope.nav = {};
	$scope.nav['left'] = [];
	$scope.nav['left'].push(leftHome);
	$scope.nav['right'] = [];
	$scope.nav['right'].push(rightHome);
	// магия
	$scope.location = function (side, file) {
		var find = 0;
		$scope.nav[side].forEach(function (element, i) {
			if (element.id == file.id) { // ищем id ко которой сделан click
				find = i + 1; // заносим index
			}
		});
		$scope.nav[side].splice(find); // удаляем все, что после index
		$scope.init(side, file); // формируем содержимое
	};
	// запускаем
	$scope.location('left', leftHome);
	$scope.location('right', rightHome);



}]).directive("contentRename", function () {
	return {
		restrict: "A",
		link: function (scope, element, attrs) {
			element.on("blur", function () {
				var file = scope.files[attrs.fileSide][attrs.fileIndex];
				file.name = element.text();
				console.log(file);
				$http.post('/CM/filemanager/updatefolder', file).success(function (data) { // обновляем на сервере
					console.log('rename ok', data);
				});
			});
		}
	};
});

// DO NOT TOUCH THIS
FileManager.directive('fileModel', ['$parse', function ($parse) {
	return {
		restrict: 'A',
		link: function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function(){
				scope.$apply(function(){
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
}]);
FileManager.service('fileUpload', ['$http', function ($http) {
	this.uploadFileToUrl = function(file, uploadUrl){
		var fd = new FormData();
		fd.append('file', file);
		$http.post(uploadUrl, fd, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		})
			.success(function(){
			})
			.error(function(){
			});
	}
}]);
FileManager.controller('myCtrl', ['$scope', 'fileUpload', function($scope, fileUpload) {
	$scope.uploadFile = function(side, parentId) {

		var file = $scope.myFile;
		var uploadUrl = "/CM/filemanager/uploadfile/" +  parentId;
		fileUpload.uploadFileToUrl(file, uploadUrl);
		$scope.init(side, {id: parentId});
	};
}]);


// PLEASE END

FileManager.controller("left", ["$scope", "$http", function ($scope, $http) {
	$scope.side = "left";
	//var temp = {id: 0, name: "home", first: true};
	//$scope.init($scope.side, temp);
}]);

FileManager.controller("right", ["$scope", "$http", function ($scope, $http) {
	$scope.side = "right";
	//var temp = {id: 0, name: "home", first: true};
	//$scope.init($scope.side, temp);
}]);