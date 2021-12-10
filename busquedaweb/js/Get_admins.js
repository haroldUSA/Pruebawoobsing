$('#submitbtn').click(function (e) {
    e.preventDefault()
    var url = $('#web').val();

    console.log(url);

    let datos={
        url:url
    }
   
    let datosPeticion = JSON.stringify(datos);
    console.log(datosPeticion);
    $.ajax({
        // la URL para la petición (url: "url al recurso o endpoint")
        url: "http://129.151.111.220:8081/api/search",
       // url: "http://localhost:8080/api/user/new",
        // la información a enviar
        // (también es posible utilizar una cadena de datos)
        //si el metodo del servicio recibe datos, es necesario definir el parametro adicional
        data : datosPeticion,

        // especifica el tipo de petición http: POST, GET, PUT, DELETE
        type: 'POST',

        contentType:"application/JSON",

        // el tipo de información que se espera de respuesta
        dataType: 'json',

        // código a ejecutar si la petición es satisfactoria;
        // la respuesta es pasada como argumento a la función
        success: function (respuesta) {
            //escribe en la consola del desarrollador para efectos de depuración
            //console.log(respuesta);
            //var result = jQuery.parseJSON(respuesta.d);
            //console.log(result);
            var client_data="";
            $.each(respuesta, function(key, value){
                console.log(key, value);
                client_data+='<tr>';
                client_data+='<td>'+key+'</td>';
                client_data+='<td>'+value+'</td>';
                client_data+='</tr>';
            });
            $('#client').append(client_data);

            $("#mensajes").show(1000);
            $("#mensajes").html("Registro Agregado...");
            $("#mensajes").hide(1000);
            //location.reload();
            // mensaje();
            // redireccionar();
             //getid();
            //listar();
        },

        // código a ejecutar si la petición falla;
        // son pasados como argumentos a la función
        // el objeto de la petición en crudo y código de estatus de la petición
        error: function (xhr, status) {
            $("#mensajes").html("Ocurrio un problema al ejecutar la petición..." + status);
            $("#mensajes").hide(1000);
        }
    });
});

function validaesVacio(dato){
    return !dato.trim().length;
}

/*$('#submitbtn1').click(function (e) {
    e.preventDefault()
    console.log(ID);
    console.log("entro");
    var messagetext = $('#Textarea').val();

    $.put("https://g3abde25bedbc30-db202109241616.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client/", {
        id: 1,
        messagetext: messagetext
    }, function (response) {
        console.log('success====:', response)
        //clearfield();
    })

    function clearfield(){
      $("#Textarea").val(" ");
    }
});*/
