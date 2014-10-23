
<script>



    var order = {
        tblNum: 1,
        orderPositions: []
    };


    function showPositions() {
        var lsLen = order.orderPositions.length,
                $tdList = $('ul.tdList');
        if(lsLen > 0){
            for(var i = 0; i < lsLen; i++ ){
                // Вывод
            }
            $("<li></li>",{
                class:"tdItem"
            }.text("#"+i+" ID: "+order.orderPositions[lsLen-1].positionId+" количество: "+order.orderPositions[lsLen-1].positionQuantity).appendTo($tdList).attr('data-itemid','pos'+i);
        }
    }


    $(document).on('click','.tdItem', function(e){
        var jet = $(e.target);
        localStorage.removeItem(jet.attr('data-itemid'),undefined);
        jet.remove();
    });

    //order.orderPositions.push({positionId: 2, positionQuontity: 2})
    function RefreshLocalStorage (pos){
        if(localStorage.getItem("localOrder") !== undefined && localStorage.getItem("localOrder") !== null) {
            var orderPositions = JSON.parse(localStorage.getItem("localOrder"));
            orderPositions.push(pos);
            localStorage.setItem("localOrder", JSON.stringify(orderPositions));
        }
    }

    function ggg (e){
        alert(e);
    }

    function AddPosition (positionId, positionQuontity) {
//    localStorage.setItem("positionIdAddToOrder", positionId);
//    localStorage.setItem("poditionQuantityAddToOrder", poditionQuantity);
        alert(positionId+" / "+positionQuontity);

        order.orderPositions.push({positionId: positionId, positionQuantity: positionQuontity})


    }


</script>
