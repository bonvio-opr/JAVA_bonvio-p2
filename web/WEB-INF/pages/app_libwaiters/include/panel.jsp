<%--
  Created by IntelliJ IDEA.
  User: mil
  Date: 15.08.2014
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div data-role="panel" data-position-fixed="true" data-display="push" data-theme="b" id="nav-panel">
    <ul data-role="listview">
        <li data-icon="delete">
            <a href="#" data-rel="close">Убрать</a>
        </li>

        <li data-role="list-divider">События:</li>
        <li><a href="table_page">Столы<span class="ui-li-count">11</span></a></li>
        <li><a href="bar_page">Бар<span class="ui-li-count">1</span></a></li>
        <li><a href="kitchen_page">Кухня<span class="ui-li-count">12</span></a></li>
        <li><a href="admin_page">Администратор<span class="ui-li-count">2</span></a></li>

        <li data-role="list-divider">Сообщения:</li>
        <li class="sideMessages"><a href="message_page">Все сообщения<span class="ui-li-count">1</span></a></li>

        <li data-role="list-divider">Заказы:</li>
        <li class="sideOrders"><a href="order_page">Позиции заказов<span class="ui-li-count">1</span></a></li>
    </ul>
</div><!-- /panel -->
