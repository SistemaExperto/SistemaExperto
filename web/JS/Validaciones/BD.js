/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$.validator.setDefaults({
    submitHandler: function () {
        alertify.error("Error.");
    }
});

jQuery.validator.addMethod("lettersonly", function (value, element)
{
    return this.optional(element) || /^[a-z á é í ó ú]+$/i.test(value);
}, "Solo letras y espacios");


$(document).ready(function () {
    $("#exportarForm").validate({
        rules: {
            txtnombre: {
                required: true,
                lettersonly: true
            },
        },
        messages: {
            txtnombre: {
                required: "Debes ingresar el nombre para guardar archivo"
            },
        },
        errorElement: "em",
        errorPlacement: function (error, element) {
            // Add the `invalid-feedback` class to the error element
            error.addClass("invalid-feedback");

            if (element.prop("type") === "checkbox") {
                error.insertAfter(element.next("label"));
            } else {
                error.insertAfter(element);
            }
        },
        highlight: function (element, errorClass, validClass) {
            $(element).addClass("is-invalid").removeClass("is-valid");
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).addClass("is-valid").removeClass("is-invalid");
        },
        submitHandler: function (form) {
            var data = $("#exportarForm").serialize();
            $.get("ControladorBD", data, function (respuesta, est, jqXHR) {
                if (respuesta == '1') {
                    Swal.fire({
                        icon: 'success',
                        color: '#ffffff',
                        title: 'Base de datos exportada correctamente!',
                        text: 'Buscar en tu carpeta de descargas.',
                        width: 600,
                        timer: 3000,
                        padding: '3em',
                        background: '#0F0000',
                        backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("img/giphysuccess.gif")
                                        left top
                                        no-repeat
                                    `
                    });
                    setTimeout(function () {
                        window.location = "Controlador?accion=BaseDatos";
                    }, 3000);
                } else {
                    Swal.fire({
                        icon: 'error',
                        color: '#ffffff',
                        title: 'No se pudo exportar la base de datos!',
                        text: 'Intentalo nuevamente.',
                        width: 600,
                        padding: '3em',
                        background: '#0F0000',
                        backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("img/giphyerror.gif")
                                        left top
                                        no-repeat
                                    `
                    });
                }
            });
        }
    });
});

$(document).ready(function () {
    $("#importarForm").validate({
        rules: {
            txtnombrebd: {
                required: true,
                accept: ".sql"
            },
        },
        messages: {
            txtnombrebd: {
                required: "Debes ingresar el archivo .sql",
                accept: "Solo se permite archivos .sql"
            },
        },
        errorElement: "em",
        errorPlacement: function (error, element) {
            // Add the `invalid-feedback` class to the error element
            error.addClass("invalid-feedback");

            if (element.prop("type") === "checkbox") {
                error.insertAfter(element.next("label"));
            } else {
                error.insertAfter(element);
            }
        },
        highlight: function (element, errorClass, validClass) {
            $(element).addClass("is-invalid").removeClass("is-valid");
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).addClass("is-valid").removeClass("is-invalid");
        },
        submitHandler: function (form) {
            var data = $("#importarForm").serialize();
            $.get("ControladorBD", data, function (respuesta, est, jqXHR) {
                if (respuesta == '1') {
                    Swal.fire({
                        icon: 'success',
                        color: '#ffffff',
                        title: 'Base de datos importada correctamente!',
                        text: 'Favor de revisar datos cargados.',
                        width: 600,
                        timer: 3000,
                        padding: '3em',
                        background: '#0F0000',
                        backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("img/giphysuccess.gif")
                                        left top
                                        no-repeat
                                    `
                    });
                } else {
                    Swal.fire({
                        icon: 'error',
                        color: '#ffffff',
                        title: 'No se pudo importar la base de datos!',
                        text: 'Intentalo nuevamente.',
                        width: 600,
                        padding: '3em',
                        background: '#0F0000',
                        backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("img/giphyerror.gif")
                                        left top
                                        no-repeat
                                    `
                    });
                }
            });
        }
    });
});