<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es-AR"/>
<section id="series">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Series y Peliculas</h4>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Director</th>
                                <th>Minutos(prom)</th>
                                <th>Presupuesto</th>
                                <th>Capitulos</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="Serie" items="${Series}" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${Serie.nombre}</td>
                                <td>${Serie.director}</td>
                                <td>${Serie.cantMinutos}</td>
                                <td><fmt:formatNumber value="${Serie.precio}" type="currency"/></td>
                                <td>${Serie.capitulos}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}servletControlador?accion=editar&idcines=${Serie.idcines}" class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"></i>
                                        Editar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Total de Capitulos</h3>
                        <h4 class="display-6">${cantidadCapitulos}</h4>
                    </div>
                </div>
                    
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Presupuesto Total</h3>
                        <h4 class="display-6"><fmt:formatNumber value="${precioTotal}" type="currency"/></h4>
                    </div>    
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarSerie.jsp"/>          