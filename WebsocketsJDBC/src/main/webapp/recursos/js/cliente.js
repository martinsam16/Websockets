

var socket = new WebSocket('ws://'+location.hostname+(location.port ? ':'+location.port: '')+'/WebsocketsJDBC/ws/persona');

function enviar(event) {
    console.log(event);
    socket.send('Enviado desde js '+event);
}

socket.onmessage = function (event) {
    PF('growlWV').renderMessage({
        "summary": "Mensaje C:",
        "detail": event.data,
        "severity": "info"
    });
};


