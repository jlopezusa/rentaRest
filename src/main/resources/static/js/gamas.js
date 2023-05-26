$(document).ready(function(){
    
    showTable();
    
    function showTable(){
        var theads = ['id', 'nombre','descripcion'];
        getDataModel('Gama','Gamas', theads);
    }
    
    $('#search').click(function(e){
        e.preventDefault();
        var id = $('#search-id').val();
        id = parseInt(id);
        if(!isNaN(id)){
            var model = "Gama";
            getDataModelById(model,id);
            $('#id').val(id);
        }else{
            alert("Ingrese ID válido");
        }
    });
    
    $('#register').click(function(e){
        e.preventDefault();
        var name = $('#name');
        var description = $('#description');
        var isID = $('#id').val();
        var existID = $('#idExist').val();
        var idp = 0;
        var method = "insert";
        if(existID == 1){
            method = "update";
            idp = isID;
        }

        if(validateRequired(name) == true){
            if(validateRequired(description) == true){
                console.log("campos validados");
                $('#message').html("");
                var dataSend = 
                    {name:name.val(),
                    description:description.val(),
                    idGama:idp}
                ;
                if(method == "insert"){
                    insertDataModel("Gama",dataSend);
                }else if(method == "update"){
                    updateDataModel("Gama",dataSend);
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
                deleteDataModel("Gama",id);               
            }
        }else{
            alert("Ingrese ID válido");
        }
    });
    
    
});