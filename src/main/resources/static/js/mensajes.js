$(document).ready(function(){
    
    showTable();
    
    function showTable(){
        var theads = ['id', 'mensaje', 'cliente', 'carro'];
        getDataModel('Message','Mensajes', theads);
    }
    
    $('#search').click(function(e){
        e.preventDefault();
        var id = $('#search-id').val();
        var model = "Message";
        id = parseInt(id);
        if(!isNaN(id)){
            getDataModelById(model,id);
            $('#id').val(id);
        }else{
            alert("Ingrese ID válido");
        }
    });
    
    $('#register').click(function(e){
        e.preventDefault();
        var messageText = $('#messageText');
        var carId = $('#idCar');
        var clientId = $('#idClient');
        var isID = $('#id').val();
        var existID = $('#idExist').val();
        var idp = 0;
        var method = "insert";
        if(existID == 1){
            method = "update";
            idp = isID;
        }
        
        if(validateRequired(messageText) == true){
            if(validateRequired(carId) == true){
                if(validateRequired(clientId) == true){
                    console.log("campos validados");
                    $('#message').html("");
                    var dataSend = 
                        {messageText:messageText.val(),
                        client:{idClient:clientId.val()},
                        car:{idCar:carId.val()},
                        idMessage:idp}
                    ;
                    if(method == "insert"){
                        insertDataModel("Message",dataSend);
                    }else if(method == "update"){
                        updateDataModel("Message",dataSend);
                    } 
                }
            }
        }         
    });    
    
    $('#delete').click(function(e){
        e.preventDefault();
        var id = $('#delete-id').val();
        id = parseInt(id);
        if(!isNaN(id)){
            var answer = confirm("¿Seguro que desea eliminar registro?");
            if(answer){
                deleteDataModel("Message",id);               
            }
        }else{
            alert("Ingrese ID válido");
        }
    });
    
    
});