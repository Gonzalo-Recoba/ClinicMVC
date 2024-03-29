window.addEventListener('load', function () {
    (function(){

        //con fetch invocamos a la API de odontólogos con el método GET
        //nos devolverá un JSON con una colección de turnos
        const url = "/turnos";
        const settings = {
            method: 'GET'
        }

        fetch(url,settings)
            .then(response => response.json())
            .then(data => {
                //recorremos la colección de turnos del JSON
                for(turno of data){
                    //por cada turno armaremos una fila de la tabla
                    //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos el turno
                    var table = document.getElementById("turnoTableBody");
                    var turnoRow = table.insertRow();
                    let tr_id = 'tr_' + turno.id;
                    turnoRow.id = tr_id;

                    turnoRow.innerHTML =
                        '<td class=\"td_delete\"><button class="btn btnDeleteTurno mr-2 btn-outline-danger" onclick="deleteTurno(' + turno.id + ')"  id="deleteTurno' + turno.id + '"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16"><path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5"/></svg></button></td>' +
                        '<td class=\"td_id\">' + turno.id + '</td>' +
                        '<td class=\"td_id\">' + turno.fecha + '</td>' +
                        '<td class=\"td_nombreOdontologo\">' + turno.odontologo.nombre.toUpperCase() + " " + turno.odontologo.apellido.toUpperCase() + '</td>' +
                        '<td class=\"td_nombrePaciente\">' + turno.paciente.nombre.toUpperCase() + " " + turno.paciente.apellido.toUpperCase() + '</td>'
                    ;
                };

            })
    })

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/turnoLista.html") {
            document.querySelector(".nav-item a:last").addClass("active");
        }
    })
})

function deleteTurno(id){
    let resp = confirm("Seguro desea eliminar al Turno?")
    if (resp) {

        const dataTurno = {
            id: id
        }
        const url = '/turnos';
        const settings = {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(dataTurno)
        }
        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                alert("Se ha eliminado al turno con el id: " + id)
            })
            .catch(error => {
                alert(error)
            })
        location.reload()
    }
}