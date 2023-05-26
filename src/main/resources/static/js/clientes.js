$(document).ready(function(){
    
    showTable();
    
    function showTable(){
        var theads = ['id','correo','contraseña','nombre','edad'];
        getDataModel('Client','Clientes', theads);
    }
    
    $('#search').click(function(e){
        e.preventDefault();
        var id = $('#search-id').val();
        var model = "Client";
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
        var name = $('#name');
        var email = $('#email');
        var age = $('#age');
        var password = $('#password');
        var isID = $('#id').val();
        var existID = $('#idExist').val();
        var idp = 0;
        var method = "insert";
        if(existID == 1){
            method = "update";
            idp = isID;
        }
        if(validateRequired(name) == true){
            if(validateRequired(email) == true){
                if(validateRequired(age) == true){
                    if(validateRequired(password) == true){
                        console.log("campos validados");
                        $('#message').html("");
                        var dataSend = 
                            {name:name.val(),
                            email:email.val(),
                            age:age.val(),
                            password:password.val(),
                            idClient:idp}
                        ;
                        if(method == "insert"){
                            insertDataModel("Client",dataSend);
                        }else if(method == "update"){
                            updateDataModel("Client",dataSend);
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
                deleteDataModel("Client",id);               
            }
        }else{
            alert("Ingrese ID válido");
        }
    });
    
    
});