
/**Init*/
$(document).ready(function(){
    start();
});


/**Start Core*/
function start(){
    console.log('start');
    refrashGetFull(); //read LS
    getMenu();
    startTimer(1);  //sec = 1*1000mc
}


/**Start Timer*/
function startTimer(interval){
    console.log('start startTimer');
    setInterval(function() {
        getEvents(); //JSON -> to LS rewrite
        //getOrders(); //JSON -> to LS rewrite
        //getMessages(); //JSON -> to LS rewrite
        refrashGetFull(); //read LS
    }, interval*1000);
}


/**Start Safe Scroll Position*/
function refrashGetFull() {
    console.log('start refrashGetFull');

    function getBodyScrollTop() { return self.pageYOffset || (document.documentElement && document.documentElement.scrollTop) || (document.body && document.body.scrollTop); };
    var scrolltop = getBodyScrollTop(); //* Позиция строла в пикселях

    drow();

    //* На заметку: методы scrollBy(numHorz, numVert) и scrollTo(numX, numY) так же позволяют прокуручивать содержимое объекта.
    scrollTo(0, scrolltop);
}


/**Start Drow*/
function drow() {
    console.log('start drow');
    // JSON_lsEvents
    if(localStorage.getItem("JSON_lsEvents") !== undefined && localStorage.getItem("JSON_lsEvents") !== null) {
        var lsEvents = JSON.parse(localStorage.getItem("JSON_lsEvents"));
        var ulList = '.main_ulEventList';
        var ulListItems = ulList+' li';
        clearListByClass(ulListItems);
        printEvents(ulList, lsEvents);
    }
    // JSON_lsOrderById
    if(localStorage.getItem("JSON_lsOrderById") !== undefined && localStorage.getItem("JSON_lsOrderById") !== null) {
        var lsOrderById = JSON.parse(localStorage.getItem("JSON_lsOrderById"));
        var ulList = '.orderById_ulEventList';
        var ulListItems = ulList+' li';
        clearListByClass(ulListItems);
        printOrderById(ulList, lsOrderById);
    }
    //JSON_lsOrderMenu
    if(localStorage.getItem("JSON_lsOrderMenu") !== undefined && localStorage.getItem("JSON_lsOrderMenu") !== null) {
        var lsOrderMenu = JSON.parse(localStorage.getItem("JSON_lsOrderMenu"));
        var ulList = '.createOrder_ulMenuCategoryList';
        var ulListItems = ulList+' div';
        //clearListByClass(ulListItems);
        //printOrderMenu(ulList, lsOrderMenu, 2);
    }
}


/**Clear Class*/
function clearListByClass(removeClass) {
    console.log('start clearListByClass');
    $(removeClass).remove();
}


//======== START Print Events ==========

/**Print events*/
function printEvents(printClass, Events) {
    console.log('start printEvents');
    for (i=0; i<Events.length; i++) {
        switch (Events[i].eventSourceBelongsTo) {
            case (1): printOrderItem (printClass, Events[i]);
                break;
            case (2): //printMessageItem (printClass, Events[i]);
                break;
            default : console.log('noneTypeCource '+Events[i]);
        }
    }
}


/**Print Order by EventsList*/
function printOrderItem (printClass, OrderItem) {
    console.log('start printOrderItem');
    var
        eventContent = OrderItem.eventContent, //"8 стол: новый заказ"
        eventHeader = OrderItem.eventHeader, //"1" - table number
        eventId = OrderItem.eventId, //61
        eventIsDeleted = OrderItem.eventIsDeleted, //0
        eventIsExposed = OrderItem.eventIsExposed, //0
        eventOrderId = OrderItem.eventOrderId, //150
        eventSourceBelongsTo = OrderItem.eventSourceBelongsTo, //1
        eventSpotId = OrderItem.eventSpotId, //10000
        eventTimestamp = OrderItem.eventTimestamp, //"11:36:39 20.08.2014"
        eventType = OrderItem.eventType; //11
    var eventExposed = '';
    if (eventIsExposed == 1) {
        eventExposed = '';
    } else if (eventIsExposed == 0) {
        eventExposed = 'eventUnRead';
    }
    printOrderByEventList(printClass, eventExposed, eventId, eventOrderId, eventHeader, eventContent, eventTimestamp);
}


