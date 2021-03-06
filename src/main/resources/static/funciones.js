function eliminarUsuario(Cedula) {
    swal({
        title: "Esta seguro de Eliminar el usuario?",
        text: "Una vez eliminado el usuario no puede ser recuperado!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/eliminarUsuario/" + Cedula,
                    success: function(res) {
                        console.log(res);
                    }
                });
                swal("Poof! el Usuario ha sido eliminado!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/listarUsuario";
                    }
                });
            } else {
                swal("El Usuario NO se ha eliminado!");
            }
        });
}

function eliminarCliente(Cedula) {
    swal({
        title: "Esta seguro de Eliminar el cliente?",
        text: "Una vez eliminado el cliente no puede ser recuperado!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/eliminarCliente/" + Cedula,
                    success: function(res) {
                        console.log(res);
                    }
                });
                swal("Poof! el Cliente ha sido eliminado!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/listarCliente";
                    }
                });
            } else {
                swal("El cliente NO se ha eliminado!");
            }
        });
}

function eliminarProveedor(nit) {
    swal({
        title: "Esta seguro de Eliminar el proveedor?",
        text: "Una vez eliminado el proveedor no puede ser recuperado!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/eliminarProveedor/" + nit,
                    success: function(res) {
                        console.log(res);
                    }
                });
                swal("Poof! el Proveedor ha sido eliminado!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/listarProveedor";
                    }
                });
            } else {
                swal("El proveedor NO se ha eliminado!");
            }
        });
}

function eliminarProducto(codigo) {
    swal({
        title: "Esta seguro de Eliminar el producto?",
        text: "Una vez eliminado el producto no puede ser recuperado!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/eliminarProducto/" + codigo,
                    success: function(res) {
                        console.log(res);
                    }
                });
                swal("Poof! el Producto ha sido eliminado!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/listarProducto";
                    }
                });
            } else {
                swal("El producto NO se ha eliminado!");
            }
        });
}

function completarUsuario() {
    var nombreUsuario = document.getElementById("selectUsuario").value;
    document.getElementById("inputUsuario").value = nombreUsuario;

    console.log(nombreUsuario)
}

function completarCliente() {
    var nombreCliente = document.getElementById("selectCliente").value;
    var cliente = document.getElementById("selectCliente").selectedOptions[0].text;
    document.getElementById("inputCliente").value = nombreCliente;
    document.getElementById("nombre_Cli_Vta").value = cliente;


}


function completarProducto1() {
    var codigoProducto = document.getElementById("selectProducto1").value;
    var producto1 = productos.find(item => item.codigo_Producto == codigoProducto);
    document.getElementById("inputProducto1").value = producto1.codigo_Producto;
    document.getElementById("precio_SinIVA1").value = producto1.precio_Compra;
    hallarValorTotalSinIVA1();

}

function completarProducto2() {
    var codigoProducto = document.getElementById("selectProducto2").value;
    var producto1 = productos.find(item => item.codigo_Producto == codigoProducto);
    document.getElementById("inputProducto2").value = producto1.codigo_Producto;
    document.getElementById("precio_SinIVA2").value = producto1.precio_Compra;
    hallarValorTotalSinIVA2();

}

function completarProducto3() {
    var codigoProducto = document.getElementById("selectProducto3").value;
    var producto1 = productos.find(item => item.codigo_Producto == codigoProducto);
    document.getElementById("inputProducto3").value = producto1.codigo_Producto;
    document.getElementById("precio_SinIVA3").value = producto1.precio_Compra;
    hallarValorTotalSinIVA3()
}


function showHour() {
    var hoy = new Date();
    var hora = hoy.getHours() + ':' + hoy.getMinutes() + ':' + hoy.getSeconds();
    document.getElementById("HoraActual").value = hora;
    setTimeout("showHour()", 1000)


}

showDate();
function showDate() {
    var hoy = new Date();
    var fecha = hoy.getDate() + ' / ' + (hoy.getMonth() + 1) + ' / ' + hoy.getFullYear();

    document.getElementById("FechaActual").value = fecha;

}

