<%--
  Created by IntelliJ IDEA.
  User: mil
  Date: 6/2/14
  Time: 4:24 PM
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
    <title>CM - menu</title>

    <!-- jQuery -->
    <script type="text/javascript" src="/CM/resources/vendors/libs/jquery/jquery-1.7.2.js"></script>
    <script type="application/x-javascript" src="/CM/resources/vendors/libs/jquery/jquery-1.11.0.js"></script>
    <script src="/CM/resources/vendors/libs/jquery/jquery-1.4.4.min.js"></script>

    <!-- jQuery Mobile -->
    <style type="text/css" media="screen">@import "/CM/resources/vendors/libs/jquery.mobile/jquery.mobile-1.2.0/css/jquery.mobile-1.0a2.css";</style>
    <script src="/CM/resources/vendors/libs/jquery.mobile/jquery.mobile-1.2.0/js/jquery.mobile-1.0a2.js" type="application/x-javascript" charset="utf-8"></script>

    <!-- Castom css-->
    <style type="text/css" media="screen">@import "/CM/resources/themes/tm_clients/css/style.css";</style>

    <!-- Castom js-->

</head>
<body>

<!-- Main Page -->
<div data-role="page" data-add-back-btn="false" data-back-btn-text="Назад" id="main_page" data-theme="c">
    <div data-role="header" data-position="fixed">
        <h1>Выберите жанр</h1>
    </div>
    <div data-role="content" >
        <%--
            HttpSession session = request.getSession();
            String uid = session.getAttribute("userid").toString();
        --%>
        <%--=uid --%>
        <ul data-role="listview" data-inset="true" data-theme="c">
            <%--<c:forEach items="${cafefullinfo.cafeSectors[0].listOfMenues}" var="categ">--%>
            <c:forEach items="${libfullinfo.cafeSectors[0].listOfMenues}" var="categ">
                <li><a href="#${categ.categoryCode}">${categ.categoryName}</a></li>
            </c:forEach>
        </ul>
    </div>
    <%--@include file="include/footer.jsp"--%>
</div>

<!-- CafeFullInfo -->
<div data-role="page" data-add-back-btn="true" data-back-btn-text="Назад" id="cafefullinfo" data-theme="a">
    <div data-role="header" data-position="fixed">
        <h1>Bonvio.net - cafefullinfo</h1>
    </div>
    <div data-role="content" >
        <h1>Bonvio.net</h1>
        <div>
            <%--${cafefullinfo}--%>
            ${libfullinfo}
        </div>
    </div>
</div>

<!-- CafePageFromMainPageList -->
<c:forEach items="${libfullinfo.cafeSectors[0].listOfMenues}" var="categ">
    <%--<c:forEach items="${cafefullinfo.cafeSectors[0].listOfMenues}" var="categ">--%>
    <div data-role="page" data-add-back-btn="true" data-back-btn-text="Назад" id="${categ.categoryCode}" data-theme="a">
        <div data-role="header" data-position="fixed">
            <h1>${categ.categoryName}</h1>
        </div>
        <div data-role="content" >
            <ul data-role="listview" data-inset="false" data-theme="c">
                <c:forEach items="${categ.positions}" var="position" varStatus="varStatus">
                    <li>
                        <a href="#${position.positionId}" data-transition="flip">

                            <%--<img style="border-radius: 10px;" src="/CM/resources/images/menu/pereplet.jpeg">--%>
                            <img style="border-radius: 10px;" src="../app_libwaiters/orders/getMenuPositionPicture/${position.positionId}">
                            <!--
                            <img src="/CM/resources/images/menu/$ {position.positionPicture}.jpeg">
                            -->
                            <h3>#${varStatus.index+1}: ${position.positionName}</h3>
                            <p>Описание: ${position.positionDescription}</p>
                            <p>Цена: ${position.positionPrice} руб.</p>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
            <%--@include file="include/footer.jsp"--%>
    </div>
</c:forEach>

<!-- CafePagePositionFromPositions -->
<c:forEach items="${libfullinfo.cafeSectors[0].listOfMenues}" var="categ">
    <%--<c:forEach items="${cafefullinfo.cafeSectors[0].listOfMenues}" var="categ">--%>
    <c:forEach items="${categ.positions}" var="position" varStatus="varStatus">
        <div data-role="page" data-add-back-btn="true" data-back-btn-text="Назад" id="${position.positionId}" data-theme="a">
            <div data-role="header" data-position="fixed">
                <h1>${categ.categoryName}</h1>
                    <%
                        HttpSession session = request.getSession();
                        //String uid = session.getAttribute("userid").toString();
                        //userTableNum
                        String userTableNum = session.getAttribute("userTableNum").toString();
                    %>
                <a href="#cafeOrder" onclick="onOrder('<%=userTableNum%>');" data-icon="check" id="" class="ui-btn-right add_local_storage">Счет</a>

            </div>
            <div data-role="content" >

                <h2 style="display: block; text-align: center;" >${position.positionName}</h2>
                <!--
                <img style="width: 100%; max-width: 300px;" src="/CM/resources/images/menu/${position.positionPicture}.jpeg">
                -->
                <img style="margin-bottom: 20px; width: 250px; border-radius: 10px; border: solid 1px black; display: block; margin: 0 auto;" src="../app_libwaiters/orders/getMenuPositionPicture/${position.positionId}">

                <div  style="width: 200px; border-radius: 10px; border: solid 1px gray; padding: 25px; line-height: 26px; margin: 0 auto;" data-role="fieldcontain">
                    <label for="desk">Описание:</label>
                    <span name="desk" id="desk">Описание: ${position.positionDescription}</span>
                    </br>
                    <label for="coast">Цена:</label>
                    <span name="coast" id="coast">${position.positionPrice} руб.</span>
                    </br>

                    <div style="">
                        <label>Количество:</label>
                        </br>
                        <select data-theme="a" id="positionQuantity_${position.positionId}">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                        </select>
                        </br>
                    </div>
                </div>

                <div style="margin-top: 10px;"></div>

                <input type="button" data-icon="plus" data-theme="a" class="toOrder" onclick="toOrder(1, ${position.positionId}, '${position.positionName}', '${position.positionPrice}', $('#positionQuantity_${position.positionId}').val() ); " value="Добавить в лист заказов"/>

                </br></br>

                <ul class="ulList" data-role="listview" data-inset="false" data-theme="a" data-split-icon='delete'>
                    <!--LISTVIEW-->
                </ul>

                </br></br>

                <form method="post" action="#" id="myForm">
                    <p><input type="button" data-theme="a" name="sendBtn" value="Оформить заказ" /></p>
                </form>

            </div>
        </div>

    </c:forEach>
</c:forEach>

<!-- CafeOrder -->
<div data-role="page" data-add-back-btn="true" data-back-btn-text="Назад" id="cafeOrder" data-theme="a">
    <div data-role="header" >
        <h1>Лист заказов</h1>
    </div>
    <div data-role="content" >
        <ul class="ulAmauntList" data-role="listview" data-inset="false" data-theme="a" data-split-icon='delete'>
            <!--LISTVIEW-->
        </ul>
        </br></br>
        <form method="post" action="#" id="orderForm">
            <p><input class="orderFormSendBtn" data-theme="a" type="button" name="sendBtn" value="Принести счет" /></p>
        </form>
    </div>
</div>

<!---->

<script type="application/x-javascript" src="/CM/resources/themes/tm_clients/js/script.js"></script>

</body>
</html>