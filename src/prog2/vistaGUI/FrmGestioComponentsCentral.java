package prog2.vistaGUI;
import prog2.adaptador.Adaptador;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class FrmGestioComponentsCentral extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JSlider sldBarresControl;
    private JLabel lblBarresControl;
    private JTextField txtBarresControl;
    private JTextField txtEstatReactor;
    private JCheckBox chkEstatReactor;
    private float insercio;

    public FrmGestioComponentsCentral(Adaptador adaptador) {
        setContentPane(contentPane);
        setTitle("Gestio Components Central");
        setSize(600, 500);
        setModal(true);
        insercio = adaptador.getInsercio();

        sldBarresControl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                insercio = sldBarresControl.getValue();
                lblBarresControl.setText("Inserció Barres: " + insercio + "%");
            }
        });

        chkEstatReactor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                boolean Reactor = chkEstatReactor.isSelected();
                if (chkEstatReactor.isSelected()) {
                    adaptador.activaReactor();
                } else {
                    adaptador.desactivaReactor();
                }
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adaptador.setInsercio(insercio);
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
