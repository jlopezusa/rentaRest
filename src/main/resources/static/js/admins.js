$(document).ready(function(){
    
    showTable();
    
    function showTable(){
        var theads = ['id','correo','nombre','contraseña'];
        getDataModel('Admin','Administradores', theads);
    }
    
    $('#search').click(function(e){
        e.preventDefault();
        var id = $('#search-id').val();
        var model = "Admin";
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
                if(validateRequired(password) == true){
                    console.log("campos validados");
                    $('#message').html("");
                    var dataSend = 
                        {name:name.val(),
                        email:email.val(),
                        password:password.val(),
                        idAdmin:idp}
                    ;
                    if(method == "insert"){
                        insertDataModel("Admin",dataSend);
                    }else if(method == "update"){
                        updateDataModel("Admin",dataSend);
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
                deleteDataModel("Admin",id);               
            }
        }else{
            alert("Ingrese ID válido");
        }
    });
    
    
});