function hallarValorTotalSinIVA1() {
    let valorUnidad = document.getElementById("precio_SinIVA1").value;
    let cantidad = document.getElementById("cantidadProducto1").value;
    let totalSinIVA = valorUnidad * cantidad;
    document.getElementById("inputTotalSinIVA1").value = totalSinIVA;
    hallarValorSubTotalSinIVA();

}

function hallarValorTotalSinIVA2() {
    let valorUnidad = document.getElementById("precio_SinIVA2").value;
    let cantidad = document.getElementById("cantidadProducto2").value;
    let totalSinIVA = valorUnidad * cantidad;
    document.getElementById("inputTotalSinIVA2").value = totalSinIVA;
    hallarValorSubTotalSinIVA();
}

function hallarValorTotalSinIVA3() {
    let valorUnidad = document.getElementById("precio_SinIVA3").value;
    let cantidad = document.getElementById("cantidadProducto3").value;
    let totalSinIVA = valorUnidad * cantidad;
    document.getElementById("inputTotalSinIVA3").value = totalSinIVA;
    hallarValorSubTotalSinIVA();
}

function hallarValorSubTotalSinIVA() {
    let valor1 = isNaN(parseInt(document.getElementById("inputTotalSinIVA1").value)) ? 0 : parseInt(document.getElementById("inputTotalSinIVA1").value);
    let valor2 = isNaN(parseInt(document.getElementById("inputTotalSinIVA2").value)) ? 0 : parseInt(document.getElementById("inputTotalSinIVA2").value);
    let valor3 = isNaN(parseInt(document.getElementById("inputTotalSinIVA3").value)) ? 0 : parseInt(document.getElementById("inputTotalSinIVA3").value);
    let valorSubTotalSinIVA = valor1 + valor2 + valor3;
    document.getElementById("inputSubTotalSinIVA").value = valorSubTotalSinIVA;

    hallarValorIVA()
    totalFactura()
    asignarDatosTotales()


}

function hallarValorIVA() {
    let porcentajeIVA = 0.05;
    let valorSubtotalIVA = isNaN(parseInt(document.getElementById("inputSubTotalSinIVA").value)) ? 0 : parseInt(document.getElementById("inputSubTotalSinIVA").value);
    let valorIVA = valorSubtotalIVA * porcentajeIVA;
    document.getElementById("inputValorIVA").value = valorIVA;

}


function totalFactura() {
    let valorSubtotalIVA = isNaN(parseInt(document.getElementById("inputSubTotalSinIVA").value)) ? 0 : parseInt(document.getElementById("inputSubTotalSinIVA").value);
    let valorIVA = isNaN(parseInt(document.getElementById("inputValorIVA").value)) ? 0 : parseInt(document.getElementById("inputValorIVA").value);
    let totalFactura = valorSubtotalIVA + valorIVA;
    document.getElementById("inputValorTotalFactura").value = totalFactura;
}

function eliminarFilaProducto1() {
    document.getElementById("inputProducto1").value = "";
    document.getElementById("selectProducto1").value = 0;
    document.getElementById("precio_SinIVA1").value = "";
    document.getElementById("cantidadProducto1").value = "";
    document.getElementById("inputTotalSinIVA1").value = "";
}

function eliminarFilaProducto2() {
    document.getElementById("inputProducto2").value = "";
    document.getElementById("selectProducto2").value = 0;
    document.getElementById("precio_SinIVA2").value = "";
    document.getElementById("cantidadProducto2").value = "";
    document.getElementById("inputTotalSinIVA2").value = "";
}

function eliminarFilaProducto3() {
    document.getElementById("inputProducto3").value = "";
    document.getElementById("selectProducto3").value = 0;
    document.getElementById("precio_SinIVA3").value = "";
    document.getElementById("cantidadProducto3").value = "";
    document.getElementById("inputTotalSinIVA3").value = "";
}

function asignarDatosTotales() {
    let valorIVA = isNaN(parseInt(document.getElementById("inputValorIVA").value)) ? 0 : parseInt(document.getElementById("inputValorIVA").value);
    let valorTotalFactura = isNaN(parseInt(document.getElementById("inputValorTotalFactura").value)) ? 0 : parseInt(document.getElementById("inputValorTotalFactura").value);


    document.getElementById("datoValorFactura").value = valorTotalFactura;
    document.getElementById("datoValorIVA").value = valorIVA;

}





