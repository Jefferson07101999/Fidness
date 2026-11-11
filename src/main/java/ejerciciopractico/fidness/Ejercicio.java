
package ejerciciopractico.fidness;


public class Ejercicio {

    private int idEjercicio;
    private String nombre;
    private String categoria;
    private String descripcion;
    private String instrucciones;

    public Ejercicio(int idEjercicio, String nombre,
                     String categoria, String descripcion,
                     String instrucciones) {
        this.idEjercicio = idEjercicio;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.instrucciones = instrucciones;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public String mostrarDetalle() {
        return "Ejercicio: " + nombre
                + "\nCategoría: " + categoria
                + "\nDescripción: " + descripcion
                + "\nInstrucciones: " + instrucciones;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
