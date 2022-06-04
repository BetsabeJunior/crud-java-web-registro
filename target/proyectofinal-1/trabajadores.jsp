<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/3d75e5734d.js" crossorigin="anonymous"></script>
        <title>Trabajadores</title>
    </head>
    <body>

        <!-- Cabecero -->
        <jsp:include page="WEB-INF/comunes/cabecero.jsp" />
        <!-- Modal -->
        <jsp:include page="WEB-INF/comunes/botonesTrabajador.jsp" />
        <!-- Formulario -->
        <jsp:include page="WEB-INF/trabajador/agregarTrabajador.jsp" />
        <!-- Consulta -->
        <jsp:include page="WEB-INF/trabajador/consultarTrabajador.jsp" />
        <!-- Listado -->
        <jsp:include page="WEB-INF/trabajador/listadoTrabajadores.jsp" />

        <!-- Footer -->
        <jsp:include page="WEB-INF/comunes/piePagina.jsp" />

        <script src="boostrap.js"></script>
    </body>
</html>
