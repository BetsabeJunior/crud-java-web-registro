<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white" >
                <h5 class="modal-title justify-content-center" >Consultar trabajador </h5>
                <button class="btn btn-info" data-bs-dismiss="modal" >
                    <i class="fas fa-times"></i>
                </button>
            </div>  
            <div class="d-flex py-2 justify-content-center" >
                <div class="form-group col-sm-4" >
                    <input type="number" class="form-control" placeholder="Cedula"  name="cedula" required >
                </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <div class="" >
                    <a class="btn btn-primary text-white" href="ServletControlador?accion=consultar&cedula=${trabajador.cedula}" >
                        <i class="fa-solid fa-magnifying-glass"></i> Consultar 
                    </a>
                </div>
            </div>
            <div class="modal-body">
                <table class="table table-striped" >
                    <thead class="thead-dark" >
                        <tr class="" style="background:  #4DF4FF;">
                            <th>Identificación</th>
                            <th>Nombre</th>
                            <th>Hora de entrada</th>
                            <th>Hora de salida</th>
                        </tr>
                    </thead>
                    <tbody>   
                        <tr>${trabajador.cedula}</tr>
                        <tr>${trabajador.nombre}</tr>
                        <tr>${trabajador.entrada}</tr>
                        <tr>${trabajador.salida}</tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
