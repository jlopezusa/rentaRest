var url = "http://localhost:8080/api";
function printDataModel(data,title,thNames,fields){
    var html = `<h1>${title}</h1><br>
                <table id="" class="table table-bordered">
                    <thead>
                        <tr>`;
    thNames.forEach(function(arr) {
        html += "<th><span style='text-transform:uppercase'>"+arr+"</span></th>";
    });
    html += `</tr>
                    </thead>
                    <tbody>`;
    data.forEach(function(model){
        html += "<tr>";
        fields.forEach(function(arr,key) {
            html += "<td>"+model[arr]+"</td>"; 
        });
        html += "</tr>";
    });
    html += `</tbody>
        </table>`;
    $('#data').html(html);
}

function getDataModel(model,title,thNames){
    $.ajax({
        url: url+"/"+model+"/all",
        type: "GET",
        dataType: "json",
        success:function(result){
            var data = result;
            if(data.length > 0){
                var fields = Object.keys(data[0]);
                printDataModel(data,title,thNames,fields);
            }else{
                $('#data').text("No existen registros");
            }        
        },
        error:function(error){
            console.log("Ha ocurrido un error al recibir data");
        }
    });
}

function getDataModelById(model,id){
    var data = null;
    $.ajax({
        url: url+"/"+model+"/get/"+id,
        type: "GET",
        dataType: "json",
        success:function(result){
            var data = result;
            putOnForm(data);
        },
        error:function(error){
            console.log("Ha ocurrido un error al recibir data");
        }
    });
}

function putOnForm(data){
    if(data != null){
        let keys = Object.keys(data);
        keys.forEach(function(key){
            var str = validateDateFormatAndParse(data[key]);
            $('#'+key).val(str);
            recursiveObjectVal(str);
        });
        function recursiveObjectVal(obj){
            //console.log(obj);
            if((typeof obj === 'object') && !Array.isArray(obj) && obj !== null){
                //console.log('entro');
                let keysChild = Object.keys(obj);
                keysChild.forEach(function(keyCh){
                    if(keyCh.startsWith("id")){
                        var str = validateDateFormatAndParse(obj[keyCh]);
                        $('#'+keyCh).val(str);
                    }
                    recursiveObjectVal(keyCh);
                });
            }
        }
        $('#idExist').val(1);     
    }else{
        $('#myform')[0].reset();
        $('#id').val(0);
        $('#idExist').val(0);
        alert("No existe registro con ese ID pero puede crearlo");
    }
}

function insertDataModel(model,dataSend){
    $.ajax({
        url: url+"/"+model+"/save",
        type: "POST",
        data: JSON.stringify(dataSend),
        contentType: "application/json; charset=utf-8",
        success:function(result){
            $('#message').html('<div class="alert alert-success" role="alert">Registro guardado con Éxito</div>');
            setTimeout(function(){
                window.location.reload(true);
            },1200);
        },
        error:function(error){
            $('#message').html('<div class="alert alert-danger" role="alert">Error al Guardar!</div>');
        }
    });
}

function updateDataModel(model,dataSend){
    $.ajax({
        url: url+"/"+model+"/update",
        type: "PUT",
        data: JSON.stringify(dataSend),
        contentType: "application/json; charset=utf-8",
        success:function(result){
            $('#message').html('<div class="alert alert-success" role="alert">Registro Actualizado con Éxito</div>');
            /*setTimeout(function(){
                window.location.reload(true);
            },1200);*/
        },
        error:function(error){
            $('#message').html('<div class="alert alert-danger" role="alert">Error al Guardar!</div>');
        }
    });
}

function deleteDataModel(model,id){
    var datas = {
        "id" : id
    };
    $.ajax({
        url: url+"/"+model+"/"+id,
        type: "DELETE",
        contentType: "application/json",
        //data: JSON.stringify(datas),
        success:function(result){
            $('#message').html('<div class="alert alert-warning" role="alert">Se ha eliminado el registro</div>');
            setTimeout(function(){
                window.location.reload(true);
            },2000);
        },
        error:function(error){
            $('#message').html('<div class="alert alert-danger" role="alert">Error en el proceso!</div>');
        }
    });
}

function getRandNumber(min, max) {
    return Math.floor(Math.random() * (max - min) ) + min;
}

function validateRequired(field){
    if($(field).val() == ""){
        $('#message').html('<div class="alert alert-danger" role="alert">Por favor ingrese campo requerido!</div>');
        $(field).focus();
    }else{
        return true;
    }
}

function validateNumbers(field){
    if($(field).val() == ""){
        $('#message').html('<div class="alert alert-danger" role="alert">Por favor ingrese campo requerido!</div>');
        $(field).focus();
    }else{
        return true;
    }
}

function validateDateFormatAndParse(str){
    var date = str;
    var parsed = Date.parse(date);
    if(isNaN(date) && !isNaN(parsed)){
        var formatted = date.substring(0,10);
        return formatted;
    }else{
        return date;
    }
}

function test(){
    $('#data').text("hola");
}