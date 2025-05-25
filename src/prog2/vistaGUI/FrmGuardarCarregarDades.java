package prog2.vistaGUI;
import prog2.adaptador.Adaptador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmGuardarCarregarDades extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton btnGuardar;
    private JButton btnCarregar;

    public FrmGuardarCarregarDades(Adaptador adaptador) {
        setContentPane(contentPane);
        setTitle("Guardar I Carregar Dades");
        setSize(600, 500);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        btnCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\tonma\\IdeaProjects\\P2-2525-Practica3Part1");
                int file = fileChooser.showDialog(FrmGuardarCarregarDades.this, "Seleccionar");
                adaptador.carregaDades(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fitxer = JOptionPane.showInputDialog("Indica la direcció del fitxer: ");
                adaptador.guardaDades(fitxer);
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
