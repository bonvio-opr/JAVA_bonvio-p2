<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>BONVIO.net</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="bonvio">
    <meta name="keyword" content="admin">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font-Awesome -->
    <link rel="stylesheet" href="resources/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Animate.css -->
    <link rel="stylesheet" href="resources/bower_components/animate.css/animate.min.css">
    <!-- Style -->
    <link rel="stylesheet" href="resources/workspace/styles/wsItems.css">
    <link rel="stylesheet" href="resources/workspace/styles/style.css">
    <link rel="stylesheet" href="resources/workspace/styles/reset.css" />
    <link rel="stylesheet" href="resources/workspace/styles/desktop.css" />
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="resources/workspace/styles/ie.css" />
    <![endif]-->

    <link rel="stylesheet" href="resources/workspace/styles/" />
</head>
<body ng-app="p2DashboardApp">

<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<img id="wallpaper" class="abs" src="resources/workspace/images/misc/wallpaper.jpg" />

<div data-ng-controller="MainCtrl">

    <div class="abs" id="wrapper" toggle-menu>

        <div data-ng-controller="Bar_topCtrl" class="abs" id="bar_top">
            <!-- start: bar_top -->
            <section data-ng-include=" 'resources/workspace/views/bar_top.html' " ></section>
            <!-- end: bar_top -->
        </div>
        <div data-ng-controller="Bar_bottomCtrl" class="abs" id="bar_bottom">
            <!-- start: bar_bottom -->
            <section data-ng-include=" 'resources/workspace/views/bar_bottom.html' " ></section>
            <!-- end: bar_bottom -->
        </div>

        <div class="abs" id="desktop">
            <!-- Add your site or application content here -->
            <div ng-view=""></div>
        </div>


    </div>

</div>

<!-- build:js(.) scripts/oldieshim.js -->
<!--[if lt IE 9]>
<script src="resources/bower_components/es5-shim/es5-shim.js"></script>
<script src="resources/bower_components/json3/lib/json3.js"></script>
<![endif]-->
<!-- endbuild -->

<script src="resources/bower_components/requirejs/require.js" data-main="resources/workspace/scripts/main.js"></script>
</body>
</html>
