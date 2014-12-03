<%--
  Created by IntelliJ IDEA.
  User: mil
  Date: 15.08.2014
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="false" %>
<%@ page errorPage="error.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="mil">
    <title>CM - waiter</title>

    <!-- jQuery JS -->
    <script type="application/x-javascript" src="/CM/resources/vendors/libs/jquery/jquery-1.11.0.js"></script>

    <!-- jQuery Mobil CSS -->
    <style type="text/css" media="screen">@import "/CM/resources/vendors/libs/jquery.mobile/jquery.mobile-1.4.3/jquery.mobile-1.4.3.css";</style>
    <style type="text/css" media="screen">@import "/CM/resources/vendors/libs/jquery.mobile/jquery.mobile-1.4.3/jquery.mobile.theme-1.4.3.css";</style>

    <!-- jQuery Mobil JS -->
    <script type="application/x-javascript" charset="utf-8" src="/CM/resources/vendors/libs/jquery.mobile/jquery.mobile-1.4.3/jquery.mobile-1.4.3.js" ></script>

    <!-- Castom css-->
    <style type="text/css" media="screen">@import "/CM/resources/vendors/libs/jquery.mobile/jquery.mobile-1.4.3/bonvio_thems_jqm.css";</style>
    <link rel="stylesheet" href="/CM/resources/vendors/libs/jquery.mobile/jquery.mobile-1.4.3/bonvio_thems_jqm.css">
    <style type="text/css" media="screen">@import "/CM/resources/themes/tm_waiters/css/style.css";</style>
    <link rel="stylesheet" href="/CM/resources/themes/tm_waiters/css/style.css">

    <!-- Castom js-->
    <script type="application/x-javascript" src="/CM/resources/themes/tm_waiters/js/script.js"></script>

</head>
<body>

<!-- Admin Page -->
<div data-role="page" data-add-back-btn="false" data-back-btn-text="Назад" id="admin_page" data-theme="a">
    <div data-role="header" data-position="fixed">
        <h1>Lib Waiters - Администратор</h1>
        <a href="#demo-intro" data-rel="back" data-icon="carat-l" data-iconpos="notext">Back</a>
        <a href="#nav-panel" data-icon="bars" data-iconpos="notext">Menu</a>
    </div>
    <div data-role="content" >
        <ul class="admin_ulEventList" data-role="listview" data-inset="true" data-theme="a" data-dividertheme="b">
            <!-- NONE -->

            <style>
                .inMessage div{
                    float: right;
                }
                .extMessage div{
                    float: left;
                }

            </style>
<%--            <li data-role="list-divider">Администратор</li>
            <li class="extMessage" >
                <img src="/CM/resources/themes/tm_waiters/smailik.jpg">
                <div>
                    <h2>Ты где есть, дружище?</h2>
                    <p>Ты где есть, дружище?</p>
                </div>
            </li>--%>
            <li data-role="list-divider">Администратор</li>
            <li class="extMessage" >

                <div>

                    <p>Ты где есть, дружище?</p>
                </div>
            </li>
            <li data-role="list-divider">Waiter 1</li>
            <li class="inMessage">

                <div>

                    <p>Запой</p>
                </div>
            </li>
            <li data-role="list-divider">Администратор</li>
            <li class="extMessage">

                <div>

                    <p>Уволен! =)</p>
                </div>
            </li>
            <li data-role="list-divider">Waiter 1</li>
            <li class="inMessage">

                <div>

                    <p>Ну ок начальник</p>
                </div>
            </li>
            <li class="inMessage">

                <div>

                    <p>Ищи нового дурака)</p>
                </div>
            </li>
        </ul>
    </div>
    <%@include file="include/panel.jsp"%><!-- /panel -->
</div>


</body>
</html>

