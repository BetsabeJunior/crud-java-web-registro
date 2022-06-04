package conexionBD;

import entidad.Trabajador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author BetsabeJunior
 */
public class TrabajadorDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_trabajador, cedula, nombre, entrada, salida "
            + "  FROM trabajador ";

    private static final String SQL_SELECT_BY_ID = "SELECT id_trabajador, cedula, nombre, entrada, salida "
            + "  FROM trabajador WHERE  id_trabajador = ?";
    
        private static final String SQL_SELECT_BUSCAR = "SELECT id_trabajador, cedula, nombre, entrada, salida "
            + "  FROM trabajador WHERE cedula = ?";

    private static final String SQL_INSERT = "INSERT INTO trabajador (cedula, nombre, entrada, salida) "
            + "  VALUES (?,?,?,?) ";

    private static final String SQL_UPDATE = "UPDATE trabajador  "
            + "  SET cedula=?, nombre=? WHERE  id_trabajador = ?";

    private static final String SQL_DELETE = "DELETE FROM trabajador WHERE  id_trabajador = ?";

    public List<Trabajador> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Trabajador trabajador = null;
        List<Trabajador> trabajadores = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idTrabajador = rs.getInt("id_trabajador");
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String entrada = rs.getString("entrada");
                String salida = rs.getString("salida");

                trabajador = new Trabajador(idTrabajador, cedula, nombre, entrada, salida);
                trabajadores.add(trabajador);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return trabajadores;
    }

    public Trabajador encontrarTrabajadorById(Trabajador trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, trabajador.getIdTrabajador());
            rs = stmt.executeQuery();
            boolean valid = rs.next();
            if (valid) {
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String entrada = rs.getString("entrada");
                String salida = rs.getString("salida");

                trabajador.setCedula(cedula);
                trabajador.setNombre(nombre);
                trabajador.setEntrada(entrada);
                trabajador.setSalida(salida);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return trabajador;
    }

    public int actualizarTrabajador(Trabajador trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, trabajador.getCedula());
            stmt.setString(2, trabajador.getNombre());
            stmt.setInt(3, trabajador.getIdTrabajador());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }

    public int insertarTrabajador(Trabajador trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, trabajador.getCedula());
            stmt.setString(2, trabajador.getNombre());
            stmt.setString(3, trabajador.getEntrada());
            stmt.setString(4, trabajador.getSalida());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }

    public int eliminarTrabajador(Trabajador trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, trabajador.getIdTrabajador());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }

        public Trabajador consultarTrabajador(Trabajador trabajador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BUSCAR);
            stmt.setString(1, trabajador.getCedula());
            rs = stmt.executeQuery();
            boolean valid = rs.next();
            if (valid) {
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String entrada = rs.getString("entrada");
                String salida = rs.getString("salida");

                trabajador.setCedula(cedula);
                trabajador.setNombre(nombre);
                trabajador.setEntrada(entrada);
                trabajador.setSalida(salida);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return trabajador;
    }
}
