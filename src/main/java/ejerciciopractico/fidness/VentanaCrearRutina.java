
package ejerciciopractico.fidness;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaCrearRutina extends JFrame {

    private Usuario usuario;
    private CatalogoEjercicios catalogo;
    private ArrayList<Rutina> rutinas;
    private JTextField txtNombre;
    private JComboBox<Ejercicio> cmbEjercicios;
    private DefaultListModel<Ejercicio> modelo;
    private JList<Ejercicio> lista;

    public VentanaCrearRutina(Usuario usuario,
                             CatalogoEjercicios catalogo,
                             ArrayList<Rutina> rutinas) {

        this.usuario = usuario;
        this.catalogo = catalogo;
        this.rutinas = rutinas;

        setTitle("Fidness - Crear rutina");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(
                20, 20, 20, 20
        ));

        JPanel superior = new JPanel(new GridLayout(3, 1, 5, 5));

        txtNombre = new JTextField();
        cmbEjercicios = new JComboBox<>();

        for (Ejercicio ejercicio : catalogo.listarEjercicios()) {
            cmbEjercicios.addItem(ejercicio);
        }

        superior.add(new JLabel("Nombre de la rutina:"));
        superior.add(txtNombre);
        superior.add(cmbEjercicios);

        modelo = new DefaultListModel<>();
        lista = new JList<>(modelo);

        JButton btnAgregar = new JButton("Agregar ejercicio");
        JButton btnQuitar = new JButton("Quitar ejercicio");
        JButton btnGuardar = new JButton("Guardar rutina");
        JButton btnVolver = new JButton("Volver");

        JPanel inferior = new JPanel(new GridLayout(2, 2, 10, 10));
        inferior.add(btnAgregar);
        inferior.add(btnQuitar);
        inferior.add(btnGuardar);
        inferior.add(btnVolver);

        panel.add(superior, BorderLayout.NORTH);
        panel.add(new JScrollPane(lista), BorderLayout.CENTER);
        panel.add(inferior, BorderLayout.SOUTH);

        add(panel);

        btnAgregar.addActionListener(e -> {

            Ejercicio ejercicio =
                    (Ejercicio) cmbEjercicios.getSelectedItem();

            if (ejercicio != null) {
                modelo.addElement(ejercicio);
            }
        });

        btnQuitar.addActionListener(e -> {

            int indice = lista.getSelectedIndex();

            if (indice >= 0) {
                modelo.remove(indice);
            } else {
                JOptionPane.showMessageDialog(
                        this, "Seleccione un ejercicio para quitar."
                );
            }
        });

        btnGuardar.addActionListener(e -> guardarRutina());

        btnVolver.addActionListener(e -> dispose());
    }

    private void guardarRutina() {

        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty() || modelo.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese un nombre y agregue ejercicios."
            );
            return;
        }

        Rutina rutina = new Rutina(
                rutinas.size() + 1, nombre, usuario
        );

        for (int i = 0; i < modelo.size(); i++) {
            rutina.agregarEjercicio(modelo.getElementAt(i));
        }

        rutinas.add(rutina);

        JOptionPane.showMessageDialog(
                this, "Rutina guardada correctamente."
        );

        dispose();
    }
}
