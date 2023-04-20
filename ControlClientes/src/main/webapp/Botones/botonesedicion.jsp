 
<div class="row">
    <div class="col-s-2 m-3">
        <a href="index.jsp" class="btn btn-secondary " >
            <i class="bi bi-arrow-90deg-left" style="font-size: 50px"></i>
            Regresar al inicio</a>

        <button type="submit"  class="btn btn-success mx-2" >
            <i class="bi bi-folder-check" style="font-size: 50px"></i> Guardar
        </button>


        <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idcliente}" 
           class="btn btn-danger mx-2" >
            <i class="bi bi-trash3-fill" style="font-size: 50px"></i>Eliminar
        </a>
    </div> 

</div>


