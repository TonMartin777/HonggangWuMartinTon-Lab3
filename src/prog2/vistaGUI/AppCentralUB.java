package prog2.vistaGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppCentralUB extends JFrame {
    private JButton btnGestioComponentsCentral;
    private JPanel panel1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppCentralUB appCentralUB = new AppCentralUB();
            appCentralUB.setVisible(true);
        });
    }

    public AppCentralUB() {
        setTitle("Central UB");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        setSize(500,400);
        setLocationRelativeTo(null);
        btnGestioComponentsCentral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioComponentsCentral frmGestioComponentsCentral = new FrmGestioComponentsCentral();
                frmGestioComponentsCentral.setVisible(true);
            }
        });
    }


}
