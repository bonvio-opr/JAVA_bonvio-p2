<%--
  Created by IntelliJ IDEA.
  User: Arti
  Date: 12.08.2014
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>

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

    <%--
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a1/jquery.mobile-1.0a1.min.css" />
    --%>

    <%--    <script src="http://code.jquery.com/jquery-1.4.3.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.0a1/jquery.mobile-1.0a1.min.js">
        </script>
        <script src="http://jquery.ibm.navitend.com/utils.js"></script>--%>

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
<body style="height: 100%;">

<!-- Main Page -->
<div data-role="page" data-add-back-btn="false" data-back-btn-text="Назад" id="page_main" data-theme="a">
    <div data-role="header" data-position="fixed">
        <h1>Lib Waiters</h1>

        <a href="#left-panel" data-display="reveal" data-icon="bars" data-iconpos="notext">Menu</a>
        <!--
                <a href="#" onclick="window.location.reload()" data-icon="back" data-iconpos="notext">Refresh</a>

                <a href="#right-panel" data-icon="bars" data-iconpos="notext">Menu</a>
                -->
    </div><!-- /header -->
    <div data-role="content" >
        <ul class="main_ulEventList touch ui-listview-outer" data-role="listview" data-theme="a" data-icon="false" data-split-icon="delete" data-dividertheme="b" data-filter="true" data-filter-theme="a" data-filter-placeholder="Поиск...">
            <!-- NONE -->
        </ul>
    </div><!-- /content -->
    <div data-role="footer" data-position="fixed">
        <h4></h4>
    </div><!-- /footer -->
    <%@include file="include/left-panel.jsp"%><!-- /panel -->

</div>

</body>
</html>
