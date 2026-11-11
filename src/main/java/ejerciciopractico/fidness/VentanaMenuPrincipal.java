
package ejerciciopractico.fidness;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaMenuPrincipal extends JFrame {

    private Usuario usuario;
    private CatalogoEjercicios catalogo;
    private ArrayList<Rutina> rutinas;

    public VentanaMenuPrincipal(Usuario usuario) {

        this.usuario = usuario;
        catalogo = new CatalogoEjercicios();
        rutinas = new ArrayList<>();

        
        catalogo.agregarEjercicio(new EjercicioFuerza(
                1, "Sentadillas", "Pierna",
                "Fortalece las piernas",
                "Flexionar las rodillas manteniendo la espalda recta.",
                4, 12
        ));


        catalogo.agregarEjercicio(new Ejercicio(
                2, "Prensa de pierna", "Pierna",
                "Trabaja los músculos de las piernas",
                "Empujar la plataforma de forma controlada."
        ));

        catalogo.agregarEjercicio(new Ejercicio(
                3, "Remo", "Espalda",
                "Fortalece la espalda",
                "Llevar el peso hacia el torso."
        ));

        catalogo.agregarEjercicio(new Ejercicio(
                4, "Curl de bíceps", "Brazo",
                "Fortalece los bíceps",
                "Levantar las pesas flexionando los codos."
        ));

        setTitle("Fidness - Menú principal");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(
                20, 30, 20, 30
        ));

        JLabel titulo = new JLabel(
                "Bienvenido, " + usuario.getNombre(),
                SwingConstants.CENTER
        );

        JButton btnEjercicios = new JButton("Consultar ejercicios");
        JButton btnRutinas = new JButton("Mis rutinas");
        JButton btnCrear = new JButton("Crear rutina");
        JButton btnSalir = new JButton("Cerrar sesión");

        panel.add(titulo);
        panel.add(btnEjercicios);
        panel.add(btnRutinas);
        panel.add(btnCrear);
        panel.add(btnSalir);

        add(panel);

        btnEjercicios.addActionListener(e -> {
            new VentanaCatalogoEjercicios().setVisible(true);
        });

        btnCrear.addActionListener(e -> {
            new VentanaCrearRutina(
                    usuario, catalogo, rutinas
            ).setVisible(true);
        });

        
btnRutinas.addActionListener(e -> {

    if (rutinas.isEmpty()) {
        JOptionPane.showMessageDialog(
                this, "Todavía no hay rutinas guardadas."
        );
        return;
    }

    Rutina seleccionada = (Rutina) JOptionPane.showInputDialog(
            this,
            "Seleccione una rutina:",
            "Mis rutinas",
            JOptionPane.QUESTION_MESSAGE,
            null,
            rutinas.toArray(),
            rutinas.get(0)
    );

    if (seleccionada == null) {
        return;
    }

    Object[] opciones = {"Exportar TXT", "Cerrar"};

    int respuesta = JOptionPane.showOptionDialog(
            this,
            new JScrollPane(new JTextArea(
                    seleccionada.mostrarRutina(), 12, 35
            )),
            "Detalle de la rutina",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opciones,
            opciones[0]
    );

    if (respuesta == 0) {

        JFileChooser selector = new JFileChooser();
        selector.setSelectedFile(
                new java.io.File("Rutina_Fidness.txt")
        );

        if (selector.showSaveDialog(this)
                == JFileChooser.APPROVE_OPTION) {

            String ruta = selector.getSelectedFile()
                    .getAbsolutePath();

            if (!ruta.toLowerCase().endsWith(".txt")) {
                ruta += ".txt";
            }

            try {
                ExportadorRutina exportador =
                        new ExportadorRutina(ruta);

                exportador.exportarTexto(seleccionada);

                JOptionPane.showMessageDialog(
                        this,
                        "Rutina exportada correctamente."
                );

            } catch (java.io.IOException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Error al exportar: " + ex.getMessage()
                );
            }
        }
    }
});

        btnSalir.addActionListener(e -> {
            usuario.cerrarSesion();
            dispose();
            new VentanaInicioSesion().setVisible(true);
        });
    }
}
