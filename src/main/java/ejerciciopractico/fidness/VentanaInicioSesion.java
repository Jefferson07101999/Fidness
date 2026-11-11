
package ejerciciopractico.fidness;


import javax.swing.*;
import java.awt.*;

public class VentanaInicioSesion extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;

    private Usuario usuarioRegistrado;

    public VentanaInicioSesion() {

        usuarioRegistrado = new Usuario(
                1,
                "Jefferson",
                "jefferson@gmail.com",
                "jefferson",
                "1234"
        );

        setTitle("Fidness - Inicio de sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(
                30, 30, 30, 30
        ));

        JLabel lblTitulo = new JLabel("Bienvenido a Fidness");
        JLabel lblUsuario = new JLabel("Usuario:");
        JLabel lblContrasena = new JLabel("Contraseña:");

        txtUsuario = new JTextField();
        txtContrasena = new JPasswordField();

        btnIngresar = new JButton("Iniciar sesión");

        panel.add(lblTitulo);
        panel.add(new JLabel(""));

        panel.add(lblUsuario);
        panel.add(txtUsuario);

        panel.add(lblContrasena);
        panel.add(txtContrasena);

        panel.add(new JLabel(""));
        panel.add(btnIngresar);

        add(panel);

        btnIngresar.addActionListener(e -> iniciarSesion());
    }

    
private void iniciarSesion() {

    String usuario = txtUsuario.getText();
    String contrasena = new String(txtContrasena.getPassword());

    if (usuarioRegistrado.iniciarSesion(usuario, contrasena)) {

        new VentanaMenuPrincipal(usuarioRegistrado).setVisible(true);
        dispose();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Usuario o contraseña incorrectos."
        );
    }
}
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new VentanaInicioSesion().setVisible(true);
        });
    }
}
