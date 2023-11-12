
import java.sql.*;

public class ConexionDB {

    private String servidor;
    private String basededatos;
    private String usuario;
    private String password;

    public ConexionDB(String servidor, String basededatos, String usuario, String password) {
        this.servidor = servidor;
        this.basededatos = basededatos;
        this.usuario = usuario;
        this.password = password;
    }

    public Connection getConexion() {

        // String conexionUrl = "jdbc:sqlserver://" + servidor + ";"
        // + "database=" + basededatos + ";"
        // + "user=" + usuario + ";"
        // + "password=" + password + ";"
        // + "trustServerCertificate=true;";
        String conexionUrl = "jdbc:sqlserver://" + "Once" + ";"
                + "database=" + "ventas" + ";"
                + "user=" + "Twice" + ";"
                + "password=" + "Once151103" + ";"
                + "trustServerCertificate=true;";
        try {
            Connection conexion = DriverManager.getConnection(conexionUrl);
            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                return conexion;
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
        return null;

    }

}
