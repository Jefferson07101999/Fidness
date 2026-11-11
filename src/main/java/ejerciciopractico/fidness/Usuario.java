
package ejerciciopractico.fidness;


public class Usuario {

    private int idUsuario;
    private String nombre;
    private String correo;
    private String usuario;
    private String contrasena;

    public Usuario(int idUsuario, String nombre, String correo,
                   String usuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        return this.usuario.equals(usuario)
                && this.contrasena.equals(contrasena);
    }

    public void cerrarSesion() {
        System.out.println("Sesión cerrada.");
    }
}
