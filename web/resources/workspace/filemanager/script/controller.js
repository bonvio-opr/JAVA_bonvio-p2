var root = {
    "left": "files/root",
    "right": "files"
};
var parentId = {
    "leftId": "1",
    "rightId": "0"
};

FileManager.controller("screen", ["$scope", "$http", function ($scope, $http) {

    $scope.location = {};
    $scope.files = {};
    $scope.nav = {};
    $scope.local = [];

    $scope.init = function (side) {
        //$scope.local[side] = localStorage[side + "ID"] || parentId[side];
        $scope.location[side] = localStorage[side] || root[side];

        $http.post($scope.location[side] + "/index.json").success(function (data) {
            //localStorage[side + "ID"] = data.pop(); // достаем ID родительского элемента
            $scope.files[side] = data;
            localStorage[side + "Id"] = data[0].parentId;
        });
        var path = $scope.location[side].split("/");
        path.forEach(function (element, i, array) {
            array[i] = {
                "text": element,
                "href": (array[i - 1] ? array[i - 1].href + "/" : "") + element
            };
        });
        $scope.nav[side] = path;
        localStorage[side] = $scope.location[side];
    };

    $scope.open = function (type, side, name) {
        switch (type) {
            case "path":
                localStorage[side] = name;
                break;
            case "folder":
                localStorage[side] += "/" + name;
                break;
        }
        $scope.init(side);
    };

    $scope.menu = function ($event, file, side) {
        console.log(file, side);
        console.log($event.target);
    };


    $scope.action = function (name, side, file, index) {
        var inversionSide = side == "left" ? "right" : "left";
        var buffer = null;
        switch (name) {
            case "move":
                buffer = $scope.files[side][index];
                buffer.parentId = localStorage[inversionSide + "Id"];
                $scope.files[side].splice(index, 1);
                $scope.files[inversionSide].push(buffer);
                console.log(file);
                break;
            case "copy":
                buffer = $scope.files[side][index];
                buffer.parentId = localStorage[inversionSide + "Id"];
                $scope.files[inversionSide].push(buffer);
                console.log(buffer);
                break;
            case "delete":
                file.parentId = localStorage[side + "Id"];
                console.log(file);
                $scope.files[side].splice(index, 1);
                break;
            case "rename":
                file.parentId = localStorage[side + "Id"];
                console.log(file);
                break;
            case "create":
                buffer = {id: 100, name: "Новая папка", type: "folder"};
                buffer.parentId = localStorage[side + "Id"];
                $scope.files[side].push(buffer);
                console.log(buffer);
                break;
        }
    };

    $scope.select = function (type, side, name) {
        console.log("selected " + name);
    };

    $scope.menu = function ($event) {
        var data = {};
        data.element = $event.target.parentNode
        data.info = data.element.getAttribute("data-info");
        data.side = data.element.getAttribute("data-side");

        console.log(data);
        if (data != null) {
            var menu = document.querySelector("menu");
            menu.style.top = $event.pageY + "px";
            menu.style.left = $event.pageX + "px";
            menu.classList.add("show");
        }
    };

}]);


FileManager.controller("left", ["$scope", "$http", function ($scope, $http) {
    $scope.side = "left";
    $scope.init($scope.side);
}]);

FileManager.controller("right", ["$scope", "$http", function ($scope, $http) {
    $scope.side = "right";
    $scope.init($scope.side);
}]);