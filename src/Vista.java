import javax.swing.*;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;

import java.awt.event.*;
import java.awt.*;
import mode.LightDarkMode;

public class Vista extends JFrame implements ActionListener, ComponentListener {

    static Vista app;
    private final menu menu;

    private JPanel panel;

    private JButton btnConectar;

    private JLabel lblServidor;
    private JLabel lblBasedeDatos;
    private JLabel lblUsuario;
    private JLabel lblContraseña;

    private JTextField txtServidor;
    private JTextField txtBasedeDatos;
    private JTextField txtUsuario;
    private JTextField txtContraseña;
    private LightDarkMode lightDarkMode;

    public Vista() {
        super("Vista");
        menu = new menu();
        HazInterfaz();
        setMinimumSize(new Dimension(350, 350));
        HazEscuchas();
    }

    private void HazEscuchas() {
        addComponentListener(this);
        btnConectar.addActionListener(this);
    }

    private void HazInterfaz() {
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        lightDarkMode = new LightDarkMode();
        add(lightDarkMode);

        Font robotoFont = new Font("Roboto", Font.PLAIN, 14);

        panel = new JPanel();
        // panel.setBounds((int) (this.getWidth() * .08), (int) (this.getWidth() * .05),
        // (int) (this.getWidth() * .80),
        // (int) (this.getHeight() * .50));

        panel.setLayout(new Contenedorlbl_txt());
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:20,2,2,2;"
                + "background:$Menu.background;"
                + "arc:10");

        lblServidor = new JLabel("Servidor");
        lblServidor.setFont(robotoFont);
        panel.add(lblServidor);

        txtServidor = new JTextField();
        panel.add(txtServidor);

        lblBasedeDatos = new JLabel("Base de Datos");
        lblBasedeDatos.setFont(robotoFont);
        panel.add(lblBasedeDatos);

        txtBasedeDatos = new JTextField();
        panel.add(txtBasedeDatos);

        lblUsuario = new JLabel("Usuario");
        lblUsuario.setFont(robotoFont);
        panel.add(lblUsuario);

        txtUsuario = new JTextField();
        panel.add(txtUsuario);

        lblContraseña = new JLabel("Contraseña");
        lblContraseña.setFont(robotoFont);
        panel.add(lblContraseña);

        txtContraseña = new JTextField();
        panel.add(txtContraseña);

        Font robotoFont2 = new Font("Roboto", Font.BOLD, 14);
        btnConectar = new JButton("Conectar");
        btnConectar.setFont(robotoFont2);
        panel.add(btnConectar);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Conectando...");
        String servidor = txtServidor.getText();
        String basededatos = txtBasedeDatos.getText();
        String usuario = txtUsuario.getText();
        String contraseña = txtContraseña.getText();

        ConexionDB conexion = new ConexionDB(servidor, basededatos, usuario, contraseña);
        // Connection con = conexion.getConexion();
        // try {
        // Statement stmt = con.createStatement();
        // stmt.executeQuery("SELECT * FROM articulos");
        // ResultSet rs = stmt.getResultSet();

        // } catch (Exception e) {
        // System.out.println(e);
        // }
        login();

    }

    public static void login() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.menu);
        app.menu.applyComponentOrientation(app.getComponentOrientation());
        // setSelectedMenu(0, 0);

        SwingUtilities.updateComponentTreeUI(app.menu);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        int w = this.getWidth();
        int h = this.getHeight();

        panel.setBounds((int) (w * .08), (int) (w * .05), (int) (w * .80), (int) (h * .50));

        Font robotoFont = getRobotoFont("Roboto", 14, w, h);
        lblServidor.setFont(robotoFont);
        lblBasedeDatos.setFont(robotoFont);
        lblUsuario.setFont(robotoFont);
        lblContraseña.setFont(robotoFont);

        Font robotoFont2 = getRobotoFont("SegoeUI", 10, w, h);
        txtServidor.setFont(robotoFont2);
        txtBasedeDatos.setFont(robotoFont2);
        txtUsuario.setFont(robotoFont2);
        txtContraseña.setFont(robotoFont2);

        Font robotoFont3 = getRobotoFont("Roboto", 12, w, h);
        btnConectar.setFont(robotoFont3);

        panel.setLayout(new Contenedorlbl_txt());

        lightDarkMode.setBounds((int) (w * .4), (int) (h * .70), (int) (w * .50), (int) (h * .10));

        revalidate();
    }

    private Font getRobotoFont(String letra, int baseSize, int width, int height) {
        int scaledSize = (int) (baseSize * (Math.min(width, height) / 350.0));
        return new Font(letra, Font.BOLD, scaledSize);
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {
        System.out.println("Shown");
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        System.out.println("Hidden");
    }
}