/**Print Messages by EventsList*/
function printMessageItem (printClass, MessageItem) {
    console.log('start printMessageItem');
    var
        eventContent = MessageItem.eventContent, //"входящее сообщение от КТО-ТО"
        eventHeader = MessageItem.eventHeader, //null
        eventId = MessageItem.eventId, //63
        eventIsDeleted = MessageItem.eventIsDeleted, //0
        eventIsExposed = MessageItem.eventIsExposed, //0
        eventOrderId = MessageItem.eventOrderId, //5
        eventSourceBelongsTo = MessageItem.eventSourceBelongsTo, //2
        eventSpotId = MessageItem.eventSpotId, //0
        eventTimestamp = MessageItem.eventTimestamp, //"12:02:36 21.08.2014"
        eventType = MessageItem.eventType; //27
    var eventExposed = '';
    if (eventIsExposed == 1) {
        eventExposed = '';
    } else if (eventIsExposed == 0) {
        eventExposed = 'eventUnRead';
    }
    printMessageByEventList(printClass, eventExposed, eventId, eventOrderId, eventHeader, eventContent, eventTimestamp);
}


/**Drow for Print Order by EventsList*/
function printOrderByEventList(printClass, eventExposed, eventId, orderLink, orderTable, orderText, orderTime) {
    console.log('start printOrderByEventList');
    $(printClass).prepend($('<li class="'+eventExposed+' order order_'+orderLink+'"></li>')
            .append($('' +
                    '<a href="orderById_page" ' +
                    'onclick="' +
                    'onOrderByOrderId(\''+orderLink+'\');' +
                    ' ' +
                    'onEventsExposeById(\''+eventId+'\');' +
                    '"' +
                    '>' +
                    '<h3>Заказ #'+orderLink+'</h3>' +
                    '<p><strong>Столик: '+orderTable+'</strong></p>' +
                    '<p>'+orderText+' (единиц.)</p>' +
                    '<p class="ui-li-aside"><strong>'+orderTime.slice(0,8)+'</strong> '+orderTime.slice(9,18)+'</p>' +
                    '</a>' +
                    '<a href="" ' +
                    'onclick="' +
                    'onEventsDeleteById(\''+eventId+'\')' +
                    '"' +
                    'class="delete">Delete</a>'
            )
        )
    );
    $(printClass).listview('refresh');
}


/**Drow for Print Messages by EventsList*/
function printMessageByEventList(printClass, eventExposed, eventId, messageLink, messageClient, messageText, messageTime) {
    console.log('start printMessageByEventList');
    $(printClass).prepend($('<li class="'+eventExposed+' messag message_'+messageLink+'"></li>')
            .append($('' +
                    '<a href="messageById_page"' +
                    'onclick="' +
                    'onMessageByOrderId(\''+messageLink+'\');' +
                    ' ' +
                    'onEventsExposeById(\''+eventId+'\');' +
                    '"' +
                    '>' +
                    '<h3>Сообщение</h3>' +
                    '<p><strong>'+messageClient+'</strong>'+eventExposed+'</p>' +
                    '<p>'+messageText+'</p>' +
                    '<p class="ui-li-aside"><strong>'+messageTime.slice(0,8)+'</strong> '+messageTime.slice(9,18)+'</p>' +
                    '</a>' +
                    '<a href="#" ' +
                    'onclick="onEventsDeleteById(\''+eventId+'\')' +
                    '"' +
                    'class="delete">Delete</a>'
            )
        )
    );
    $(printClass).listview('refresh');
}

//======== END Print Events ==========

//======== START Print Menu ==========

