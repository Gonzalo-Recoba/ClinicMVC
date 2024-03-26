window.addEventListener('load', function () {
    (function(){

        //con fetch invocamos a la API de odontólogos con el método GET
        //nos devolverá un JSON con una colección de odontólogos
        const url = '/pacientes';
        const settings = {
            method: 'GET'
        }

        fetch(url,settings)
            .then(response => response.json())
            .then(data => {
                //recorremos la colección de pacentes del JSON
                for(paciente of data){
                    //por cada paciente armaremos una fila de la tabla
                    //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos el paciente
                    var table = document.getElementById("pacienteTable");
                    var pacienteRow = table.insertRow();
                    let tr_id = 'tr_' + paciente.id;
                    pacienteRow.id = tr_id;

                    pacienteRow.innerHTML =
                        '<td class=\"td_id\">' + paciente.id + '</td>' +
                        '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                        '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>'
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