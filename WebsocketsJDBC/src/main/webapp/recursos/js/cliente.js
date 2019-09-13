

var socket = new WebSocket('ws://' + location.hostname + (location.port ? ':' + location.port : '') + '/WebsocketsJDBC/ws/persona');

function enviar(event) {
    console.log(event);
    socket.send('Enviado desde js ' + event);
}

socket.onmessage = function (event) {
    PF('growlWV').renderMessage({
        "summary": "Actualización",
        "detail": event.data,
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


