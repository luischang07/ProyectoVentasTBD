import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class menu extends JPanel {

    public menu() {
        init();
    }

    public void init() {
        // setSize(400, 500);

        setLayout(new BorderLayout());
        add(new JButton("Bienvenido"));

        setVisible(true);
    }

}
