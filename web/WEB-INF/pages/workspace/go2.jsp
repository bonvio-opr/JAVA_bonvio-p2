<%--
  Created by IntelliJ IDEA.
  User: mil
  Date: 22.10.2014
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setStatus(301);
    response.setHeader( "Location", "/CM/ok" );
    response.setHeader( "Connection", "close" );
%>