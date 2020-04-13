/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery.validator.addMethod("lettersonly", function (value, element)
{
    return this.optional(element) || /^[a-z Ã¡ Ã© Ã­ Ã³ Ãº]+$/i.test(value);
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
            txtnombre: {
                required: true,
                lettersonly: true
            },
            txtapaterno: {
                required: true,
                lettersonly: true
            },
            txtamaterno: {
                required: true,
                lettersonly: true
            },
            txtcorreo: {
                required: true,
                email: true
            },
            txtcontra: {
                required: true,
                minlength: 5
            },
            txtcontra2: {
                required: true,
                minlength: 5,
                equalTo: "#txtcontra"
            },
            txttelefono: {
                required: true,
                number: true,
                minlength: 10,
                maxlength: 10
            },
            txtfechanac: {
                required: true,
                date: true,
                daterange: true
            },
            txttipo: {
                required: true
            },
            txtestado: {
                required: true
            },
        },
        messages: {
            txtnombre: {
                required: "Debes ingresar el nombre"
            },
            txtapaterno: {
                required: "Debes ingresar el apellido paterno"
            },
            txtamaterno: {
                required: "Debes ingresar el apellido materno"
            },
            txtcorreo: {
                required: "Debes ingresar el correo electronico",
                email: "Ingresa un correo electronico valido"
            },
            txtcontra: {
                required: "Debes ingresar la contraseña",
                minlength: "La contraseña debe contener al menos 5 caracteres"
            },
            txtcontra2: {
                required: "Debes ingresar la confirmación de la contraseña",
                minlength: "La contraseña debe contener al menos 5 caracteres",
                equalTo: "Las contraseñas no coinciden"
            },
            txttelefono: {
                required: "Debes ingresar el telefono",
                number: "Ingresa solo numeros",
                minlength: "Ingresa tu numero a 10 digitos",
                maxlength: "Ingresa tu numero a 10 digitos"
            },
            txtfechanac: {
                required: "Debes ingresar la fecha de nacimiento",
                date: "Ingresa un fecha de nacimiento valida"
            },
            txttipo: {
                required: "Debes seleccionar un tipo de usuario"
            },
            txtestado: {
                required: "Debes seleccionar el estado del usuario"
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
            $.get("ControladorUsuario", data, function (respuesta, est, jqXHR) {
                if (respuesta == '1') {
                    Swal.fire({
                        icon: 'success',
                        color: '#ffffff',
                        title: 'Registro de usuario exitoso!',
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
                        window.location = "ControladorUsuario?action=listar&registros=false";
                    }, 3000);
                } else {
                    Swal.fire({
                        icon: 'error',
                        color: '#ffffff',
                        title: 'No se pudo registrar el usuario!',
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
                    $("#txtcorreo").val("");
                    $("#txtcontra").val("");
                    $("#txtcontra2").val("");
                }
            });
        }
    });
});

