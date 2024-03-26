window.addEventListener('load', function () {

    //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
    //los datos que el usuario cargará del nuevo odontólogo
    const formularioPaciente = document.querySelector('#add_new_paciente');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    formularioPaciente.addEventListener('submit', function (event) {

        //creamos un JSON que tendrá los datos del nuevo odontólogo
        const formDataPaciente = {
            nombre: document.querySelector('#nombrePaciente').value,
            apellido: document.querySelector('#apellidoPaciente').value,
            dni: document.querySelector('#dniPaciente').value,
            fechaIngreso: document.querySelector('#fechaIngresoPaciente'),
        };
        //invocamos utilizando la función fetch la API odontólogos con el método POST que guardará
        //el odontólogo que enviaremos en formato JSON
        const url = '/pacientes';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataPaciente)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                //Si no hay ningun error se muestra un mensaje diciendo que el paciente
                //se agrego bien
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Paciente agregado </div>'

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();

            })
            .catch(error => {
                //Si hay algun error se muestra un mensaje diciendo que el paciente
                //no se pudo guardar y se intente nuevamente
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>'

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
                //se dejan todos los campos vacíos por si se quiere ingresar otro odontólogo
                resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#nombrePaciente').value = "";
        document.querySelector('#apellidoPaciente').value = "";
        document.querySelector("#dniPaciente").value = "";
        document.querySelector("#fechaIngresoPaciente").value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/pacienteLista.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});