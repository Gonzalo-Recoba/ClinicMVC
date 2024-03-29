window.addEventListener('load', function () {

    //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
    //los datos que el usuario cargará del nuevo odontólogo
    const formulario = document.querySelector('#add_new_dentist');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    formulario.addEventListener('submit', function (event) {

        const formDataOdontologo = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value,

        };

        const url = '/odontologos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataOdontologo)
        }
        console.log(formDataOdontologo)
        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                alert("Se ha creado el Odontologo correctamente.")
            })
            .catch(error => {
                alert("No se pudo crear el Odontologo, intentelo nuevamente.")
            })
            .finally(()=>{
                document.querySelector('#nombre').value = "";
                document.querySelector('#apellido').value = "";
                document.querySelector('#matricula').value = "";
            })
    });


    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/odontologoLista.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});