<%--
  Created by IntelliJ IDEA.
  User: mil
  Date: 29.08.2014
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>bonvio.net</title>

    <!-- Bootstrap -->
    <link href="/CM/resources/vendors/libs/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS -->
    <link href="/CM/resources/themes/tm_libmenuupload/css/style.css" type="text/css" rel="stylesheet" >

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="application/x-javascript" src="/CM/resources/vendors/jquery-2.1.0.min.js"></script>

    <script type="application/x-javascript" src="/CM/resources/themes/tm_libmenuupload/js/script.js"></script>


</head>

<body>
<div class="menuuploading-container">
    <table class="menuuploading-container-table-title">
        <tr>
            <td class="menuuploading-container-table-title-td" onclick=menuUploadSelectTab(0)>
                <h3>Меню</h3>
            </td>
            <td class="menuuploading-container-table-title-td" onclick=menuUploadSelectTab(1)>
                <h3>Ингредиенты</h3>
            </td>
        </tr>
    </table>
    <div class="menuuploading-container-menu menuuploading-container-div-item">
        <h3 style="text-align: center; color: white">Управление меню</h3>
        <fieldset class="menuuploading-fieldset">
            <table>
                <tr>
                    <td colspan="3">
                        <h4 style="text-align: center; color: white"><cite>Категории меню</cite></h4>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <table id="menuuploading-categories-list-table">

                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="text" id="menuuploading-categories-list-table-newcatname" placeholder="Название">
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="text" id="menuuploading-categories-list-table-newcatcode" placeholder="Код (латинница)">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <select name="categorytype" id="menuuploading-categories-list-table-newcattype">
                            <option value="1">Бар</option>
                            <option value="2">Кухня</option>
                            <option value="0">Остальное</option>
                        </select>
                    </td>
                    <td>
                        <h5 style="text-align: center; color: white">Принадлежность</h5>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button onclick=addCategory()>Добавить</button>
                    </td>
                </tr>
            </table>
        </fieldset>
        <br/>
        <fieldset class="menuuploading-fieldset">
            <form method="post" action="/CM/app_libmenuupload/job/addPositionWithoutRecipe" enctype="multipart/form-data">
                <table id="menuuploading-add-wo-recipe" style="border: 1px solid black">
                    <tr>
                        <td colspan="3">
                            <h4 style="text-align: center; color: white"><cite>Добавление позиции без рецепта</cite></h4>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="language">
                                <option value="1">Русский</option>
                                <option value="2">Английский</option>
                                <option value="3">Французский</option>
                                <option value="4">Немецкий</option>
                                <option value="5">Украинский</option>
                                <option value="6">Испанский</option>
                                <option value="7">Итальянский</option>
                            </select>
                        </td>
                        <td>
                            <h5 style="text-align: center; color: white">Язык</h5>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="text" name="name">
                        </td>
                        <td>
                            <h5 style="text-align: center; color: white">Название</h5>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="file" name="file">
                        </td>
                        <td>
                            <h5 style="text-align: center; color: white">Изображение</h5>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="text" name="price">
                        </td>
                        <td>
                            <h5 style="text-align: center; color: white">Цена</h5>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <textarea name="description"></textarea>
                        </td>
                        <td>
                            <h5 style="text-align: center; color: white">Описание (опционально)</h5>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="category" id="menuuploading-add-wo-recipe-category">

                            </select>
                        </td>
                        <td>
                            <h5 style="text-align: center; color: white">Категория</h5>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" style="width: 80px" name="quantity">
                        </td>
                        <td>
                            <select style="width: 80px" name="units">
                                <option value="шт">шт</option>
                                <option value="гр">гр</option>
                                <option value="л">л</option>
                            </select>
                        </td>
                        <td>
                            <h5 style="text-align: center; color: white">Кол-во</h5>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="checkbox" checked name="included"/>
                        </td>
                        <td>
                            <h5 style="text-align: center; color: white">Добавить в меню</h5>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <%--<button onclick=addPositionWithoutRecipe()>Добавить</button>--%>
                            <input type="submit" value="Добавить" />
                        </td>
                    </tr>
                    <%--<tr>
                        <td colspan="3">
                            <c:if test="${positionWithoutRecipeUploadError != ''}">
                                <span style="color:red"><b><c:out value="${positionWithoutRecipeUploadError}"/></b></span>
                            </c:if>
                        </td>
                    </tr>--%>
                </table>
            </form>

        </fieldset>

    </div>
    <div class="menuuploading-container-ingr menuuploading-container-div-item">
        <h3 style="text-align: center; color: white">Управление ингредиентами</h3>
        <fieldset class="menuuploading-fieldset">
            <table>
                <tr>
                    <td colspan="3">
                        <h4 style="text-align: center; color: white"><cite>Добавление ингредиентов</cite></h4>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Название </label>
                    </td>
                    <td>
                        <input type="text" id="menuuploading-insertingr-newingrname">
                    </td>
                    <td>
                        <button onclick=addIngr()>Добавить</button>
                    </td>
                </tr>
            </table>
        </fieldset>
        <br/>
        <fieldset class="menuuploading-fieldset">
            <table>
                <tr>
                    <td colspan="3">
                        <h4 style="text-align: center; color: white"><cite>Поиск и удаление ингредиентов</cite></h4>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <table id="menuuploading-ingredients-table"></table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" id="menuuploading-searchingr">
                    </td>
                    <td>
                        <button onclick=searchIngr()>ОК</button>
                    </td>
                    <td>
                        <button onclick=showAll()>Показать всё</button>
                    </td>
                </tr>
            </table>
        </fieldset>
    </div>
