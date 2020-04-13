/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#recuperarForm").validate({
        rules: {
            txtcorreo: {
                required: true,
                email: true
            },
        },
        messages: {
            txtcorreo: {
                required: "Debes ingresar tu correo electronico",
                email: "Ingresa un correo electronico valido"
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
            var data = $("#recuperarForm").serialize();
            $.get("../ControladorUsuario", data, function (respuesta, est, jqXHR) {
                if (respuesta == '1') {
                    Swal.fire({
                        icon: 'success',
                        color: '#FFFFFF',
                        title: 'Se envio el correo correctamente!',
                        text: 'Verifica tu correo electrónico.',
                        width: 600,
                        padding: '3em',
                        background: '#0F0000',
                        backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("../img/giphysuccess.gif")
                                        left top
                                        no-repeat
                                    `
                    });
                    setTimeout(function () {
                        window.location = "../index.jsp";
                    }, 3000);
                } else if (respuesta == '2') {
                    Swal.fire({
                        icon: 'error',
                        color: '#FFFFFF',
                        title: 'No se pudo enviar el correo electrónico!',
                        text: 'Verifica tu correo electrónico.',
                        width: 600,
                        padding: '3em',
                        background: '#0F0000',
                        backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("../img/giphyerror.gif")
                                        left top
                                        no-repeat
                                    `
                    });
                } else {
                    Swal.fire({
                        icon: 'error',
                        color: '#ffffff',
                        title: 'No se pudo enviar la solicitud!',
                        text: 'El correo no se encuentra registrado en el sistema.',
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
                    $("#txtcorreo").val("");
                }
            });
        }
    });
});

$(document).ready(function () {
    $("#restablecerForm").validate({
        rules: {
            txtcontran: {
                required: true,
                minlength: 5
            },
            txtcontra2: {
                required: true,
                minlength: 5,
                equalTo: "#txtcontran"
            },
        },
        messages: {
            txtcontran: {
                required: "Debes ingresar la contraseña",
                minlength: "La contraseÃ±a debe contener al menos 5 caracteres"
            },
            txtcontra2: {
                required: "Debes ingresar la confirmación de la contraseña",
                minlength: "La contraseña debe contener al menos 5 caracteres",
                equalTo: "Las contraseñas no coinciden"
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
            var data = $("#restablecerForm").serialize();
            $.get("../ControladorUsuario", data, function (respuesta, est, jqXHR) {
                if (respuesta == '1') {
                    Swal.fire({
                        icon: 'success',
                        color: '#ffffff',
                        title: 'Contraseña restablecida correctamente!',
                        text: 'Inicia sesión para ingresar al sistema.',
                        width: 600,
                        timer: 3000,
                        padding: '3em',
                        background: '#0F0000',
                        backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("../img/giphysuccess.gif")
                                        left top
                                        no-repeat
                                    `
                    });
                    setTimeout(function () {
                        window.location = "../index.jsp";
                    }, 3000);
                } else {
                    Swal.fire({
                        icon: 'error',
                        color: '#ffffff',
                        title: 'No se pudo restablecer la contrseña!',
                        text: 'Verifica los datos ingresados.',
                        width: 600,
                        padding: '3em',
                        background: '#0F0000',
                        backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("../img/giphyerror.gif")
                                        left top
                                        no-repeat
                                    `
                    });
                    $("#txtcontran").val("");
                    $("#txtcontra2").val("");
                }
            });
        }
    });
});

/*
 var pass1 = $('[name=txtcontra]');
 var pass2 = $('[name=txtcontra2]');
 var confirmacion = "Las contraseÃ±as si coinciden";
 var negacion = "No coinciden las contraseÃ±as";
 //oculto por defecto el elemento span
 var span = $('<span></span>').insertAfter(pass2);
 span.hide();
 //funciÃ³n que comprueba las dos contraseÃ±as
 function coincidePassword() {
 var valor1 = pass1.val();
 var valor2 = pass2.val();
 //muestro el span
 span.show().removeClass();
 //condiciones dentro de la funciÃ³n
 if (valor1 != valor2) {
 span.text(negacion).addClass('negacion');
 }
 if (valor1.length != 0 && valor1 == valor2) {
 span.text(confirmacion).removeClass("negacion").addClass('confirmacion');
 }
 }
 //ejecuto la funciÃ³n al soltar la tecla
 pass2.keyup(function () {
 coincidePassword();
 });*/