/**print Order Menu by Events*/
function printOrderMenu(printClass, orderMenu ,collapseSet) {
    console.log('start printOrderMenu');
    // "fantastika"// 11// "Фантастика"// "eqw"// 9// 1// "Русский"// "as"// null// 54// 2// null// 0// "л"
    var catId = 0;
    //var    categoryCode, categoryId, categoryName, positionDescription, positionId, positionIncluded, positionLanguage, positionName, positionPicture, positionPrice, positionQuantity, positionRecipeDescription, positionStatus, positionUnits;
    var collapseSetValue = '';
    for (i = 0; i < orderMenu.length; i++) {
        if (collapseSet !== i) {
            collapseSetValue = 'true';
        } else {
            collapseSetValue = 'false';
        }
        if (catId !== orderMenu[i].categoryId){

            $(printClass).append('<div data-role="collapsible" data-collapsed="'+collapseSetValue+'"' +
                'onclick="onCollapseSet(\''+i+'\')">' +
                '<h2>' + orderMenu[i].categoryName + '</h2>' +
                '<ul data-role="listview" data-iconpos="right" data-theme="a" data-dividertheme="b" data-filter="true" data-filter-theme="a" data-filter-placeholder="Поиск..." class="cat_'+orderMenu[i].categoryId+''+'"></ul>' +
                '</div>');
            catId = orderMenu[i].categoryId;
        }
        $('.cat_'+orderMenu[i].categoryId).append('<li>' +
            '<a href="#">' +
            '<h3>Позиция ' + orderMenu[i].positionName + '</h3>' +
            '<p>Описание ' + orderMenu[i].positionDescription + '</p>' +
            '<p>Цена ' + orderMenu[i].positionPrice + '</p>' +
            '<p class="ui-li-aside">' +
            '<button class="ui-btn ui-btn-inline ui-icon-plus ui-btn-icon-left"' +
            '       onclick="' +
            '       onAddingPositionId('+orderMenu[i].positionId+');' +
            '"' +
            '> Добавить </button>' +
            '<button class="ui-btn ui-btn-inline ui-icon-minus ui-btn-icon-right"' +
            '       onclick="' +
            '       onRemovePositionId('+orderMenu[i].positionId+');' +
            '"' +
            '> Уменьшить </button>' +
            '<span>  </span>' +
            '</p>' +
            '<span class="ui-li-count menuCountPosition_'+orderMenu[i].positionId+'">0</span>' +
            '<span style="color: red" class="menuPopapPosition_'+orderMenu[i].positionId+'"></span>' +
            '</a><a href="" class="delete" data-icon="check"' +
            '       onclick="' +
            '       onApplyPositionId('+orderMenu[i].positionId+');' +
            '"' +
            '></a>' +
            '</li>');
    }
    $(printClass).find('div[data-role=collapsible]').collapsible({refresh:true});
    $(printClass).find('ul[data-role=listview]').listview({refresh:true});
    $(printClass).find('ul[data-role=listview]').listview('refresh');
}

//-- onClicked

function onAddingPositionId(positionId){
    $('.menuPopapPosition_'+positionId).text('');
    var menuCountPosition = '.menuCountPosition_'+positionId;
    var menuCountPositionText = $(menuCountPosition).text();
    menuCountPositionText = parseInt(menuCountPositionText);
    menuCountPositionText += 1;
    $(menuCountPosition).text(menuCountPositionText);
}

function onRemovePositionId(positionId) {

    $('.menuPopapPosition_'+positionId).text('');

    var menuCountPosition = '.menuCountPosition_'+positionId;
    var menuCountPositionText = $(menuCountPosition).text();
    menuCountPositionText = parseInt(menuCountPositionText);
    if (menuCountPositionText > 0){
        menuCountPositionText -= 1;
    }
    $(menuCountPosition).text(menuCountPositionText);
}

function onApplyPositionId(positionId) {
    var menuCountPosition = '.menuCountPosition_'+positionId;
    var menuCountPositionText = $(menuCountPosition).text();
    var positionQuantity = parseInt(menuCountPositionText);
    var tableNum = $('.tableNum').val();

    if (positionQuantity !== 0){
        $('.popText').text('Добавлено');
        if(localStorage.getItem("app_libwaiters_LS_JSON_Order") !== undefined && localStorage.getItem("app_libwaiters_LS_JSON_Order") !== null) {
            AddLS_orderPositions(positionId, positionQuantity);
        } else {
            CreatLS_Order(tableNum, positionId, positionQuantity);
        }
        PositionUlListView();
    } else {
        $('.menuPopapPosition_'+positionId).text('Введите количество');
    }
}

/***/
function Increment_orderPositions(positionQuantity, incQuantity) {
    positionQuantity = parseInt(positionQuantity);
    incQuantity = parseInt(incQuantity);
    positionQuantity += incQuantity;
    return positionQuantity+"";
}

/***/
function AddLS_orderPositions(positionId, positionQuantity) {
    var Order = JSON.parse(localStorage.getItem("app_libwaiters_LS_JSON_Order")),
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
    var app_libwaiters_LS_JSON_Order = JSON.stringify(Order);
    localStorage.setItem("app_libwaiters_LS_JSON_Order", app_libwaiters_LS_JSON_Order);

}