</div>


</body>
<%--<body>



<div class="container">
    <header>
        <h1>BONVIO.COM</h1>
    </header>

    <ul class="nav nav-tabs" role="tablist" id="myTab">
        <li class="active"><a href="#ingredients" role="tab" data-toggle="tab">Ingredients</a></li>
        <li><a href="#menu" role="tab" data-toggle="tab">Menu</a></li>
        <li><a href="#settings" role="tab" data-toggle="tab">Настройки</a></li>
    </ul>

    <div class="tab-content">

        <!-- ingredients -->
        <div class="tab-pane active" id="ingredients">

            <div class="panel panel-default">
                <div class="panel-heading">ADD</div>
                <div class="panel-body">
                    <form class="form" role="form">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">Ingredients name</div>
                                <input class="form-control" type="name" placeholder="Enter ingredients name">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="btn-group">
                                <button type="submit" class="btn btn-default">Add</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">SEARCH</div>
                <div class="panel-body">
                    <form class="form" role="form">
                        <div class="form-group">
                            <div class="input-group">
                                <input class="form-control" type="name" placeholder="Search...">
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">OK</button>
                            <button type="submit" class="btn btn-default">Clear</button>
                            <button type="submit" class="btn btn-default">View all</button>
                        </div>
                        <div class="form-group">
                            <textarea class="form-control" rows="3"></textarea>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" value="">
                                Delete
                            </label>
                        </div>
                        <div class="checkbox disabled">
                            <label>
                                <input type="checkbox" value="" disabled>
                                ...
                            </label>
                        </div>

                    </form>
                </div>
            </div>

        </div>

        <!-- menu -->
        <div class="tab-pane" id="menu">

            <div class="panel panel-default">
                <div class="panel-heading">Category nemu</div>
                <div class="panel-body">
                    <form class="form" role="form">

                        <div class="form-group">
                            <textarea class="form-control" rows="3"></textarea>
                        </div>

                        <div class="checkbox">
                            <label>
                                <input type="checkbox" value="">
                                Delete
                            </label>
                        </div>

                        <div class="checkbox disabled">
                            <label>
                                <input type="checkbox" value="" disabled>
                                ...
                            </label>
                        </div>

                        <div class="form-group">
                            <div class="input-group">
                                <input class="form-control" type="name" placeholder="">
                            </div>
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-default">Add</button>
                        </div>

                    </form>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">Add position without rules</div>
                <div class="panel-body">
                    <form class="form" role="form">

                        <div class="form-group">
                            <select class="form-control">
                                <option>Russion</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <div class="input-group">
                                <input class="form-control" type="name" placeholder="Name">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group">
                                <input class="form-control" type="name" placeholder="Price">
                            </div>
                        </div>

                        <div class="form-group">
                            <textarea class="form-control" rows="3"></textarea>
                        </div>

                        <div class="form-group">
                            <label for="exampleInputFile">File input</label>
                            <input type="file" id="exampleInputFile">
                            <p class="help-block">*.jpg or *.png only</p>
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-default">Add</button>
                        </div>

                    </form>
                </div>

            </div>

            <div class="panel panel-default">
                <div class="panel-heading">Rules modificate</div>
                <div class="panel-body">
                    <form class="form" role="form">

                        <div class="form-group">
                            <button type="submit" class="btn btn-default">Dell</button>
                        </div>

                        <div class="form-group">
                            <select class="form-control">
                                <option>ggg</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <textarea class="form-control" rows="3"></textarea>
                        </div>

                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <input type="checkbox">
                                </span>
                                <input type="text" class="form-control">
                            </div><!-- /input-group -->
                        </div>

                    </form>
                </div>
            </div>

        </div>

        <!-- settings -->
        <div class="tab-pane" id="settings">...</div>
    </div>
</div>


    <script>
        $(function () {
            $('#myTab a:last').tab('show')
        })
    </script>

    <!-- JavaScript-->
    <script src="/CM/resources/themes/libs/JQ/jquery-1.10.2.js"></script>
    <!-- JavaScript -->
    <script src="/CM/resources/themes/libs/JQ/jquery-1.11.0.js"></script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins)-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/CM/resources/themes/libs/bootstrap/js/bootstrap.js"></script>
</body>--%>
</html>
