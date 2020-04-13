/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function deleteRecord(id) {
    /*var doIt = confirm('¿Estas seguro que quieres eliminar el usuario?');*/
    Swal.fire({
        title: '¿Está seguro que desea eliminar el registro con ID: ' + id + '?',
        text: "Ya no podras recuperar esta información!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, Eliminar!',
        width: 600,
        padding: '3em',
        background: '#0F0000',
        backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("img/giphyerror.gif")
                                        left top
                                        no-repeat
                                    `
    }).then((result) => {
        if (result.value) {
            Swal.fire({
                icon: 'success',
                color: '#ffffff',
                title: 'Registro eliminado con éxito!',
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
            window.location = "ControladorUsuario?action=eliminar&id=" + id + "&registros=false";
        } else {

        }
    });
}