/***/
function CreatLS_Order(tableNum, positionId, positionQuantity) {
    var Order = {
        tblNum: tableNum,
        orderPositions: [{positionId: positionId, positionQuantity: positionQuantity}]
    };
    var app_libwaiters_LS_JSON_Order = JSON.stringify(Order);
    localStorage.setItem("app_libwaiters_LS_JSON_Order", app_libwaiters_LS_JSON_Order);

}

/***/
function PositionUlListView(){
    if(localStorage.getItem("app_libwaiters_LS_JSON_Order") !== undefined && localStorage.getItem("app_libwaiters_LS_JSON_Order") !== null) {
        var Order = JSON.parse(localStorage.getItem("app_libwaiters_LS_JSON_Order")),
            orderPositions = Order.orderPositions,
            ulItem = $("ul.createOrder_ullistView"),
            tdMask = 'tdl_';

        //JSON_lsOrderMenu
        var JSON_lsOrderMenu = JSON.parse(localStorage.getItem("JSON_lsOrderMenu")),
            posName = JSON_lsOrderMenu[0].positionName,
            posPrice = JSON_lsOrderMenu[0].positionPrice,
            positionId,
            fullAmount = 0;

        for (i=0; i<orderPositions.length; i++){
            positionId = orderPositions[i].positionId;
            for (j=0; j<JSON_lsOrderMenu.length; j++){
                if (JSON_lsOrderMenu[j].positionId == positionId) {
                    posName = JSON_lsOrderMenu[j].positionName;
                    posPrice = JSON_lsOrderMenu[j].positionPrice;
                }
            }
            ulItem
                .prepend($('<li data-icon="delete" onclick="shishkinAlert('+orderPositions[i].positionId+');" data-role="option" class="tdLi '+tdMask+orderPositions[i].positionId+'"></li>')
                    .append($('' +
                        '<a href="#" onclick="shishkinAlert('+orderPositions[i].positionId+');" data-theme="a">' +
                        '<img style="margin-bottom: 20px; margin: 10px; height: 60px; border-radius: 4px; border: solid 1px black; display: block; float: left;" src="../app_libwaiters/orders/getMenuPositionPicture/'+orderPositions[i].positionId+'">' +
                        '<h3>Наименование: '+posName+'</h3>' +
                        '<p>Цена: '+posPrice+' рублей.</p>' +
                        '<p class="ui-li-aside">Общая цена: <strong class="amountCart_'+orderPositions[i].positionId+'"></strong></p>' +
                        '<span class="ui-li-count">'+orderPositions[i].positionQuantity+'</span>' +
                        '</a>' +
                        //    '<a href="#" onclick="shishkinAlert('+orderPositions[i].positionId+');" data-theme="a"></a>' +
                        '')
                )
            );
            $('.amountCart_'+orderPositions[i].positionId).text(posPrice*orderPositions[i].positionQuantity+' рублей.');
            fullAmount += posPrice*orderPositions[i].positionQuantity;
            $('.fullAmount').text(fullAmount);
        }

        ulItem.listview('refresh');
    }
}

//tableId: 15,
//serializedOrder: '{"orderPositions":[{"positionId":115,"positionQuantity":"1"}]}'

//{"tblNum":"11","orderPositions":[{"positionId":140,"positionQuantity":1}]}
//=========post

function onCreateOrder() {
    if(localStorage.getItem("app_libwaiters_LS_JSON_Order") !== undefined && localStorage.getItem("app_libwaiters_LS_JSON_Order") !== null) {
        var Order = JSON.parse(localStorage.getItem("app_libwaiters_LS_JSON_Order")),
            tableId = Order.tblNum,
            orderPositions = Order.orderPositions;
    }


    $.post('orders/createAnonymousOrderOnTable', {
            tableId: tableId,
            serializedOrder: '{"orderPositions":'+JSON.stringify(orderPositions)+'}'
        },
        function(d){
            console.log(d)
        },
        function(){
            console.log('error')
        });
}


/***/
function shishkinAlert(value) {
    removeItem(value);
    delOrderPosition(value);
}

/***/
function removeItem(value) {
    var ulItem = $("ul.createOrder_ullistView"),
        tdMask = 'tdl_',
        className = tdMask+value;
    $('.'+className).remove();
}

