
package ejerciciopractico.fidness;

import java.util.ArrayList;
import java.time.LocalDate;

public class Rutina {

    private int idRutina;
    private String nombre;
    private LocalDate fechaCreacion;
    private Usuario usuario;
    private ArrayList<Ejercicio> ejercicios;

    public Rutina(int idRutina, String nombre, Usuario usuario) {
        this.idRutina = idRutina;
        this.nombre = nombre;
        this.usuario = usuario;
        this.fechaCreacion = LocalDate.now();
        this.ejercicios = new ArrayList<>();
    }

    public int getIdRutina() {
        return idRutina;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void agregarEjercicio(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
    }

    public boolean quitarEjercicio(Ejercicio ejercicio) {
        return ejercicios.remove(ejercicio);
    }

    public String mostrarRutina() {

        String resultado = "Rutina: " + nombre
                + "\nFecha: " + fechaCreacion
                + "\nUsuario: " + usuario.getNombre()
                + "\n\nEjercicios:\n";

        if (ejercicios.isEmpty()) {
            return resultado + "No hay ejercicios agregados.";
        }

        for (Ejercicio ejercicio : ejercicios) {
            resultado += "- " + ejercicio.getNombre() + "\n";
        }

        return resultado;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
