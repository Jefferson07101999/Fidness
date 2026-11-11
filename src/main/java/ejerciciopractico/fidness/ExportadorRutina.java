
package ejerciciopractico.fidness;


import java.io.FileWriter;
import java.io.IOException;

public class ExportadorRutina {

    private String rutaArchivo;

    public ExportadorRutina(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void exportarTexto(Rutina rutina) throws IOException {

        try (FileWriter archivo = new FileWriter(rutaArchivo)) {
            archivo.write(rutina.mostrarRutina());
        }
    }
}