/***/
function delOrderPosition(value) {
    //globalDel++;
    if(localStorage.getItem("app_libwaiters_LS_JSON_Order") !== undefined && localStorage.getItem("app_libwaiters_LS_JSON_Order") !== null) {
        var Order = JSON.parse(localStorage.getItem("app_libwaiters_LS_JSON_Order")),
            orderPositions = Order.orderPositions,
            dellOrder;
        for (i=0; i<orderPositions.length; i++){
            if (value == Order.orderPositions[i].positionId) {
                dellOrder = i;
            }
        }
        console.log(dellOrder);
        Order.orderPositions.splice(dellOrder, 1);
        var JSON_Order = JSON.stringify(Order);
        //if (globalDel == 1) {
        localStorage.setItem("app_libwaiters_LS_JSON_Order", JSON_Order);
        //} else {
        //    globalDel = 0;
        // }
    }
}

//======== END Print Menu ==========

//======== START Print Order By Id ==========

/**print Order By Id*/
function printOrderById(printClass, amaunt) {
    console.log('start printOrderById'+amaunt[0].orderId);
    //"13:07:33 21.08.2014"//"12:30:47 21.08.2014"//153//12//"e"//251//"10.0"//0//10
    var
        orderDateClosed, orderDateOpened, orderId, orderPosId, orderPosName, orderPosNumber, orderPosQuant, orderPosStatus, orderTableNumber;
    var timerStatus = '';
    $(printClass).append('<li>Заказ <strong>#'+amaunt[0].orderId+'</strong> Стол №'+amaunt[0].orderTableNumber+' <span class="amauntCount ui-li-count positionQuantity">2</span></li>');
    for (i = 0; i < amaunt.length; i++) {
        orderDateClosed = amaunt[i].orderDateClosed;
        orderDateOpened = amaunt[i].orderDateOpened;
        orderId = amaunt[i].orderId;
        orderPosId = amaunt[i].orderPosId;
        orderPosName = amaunt[i].orderPosName;
        orderPosNumber = amaunt[i].orderPosNumber;
        orderPosQuant = amaunt[i].orderPosQuant;
        orderPosStatus = amaunt[i].orderPosStatus;
        switch (orderPosStatus){
            case (0): orderPosStatus = ' Не готово'; break;
            case (1): orderPosStatus = ' Подтверждено'; break;
            case (2): orderPosStatus = ' Отказались'; break;
            case (3): orderPosStatus = ' Принято'; break;
            case (4): orderPosStatus = ' Невозможно'; break;
            case (5): orderPosStatus = ' Готово'; break;
            case (6): orderPosStatus = ' Доставлено'; break;
        }
        orderTableNumber = amaunt[i].orderTableNumber;
        if (orderDateClosed !== 'unrecognized date'){
            timerStatus = 'Время закрытия заказа: <strong>'+orderDateClosed.slice(0,8)+'</strong> '+orderDateClosed.slice(9);
        } else {
            timerStatus = 'Время открытия заказа: <strong>'+orderDateOpened.slice(0,8)+'</strong> '+orderDateOpened.slice(9);
        }
        $(printClass).append('<li><a>' +
            '<img style="margin-bottom: 20px; margin: 10px; height: 60px; border-radius: 4px; border: solid 1px black; display: block; float: left;" src="../app_libwaiters/orders/getMenuPositionPicture/'+orderPosId+'">' +
            '<h2>'+orderPosName+'</h2>' +
            '<p> Позиция по меню №'+orderPosId+'</p>' +
            '<p> Стол №'+orderTableNumber+'</p>' +
            '<p class="posStatus_'+orderPosId+'"> Статус'+orderPosStatus+'</p>' +
            '<p class="ui-li-aside">'+timerStatus+'</p>' +
            '<span class="ui-li-count positionQuantity">'+orderPosQuant+'</span>' +
            '</a>' +
            '' +
            '   <a href="#" class="delete" data-icon="check"' +
            '       onclick="' +
            '       onAccomplishedOrderId('+orderId+','+orderPosNumber+');' +
            //    '       onOrderByOrderId(\''+orderId+'\');' +
            //    '       onSwitchStatusByOrderId(\''+orderId+'\');' +
            '       " ' +
            '   >Доставил</a></li>');
    }
    $(printClass).append('<li>Заказ <strong>#'+amaunt[0].orderId+'</strong> Стол №'+amaunt[0].orderTableNumber+' <span class="amauntCount ui-li-count positionQuantity">2</span></li>');
    $('.amauntCount').text(i);
    $(printClass).listview('refresh');
    //!!!============right-panelUl
    $('.right-panelUl li').remove();
    $('.right-panelUl').append('<li data-role="list-divider">Действие:</li>'+
        '<li>' +
        '   <a href="#" class="ui-btn ui-icon-delete ui-btn-icon-left"' +
        '       onclick="' +
        '       closeOrderId(\''+amaunt[0].orderId+'\');' +
        '       " ' +
        '   >Закрыть зказ</a>' +
        '</li>');
    $('.right-panelUl').listview('refresh');
}