$(document).ready(function () {
    $("#editarForm").validate({
        rules: {
            txtnombre: {
                required: true,
                lettersonly: true
            },
            txtapaterno: {
                required: true,
                lettersonly: true
            },
            txtamaterno: {
                required: true,
                lettersonly: true
            },
            txtcorreo: {
                required: true,
                email: true
            },
            txtcontra: {
                required: true,
                minlength: 5
            },
            txtcontra2: {
                required: true,
                minlength: 5,
                equalTo: "#txtcontra"
            },
            txttelefono: {
                required: true,
                minlength: 10,
                maxlength: 10
            },
            txtfechanac: {
                required: true,
                date: true,
                daterange: true
            },
            txttipo: {
                required: true
            },
            txtestado: {
                required: true
            },
        },
        messages: {
            txtnombre: {
                required: "Debes ingresar el nombre"
            },
            txtapaterno: {
                required: "Debes ingresar el apellido paterno"
            },
            txtamaterno: {
                required: "Debes ingresar el apellido materno"
            },
            txtcorreo: {
                required: "Debes ingresar el correo electronico",
                email: "Ingresa un correo electronico valido"
            },
            txtcontra: {
                required: "Debes ingresar la contraseña",
                minlength: "La contraseña debe contener al menos 5 caracteres"
            },
            txtcontra2: {
                required: "Debes ingresar la confirmación de la contraseña",
                minlength: "La contraseña debe contener al menos 5 caracteres",
                equalTo: "Las contraseñas no coinciden"
            },
            txttelefono: {
                required: "Debes ingresar el telefono",
                number: "Ingresa solo numeros",
                minlength: "Ingresa tu numero a 10 digitos",
                maxlength: "Ingresa tu numero a 10 digitos"
            },
            txtfechanac: {
                required: "Debes ingresar la fecha de nacimiento",
                date: "Ingresa un fecha de nacimiento valida"
            },
            txttipo: {
                required: "Debes seleccionar un tipo de usuario"
            },
            txtestado: {
                required: "Debes seleccionar el estado del usuario"
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
            $.get("ControladorUsuario", data, function (respuesta, est, jqXHR) {
                if (respuesta == '1') {
                    Swal.fire({
                        icon: 'success',
                        color: '#ffffff',
                        title: 'Actualización de usuario exitoso!',
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
                        window.location = "ControladorUsuario?action=listar&registros=false";
                    }, 3000);
                } else {
                    Swal.fire({
                        icon: 'error',
                        color: '#ffffff',
                        title: 'No se pudo actualizar el usuario!',
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
    $("#registroForm").validate({
        rules: {
            txtnombre: {
                required: true,
                lettersonly: true
            },
            txtapaterno: {
                required: true,
                lettersonly: true
            },
            txtamaterno: {
                required: true,
                lettersonly: true
            },
            txtcorreo: {
                required: true,
                email: true
            },
            txtcontra: {
                required: true,
                minlength: 5
            },
            txtcontra2: {
                required: true,
                minlength: 5,
                equalTo: "#txtcontra"
            },
            txttelefono: {
                required: true,
                number: true,
                minlength: 10,
                maxlength: 10
            },
            txtfechanac: {
                required: true,
                date: true,
                daterange: true
            },
            txttipo: {
                required: true
            },
            txtestado: {
                required: true
            },
        },
        messages: {
            txtnombre: {
                required: "Debes ingresar el nombre"
            },
            txtapaterno: {
                required: "Debes ingresar el apellido paterno"
            },
            txtamaterno: {
                required: "Debes ingresar el apellido materno"
            },
            txtcorreo: {
                required: "Debes ingresar el correo electronico",
                email: "Ingresa un correo electronico valido"
            },
            txtcontra: {
                required: "Debes ingresar la contraseña",
                minlength: "La contraseñaa debe contener al menos 5 caracteres"
            },
            txtcontra2: {
                required: "Debes ingresar la confirmación de la contraseña",
                minlength: "La contraseña debe contener al menos 5 caracteres",
                equalTo: "Las contraseñas no coinciden"
            },
            txttelefono: {
                required: "Debes ingresar el telefono",
                number: "Ingresa solo numeros",
                minlength: "Ingresa tu numero a 10 digitos",
                maxlength: "Ingresa tu numero a 10 digitos"
            },
            txtfechanac: {
                required: "Debes ingresar la fecha de nacimiento",
                date: "Ingresa un fecha de nacimiento valida"
            },
            txttipo: {
                required: "Debes seleccionar un tipo de usuario"
            },
            txtestado: {
                required: "Debes seleccionar el estado del usuario"
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
            var data = $("#registroForm").serialize();
            $.get("ControladorUsuario", data, function (respuesta, est, jqXHR) {
                if (respuesta == '1') {
                    Swal.fire({
                        icon: 'success',
                        color: '#ffffff',
                        title: 'Registro de usuario exitoso!',
                        text: 'Iniciando sesión, favor de esperar',
                        width: 600,
                        timer: 5000,
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
                        window.location = "Validar?txtcorreo=" + $("#txtcorreo").val() + "&txtcontra=" + $("#txtcontra").val() + "&accion=ingresar&login=true";
                    }, 5000);
                } else {
                    Swal.fire({
                        icon: 'error',
                        color: '#ffffff',
                        title: 'No se pudo registrar el usuario!',
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
                    $("#txtcorreo").val("");
                    $("#txtcontra").val("");
                    $("#txtcontra2").val("");
                }
            });
        }
    });
});


