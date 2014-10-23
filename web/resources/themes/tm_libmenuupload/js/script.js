(function() {
    $(document).ready(function() {
        menuUploadSelectTab(0);
        $.ajax({
            url: '/CM/app_libmenuupload/job/getCategories',
            type: 'post',
            success: function(d) {
                var $tbl = $('table#menuuploading-categories-list-table'),
                    $sel = $('select#menuuploading-add-wo-recipe-category');
                if(d.length>0) {
                    $sel
                        .empty();
                    for(var i=0; i< d.length; i++) {
                        var catType='Прочее';
                        if(d[i]['categoryType']==1) {catType='Бар';}
                        else if(d[i]['categoryType']==2) {catType='Кухня';}
                        $sel
                            .append($('<option>', {
                                value : d[i]['categoryId'] }
                            )
                            .text(d[i]['categoryName'])
                        );
                        $tbl
                            .append($('<tr/>')
                                .append($('<td style="text-align:center; width: 300px"/>')
                                    .append($('<h5/>')
                                        .append(d[i]['categoryName'] + ' ('+catType+')')
                                    )
                                )
                                .append($('<td/>')
                                    .append('<button style="cursor: default" onclick=deleteCategory('+d[i]['categoryId']+')>Удалить</button>')
                                )
                            )
                    }
                } else {
                    $tbl
                        .append($('<tr/>')
                            .append($('<td colspan="2"/>')
                                .append($('<h5/>')
                                    .append('Не добавлено ни одной категории<br/>Добавьте категорию.')
                                )
                            )
                    )
                }
            },
            error: function() {
                console.log('cannot get cafe menu Categories');
            }
        });
    });
})();

function menuUploadSelectTab(i) {
    $('.menuuploading-container-div-item').hide();
    $('.menuuploading-container-table-title-td').removeClass("menuuploading-container-table-title-active");
    $('.menuuploading-container-table-title-td').eq(i).addClass("menuuploading-container-table-title-active");
    if(i===0) {
        $('.menuuploading-container-menu').show();
    } else if(i===1) {
        $('.menuuploading-container-ingr').show();
    }
}

function addCategory() {
    var cName = $('#menuuploading-categories-list-table-newcatname').val(),
        cCode = $('#menuuploading-categories-list-table-newcatcode').val(),
        cType = $('#menuuploading-categories-list-table-newcattype').val();
    if((cName.length * cCode.length) > 0 ) {
        $.ajax({
            url: '/CM/app_libmenuupload/job/addCategory',
            type: 'post',
            data: {
                catName: cName,
                catCode: cCode,
                catType: cType
            },
            success: function(d) {
                if(d===1)
                    location.reload();
                else
                    alert("Ошибка добавления новой категории");
            },
            error: function() {
                console.log('error while adding new category')
            }
        })

    } else {
        alert('Заполните оба поля: название и код');
    }
}

function deleteCategory(i) {
    $.ajax({
        url: '/CM/app_libmenuupload/job/deleteCategory',
        type: 'post',
        data: {
            catId: i
        },
        success: function(d) {
            if(d===1)
                location.reload();
            else
                alert("Ошибка удаления категории");
        },
        error: function() {
            console.log('error while adding new category')
        }
    })
}

function removeIngr(ingrId) {
    $.ajax({
        url: '/CM/app_libmenuupload/job/ingredientRemove',
        type: 'post',
        data: {
            ingredientId: ingrId
        },
        success: function (d) {
            if (d === 1)
                location.reload();
            else
                alert("Ошибка удаления ингредиента");
        },
        error: function () {
            console.log('error while removing new ingredient')
        }
    });
}

