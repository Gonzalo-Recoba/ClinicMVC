window.addEventListener('load', function () {

    const formularioPaciente = document.querySelector('#add_new_paciente');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    formularioPaciente.addEventListener('submit', function (event) {

        const formDataDomicilio = {
            calle: document.querySelector("#calleDomicilioPaciente").value,
            numero: document.querySelector("#numeroDomicilioPaciente").value,
            localidad: document.querySelector("#localidadDomicilioPaciente").value,
            provincia: document.querySelector("#provinciaDomicilioPaciente").value,
        }
        const urlDomicilios = "/domicilios"
        const settingsDomicilio = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataDomicilio)
        }
        var idDomicilio;
        fetch(urlDomicilios, settingsDomicilio)
            .then(response => response.json())
            .then(data => {
                alert("Se creo el domicilio correctamente.")
                idDomicilio = data.id;

            })
            .catch(error => {
                alert("No se puede crear al domicilio, por favor intentelo nuevamente.")
            })
            .finally(()=>{
                document.querySelector("#calleDomicilioPaciente").value,
                document.querySelector("#numeroDomicilioPaciente").value,
                document.querySelector("#localidadDomicilioPaciente").value,
                document.querySelector("#provinciaDomicilioPaciente").value
            })


        const formDataPaciente = {
            nombre: document.querySelector('#nombrePaciente').value,
            apellido: document.querySelector('#apellidoPaciente').value,
            dni: document.querySelector('#dniPaciente').value,
            fechaIngreso: document.querySelector('#fechaIngresoPaciente').value,
        }
        const urlPacientes = '/pacientes';
        const settingsPaciente = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataPaciente)
        }
        fetch(urlPacientes, settingsPaciente)
            .then(response => response.json())
            .then(data => {
                alert("Se creo el paciente correctamente.")
            })
            .catch(error => {
                alert("No se puede crear al paciente, por favor intentelo nuevamente.")
            })
            .finally(()=>{
                document.querySelector('#nombrePaciente').value = "";
                document.querySelector('#apellidoPaciente').value = "";
                document.querySelector("#dniPaciente").value = "";
                document.querySelector("#fechaIngresoPaciente").value = "";
            })

    });


    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first-child").classList.add("active");
        } else if (pathname == "/pacienteLista.html") {
            document.querySelector(".nav .nav-item a:last-child").classList.add("active");
        }
    })();
});