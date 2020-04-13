/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery.validator.addMethod("lettersonly", function (value, element)
{
    return this.optional(element) || /^[a-z á é í ó ú]+$/i.test(value);
}, "Solo letras y espacios");

$.validator.setDefaults({
    submitHandler: function () {
        alertify.error("Error.");
    }
});

$.validator.addMethod('daterange', function (value, element) {
    if (this.optional(element)) {
        return true;
    }

    var startDate = Date.parse('1920-12-31'),
            endDate = Date.parse('2005-12-31'),
            enteredDate = Date.parse(value);

    if (isNaN(enteredDate))
        return false;

    return ((startDate <= enteredDate) && (enteredDate <= endDate));
}, "Ingresa una fecha valida de nacimiento");

$(document).ready(function () {
    $("#agregarForm").validate({
        rules: {
            txtfamiliar_idfamiliar: {
                required: true
            },
            txtmaterial_piso: {
                required: true
            },
            txtmaterial_pared: {
                required: true
            },
            txtacabado_pared: {
                required: true
            },
            txtmaterial_techo: {
                required: true
            },
            txttipo_sanitario: {
                required: true
            },
            txtdrenaje: {
                required: true
            },
        },
        messages: {
            txtfamiliar_idfamiliar: {
                required: "Debes seleccionar el familiar"
            },
            txtmaterial_piso: {
                required: "Debes seleccionar el material del piso"
            },
            txtmaterial_pared: {
                required: "Debes seleccionar el material de la pared"
            },
            txtacabado_pared: {
                required: "Debes seleccionar el material del acabado de la pared"
            },
            txtmaterial_techo: {
                required: "Debes seleccionar el material del techo"
            },
            txttipo_sanitario: {
                required: "Debes seleccionar el tipo de sanitario"
            },
            txtdrenaje: {
                required: "Debes seleccionar si cuenta con drenaje"
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
            var data = $("#agregarForm").serialize();
            $.get("ControladorVivienda", data, function (respuesta, est, jqXHR) {
                if (respuesta == '1') {
                    Swal.fire({
                        icon: 'success',
                        color: '#ffffff',
                        title: 'Registro de vivienda exitoso!',
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
                        window.location = "ControladorVivienda?action=listar";
                    }, 3000);
                } else {
                    Swal.fire({
                        icon: 'error',
                        color: '#ffffff',
                        title: 'No se pudo registrar la vivienda!',
                        text: 'Verifique sus datos o correo ya registrado.',
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
    $("#editarForm").validate({
        rules: {
            txtfamiliar_idfamiliar: {
                required: true
            },
            txtmaterial_piso: {
                required: true
            },
            txtmaterial_pared: {
                required: true
            },
            txtacabado_pared: {
                required: true
            },
            txtmaterial_techo: {
                required: true
            },
            txttipo_sanitario: {
                required: true
            },
            txtdrenaje: {
                required: true
            },
        },
        messages: {
            txtfamiliar_idfamiliar: {
                required: "Debes seleccionar el familiar"
            },
            txtmaterial_piso: {
                required: "Debes seleccionar el material del piso"
            },
            txtmaterial_pared: {
                required: "Debes seleccionar el material de la pared"
            },
            txtacabado_pared: {
                required: "Debes seleccionar el material del acabado de la pared"
            },
            txtmaterial_techo: {
                required: "Debes seleccionar el material del techo"
            },
            txttipo_sanitario: {
                required: "Debes seleccionar el tipo de sanitario"
            },
            txtdrenaje: {
                required: "Debes seleccionar si cuenta con drenaje"
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
            var data = $("#editarForm").serialize();
            $.get("ControladorVivienda", data, function (respuesta, est, jqXHR) {
                if (respuesta == '1') {
                    Swal.fire({
                        icon: 'success',
                        color: '#ffffff',
                        title: 'Actualizaci�n de viviena exitoso!',
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
                        window.location = "ControladorVivienda?action=listar";
                    }, 3000);
                } else {
                    Swal.fire({
                        icon: 'error',
                        color: '#ffffff',
                        title: 'No se pudo actualizar la vivienda!',
                        text: 'Verifique sus datos o correo ya registrado.',
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


