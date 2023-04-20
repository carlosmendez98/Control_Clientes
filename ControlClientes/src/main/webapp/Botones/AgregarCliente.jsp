

<button type="button" class="btn btn-primary m-1 px-5 " data-toggle="modal" data-target="#agregarClienteModal">
    <i class="bi bi-person-plus-fill m-0 py-0 " style="font-size: 30px" ></i> Agregar Cliente 
</button>
<div class="modal" id="agregarClienteModal">
    <div class="modal-dialog">
        <div class="modal-content  ">
            <div class="modal-header ">
                <h5 class="modal-title">Agregar Cliente </h5>
                <button style="padding: 10px; margin: -16px; border-radius: 2px" onclick="" class="btn btn-close bg-danger " data-dismiss="modal" id="botonx" >&times;</button>
            </div>

            <div class="modal-body ">
                <form method="post" class="was-validated" action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"  >
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="name">Nombre</label>
                        <input name="name" type="text" class="form-control" placeholder="Digite Nombre" aria-label="" aria-describedby="basic-addon1" required="true">

                    </div>

                    <div class="input-group mb-3">
                        <label class="input-group-text" for="firts_name">Apellido</label>
                        <input name="firts_name" type="text" class="form-control" placeholder="Digite Apellido" required="">

                    </div>

                    <div class="input-group mb-3">
                        <label class="input-group-text" for="tel">Telefono</label>
                        <input name="tel" type="text" class="form-control" placeholder="Digite el Telefono" required>

                    </div>


                    <div class="input-group mb-3">
                        <label class="input-group-text" >Email</label>
                        <input name="Email" type="text" class="form-control" placeholder="Digite Email" required>
                
                    </div>

                    <div class="input-group mb-3">
                        <label class="input-group-text" for="salario">Salario</label>
                        <input name="salario" type="text" class="form-control" placeholder="Digite el Salario" required>

                    </div>

                    <div class="modal-group">
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Guardar</button>

                        </div>
                    </div>
               </form>
                    </div>
               


            </div>

        </div>

    </div>


