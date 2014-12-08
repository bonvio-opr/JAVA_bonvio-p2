<%--
  Created by IntelliJ IDEA.
  User: niko
  Date: 05.12.14
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html ng-app="Gallery">
<head>
  <meta charset="utf-8">
  <script src="/CM/resources/bower_components/angular/angular.min.js"></script>
  <link href="/CM/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <script src="/CM/resources/workspace/imageview/script/main.js"></script>
  <link href="/CM/resources/workspace/imageview/style/main.css" rel="stylesheet">
</head>
<body ng-controller="screen" ng-keypress="keyPress($event)" ng-init="currentImage.src = 'http://localhost:8092/CM/filemanager/getfile/101'">

<%--<nav>--%>
  <%--<ul>--%>
    <%--<li><a href="#" ng-click="init('img')">Открыть галерею img</a></li>--%>
    <%--<li><a href="#" ng-click="init('img2')">Открыть галерею img2</a></li>--%>
  <%--</ul>--%>
<%--</nav>--%>

<section id="screen" ng-if="currentImage.src" ng-init="setting = false">
  <header>
    {{currentImage.name}}Image Viewer <span>{{index + 1}} / {{images.length}}</span>
  </header>
  <section ng-style="{
		'background-color': color,
		'transition-property': 'background-color',
		'transition-duration': '0.5s'}">
    <img ng-src="{{currentImage.src}}"
         ng-class="fullImage ? 'full' : ''"
         ng-click="nextImage()">
  </section>
  <footer>
		<span class="left"
              ng-show="interval">
			<a href="#"
               ng-class="intervalTime == 1000 ? 'active' : ''"
               ng-click="slideShow('change', 1000)">1 сек</a>
			<a href="#"
               ng-class="intervalTime == 2000 ? 'active' : ''"
               ng-click="slideShow('change', 2000)">2 сек</a>
			<a href="#"
               ng-class="intervalTime == 5000 ? 'active' : ''"
               ng-click="slideShow('change', 5000)">5 сек</a>
		</span>
    <a href="#" class="fa fa-arrow-left prev"
       ng-click="prevImage()"></a>
    <a href="#" class="fa slide"
       ng-class="interval ? 'fa-pause' : 'fa-image'"
       ng-click="interval ? slideShow('stop', intervalTime) : slideShow('start', null)"></a>
    <a href="#" class="fa fa-arrow-right next"
       ng-click="nextImage()"></a>
		<span class="right">
			<a ng-show="setting" href="#" class="fa fa-desktop"
               ng-click="useAsBackground()"></a>
			<a ng-show="setting" href="#" class="fa full"
               ng-class="fullImage ? 'fa-compress' : 'fa-expand'"
               ng-click="fullImage = !fullImage"></a>
			<a ng-show="setting" href="#" class="fa fa-circle color"
               ng-class="color == '#fff' ? 'black' : 'white' "
               ng-click="changeBG()"></a>
			<a href="#" class="fa fa-gear" ng-click="setting = !setting"></a>
		</span>
  </footer>
</section>
</body>
</html>