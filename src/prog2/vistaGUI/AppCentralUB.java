package prog2.vistaGUI;
import prog2.adaptador.Adaptador;
import prog2.vista.VariableNormal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static prog2.vista.CentralUB.*;

public class AppCentralUB extends JFrame {
    private JButton btnGestioComponentsCentral;
    private JButton btnVisualitzarInformacioCentral;
    private JPanel panelApp;
    private JButton btnFinalitzarDia;
    private JButton btnDades;
    private JLabel lblDia;
    private JLabel lblDemandaPotencia;
    private JLabel lblGuanysAcumulats;
    private Adaptador adaptador;
    private int diaActual = 1;
    private VariableNormal variableNormal;

    /** Demanda de potència del dia actual **/
    private float demandaPotencia;


    public AppCentralUB() {
        adaptador = new Adaptador();
        setTitle("Central UB");
        setContentPane(panelApp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        btnGestioComponentsCentral.setEnabled(true);
        btnVisualitzarInformacioCentral.setEnabled(true);
        variableNormal = new VariableNormal(VAR_NORM_MEAN, VAR_NORM_STD, VAR_NORM_SEED);
        demandaPotencia = generaDemandaPotencia();
        lblDia.setText("Dia: " + diaActual);
        lblDemandaPotencia.setText("Potencia demanada: "+  demandaPotencia);
        lblGuanysAcumulats.setText("Guanys acumulats: "+adaptador.getGuanysAcumulats());

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

                String info = adaptador.finalitzaDia(demandaPotencia);

                diaActual++;
                demandaPotencia = generaDemandaPotencia(); // nova demanda per al següent dia

                // Mostrar la informació del dia en la finestra emergent
                JOptionPane.showMessageDialog(null, info, "Dia finalitzat", JOptionPane.INFORMATION_MESSAGE);

                // Actualitzar etiquetes
                lblDia.setText("Dia: " + diaActual);
                lblDemandaPotencia.setText("Potència demanada: " + demandaPotencia);
                lblGuanysAcumulats.setText("Guanys acumulats: " + adaptador.getGuanysAcumulats());
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

    private float generaDemandaPotencia() {
        float valor = Math.round(variableNormal.seguentValor());
        if (valor > DEMANDA_MAX)
            return DEMANDA_MAX;
        else if (valor < DEMANDA_MIN)
            return DEMANDA_MIN;
        else
            return valor;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppCentralUB appCentralUB = new AppCentralUB();
            appCentralUB.setVisible(true);
        });
    }
}