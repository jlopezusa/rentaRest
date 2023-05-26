$(document).ready(function(){
    
    showTable();
    
    function showTable(){
        var theads = ['id', 'mensaje', 'puntuacion', 'reservacion'];
        getDataModel('Score','Calificaciones', theads);
    }
    
    $('#search').click(function(e){
        e.preventDefault();
        var id = $('#search-id').val();
        var model = "Score";
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
        var message = $('#message');
        var score = $('#score');
        var reservationId = $('#idReservation');
        var isID = $('#id').val();
        var existID = $('#idExist').val();
        var idp = 0;
        var method = "insert";
        if(existID == 1){
            method = "update";
            idp = isID;
        }
        
        if(validateRequired(message) == true){
            if(validateRequired(score) == true){
                if(validateRequired(reservationId) == true){                 
                    console.log("campos validados");
                    $('#message').html("");
                    var dataSend = 
                        {message:message.val(),
                        score:score.val(),
                        reservation:reservationId.val(),
                        idScore:idp}
                    ;
                    if(method == "insert"){
                        insertDataModel("Score",dataSend);
                    }else if(method == "update"){
                        updateDataModel("Score",dataSend);
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
                deleteDataModel("Score",id);               
            }
        }else{
            alert("Ingrese ID válido");
        }
    });
    
    
});

