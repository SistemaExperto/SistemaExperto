/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener('load', function () {
    var correo = document.getElementById("txtcorreo").value;
    var contra = document.getElementById("txtcontra").value;
    document.getElementById("btningresar").addEventListener('click', function () {


        var bandera = false;
        if (correo.length > 0 && contra.length > 0) {
            bandera = true;
        }

        if (bandera) {
            document.getElementById("forminicio").submit();
        } else {
            alert("Debes llenar todos los campos");
        }
    });

    correo.addEventListener("input", function (event) {
        if (correo.validity.typeMismatch) {
            correo.setCustomValidity("Debes ingresar un correo electronico");
        } else {
            correo.setCustomValidity("efrffr");
        }
    });

});

