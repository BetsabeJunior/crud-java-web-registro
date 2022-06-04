<div class="modal fade" id="agregarTrabajadorModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title text-center">Agregar trabajador </h5>
                <button class="btn btn-info" data-bs-dismiss="modal">
                    <i class="fas fa-times"></i>
                </button>
            </div>
            <form action="ServletControlador?accion=insertar" method="post" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label form="cedula">Identificaci�n</label>
                        <input type="number" class="form-control" name="cedula" required>
                    </div>
                    <div class="form-group">
                        <label form="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="d-flex">
                        <div class="form-group col-sm-6">
                            <label form="entrada">Hora y fecha de entrada</label>
                            <input type="datetime-local" class="form-control" name="entrada" required>
                        </div>&nbsp;
                        <div class="form-group col-sm-6">
                            <label form="salida">Hora y fecha de salida</label>
                            <input type="datetime-local" class="form-control" name="salida" required>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>