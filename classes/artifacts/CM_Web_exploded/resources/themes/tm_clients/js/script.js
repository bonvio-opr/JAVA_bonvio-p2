
/***/
$(document).ready(function(){
    PositionUlListView();

    localStorage.removeItem("LS_OrderId");
})

var globalDel = 0;

/***/
function CreatLS_Order(tableNum, positionId, positionQuantity) {
    var Order = {
        tblNum: tableNum,
        orderPositions: [{positionId: positionId, positionQuantity: positionQuantity}]
    };
    var JSON_Order = JSON.stringify(Order);
    localStorage.setItem("LS_JSON_Order", JSON_Order);
}


/***/
function Increment_orderPositions(positionQuantity, incQuantity) {
    positionQuantity = parseInt(positionQuantity);
    incQuantity = parseInt(incQuantity);
    positionQuantity += incQuantity;
    return positionQuantity+"";
}


/***/
function AddLS_orderPositions(tableNum, positionId, positionQuantity) {
    var Order = JSON.parse(localStorage.getItem("LS_JSON_Order")),
        orderPositions = Order.orderPositions,
        check = 0;
    for (i=0; i<orderPositions.length; i++){
        if (orderPositions[i].positionId == positionId) {
            orderPositions[i].positionQuantity = Increment_orderPositions(orderPositions[i].positionQuantity, positionQuantity);
            check = 1;
        }
        removeItem(orderPositions[i].positionId);
    }
    if (check == 0) {
        Order.orderPositions.push({positionId: positionId, positionQuantity: positionQuantity});
    }
    var JSON_Order = JSON.stringify(Order);
    localStorage.setItem("LS_JSON_Order", JSON_Order);
}


/***/
function PositionUlListView(){

    var posName;
    var posPrice;
    var positionId = 0;

    if(localStorage.getItem("LS_JSON_Order") !== undefined && localStorage.getItem("LS_JSON_Order") !== null) {
        var Order = JSON.parse(localStorage.getItem("LS_JSON_Order")),
            orderPositions = Order.orderPositions,
            ulItem = $("ul.ulList"),
            tdMask = 'tdl_';
        for (i=0; i<orderPositions.length; i++){

            positionId = orderPositions[i].positionId;

            posName = localStorage.getItem("SL_Order_Desc_Name_"+positionId);
            posPrice = localStorage.getItem("SL_Order_Desc_Price_"+positionId);

            ulItem
                .prepend($('<li onclick="shishkinAlert('+orderPositions[i].positionId+');" data-role="option" class="tdLi '+tdMask+orderPositions[i].positionId+'"></li>')
                    .append($('' +
                        '<a href="#" onclick="shishkinAlert('+orderPositions[i].positionId+');" data-theme="a">' +
                        '<img style="margin-bottom: 20px; margin: 10px; height: 60px; border-radius: 4px; border: solid 1px black; display: block; float: left;" src="../app_libwaiters/orders/getMenuPositionPicture/'+orderPositions[i].positionId+'">' +
                        '<h3>Наименование: '+posName+'</h3>' +
                        '<p>Цена: '+posPrice+'</p>' +
                        '<p>Количество: '+orderPositions[i].positionQuantity+'</p>' +
                        '<a href="#" onclick="shishkinAlert('+orderPositions[i].positionId+');" data-theme="a"></a>' +
                        '</a>' +
                        '')
                )
            );

        }
        ulItem.listview('refresh');
    }
}


/***/
function removeItem(value) {
    var ulItem = $("ul.ulList"),
        tdMask = 'tdl_',
        className = tdMask+value;
    $('.'+className).remove();
}


/***/
function delOrderPosition(value) {
    globalDel++;
    if(localStorage.getItem("LS_JSON_Order") !== undefined && localStorage.getItem("LS_JSON_Order") !== null) {
        var Order = JSON.parse(localStorage.getItem("LS_JSON_Order")),
            orderPositions = Order.orderPositions,
            dellOrder;
        for (i=0; i<orderPositions.length; i++){
            if (value == Order.orderPositions[i].positionId) {
                dellOrder = i;
            }
        }
        Order.orderPositions.splice(dellOrder, 1);
        var JSON_Order = JSON.stringify(Order);
        if (globalDel == 1) {
            localStorage.setItem("LS_JSON_Order", JSON_Order);
        } else {
            globalDel = 0;
        }
    }
}


/***/
function shishkinAlert(value) {
    removeItem(value);
    delOrderPosition(value);
}