//======== END Print Order By Id ==========


// ================== onClick =====================


/***/
function onSwitchStatusByOrderId(orderById) {
    console.log('start onOrderByOrderId');
    console.log(orderById);
    getOrderByOrderId(orderById);
}


/***/
function onOrderByOrderId(orderById) {
    console.log('start onOrderByOrderId');
    console.log(orderById);
    getOrderByOrderId(orderById);
}


/***/
function onMessageByOrderId(messageById) {
    console.log('start onMessageByOrderId');
    console.log(messageById);
    getOrderByOrderId(messageById);
}


/***/
function onEventsDeleteById(eventId) {
    console.log('start');
    console.log(eventId);
    eventsDeleteById(eventId);
}


/***/
function onEventsExposeById(eventId) {
    console.log('start onEventsExposeById');
    console.log(eventId);
    eventsExposeById(eventId);
}


/***/
function onAccomplishedOrderId(orderId, orderPosNumber) {
    console.log('start onAccomplishedOrderId');
    console.log(orderId, orderPosNumber);
    accomplishedOrderId(orderId, orderPosNumber);
}


function onClearMenu () {
    console.log('start onClearMenu');
    localStorage.removeItem("app_libwaiters_LS_JSON_Order");

    var ulList = 'ul.createOrder_ullistView';
    var ulListItems = ulList+' li';
    clearListByClass(ulListItems);

}


/***/
function onDrowMenu() {
    console.log('start onDrowMenu');

    localStorage.removeItem("app_libwaiters_LS_JSON_Order");

    var lsOrderMenu = JSON.parse(localStorage.getItem("JSON_lsOrderMenu"));
    var ulList = '.createOrder_ulMenuCategoryList';
    var ulListItems = ulList+' div';
    clearListByClass(ulListItems);
    printOrderMenu(ulList, lsOrderMenu, 0);
    //PositionUlListView()
}


/***/
function onDrowOrderById() {
    console.log('start onDrowOrderById');
    var lsOrderById = JSON.parse(localStorage.getItem("JSON_lsOrderById"));
    var ulList = '.orderById_ulEventList';
    var ulListItems = ulList+' li';
    clearListByClass(ulListItems);
    printOrderById(ulList, lsOrderById);
}

/*================================================== AJAX module ================================================*/
/* --------- POST ----------*/


/***/
function getMenu (){
    console.log('START getMenu');
    $.ajax({
        type:'post',
        url:'orders/getMenu',
        contentType: 'application/json',
        success: function(OrderMenu){
            console.log('getMenu - '+OrderMenu);
            //console.log(OrderMenu);
            createLocalStorageOrderMenu(OrderMenu);
        },
        error: function(){
            //alert('request error');
            console.log('getMenu - 0');
        }
    });
    return false;
}


/***/
function getEvents() {
    console.log('START getEvents');
    $.ajax({
        type:'post',
        url:'../cafe/events/getEvents',
        data: {
            spotId: 10000,
            myCurrentAccountRole: 'b'
        },
        success: function(Events){
            console.log('getEvents - '+Events);
            //console.log(Events);
            refrashLocalStorageEvents(Events);
        },
        error: function(){
            console.log('getEvents - 0');
            // alert('request error');
        }
    });
    return false;
}


/***/
function getOrders() {
    console.log('START getOrders');
    $.ajax({
        type: 'post',
        url: 'orders/getOrders',
        contentType: 'application/json',
        success: function (Orders) {
            console.log('getOrders - '+Orders);
            refrashLocalStorageOrders(Orders);
        },
        error: function () {
            //alert('request error');
            console.log('getOrders - 0');
        }
    });
    return false;
}


