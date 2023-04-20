package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;


public class ClienteDaoJDBC {

    //SELECCIONAR EN BASE DE DATOS POR BASE = CONTROL_CLIENTE.cliente
    private static final String SQL_SELECT = "SELECT idcliente, nombre, apellido,"
            + " email,telefono,saldo FROM control_clientes.cliente";

    private static final String SQL_SELECT_BY_ID = "SELECT idcliente, nombre, apellido, email, telefono, saldo "
            + "FROM control_clientes.cliente WHERE idcliente = ?";

    //ISNERTAR EN BASE DE DATOS POR BASE = CONTROL_CLIENTE.cliente
    private static final String SQL_INSERT = "INSERT INTO control_clientes.cliente"
            + "(nombre, apellido, telefono, email, saldo) VALUES (?, ?, ?, ?, ?)";

    //MODIFICAR EN BASE DE DATOS POR BASE = CONTROL_CLIENTE.cliente
    private static final String SQL_UPDATE = "UPDATE control_clientes.cliente "
            + " SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE idcliente=?";

    //ELIMINAR EN BASE DE DATOS POR BASE = CONTROL_CLIENTE.cliente
    private static final String SQL_DELETE = "DELETE FROM control_clientes.cliente WHERE idcliente=?";

    // LISTAR TODO LOS CLIENTES DE LA BASE DE DATOS 
    public List<Cliente> Selecionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int idCliente = rs.getInt("idcliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo");

                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            Conexion.clos(rs);
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return clientes;
    }
// INSERTAR UN NUEVO CLIENTE A LA BASE DE DATOS

    public int insertar(Cliente cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            registro = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registro;
    }
// ENCONTRAR POR ID EN LA BASE DE DATOS

    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdcliente());
            rs = stmt.executeQuery();
            rs.next(); //nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.clos(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return cliente;
    }

    // MODIFICAR HACIA LA BASE DE DATOS 
    public int modificar(Cliente cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdcliente());
            registro = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registro;
    }

    // ELIMINAR DE LA BASE DE DATOS  
    
    public int Delete(Cliente cliente){
      
            Connection conn = null;
            PreparedStatement stmt = null;
            int registro = 0;
            
              try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdcliente());
             registro = stmt.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
            finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
                return registro;
    }
}
