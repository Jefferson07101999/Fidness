
package ejerciciopractico.fidness;


public class EjercicioFuerza extends Ejercicio {

    private int series;
    private int repeticiones;

    public EjercicioFuerza(int idEjercicio, String nombre,
            String categoria, String descripcion,
            String instrucciones, int series, int repeticiones) {

        super(idEjercicio, nombre, categoria,
                descripcion, instrucciones);

        this.series = series;
        this.repeticiones = repeticiones;
    }

    @Override
    public String mostrarDetalle() {

        return super.mostrarDetalle()
                + "\nSeries: " + series
                + "\nRepeticiones: " + repeticiones;
    }
}
