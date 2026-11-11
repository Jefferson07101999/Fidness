
package ejerciciopractico.fidness;


import java.util.ArrayList;

public class CatalogoEjercicios {

    private ArrayList<Ejercicio> ejercicios;

    public CatalogoEjercicios() {
        ejercicios = new ArrayList<>();
    }

    public void agregarEjercicio(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
    }

    public ArrayList<Ejercicio> buscarPorCategoria(String categoria) {

        ArrayList<Ejercicio> encontrados = new ArrayList<>();

        for (Ejercicio ejercicio : ejercicios) {
            if (ejercicio.getCategoria().equalsIgnoreCase(categoria)) {
                encontrados.add(ejercicio);
            }
        }

        return encontrados;
    }

    public ArrayList<Ejercicio> listarEjercicios() {
        return ejercicios;
    }
}
