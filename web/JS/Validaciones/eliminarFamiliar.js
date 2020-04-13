/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function deleteRecord(id) {
    /*var doIt = confirm('�Estas seguro que quieres eliminar el usuario?');*/
    Swal.fire({
        title: '�Est� seguro que desea eliminar el registro con ID: ' + id + '?',
        text: "Ya no podras recuperar esta informaci�n!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'S�, Eliminar!',
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
                title: 'Registro eliminado con �xito!',
                width: 600,
                timer: 2000,
                padding: '3em',
                background: '#0F0000',
                backdrop: `
                                        rgba(15, 0, 0, 0.6)
                                        url("img/giphysuccess.gif")
                                        left top
                                        no-repeat
                                    `
            });
            window.location = "ControladorFamiliar?action=eliminar&id="+id;
        } else {

        }
    });
}



