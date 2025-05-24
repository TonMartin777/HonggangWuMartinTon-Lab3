package prog2.vistaGUI;
import prog2.adaptador.Adaptador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppCentralUB extends JFrame {
    private JButton btnGestioComponentsCentral;
    private JButton btnVisualitzarInformacioCentral;
    private JPanel panelApp;
    private JButton btnFinalitzarDia;
    private JButton btnDades;
    private JLabel lblDia;
    private JLabel lblDemandaPotencia;
    private JLabel lblGuanysAcumulats;
    Adaptador adaptador;
    private int diaActual = 1;


    public AppCentralUB() {
        adaptador = new Adaptador();
        setTitle("Central UB");
        setContentPane(panelApp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        btnGestioComponentsCentral.setEnabled(true);
        btnVisualitzarInformacioCentral.setEnabled(true);
        lblDia.setText("Dia: " + diaActual);

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
                diaActual ++;
                adaptador.finalitzaDia(25); // Honggang que va aquí? He puesto 25 para que no de error.
                JOptionPane.showMessageDialog(null, "Aqui debe aparecer la informacion del dia.", "Dia finalitzat", JOptionPane.INFORMATION_MESSAGE);
                lblDia.setText("Dia: " + diaActual);
            }
        });

        // LISTENER CARREGA I GUARDAR DADES
        btnDades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGuardarCarregarDades fgcd = new FrmGuardarCarregarDades(adaptador);
                fgcd.setVisible(true);
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