function addIngr() {
    var ingrName = $('input#menuuploading-insertingr-newingrname').val();
    if(ingrName.length>0) {
        $.ajax({
            url: '/CM/app_libmenuupload/job/ingredientAdd',
            type: 'post',
            data: {
                ingredientName: ingrName
            },
            success: function (d) {
                if (d === 1)
                    location.reload();
                else
                    alert("Ошибка добавления ингредиента");
            },
            error: function () {
                console.log('error while adding new ingredient')
            }
        })
    } else {
        $('input#menuuploading-insertingr-newingrname').val('');
        alert('Задайте непустое название для ингредиента');
    }
}

function searchIngr() {
    var iName = $('#menuuploading-searchingr').val();
    if(iName.length>=2) {
        $.ajax({
            url: '/CM/app_libmenuupload/job/ingredientsShowByNamePart',
            type: 'post',
            data: {
                namePart: iName
            },
            success: function (d) {
                var $tbl = $('table#menuuploading-ingredients-table');
                if (d.length > 0) {
                    $tbl.empty();
                    for (var i = 0; i < d.length; i++) {
                        $tbl
                            .append($('<tr/>')
                                .append($('<td style="text-align:center; width: 300px"/>')
                                    .append($('<h5/>')
                                        .append(d[i]['ingredientName'])
                                )
                            )
                                .append($('<td/>')
                                    .append('<button style="cursor: default" onclick=removeIngr(' + d[i]['ingredientId'] + ')>Удалить</button>')
                            )
                        )
                    }
                } else {
                    $tbl
                        .empty()
                        .append($('<tr/>')
                            .append($('<td colspan="2"/>')
                                .append($('<h5/>')
                                    .append('Поиск не дал результатов.')
                            )
                        )
                    )
                }
            },
            error: function () {
                console.log('cannot get cafe menu Categories');
            }
        })
    } else {
        alert('Введите больше 2 символов');
    }
}

function showAll() {
    $.ajax({
        url: '/CM/app_libmenuupload/job/ingredientsShowAll',
        type: 'post',
        success: function (d) {
            var $tbl = $('table#menuuploading-ingredients-table');
            if (d.length > 0) {
                $tbl.empty();
                for (var i = 0; i < d.length; i++) {
                    $tbl
                        .append($('<tr/>')
                            .append($('<td style="text-align:center; width: 300px"/>')
                                .append($('<h5/>')
                                    .append(d[i]['ingredientName'])
                            )
                        )
                            .append($('<td/>')
                                .append('<button style="cursor: default" onclick=removeIngr(' + d[i]['ingredientId'] + ')>Удалить</button>')
                        )
                    )
                }
            } else {
                $tbl
                    .empty()
                    .append($('<tr/>')
                        .append($('<td colspan="2"/>')
                            .append($('<h5/>')
                                .append('Не добавлено ни одного ингредиента.<br/>Воспользуйтесь формой вверху страницы')
                        )
                    )
                )
            }
        },
        error: function () {
            console.log('cannot get cafe menu Categories');
        }
    })
}

function addPositionWithoutRecipe() {
    var rLang = $('#menuuploading-add-wo-recipe-language').val(),
        rName = $('#menuuploading-add-wo-recipe-name').val(),
        rPrice = $('#menuuploading-add-wo-recipe-price').val(),
        rDescr = $('#menuuploading-add-wo-recipe-description').val(),
        rCategCode = $('#menuuploading-add-wo-recipe-category').val(),
        rQuant = $('#menuuploading-add-wo-recipe-quantity').val(),
        rUnits = $('#menuuploading-add-wo-recipe-units').val(),
        rIncluded = $('#menuuploading-add-wo-recipe-included');
    if(rName.length<1) {alert('Укажите название');}
    else if(isNaN(rPrice) || rPrice.length<1) {alert('Некорректная цена');}
    else if(!rCategCode) {alert('Не найдено категории. Добавьте хотя бы одну категорию меню (вверху страницы)');}
    else if(!rQuant) {alert('Некорректное количество');}
    else if(!rUnits) {alert('Некорректные ед.изм.');}
    else {
        console.log('Данные корректны, добавляем позицию в меню');
    }
}

function addPositionWithRecipe() {
    alert('position added with recipe');
}






























