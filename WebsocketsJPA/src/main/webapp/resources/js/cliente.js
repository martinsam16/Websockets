

var socket = new WebSocket('ws://' + location.hostname + (location.port ? ':' + location.port : '') + '/WebsocketsJPA/ws/persona');

function enviar(event) {
    socket.send('Enviado desde js ' + event);
}

socket.onmessage = function (event) {
    PF('mensajeSockets').renderMessage({
        "summary": "Actualización",
        "detail": "Se registró a " + event.data,
        "severity": "info"
    });
    actualizarDatos();
    console.log('Actualizado datos desde js');

};

function actualizarDatos() {
    PrimeFaces.ab({s: "j_idt90:btnActualizarPersona", f: "j_idt90", u: "PersonaListForm:datalist"});
    return false;
}

socket.onopen = function (event) {
    console.log('Conexión abierta ' + event);
};

socket.onclose = function (event) {
    console.log('Conexión socket cerrada ' + event);
};

socket.onerror = function (event) {
    console.log('Error! ' + event);
};

function cerrarSesion() {
    socket.onclose = function () {};
    socket.close();
    console.log('Conexión socket cerrada!!');
}


