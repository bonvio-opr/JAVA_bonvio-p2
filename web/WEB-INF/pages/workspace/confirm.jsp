<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="true" %>
<%@ page errorPage="error.jsp" %>

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
    <link href="/CM/resources/vendors/libs/bootstrap/css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/CM/resources/themes/tm_login/css/signin.css">
</head>
<body>
<div class="wrapper">
    <div class="container">
        <fieldset>
            <!-- AuthForm -->
            <form action="proceed" method="post" class="form-signin" role="form">
                <div class="logo">
                    <img src="/CM/resources/images/logo_no_back.png"/>
                    <span>.net</span>
                </div>

                <input class="form-control" type="text" name="lcode" size="4"/>

                <div class="panel panel-default">
                    <div class="panel-heading">

                        <c:if test="${lastconfirmationnum != null}">
                            <span>Код подтверждения (4 цифры) для номера +7${lastconfirmationnum}:</span>
                            <input class="form-control" type="hidden" name="lnum" value="${lastconfirmationnum}" />
                        </c:if>
                        <c:if test="${lastconfirmationnum == null}">
                            <span>Код подтвеждения (4 цифры):</span>
                            <input class="form-control" type="hidden" value="" />
                        </c:if>


                    </div>
                </div>

                <button type="button" class="btn btn-primary btn-lg btn-block" type="submit" value="Продолжить"/>Продолжить</button>

                <c:if test="${lasterror != null}"><b><span style="color: red">Неверный код</span></b></c:if>

                <a class="btn" href="logout"><span>На главную</span></a>

                <a class="btn" href="restore"><span>Выслать пароль</span></a>


            </form>
        </fieldset>
    </div> <!-- /container -->
    </div>
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
</body>
</html>