/***/
function Add_orderDesc(positionId, positionName, positionPrice) {
    localStorage.setItem("SL_Order_Desc_Name_"+positionId, positionName);
    localStorage.setItem("SL_Order_Desc_Price_"+positionId, positionPrice);
}


/***/
function toOrder(tableNum, positionId, positionName, positionPrice, positionQuantity) {

    Add_orderDesc(positionId, positionName, positionPrice);

    if(localStorage.getItem("LS_JSON_Order") !== undefined && localStorage.getItem("LS_JSON_Order") !== null) {
        AddLS_orderPositions(tableNum, positionId, positionQuantity);
    } else {
        CreatLS_Order(tableNum, positionId, positionQuantity);
    }
    //PositionUlListView("last");

    PositionUlListView();
}

/***/
$(function() {
    $("#myForm input").click(function() {
        var Order = JSON.parse(localStorage.getItem("LS_JSON_Order")),
            orderPositions = Order.orderPositions,
            postOrder = {orderPositions: orderPositions};
        $.ajax({
            type: 'post',
            url:'order/add',
            data: JSON.stringify(postOrder),
            contentType: 'application/json',
            success: function(postOrder) {
                alert(postOrder);
                localStorage.setItem("LS_OrderId", postOrder);
                localStorage.removeItem("LS_JSON_Order");
                $('.tdLi').remove();
                viewOrder(postOrder);
            },
            error: function() {
                alert('DEBUG: error')
            }
        });
        return false;
    });
});



/***/
 function onOrder(userTableNum) {
    var orderId = localStorage.getItem("LS_OrderId");

    localStorage.setItem("LS_userTableNum", userTableNum);

    viewOrder(orderId);
 }

/***/
function viewOrder(orderId){
    getOrderByOrderId(orderId);
    console.log(orderId);
}


/***/
function getOrderByOrderId(orderId) {
    $.ajax({
        type:'post',
        url:'order/show',
        data: {
            orderId: orderId
        },
        success: function(amaunt){
            console.log(amaunt);
            refrashLocalStorageAmaunt(amaunt);
        },
        error: function(){
            alert('huy');
        }
    });
    return false;
}


/***/
function refrashLocalStorageAmaunt(amaunt) {
    //var LS_JSON_Amaunt = JSON.stringify(amaunt));
    //localStorage.setItem("LS_JSON_Amaunt", amaunt);
    $('.ulAmauntList li').remove();
    //viewAmaunt(amaunt);

    var
        positionDescription,
        positionId,
        positionLanguage,
        positionName,
        positionPrice,
        positionQuantity,
        positionQuantityInOrder,
        positionStatus ,
        positionUnits;

    var
        fullPositionPrice = 0;

    $('.ulAmauntList').append('<li>Заказано позиций: <span class="amauntCount">2</span></li>');

    for (i = 0; i < amaunt.length; i++) {

        positionId = amaunt[i].positionId;
        positionName = amaunt[i].positionName;
        positionDescription = amaunt[i].positionDescription;
        positionQuantityInOrder = amaunt[i].positionQuantityInOrder;
        positionPrice = amaunt[i].positionPrice;

        $('.ulAmauntList').append('' +
            '<li><a>' +
            '<img style="margin-bottom: 20px; margin: 10px; height: 60px; border-radius: 4px; border: solid 1px black; display: block; float: left;" src="../app_libwaiters/orders/getMenuPositionPicture/'+positionId+'">' +
            '<h2>'+positionName+'</h2>' +
            '<p>'+positionDescription+'</p>' +
            '<p>'+positionPrice*positionQuantityInOrder+' рублей.</p>' +
            '<span class="ui-li-count positionQuantity">'+positionQuantityInOrder+'</span>' +
            '</a></li>');

        fullPositionPrice += positionPrice*positionQuantityInOrder;
    }

    $('.amauntCount').text(i);

    $('.ulAmauntList').append('<li>Итогова сумма: '+fullPositionPrice+' рублей.</li>');

    $('.ulAmauntList').listview('refresh');

}


/***/
/*orderForm*/
$(function() {
    $("#orderForm input").click(function() {
        var orderId = localStorage.getItem("LS_OrderId");
        var userTableNum = localStorage.getItem("LS_userTableNum");
        $.ajax({
            type:'post',
            url:'order/closeOrder',
            data: {
                tblNum: userTableNum,
                orderId: orderId},
            success: function(d){
                console.log(d);
            }, error: function(){
                alert('huy');
            }
        })
        return false;
    });
});
