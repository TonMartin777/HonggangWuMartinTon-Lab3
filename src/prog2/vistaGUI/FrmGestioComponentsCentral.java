package prog2.vistaGUI;
import prog2.adaptador.Adaptador;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class FrmGestioComponentsCentral extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JSlider sldBarresControl;
    private JLabel lblBarresControl;
    private JTextField txtBarresControl;
    private JTextField txtEstatReactor;
    private JCheckBox chkEstatReactor;
    private JTextField txtSistemaRefrigeracio;
    private JList lstBombesForaServei;
    private JCheckBox chkBomba1;
    private float insercio;
    private boolean reactor;

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
                if (chkEstatReactor.isSelected()) {
                    adaptador.activaReactor();
                } else {
                    adaptador.desactivaReactor();
                }
            }
        });

        lstBombesForaServei.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });

        chkBomba1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chkBomba1.isSelected()) {
                    // If esta bomba esta fuera de servicio
                    JOptionPane.showMessageDialog(null, "Bomba Fora de Servei", "Excepció", JOptionPane.WARNING_MESSAGE);
                    // Else if esta bomba no esta fuera de servicio
                    adaptador.activaBomba(1);
                } else {
                    adaptador.desactivaBomba(1);
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
