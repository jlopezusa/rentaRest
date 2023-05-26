$(document).ready(function(){
    
    showTable();
    
    function showTable(){
        var theads = ['id', 'nombre','marca','año','descripción'];
        getDataModel('Car','Carros', theads);
    }
    
    $('#search').click(function(e){
        e.preventDefault();
        var id = $('#search-id').val();
        id = parseInt(id);
        if(!isNaN(id)){
            var model = "Car";
            getDataModelById(model,id);
            $('#id').val(id);
        }else{
            alert("Ingrese ID válido");
        }
    });
    
    $('#register').click(function(e){
        e.preventDefault();
        var name = $('#name');
        var brand = $('#brand');
        var year = $('#year');
        var description = $('#description');
        var gamaId = $('#idGama');
        var isID = $('#id').val();
        var existID = $('#idExist').val();
        var idp = 0;
        var method = "insert";
        if(existID == 1){
            method = "update";
            idp = isID;
        }
        
        if(validateRequired(name) == true){
            if(validateRequired(brand) == true){
                if(validateRequired(year) == true){
                    if(validateRequired(description) == true){
                        if(validateRequired(gamaId) == true){
                            console.log("campos validados");
                            $('#message').html("");
                            var dataSend = 
                                {name:name.val(),
                                brand:brand.val(),
                                year:year.val(),
                                description:description.val(),
                                gama:{idGama:gamaId.val()},
                                idCar:idp}
                            ;
                            if(method == "insert"){
                                insertDataModel("Car",dataSend);
                            }else if(method == "update"){
                                updateDataModel("Car",dataSend);
                            }
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
                deleteDataModel("Car",id);               
            }
        }else{
            alert("Ingrese ID válido");
        }
    });
    
    
});