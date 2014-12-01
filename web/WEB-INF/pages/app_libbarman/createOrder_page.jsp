<%--
  Created by IntelliJ IDEA.
  User: mil
  Date: 10.09.2014
  Time: 17:03
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


    <script>

    </script>

</head>
<body>

<!-- Order By Id Page -->
<div data-role="page" data-add-back-btn="false" data-back-btn-text="Назад" id="createOrder_page" data-theme="a">
    <div data-role="header" data-position="fixed">
        <h1>Lib Waiters - Создать заказ</h1>
        <a data-rel="back" data-icon="carat-l" data-iconpos="notext">Back</a>
        <%--<a onclick="window.location.reload()" data-icon="back" data-iconpos="notext">Refresh</a>--%>
        <%--<a href="#right-panel" data-icon="bars" data-display="overlay" data-iconpos="notext">Menu</a>--%>
    </div><!-- /header -->
    <div data-role="content" >

        <label for="text-basic">Номер стола:</label>
        <input class="tableNum"  type="text" name="text-basic" id="text-basic" value="10">

        <%--<select class="tableNum" name="select-choice-a" id="select-choice-a" data-native-menu="false">
            <option>Номер стола:</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
        </select>--%>

        </hr></br></br>


        <div data-role="popup" id="popupDialogCreate" data-overlay-theme="b" data-theme="b" data-dismissible="false" style="max-width:400px;">
            <div data-role="header" data-theme="a">
                <h1>Заказ</h1>
            </div>
            <div role="main" class="ui-content">
                <h3 class="ui-title">Заказ создан.</h3>
                <p>Данный заказ можно посмотреть на странице <a href="/CM/app_libwaiters/">входящих сообщений</a></p>
                <a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" data-rel="back" data-transition="flow">ОК</a>
            </div>
        </div>

        <ul class="createOrder_ullistView" data-role="listview">
            <li data-icon="delete" data-role="option">Итоговая сумма: <strong class="fullAmount">0</strong> рублей. </li>
            <!-- NONE -->
        </ul>

        </hr></br></br>
        <a href="#popupDialogCreate" data-rel="popup" data-position-to="window" data-transition="pop" onclick="onClearMenu(); onCreateOrder()" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-icon-check ui-btn-icon-left ui-btn-b">Оформить заказ</a>
        <a href="" onclick="onClearMenu();" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-icon-delete ui-btn-icon-left ui-btn-b">Очистить список заказа</a>

        </hr></br></br>

        <div class="createOrder_ulMenuCategoryList" data-role="collapsibleset" data-inset="false">
            <!-- NONE -->
        </div>

        <p class="ui-btn" onclick="onDrowMenu();">Показать меню</p>
        <%--
        <ul class="createOrder_ulMenuCategoryList" data-role="listview" data-theme="a" data-dividertheme="b" data-filter="true" data-filter-theme="a" data-filter-placeholder="Поиск...">
            <!-- NONE -->
        </ul>
        --%>

    </div><!-- /content -->
    <div data-role="footer" data-position="fixed">
        <h4></h4>
    </div><!-- /footer -->
    <%--<%@include file="include/right-panel.jsp"%>--%><!-- /panel -->
</div>

</body>
</html>
