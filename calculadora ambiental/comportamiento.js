


///declaracion y enlazamiento dd las variables de js con los elementos de html
var estado=document.getElementById('estado');
var latitud=document.getElementById('latitud');
var longitud=document.getElementById('longitud');
var area=document.getElementById('area');
var largo_colector=document.getElementById('larcol');
var ancho_colector=document.getElementById('ancol');
var nolados=document.getElementById('nolads');
var hapotema=document.getElementById('hapcol');
var forma=document.getElementById('forma');
var lado_colector=document.getElementById('ladcol');
var calcularea=document.getElementById('calcular');

function estadoselect()
{
    //obtenemos el valor seleccionada en estado
    var selectedOption = this.options[estado.selectedIndex];
    var texto=selectedOption.text;
    //switch con datos de cada estado
    switch (texto) {
        case "Aguascalientes":
            latitud.innerHTML = "21.8818° N";
            longitud.innerHTML = "102.2916° W";
            break;
        case "Baja California":
            latitud.innerHTML = "30.8406° N";
            longitud.innerHTML = "115.2838° W";
            break;
        case "Baja California Sur":
            latitud.innerHTML = "25.1222° N";
            longitud.innerHTML = "112.9809° W";
            break;
        case "Campeche":
            latitud.innerHTML = "19.8301° N";
            longitud.innerHTML = "90.5349° W";
            break;
        case "Chiapas":
            latitud.innerHTML = "16.7569° N";
            longitud.innerHTML = "93.1292° W";
            break;
        case "Chihuahua":
            latitud.innerHTML = "28.6320° N";
            longitud.innerHTML = "106.0691° W";
            break;
        case "Ciudad de Mexico":
            latitud.innerHTML = "19.4326° N";
            longitud.innerHTML = "99.1332° W";
            break;
        case "Coahuila":
            latitud.innerHTML = "27.0587° N";
            longitud.innerHTML = "101.7068° W";
            break;
        case "Colima":
            latitud.innerHTML = "19.2452° N";
            longitud.innerHTML = "103.7249° W";
            break;
        case "Durango":
            latitud.innerHTML = "24.0277° N";
            longitud.innerHTML = "104.6532° W";
            break;
        case "Guanajuato":
            latitud.innerHTML = "21.0190° N";
            longitud.innerHTML = "101.2574° W";
            break;
        case "Guerrero":
            latitud.innerHTML = "17.5748° N";
            longitud.innerHTML = "99.1949° W";
            break;
        case "Hidalgo":
            latitud.innerHTML = "20.1011° N";
            longitud.innerHTML = "98.7591° W";
            break;
        case "Jalisco":
            latitud.innerHTML = "20.6597° N";
            longitud.innerHTML = "103.3496° W";
            break;
        case "Estado de Mexico":
            latitud.innerHTML = "19.4969° N";
            longitud.innerHTML = "99.7233° W";
            break;
        case "Michoacan":
            latitud.innerHTML = "19.5665° N";
            longitud.innerHTML = "101.7068° W";
            break;
        case "Morelos":
            latitud.innerHTML = "18.6813° N";
            longitud.innerHTML = "99.1013° W";
            break;
        case "Nayarit":
            latitud.innerHTML = "21.7514° N";
            longitud.innerHTML = "104.8455° W";
            break;
        case "Nuevo Leon":
            latitud.innerHTML = "25.5922° N";
            longitud.innerHTML = "99.9962° W";
            break;
        case "Oaxaca":
            latitud.innerHTML = "17.0732° N";
            longitud.innerHTML = "96.7266° W";
            break;
        case "Puebla":
            latitud.innerHTML = "19.0413° N";
            longitud.innerHTML = "98.2063° W";
            break;
        case "Queretaro":
            latitud.innerHTML = "20.5888° N";
            longitud.innerHTML = "100.3899° W";
            break;
        case "Quintana Roo":
            latitud.innerHTML = "19.1817° N";
            longitud.innerHTML = "88.4791° W";
            break;
        case "San Luis Potosi":
            latitud.innerHTML = "22.1565° N";
            longitud.innerHTML = "100.9855° W";
            break;
        case "Sinaloa":
            latitud.innerHTML = "25.1721° N";
            longitud.innerHTML = "107.4795° W";
            break;
        case "Sonora":
            latitud.innerHTML = "29.0892° N";
            longitud.innerHTML = "110.9617° W";
            break;
        case "Tabasco":
            latitud.innerHTML = "17.8409° N";
            longitud.innerHTML = "92.6189° W";
            break;
        case "Tamaulipas":
            latitud.innerHTML = "24.2669° N";
            longitud.innerHTML = "98.8363° W";
            break;
        case "Tlaxcala":
            latitud.innerHTML = "19.3189° N";
            longitud.innerHTML = "98.2300° W";
            break;
        case "Veracruz":
            latitud.innerHTML = "19.1738° N";
            longitud.innerHTML = "96.1342° W";
            break;
        case "Yucatan":
            latitud.innerHTML = "20.7099° N";
            longitud.innerHTML = "89.0943° W";
            break;
        case "Zacatecas":
            latitud.innerHTML = "22.7709° N";
            longitud.innerHTML = "102.5832° W";
            break;
        default:
            latitud.innerHTML = "Latitud desconocida";
            longitud.innerHTML = "Longitud desconocida";
        }

}
///funcion que calcula el area segun la forma del colector
function calculo_area()
{
    alert("entro");
    ///obtengo el numero de lados que selecciono el usuario en el select
    var selectedOption = this.options[forma.selectedIndex];
    var lados=selectedOption.text;
    switch(lados)
    {
        case '3':
        resultado=(largo_colector.value * ancho_colector.value)/2;
        break;
        case '4':
        resultado=largo_colector.value * ancho_colector.value;
        break;
        ///para los que tengan 5 o mas lados
        default:
        var perimetro=nolados.value*lado_colector.value;
        resultado=(perimetro * hapotema.value)/2;
        break;
    }
    area.innerHTML=resultado;
    console.log("salio");



}
///Establece comportamiento cuando cambia el estado el elemento select "estado"
estado.addEventListener("change", estadoselect)
///Establece comportamiento cuando se clickea el boton calcular de area
calcularea.onclick=calculo_area;
forma.addEventListener("change",calculo_area)



