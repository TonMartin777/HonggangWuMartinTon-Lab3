package prog2.vistaGUI;
import prog2.adaptador.Adaptador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppCentralUB extends JFrame {
    private JButton btnGestioComponentsCentral;
    private JButton btnVisualitzarInformacioCentral;
    private JPanel panelApp;
    private JTextField txtInformacio;
    private JButton btnFinalitzarDia;
    private JButton btnDades;
    Adaptador adaptador;

    public AppCentralUB() {
        adaptador = new Adaptador();
        setTitle("Central UB");
        setContentPane(panelApp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        btnGestioComponentsCentral.setEnabled(true);
        btnVisualitzarInformacioCentral.setEnabled(true);

        // LISTENER GESTIO COMPONENTS CENTRAL
        btnGestioComponentsCentral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioComponentsCentral fgcc = new FrmGestioComponentsCentral(adaptador);
                fgcc.setVisible(true);
            }
        });

        // LISTENER VISUALITZAR INFORMACIÓ CENTRAL
        btnVisualitzarInformacioCentral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVisualitzarInformacio fvi = new FrmVisualitzarInformacio(adaptador);
                fvi.setVisible(true);
            }
        });

        // LISTENER FINALITZAR DIA
        btnFinalitzarDia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaptador.finalitzaDia(25);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppCentralUB appCentralUB = new AppCentralUB();
            appCentralUB.setVisible(true);
        });
    }
}