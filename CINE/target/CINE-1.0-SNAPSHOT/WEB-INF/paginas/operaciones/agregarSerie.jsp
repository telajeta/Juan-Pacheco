<div class="modal fade" id="agregarSerieModal" tabinex="-1" aria-labelledby="agregarSerieModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Serie</h5>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required="">
                    </div>
                    <div class="form-group">
                        <label for="director">Director</label>
                        <input type="text" class="form-control" name="director" required="">
                    </div>
                    <div class="form-group">
                        <label for="cantMinutos">Minutos en promedio</label>
                        <input type="number" class="form-control" name="cantMinutos" required="">
                    </div>
                    <div class="form-group">
                        <label for="precio">Presupuesto</label>
                        <input type="currency" class="form-control" name="precio" required="">
                    </div>
                    <div class="form-group">
                        <label for="capitulos">Cantidad de Capitulos</label>
                        <input type="number" class="form-control" name="capitulos" required="">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        GUARDAR
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>