/***/
function getMessages() {
    console.log('START getMessages');
    $.ajax({
        type: 'post',
        url: 'http://localhost:8080/CM/common/messenger/getMessages',
        contentType: 'application/json',
        success: function (Messages) {
            console.log('getMessages - '+Messages);
            refrashLocalStorageMessages(Messages);
        },
        error: function () {
            //alert('request error');
            console.log('getMessages - 0');
        }
    });
    return false;
}


/***/
function getOrderByOrderId(orderId) {
    console.log('START getOrderByOrderId - '+orderId);
    $.ajax({
        type:'post',
        url:'orders/getOrderById',
        data: {
            orderId: orderId
        },
        success: function(amaunt){
            console.log('getOrderByOrderId '+amaunt);
            refrashLocalStorageOrderById(amaunt);
        },
        error: function(){
            console.log('getOrderByOrderId - 0');
            //alert('request error');
        }
    });
    return false;
}


/***/
function eventsDeleteById(eventId) {
    console.log('START eventsDeleteById - '+eventId);
    $.ajax({
        type:'post',
        url:'../cafe/events/deleteById',
        data: {
            eventId: eventId
        },
        success: function(data){
            console.log('eventsDeleteById - '+data);
        },
        error: function(){
            console.log('eventsDeleteById - 0');
            //alert('request error');
        }
    });
    return false;
}


/***/
function eventsExposeById(eventId) {
    console.log('START eventsExposeById - '+eventId);
    $.ajax({
        type:'post',
        url:'../cafe/events/exposeById',
        data: {
            eventId: eventId
        },
        success: function(data){
            console.log('eventsExposeById - '+data);
        },
        error: function(){
            console.log('eventsExposeById - 0');
            //alert('request error');
        }
    });
    return false;
}


/***/
function closeOrderId(orderId) {
    console.log('START closeOrderId - '+orderId);
    $.post('orders/close', {
        orderId: orderId
    }, function(response) {
        console.log('closeOrderId - '+response)
    }, function() {
        console.log('closeOrderId - 0 request error');
    });
}


/***/
function accomplishedOrderId(orderId, orderPosNumber) {
    console.log('START accomplishedOrderId - (orderId='+orderId+'; orderPosNumber='+orderPosNumber+')');
    //getOrderByOrderId(orderId);
    $.ajax({
        type:'post',
        url:'orders/setPositionAccomplished',
        data: {
            orderId: orderId,
            orderPosNumber: orderPosNumber
        },
        success: function(amaunt){
            console.log('accomplishedOrderId '+amaunt);
            getOrderByOrderId(orderId); //refrash lsOrderByOrderId
        },
        error: function(){
            //alert('request error');
            console.log('accomplishedOrderId - 0');
        }
    });
    return false;
}
/* --------- /POST ----------*/

/***/
function createLocalStorageOrderMenu(lsOrderMenu) {
    console.log('start createLocalStorageOrderMenu');
    var JSON_lsOrderMenu = JSON.stringify(lsOrderMenu);
    localStorage.setItem("JSON_lsOrderMenu", JSON_lsOrderMenu);
}


/***/
function refrashLocalStorageEvents(lsEvents) {
    console.log('start refrashLocalStorageEvents');
    var JSON_lsEvents = JSON.stringify(lsEvents);
    localStorage.setItem("JSON_lsEvents", JSON_lsEvents);
}


/***/
function refrashLocalStorageOrders(lsOrders) {
    console.log('start refrashLocalStorageOrders');
    var JSON_lsOrders = JSON.stringify(lsOrders);
    localStorage.setItem("JSON_lsOrders", JSON_lsOrders);
}


/***/
function refrashLocalStorageOrderById(lsOrderById) {
    console.log('start refrashLocalStorageOrderById');
    var JSON_lsOrderById = JSON.stringify(lsOrderById);
    localStorage.setItem("JSON_lsOrderById", JSON_lsOrderById);
}


/***/
function refrashLocalStorageMessages(lsMessages) {
    console.log('start refrashLocalStorageMessages');
    var JSON_lsMessages = JSON.stringify(lsMessages);
    localStorage.setItem("JSON_lsMessages", JSON_lsMessages);
}