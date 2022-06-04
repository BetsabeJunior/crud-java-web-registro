package entidad;

/**
 * @author BetsabeJunior
 */
public class Trabajador {

    private int idTrabajador;
    private String cedula;
    private String nombre;
    private String entrada;
    private String salida;

    public Trabajador(int idTrabajador, String cedula, String nombre) {
        this.idTrabajador = idTrabajador;
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public Trabajador(String cedula) {
        this.cedula = cedula;
    }

    public Trabajador() {
    }

    public Trabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Trabajador(String cedula, String nombre, String entrada, String salida) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.entrada = entrada;
        this.salida = salida;
    }

    public Trabajador(int idTrabajador, String cedula, String nombre, String entrada, String salida) {
        this.idTrabajador = idTrabajador;
        this.cedula = cedula;
        this.nombre = nombre;
        this.entrada = entrada;
        this.salida = salida;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "idTrabajador=" + idTrabajador + ", cedula=" + cedula + ", nombre=" + nombre + ", entrada=" + entrada + ", salida=" + salida + '}';
    }

}
