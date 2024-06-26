window.addEventListener('load', function () {
        const urlPacientes = "/pacientes";
        const urlOdontologos = "/odontologos"
        const settings = {
            method: 'GET'
        }
        let selectPaciente = document.getElementById("selectPaciente");
        let selectOdontologo = document.getElementById("selectOdontologo")
        fetch(urlPacientes,settings)
            .then(response => response.json())
            .then(data => {
                for(paciente of data){
                    selectPaciente.innerHTML +=
                        '<option value="'+ paciente.id +'" label="' + paciente.nombre.toUpperCase() + " " + paciente.apellido.toUpperCase() +'">' + paciente.nombre + '</option>';
                }
            })

        fetch(urlOdontologos,settings)
            .then(response => response.json())
            .then(data => {
                for(odontologo of data){
                    selectOdontologo.innerHTML +=
                        '<option value="'+ odontologo.id +'" label="' + odontologo.nombre.toUpperCase() + " " + odontologo.apellido.toUpperCase() +'">' + odontologo.nombre + '</option>';
                }
            })


    const formularioTurno = document.querySelector('#add_new_turno');
    formularioTurno.addEventListener('submit', function (event) {
        const formDataTurno = {
            fecha: document.querySelector('#fechaTurno').value,
            odontologo: {
                id: document.querySelector('#selectOdontologo').value},
            paciente: {
                id: document.querySelector('#selectPaciente').value}
            }
        const urlTurnos = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataTurno)
        }
        fetch(urlTurnos, settings)
            .then(response => response.json())
            .then(data => {
                alert("Turno creado correctamente.")
            })
            .catch(error => {
                alert("No se pudo crear el turno, intentelo nuevamente.")
            })
            .finally(()=>{
                document.querySelector('#fechaTurno').value = "";
                document.querySelector('#selectOdontologo').value = "";
                document.querySelector("#selectPaciente").value = "";
            })
        })
})