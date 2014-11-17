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

    <!-- Style -->
    <link rel="stylesheet" href="resources/workspace/styles/wsItems.css">
    <link rel="stylesheet" href="resources/workspace/styles/style.css">

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font-Awesome -->
    <link rel="stylesheet" href="resources/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Animate.css -->
    <link rel="stylesheet" href="resources/bower_components/animate.css/animate.min.css">

</head>
<body ng-app="p2DashboardApp">

<div ng-controller = "MainCtrl">

    <!-- start: Header - ->
    <section data-ng-include=" 'views/header.html' " ></section>
    <!-- end: Header -->
    <!-- start: Nav -->
    <section data-ng-include=" 'resources/workspace/views/nav.html' " ></section>
    <!-- end: Nav -->
    <!-- start: Content -->
    <div class="main">

        <div id="content-wrapper"
             id="content"
             data-ng-controller="ContentCtrl"
             data-collapse-nav
             data-slim-scroll
             data-highlight-active>

            <!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
            <![endif]-->

            <!-- Add your site or application content here -->
            <div ng-view></div>

        </div>

    </div>
    <!-- end: Content -->
    <!-- end: Footer - ->
    <section data-ng-include=" 'resources/workspace/views/footer.html' " ></section>
    <!-- end: Footer -->

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









































<%--
old
<!DOCTYPE HTML>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Origin Admin - Bootstrap Admin Template">
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword" content="Origin, Admin, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/http://bootstrapmaster.com/live/origin-ajax/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://bootstrapmaster.com/live/origin-ajax/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://bootstrapmaster.com/live/origin-ajax/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="57x57" href="http://bootstrapmaster.com/live/origin-ajax/assets/ico/apple-touch-icon-57-precomposed.png">

    <!--
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    -->

    <title>BONVIO Admin</title>

    <!-- require -->
    <script data-main="controls/common/require-config" src="resources/vendors/require.js" type="text/javascript"></script>

    <!-- Bootstrap core CSS -->
    <link href="resources/vendors/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-style">

    <link href="resources/themes/tm_workspace/css/jquery.mmenu.css" rel="stylesheet">
    <link href="resources/themes/tm_workspace/css/font-awesome.min.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="resources/themes/tm_workspace/css/style.min.css" rel="stylesheet" id="main-style">
    <link href="resources/themes/tm_workspace/css/add-ons.min.css" rel="stylesheet">

    <!-- Themes -->
    <link href="resources/themes/tm_workspace/css/themes.min.css" rel="stylesheet">

    <!-- Add custom CSS here
    <link href="/CM/resources/themes/tm_workspace/css/style.css" type="text/css" rel="stylesheet" >-->

    <!-- Remove following comment to add Right to Left Support or add class rtl to body -->
    <!-- <link href="assets/css/style.rtl.min.css" rel="stylesheet"> -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<!-- BODY options, add following classes to body to change options

    1. 'sidebar-minified'     - Switch sidebar to minified version (width 50px)
    2. 'sidebar-hidden'		  - Hide sidebar
    3. 'rtl'				  - Switch to Right to Left Mode
    4. 'container'			  - Boxed layout
    5. 'static-sidebar'		  - Static Sidebar
    6. 'static-header'		  - Static Header
    7. 'hidden-usage'		  - Hidden Usage Bar

    Themes:

    1. 'elegant'			  - Elegant Theme
    2. 'sky'				  - Sky Theme

-->

<body class="elegant">

<!-- workspace -->
<div id="workspace" style="height: 100%;">
    <!--000-->
</div>

<!-- start: JavaScript-->
<!--[if !IE]>-->
<!--
<script src="http://bootstrapmaster.com/live/origin-ajax/assets/js/jquery-2.1.1.min.js"></script>

<!--<![endif]-->

<!--[if IE]>
<!--
<script src="assets/js/jquery-1.11.1.min.js"></script>

<![endif]-->

<!--[if !IE]>-->

<script type="text/javascript">
    //window.jQuery || document.write("<script src='resources/themes/tm_workspace/js/jquery-2.1.1.min.js'>"+"<"+"/script>");
</script>

<!--<![endif]-->

<!--[if IE]>

<script type="text/javascript">
    //window.jQuery || document.write("<script src='assets/js/jquery-1.11.1.min.js'>"+"<"+"/script>");
</script>

<![endif]-->

<!-- scripts-->
&lt;%&ndash;<script src="http://bootstrapmaster.com/live/origin-ajax/assets/js/jquery-migrate-1.2.1.min.js"></script>
<script src="http://bootstrapmaster.com/live/origin-ajax/assets/js/bootstrap.min.js"></script>

<!-- theme scripts -->
<script src="http://bootstrapmaster.com/live/origin-ajax/assets/plugins/pace/pace.min.js"></script>
<script src="resources/themes/tm_workspace/js/jquery.mmenu.min.js"></script>
<script src="resources/themes/tm_workspace/js/core.min.js"></script>
<script src="resources/themes/tm_workspace/plugins/jquery-cookie/jquery.cookie.min.js"></script>
<script src="resources/themes/tm_workspace/js/demo.min.js"></script>&ndash;%&gt;

<!-- end: JavaScript-->

</body>
</html>--%>
