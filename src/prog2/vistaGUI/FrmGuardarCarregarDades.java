package prog2.vistaGUI;
import prog2.adaptador.Adaptador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class FrmGuardarCarregarDades extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton btnGuardar;
    private JButton btnCarregar;
    private JTextField txtCarregar;
    private JTextField txtGuardar;

    public FrmGuardarCarregarDades(Adaptador adaptador) {
        setContentPane(contentPane);
        setTitle("Guardar I Carregar Dades");
        setSize(600, 500);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
        btnCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fitxer;
                JFileChooser seleccio = new JFileChooser();
                int resultat = seleccio.showOpenDialog(FrmGuardarCarregarDades.this);
                if (resultat == JFileChooser.APPROVE_OPTION) {
                    fitxer = seleccio.getSelectedFile();
                    txtCarregar.setText(fitxer.getName());
                }
            }
        });
    }
}
