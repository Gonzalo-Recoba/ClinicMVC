window.addEventListener('load', function () {
    (function(){
        const url = "/pacientes";
        const settings = {
            method: 'GET'
        }

        fetch(url,settings)
            .then(response => response.json())
            .then(data => {
                for(paciente of data){
                    var table = document.getElementById("pacienteTableBody");
                    var pacienteRow = table.insertRow();
                    let tr_id = 'tr_' + paciente.id;
                    pacienteRow.id = tr_id;

                    pacienteRow.innerHTML =
                        '<td class=\"td_delete\">' +
                            '<button class="btn btnDeletePaciente mr-2 btn-outline-danger" onclick="deletePaciente(' + paciente.id + ')" id="deletePaciente' + paciente.id + '"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16"><path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5"/></svg></button>' +
                            '<button type="button" class="btn btn-outline-warning btnEditPaciente" onclick="editPaciente(' + paciente.id + ')"  id="editPaciente' + paciente.id + '"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16"><path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/><path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/></svg></button>' +
                        '</td>' +
                        '<td class=\"td_id\">' + paciente.id + '</td>' +
                        '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                        '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                        '<td class=\"td_dni\">' + paciente.dni.toUpperCase() + '</td>' +
                        '<td class=\"td_fIngreso\">' + paciente.fechaIngreso + '</td>'
                    ;
                };
            })
    })

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/pacienteLista.html") {
            document.querySelector(".nav-item a:last").addClass("active");
        }
    })
})


function deletePaciente(id){
    let resp = confirm("Seguro desea eliminar al Paciente?")
    if (resp) {
        const dataPaciente = {
            id: id
        }
        const url = '/pacientes';
        const settings = {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(dataPaciente)
        }
        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                alert("Se ha eliminado al paciente con el id: " + id)
            })
            .catch(error => {
                alert(error)
            })
        location.reload()
    }
}

function editPaciente(idP) {
    const url = '/pacientes';
    const settingsGet = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    }
    fetch(url, settingsGet)
        .then(response => response.json())

        .then(data => {
            for (paciente of data) {
                if (paciente.id === idP) {
                    document.querySelector("#paciente_id").value = paciente.id;
                    document.querySelector("#nombrePaciente").value = paciente.nombre;
                    document.querySelector("#apellidoPaciente").value = paciente.apellido;
                    document.querySelector("#dniPaciente").value = paciente.dni;
                    document.querySelector("#fechaIngresoPaciente").value = paciente.fechaIngreso;
                }
            }
        })
        .catch(error => {
            alert(error)
        })

    const divFormEdit = document.getElementById("div_paciente_updating")
    divFormEdit.style.display = 'block'
}
    const formularioPaciente = document.querySelector('#update_paciente_form');
    formularioPaciente.addEventListener('submit', function (event) {
        const formDataPaciente = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombrePaciente').value,
            apellido: document.querySelector('#apellidoPaciente').value,
            dni: document.querySelector('#dniPaciente').value,
            fechaIngreso: document.querySelector('#fechaIngresoPaciente').value,
        }
        const urlPacientes = '/pacientes';
        const settingsPaciente = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataPaciente)
        }
        fetch(urlPacientes, settingsPaciente)
            .then(response => response.json())
            .then(data => {
                alert("Se actualizo el paciente correctamente.")
            })
            .catch(error => {
                alert(error)
            })
            .finally(() => {
                document.querySelector('#nombrePaciente').value = "";
                document.querySelector('#apellidoPaciente').value = "";
                document.querySelector("#dniPaciente").value = "";
                document.querySelector("#fechaIngresoPaciente").value = "";
            })
        location.reload()
    })