<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>BONVIO.net - подтверждение учетной записи</title>
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
                <form action="proceed" method="post" class="form" role="form">
                    <table class="table">
                        <tr>
                            <td>
                                <c:if test="${lastconfirmationnum != null}">
                                    <span>Код подтверждения (4 цифры) для номера +7${lastconfirmationnum}:</span>
                                    <input type="hidden" name="lnum" value="${lastconfirmationnum}" />
                                </c:if>
                                <c:if test="${lastconfirmationnum == null}">
                                    <span>Код подтвеждения (4 цифры):</span>
                                    <input type="hidden" value="" />
                                </c:if>

                            </td>
                            <td>
                                <input type="text" name="lcode" size="4"/>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-default">Продолжить</button>
                                <c:if test="${lasterror != null}"><b><span style="color: red">Неверный код</span></b></c:if>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <a href="logout"><span>На главную</span></a>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <a href="restore"><span>Выслать пароль</span></a>
                            </td>
                        </tr>
                    </table>
                </form>
            </fieldset>
        </div> <!-- /container -->
    </div>
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
</body>
</html>