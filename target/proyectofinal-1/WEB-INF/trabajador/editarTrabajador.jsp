<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../boostrap.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/3d75e5734d.js" crossorigin="anonymous"></script>
        <title>Editar Trabajador</title>
    </head>
    <body>
        <!-- cabeceros -->
        <jsp:include page="../comunes/cabecero.jsp"/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <form action="ServletControlador?accion=modificar&idTrabajador=${trabajador.idTrabajador}" method="post"  class="was-validated" >
                        <div class="modal-body" >
                            <div class="form-group" >
                                <label form="cedula" >Identificación</label>
                                <input type="number" class="form-control"  name="cedula" required  value="${trabajador.cedula}">
                            </div>
                            <div class="form-group" >
                                <label form="nombre" >Nombre</label>
                                <input type="text" class="form-control"  name="nombre" required value="${trabajador.nombre}">
                            </div>
                            <div class="d-flex" >
                                <div class="form-group col-sm-6" >
                                    <label form="entrada" >Hora y fecha de entrada</label>
                                    <input type="text" class="form-control"  name="entrada" disabled=""   value="${trabajador.entrada}">
                                </div>&nbsp;
                                <div class="form-group col-sm-6" >
                                    <label form="salida" >Hora y fecha de salida</label>
                                    <input type="text" class="form-control"  name="salida" disabled="" value="${trabajador.salida}" >
                                </div>
                            </div>
                        </div>
                        <jsp:include page="../comunes/botonesNavTrabajador.jsp"/>
                    </form>
                </div>  
            </div>
        </div>
        <jsp:include page="../comunes/piePagina.jsp"/>
        <script src="boostrap.js"></script>
    </body>
</html>
