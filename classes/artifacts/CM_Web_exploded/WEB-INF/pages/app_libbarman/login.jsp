<%--
  Created by IntelliJ IDEA.
  User: mil
  Date: 6/2/14
  Time: 4:24 PM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="mil">
    <!--<link rel="shortcut icon" href="../../assets/ico/favicon.ico">-->
    <title>CM - login</title>
    <!-- Bootstrap core CSS -->
    <link href="/CM/resources/themes/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/CM/resources/themes/tm_login/css/signin.css">
</head>

<body>
<div class="wrapper">
    <div class="container">
        <fieldset>
            <!-- AuthForm -->
            <form name='f' action='check' method='post' class="form-signin" role="form">
                <!--
                <h2 class="form-signin-heading">BONVIO.NET </h2>
                -->
                <div class="logo">
                    <img src="/CM/resources/images/logo_no_back.png"/>
                    <span>.net</span>
                </div>
                <!--placeholder="Email или телефон"--><!--placeholder="Пароль"-->
                <input type="text" value="+79633163475" name="usrnum" class="form-control"  required autofocus />
                <input type="password" value="qwerty" name="usrpwd" class="form-control"  required />
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span>Если Вы впервые пользуетесь сервисом <i>BONVIO.NET</i> - введите любой пароль.</span>
                    </div>
                </div>
                <button class="btn btn-lg btn-primary btn-block"  name="submit" type="submit">Войти</button>
            </form>
        </fieldset>
    </div> <!-- /container -->
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>