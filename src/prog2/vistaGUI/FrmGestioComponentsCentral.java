package prog2.vistaGUI;
import prog2.adaptador.Adaptador;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class FrmGestioComponentsCentral extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSlider sldBarresControl;
    private JLabel lblBarresControl;

    public FrmGestioComponentsCentral(JFrame parent) {
        super(parent);
        setContentPane(contentPane);
        setTitle("Gestio Components Central");
        setSize(600, 500);
        setLocationRelativeTo(parent);
        setModal(true);

        sldBarresControl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                float insercio = sldBarresControl.getValue();
                // Aqui hay que hacer que el grado de insercion sea insercio, pero ns como.
                // Adaptador adaptador = new Adaptador();
                // adaptador.setInsercio(insercio);
                lblBarresControl.setText("Inserció Barres: " + insercio + "%");
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
}
