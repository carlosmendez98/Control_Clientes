
<!DOCTYPE html>
<html>
    


    
    <head>
            <!-- REPOSITORIO DE JSTL, BOOSTRAP Y GOOGLE FONTS !-->
    <jsp:include page="../Repositorio/FormatoYJstl.jsp"></jsp:include>
    <jsp:include page="../Repositorio/Boostrap.jsp"></jsp:include>
        
        <title>Modificar Cliente</title>
    </head>
  
    <body>
  <%@include file="/Comunes/cabecero.jsp" %>
        <form  action="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idcliente}" method="POST" >
          
            <jsp:include page="../Botones/botonesedicion.jsp" />
                
       
            <section id="details" >
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4> Editar Cliente</h4>
                                </div>
                                <div class="card-body ">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" requiered="true" value="${cliente.nombre}">
                                    </div>


                                    <div class="form-group">
                                        <label for="apellido">Apellido</label>
                                        <input type="text" class="form-control" id="apellido" name="apellido" requiered="true" value="${cliente.apellido}" >
                                    </div>

                                    <div class="form-group">
                                        <label for="email">email</label>
                                        <input type="email" class="form-control" id="email" name="email" value="${cliente.email}" requiered="true">
                                    </div>

                                    <div class="form-group">
                                        <label for="telefono">Telefono</label>
                                        <input type="text" class="form-control" id="telefono" name="telefono" value="${cliente.telefono}" requiered="true">
                                    </div>
                                    <!-- FALTA EL FORMAT PARA QUE QUEDE UN FORMATO MONEDA !-->
                                     <div class="form-group">
                                        <label for="salario">Salario</label>
                                    
                                        <input type="number" class="form-control" id="salario" name="salario" requiered="true" value="${cliente.saldo}" step="any">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/ crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>



    </body>

</html>
