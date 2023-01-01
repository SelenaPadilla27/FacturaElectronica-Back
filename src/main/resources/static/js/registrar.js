// Call the dataTables jQuery plugin
$(document).ready(function() {
   });

 async function registrarUsuarios(){
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellidos').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;
    let repetirPassword = document.getElementById('txtRepetirPassword').value;
    if (repetirPassword != datos.password){
    alert('Las  contraseña no coinciden');
    return;
    }
    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert("La cuenta fue creada con exito!");
  window.location.href = 'login.html'
}

