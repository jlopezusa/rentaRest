$(document).ready(function(){
    
    showTable();
    
    function showTable(){
        var theads = ['id', 'Fecha Devolucion', 'Fecha Inicio', 'Estado'];
        getDataModel('Reservation','Reservaciones', theads);
    }
    
    $('#search').click(function(e){
        e.preventDefault();
        var id = $('#search-id').val();
        var model = "Reservation";
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
        var devolutionDate = $('#devolutionDate');
        var startDate = $('#startDate');
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
        
        if(validateRequired(devolutionDate) == true){
            if(validateRequired(startDate) == true){
                if(validateRequired(carId) == true){
                    if(validateRequired(clientId) == true){
                        console.log("campos validados");
                        $('#message').html("");
                        var dataSend = 
                            {devolutionDate:devolutionDate.val(),
                            startDate:startDate.val(),
                            client:{idClient:clientId.val()},
                            car:{idCar:carId.val()},
                            idReservation:idp}
                        ;
                        if(method == "insert"){
                            insertDataModel("Reservation",dataSend);
                        }else if(method == "update"){
                            updateDataModel("Reservation",dataSend);
                        } 
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
                deleteDataModel("Reservation",id);               
            }
        }else{
            alert("Ingrese ID válido");
        }
    });
    
    
});
