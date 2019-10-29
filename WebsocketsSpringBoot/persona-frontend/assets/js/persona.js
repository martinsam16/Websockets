
const urlUbigeo = 'http://localhost:3000/api/v1/ubigeo';
const urlPersona = 'http://localhost:3000/api/v1/persona';
let ws = new WebSocket('ws://localhost:3000/persona');

//const urlUbigeo = 'http://developers.vallegrande.edu.pe/idoc-0.0.1/api/v1/ubigeo';
//const urlPersona = 'http://developers.vallegrande.edu.pe/idoc-0.0.1/api/v1/persona';

var listaUbigeo = JSON.parse(localStorage.getItem("listaUbigeo"));
var listaPersona = [];
var personaSeleccionado;
var tblPersona = $('#tblPersona').dataTable({
    "columnDefs": [
        {
            "targets": 7,
            "data": null,
            "defaultContent": "<a onclick='obtenerPersona($(this).parent()); setearDatos();' class='btn btn-icon btn-light' data-toggle='modal' data-target='#frmModificarPersona'><i class='fas fa-eye'></i></a>"
        },
        {
            "targets": 8,
            "data": null,
            "defaultContent": "<a onclick='obtenerPersona($(this).parent()); eliminarPersona();' class='btn btn-icon btn-danger'><i class='fas fa-times'></i></a>"
        },
    ],
    aoColumns: [
        { data: 'idper' },
        { mData: 'apepatper' },
        { mData: 'apematper' },
        { mData: 'nomper' },
        { mData: 'dniper' },
        { mData: 'estper' },
        { mData: 'ubigeo.distubi' }
    ],
});

obtenerPersona = (val) => {
    personaSeleccionado = tblPersona.fnGetData(val);
    console.log(personaSeleccionado);
}

const listarUbigeo = async () => {
    if (listaUbigeo == null) {
        const response = await fetch(urlUbigeo);
        localStorage.setItem("listaUbigeo", JSON.stringify(await response.json()));
        listaUbigeo = JSON.parse(localStorage.getItem("listaUbigeo"));
    }
    listaUbigeo.forEach(ubigeo => {
        $("select#listaUbigeo").append(
            $("<option>")
                .val(ubigeo.codubi)
                .html(ubigeo.distubi)
        );
    });
}


ws.onopen = () => {
    console.log('Conectado a socket');
    ws.send('C:');
}

ws.onmessage = (event) => {
    tblPersona.fnClearTable();
    listaPersona = JSON.parse(event.data);

    tblPersona.fnAddData(listaPersona);
    tblPersona.fnDraw();
    console.log('Actualización listado');
}


listarPersona = () => {
    if (ws.readyState === 1) {
        ws.send('C:');
    }
}

listarUbigeo();
$('#divId').hide();


accionPersona = async function (metodo, datos) {

    await fetch(urlPersona, {
        method: metodo,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    }).then(
        (res) => {
            console.log('registrado/editado correctamente');
            listarPersona();
            $(function () {
                $('.modal').modal('hide');
            });
        },
        (rej) => {
            console.log('error xd');
        }
    );
}


$("#frmPersona").submit(function (event) {
    event.preventDefault();
});

$("#btnGuardarPersona").click(function () {
    accionPersona('POST', obtenerDatosPersona());
});

$("#btnModificarPersona").click(function () {
    accionPersona('PUT', obtenerDatosPersona());
});

eliminarPersona = () => {

    fetch(urlPersona + '/' + personaSeleccionado.idper, {
        method: 'DELETE',
    }).then(
        (res) => {
            console.log('Eliminado ' + personaSeleccionado.idper);
            listarPersona();
        },
        (rej) => {
            console.log('error xd');
        }
    );
}



obtenerDatosPersona = function () {
    let personaForm = $('form#frmPersona').serializeArray();
    let ubigeoSeleccionado = listaUbigeo.filter(
        ubigeo => ubigeo.codubi == personaForm[5].value
    );

    return data = {
        idper: personaForm[0].value != ""
            ? personaForm[0].value : Math.max.apply(Math, listaPersona.map((p) => {
                return p.idper;
            })) + 1,
        apepatper: personaForm[1].value,
        apematper: personaForm[2].value,
        nomper: personaForm[3].value,
        dniper: personaForm[4].value,
        ubigeo: ubigeoSeleccionado[0],
        dirper: personaForm[6].value,
        estper: "A",
        genper: personaForm[7].value
    };
}

setearDatos = () => {
    $('#btnModificarPersona').show();
    $('#btnGuardarPersona').hide();

    $('[name=idper]').val(personaSeleccionado.idper);
    $('[name=apepatper]').val(personaSeleccionado.apepatper);
    $('[name=apematper]').val(personaSeleccionado.apematper);
    $('[name=nomper]').val(personaSeleccionado.nomper);
    $('[name=dniper]').val(personaSeleccionado.dniper);
    $('[name=dirper]').val(personaSeleccionado.dirper);
    $('[name=codubi]').val(personaSeleccionado.ubigeo.codubi);
    personaSeleccionado.genper == 'M' ? $("#genM").prop("checked", true) : $("#genF").prop("checked", true);
}

clearDatos = () => {
    $('#btnModificarPersona').hide();
    $('#btnGuardarPersona').show();

    $('[name=idper]').val('');
    $('[name=apepatper]').val('');
    $('[name=apematper]').val('');
    $('[name=nomper]').val('');
    $('[name=dniper]').val('');
    $('[name=dirper]').val('');
    $("#genM").prop("checked", true); //viva el patriarcado
}