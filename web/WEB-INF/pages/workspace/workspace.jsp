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
    <!-- Bootstrap core CSS - ->
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
</head>
<body ng-app="p2DashboardApp">

<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<div ng-controller = "MainCtrl" class="abs" id="wrapper">

    <div class="abs" id="desktop">

        <a class="abs icon" style="left:20px;top:20px;" href="#icon_dock_drive">
            <img src="resources/workspace/images/icons/icon_32_drive.png" />
            Hard Drive
        </a>

        <div id="window_drive" class="abs window">
            <div class="abs window_inner">
                <div class="window_top">
          <span class="float_left">
            <img src="resources/workspace/images/icons/icon_16_drive.png" />
            Hard Drive
          </span>
          <span class="float_right">
            <a href="#" class="window_min"></a>
            <a href="#" class="window_resize"></a>
            <a href="#icon_dock_drive" class="window_close"></a>
          </span>
                </div>
                <div class="abs window_content">
                    <div class="window_aside">
                        Storage in use: 119.1 GB
                    </div>
                    <div class="window_main">
                        gfd
                    </div>
                </div>
                <div class="abs window_bottom">
                    Free: 80.9 GB
                </div>
            </div>
            <span class="abs ui-resizable-handle ui-resizable-se"></span>
        </div>

    </div>

    <div class="abs" id="bar_top">
        <span class="float_right" id="clock"></span>
        <ul>
            <li>
                <a class="menu_trigger" href="#">Desktops</a>
                <ul class="menu">
                    <li>
                        <a href="#">1</a>
                    </li>

                </ul>
            </li>

        </ul>
    </div>
    <div class="abs" id="bar_bottom">
        <a class="float_left" href="#" id="show_desktop" title="Show Desktop">
            <img src="resources/workspace/images/icons/icon_22_desktop.png" />
        </a>
        <ul id="dock">

            <li id="icon_dock_drive">
                <a href="#window_drive">
                    <img src="resources/workspace/images/icons/icon_16_drive.png" />
                    Hard Drive
                </a>
            </li>

        </ul>
        <a class="float_right" href="http://www.bonvio.net" title="Secure Hosting">
            <img width="80" src="resources/workspace/images/logo-bonvio_transparant.png" />
        </a>
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
