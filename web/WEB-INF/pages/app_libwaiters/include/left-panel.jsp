<%--
  Created by IntelliJ IDEA.
  User: mil
  Date: 15.08.2014
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div data-role="panel" data-position-fixed="true" data-display="push" data-theme="b" id="left-panel">

    <ul data-role="listview">
        <li data-icon="delete">
            <a href="#" data-rel="close">Убрать</a>
        </li>

        <li><a href="createOrder_page" <%--onclick="onDrowMenu();"--%>>Создать заказ</a></li>

        <%--<li class="sideOrders"><a href="order_page">Позиции заказов<span class="ui-li-count">1</span></a></li>--%>
    </ul>


<%--    <form class="userform left-panelForm">
        <a class="btn" href="createOrder_page">Создать заказ</a>
    </form>--%>

</div><!-- /panel -->

