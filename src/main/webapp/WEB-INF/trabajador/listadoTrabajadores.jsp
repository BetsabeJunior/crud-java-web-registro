<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section id="Trabajadores" >
    <div class="container py-4" >
        <div class="row" >
            <div class="col-md-8" >
                <div class="card"  >
                    <div class="card-header"  >
                        <h4 class="text-center">Listado De Trabajadores</h4>
                    </div>
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
                            <c:forEach var="empleado" items="${trabajadores}" varStatus="status">
                                <tr class="table table-striped">
                                    <td>${empleado.cedula}</td>
                                    <td>${empleado.nombre} </td>
                                    <td> ${empleado.entrada}</td>
                                    <td>${empleado.salida} </td>
                                    <td>
                                        <a href="ServletControlador?accion=editar&idTrabajador=${empleado.idTrabajador}"
                                           class="btn  text-white" style="background:  #FF5AB0;" >
                                            <i class="fas fa-pen-alt"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card"> 
                    <div class="card-body text-center  text-black mb-3" style="background:  #4DF4FF;">
                        <h3>Total Trabajadores Registrados</h3>
                        <h3 class="display-6">
                            <i class="fa-solid fa-users" ></i>  <fmt:formatNumber value="${totalTrabajador}" />
                        </h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>