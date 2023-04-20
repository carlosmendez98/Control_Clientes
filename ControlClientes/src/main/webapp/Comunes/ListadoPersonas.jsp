
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_cop"/>

<!--   Pagina modal JSP BotonAgregarCliente -->
<%@include file="/Botones/AgregarCliente.jsp" %>
<html>
    <body>
        <section id="clientes">  
            <div class="row">
                <div class="col-md-8">

                    <div class="bg-dark text-white p-1 " style="border-spacing: 50px">

                        <div class="container " style="text-align: center">
                            <h4  style="display: "> Listado personas</h4>
                        </div>
                    </div>
                    <table class="table table-dark table-striped">
                        <thead>

                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Salario</th>
                                <th>accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>   
                                    <td>${cliente.idcliente} 
                                    <td>${cliente.nombre}</td>
                                    <td>${cliente.apellido}</td>
                                    <td> <fmt:formatNumber type="number" value="${cliente.saldo}"/></td>
                                    <td>
                                       <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idcliente}" 
                                           class="btn btn-secondary">
                                           
                                            <i class="bi bi-person-fill-gear" style="font-size: 20px"></i> Editar
                                        </a>
                                    </td> 
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>                  
                <div class="col-md-3 ">
                    <div class="card text-center mb-2 ">
                        <div class="card body bg-success">
                            <h3>Total Sueldo</h3>
                            <h4 class="display-4">
                                <span class="bi bi-cash-coin" ></span> <fmt:formatNumber type="number"  value="${totalsueldo}"></fmt:formatNumber> </h4>
                            </div>
                        </div>  


                        <div class="card text-center mb-1">
                            <div class="card body bg-primary">
                                <h3>Total Personas</h3>
                                <h4 class="display-3">
                                    <i class="bi bi-people-fill"></i> ${totalclientes}</h4>
                        </div>
                    </div>  
                </div>
            </div>
        </section> 
    </body>
</html>