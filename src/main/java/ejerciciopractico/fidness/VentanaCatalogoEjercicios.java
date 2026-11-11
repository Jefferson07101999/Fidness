
package ejerciciopractico.fidness;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaCatalogoEjercicios extends JFrame {

    private CatalogoEjercicios catalogo;
    private JComboBox<String> cmbCategoria;
    private DefaultListModel<Ejercicio> modelo;
    private JList<Ejercicio> lista;

    public VentanaCatalogoEjercicios() {

        catalogo = new CatalogoEjercicios();

        
        catalogo.agregarEjercicio(new EjercicioFuerza(
                1, "Sentadillas", "Pierna",
                "Fortalece las piernas",
                "Flexionar las rodillas manteniendo la espalda recta.",
                4, 12
        ));


        catalogo.agregarEjercicio(new Ejercicio(
                2, "Prensa de pierna", "Pierna",
                "Ejercicio para trabajar los músculos de las piernas",
                "Empujar la plataforma con los pies de forma controlada."
        ));

        catalogo.agregarEjercicio(new Ejercicio(
                3, "Remo", "Espalda",
                "Ejercicio para fortalecer la espalda",
                "Llevar el peso hacia el torso manteniendo la espalda recta."
        ));

        catalogo.agregarEjercicio(new Ejercicio(
                4, "Curl de bíceps", "Brazo",
                "Ejercicio para fortalecer los bíceps",
                "Flexionar los codos levantando las pesas sin balancear el cuerpo."
        ));

        setTitle("Fidness - Catálogo de ejercicios");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(
                20, 20, 20, 20
        ));

        cmbCategoria = new JComboBox<>(
                new String[]{"Todos", "Pierna", "Espalda", "Brazo"}
        );

        modelo = new DefaultListModel<>();
        lista = new JList<>(modelo);

        JButton btnDetalle = new JButton("Ver detalle");
        JButton btnVolver = new JButton("Volver");

        JPanel superior = new JPanel(new BorderLayout());
        superior.add(new JLabel("Categoría:"), BorderLayout.WEST);
        superior.add(cmbCategoria, BorderLayout.CENTER);

        JPanel inferior = new JPanel(new GridLayout(1, 2, 10, 10));
        inferior.add(btnDetalle);
        inferior.add(btnVolver);

        panel.add(superior, BorderLayout.NORTH);
        panel.add(new JScrollPane(lista), BorderLayout.CENTER);
        panel.add(inferior, BorderLayout.SOUTH);

        add(panel);

        cmbCategoria.addActionListener(e -> cargarEjercicios());

        btnDetalle.addActionListener(e -> {

            Ejercicio seleccionado = lista.getSelectedValue();

            if (seleccionado == null) {
                JOptionPane.showMessageDialog(
                        this, "Seleccione un ejercicio."
                );
                return;
            }

            JOptionPane.showMessageDialog(
                    this,
                    seleccionado.mostrarDetalle(),
                    "Detalle del ejercicio",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        btnVolver.addActionListener(e -> dispose());

        cargarEjercicios();
    }

    private void cargarEjercicios() {

        modelo.clear();

        String categoria = cmbCategoria.getSelectedItem().toString();

        ArrayList<Ejercicio> ejercicios;

        if (categoria.equals("Todos")) {
            ejercicios = catalogo.listarEjercicios();
        } else {
            ejercicios = catalogo.buscarPorCategoria(categoria);
        }

        for (Ejercicio ejercicio : ejercicios) {
            modelo.addElement(ejercicio);
        }
    }
}
