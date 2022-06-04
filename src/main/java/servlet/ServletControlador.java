package servlet;

import conexionBD.TrabajadorDaoJDBC;
import entidad.Trabajador;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author BetsabeJunior
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarTrabajador(req, resp);
                    break;
                case "eliminar":
                    this.eliminarTrabajador(req, resp);
                    break;
                case "consultar":
                    this.consultarTrabajador(req, resp);
                    break;
            }
        } else {
            this.accionDefault(req, resp);
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarTrabajador(req, resp);
                    break;
                case "modificar":
                    this.modificarTrabajador(req, resp);
                    break;
                default:
                    this.accionDefault(req, resp);
            }
        }
    }

    private void consultarTrabajador(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cedula = req.getParameter("cedula");
        Trabajador trabajador = new TrabajadorDaoJDBC().consultarTrabajador(new Trabajador(cedula));
        req.setAttribute("trabajador", trabajador);
        String jspEditar = "/WEB-INF/trabajador/consultarTrabajador.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, resp);

    }

    private void eliminarTrabajador(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTrabajador = Integer.parseInt(req.getParameter("idTrabajador"));
        Trabajador trabajador = new Trabajador(idTrabajador);
        int registroMod = new TrabajadorDaoJDBC().eliminarTrabajador(trabajador);
        System.out.println("registroMod");

        this.accionDefault(req, resp);

    }

    private void editarTrabajador(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTrabajador = Integer.parseInt(req.getParameter("idTrabajador"));
        Trabajador trabajador = new TrabajadorDaoJDBC().encontrarTrabajadorById(new Trabajador(idTrabajador));
        req.setAttribute("trabajador", trabajador);
        String jspEditar = "/WEB-INF/trabajador/editarTrabajador.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, resp);
    }

    protected void insertarTrabajador(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cedula = req.getParameter("cedula");
        String nombre = req.getParameter("nombre");
        String entrada = req.getParameter("entrada");
        String salida = req.getParameter("salida");

        Trabajador trabajador = new Trabajador(cedula, nombre, entrada, salida);
        int registroMod = new TrabajadorDaoJDBC().insertarTrabajador(trabajador);
        System.out.println(registroMod);
        this.accionDefault(req, resp);

    }

    private void modificarTrabajador(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTrabajador = Integer.parseInt(req.getParameter("idTrabajador"));
        String cedula = req.getParameter("cedula");
        String nombre = req.getParameter("nombre");
        Trabajador trabajador = new Trabajador(idTrabajador, cedula, nombre);
        int registroMod = new TrabajadorDaoJDBC().actualizarTrabajador(trabajador);
        System.out.println(registroMod);
        this.accionDefault(req, resp);
    }

    protected void accionDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Trabajador> trabajadores = new TrabajadorDaoJDBC().listar();

        HttpSession session = req.getSession();
        session.setAttribute("trabajadores", trabajadores);
        session.setAttribute("totalTrabajador", trabajadores.size());
        resp.sendRedirect("trabajadores.jsp");
    }
}
