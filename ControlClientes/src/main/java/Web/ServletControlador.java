package Web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(req, resp);
                    break;
                                        
                case "eliminar":
                    this.eliminar(req, resp);
                       break;
                default:
                    this.acciondefault(req, resp);

            }

        } else {
            this.acciondefault(req, resp);
        }
    }

    //EDITAR CLIENTE accion="editar"
    public void editarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idcliente = Integer.parseInt(req.getParameter("idCliente"));
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idcliente));
        req.setAttribute("cliente", cliente);
        String jspeditar = "/Comunes/editarClientes.jsp";
        req.getRequestDispatcher(jspeditar).forward(req, resp);

    }

    public void acciondefault(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Cliente> clientes = new ClienteDaoJDBC().Selecionar();
        System.out.println("clientes = " + clientes);
        //alcance de sesion
        HttpSession sesion = req.getSession();

        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalclientes", clientes.size());
        sesion.setAttribute("totalsueldo", this.totalsueldo(clientes));
        //req.getRequestDispatcher("Clientes.jsp").forward(req, resp);
        resp.sendRedirect("Clientes.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarcliente(req, resp);
                    break;

                case "editar":
                    this.editar(req, resp);
                    break;

                default:
                    this.acciondefault(req, resp);

            }

        } else {
            this.acciondefault(req, resp);
        }

    }

    // METODO TOTAL SUELDO
    public double totalsueldo(List<Cliente> clientes) {

        double sueldo_total = 0;
        for (Cliente cliente : clientes) {
            sueldo_total += cliente.getSaldo();

        }
        return sueldo_total;
    }

    // ELIMINAR CLIENTE accion="eliminar"
    
    public void eliminar(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        
         int idcliente = Integer.parseInt(req.getParameter("idCliente"));
         Cliente cliente = new Cliente(idcliente);
             int registro = new ClienteDaoJDBC().Delete(cliente);
            System.out.println("registros modificados = " + registro);
            this.acciondefault(req, resp);
        
        
    }
    
    
    
    // INSERTAR CLIENTE accion="insertar" 
    public void insertarcliente(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // recuperamos los valores del formulario
        String nombre = req.getParameter("name");
        String apellido = req.getParameter("firts_name");
        String email = req.getParameter("Email");
        String tel = req.getParameter("tel");

        double saldo = 0;
        String sueldo_string = req.getParameter("salario");
        if (sueldo_string != null && !"".equals(sueldo_string)) {
            saldo = Double.parseDouble(sueldo_string);
        }
        Cliente cliente = new Cliente(nombre, apellido, email, tel, saldo);

        try {
            int registro = new ClienteDaoJDBC().insertar(cliente);
            System.out.println("registros modificados = " + registro);
            this.acciondefault(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    //MODIFICAR CLIENTE accion="editar"
    public void editar(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


          // Obtenemos los valores del formulario
        int idcliente = Integer.parseInt(req.getParameter("idCliente"));
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String tel = req.getParameter("telefono");
        double saldo = 0;
        String sueldo_string = req.getParameter("salario");
        if (sueldo_string != null && !"".equals(sueldo_string)) {
            saldo = Double.parseDouble(sueldo_string);
        }

        Cliente cliente = new Cliente(idcliente, nombre, apellido, email, tel, saldo);

        try {
            int registro = new ClienteDaoJDBC().modificar(cliente);
            System.out.println("registros modificados = " + registro);
            this.acciondefault(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        
        
    }
}
