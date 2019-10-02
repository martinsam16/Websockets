

var socket = new WebSocket('ws://' + location.hostname + (location.port ? ':' + location.port : '') + '/WebsocketsJDBC/ws/persona');

function enviar(event) {
    socket.send('Enviado desde js ' + event);
}

socket.onmessage = function (event) {
    PF('growlWV').renderMessage({
        "summary": "Actualización",
        "detail": "Se registró a " + event.data,
        "severity": "info"
    });
    actualizarDatos();
    console.log('Actualizado datos desde js');

};

function actualizarDatos() {
    PrimeFaces.ab({s: "frmRegistrarPersona:btnActualizar", f: "frmRegistrarPersona", u: "frmRegistrarPersona frmListarPersona", onco: function (xhr, status, args) {
            PF('wvDtTblPersona').filter();
        }});
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


