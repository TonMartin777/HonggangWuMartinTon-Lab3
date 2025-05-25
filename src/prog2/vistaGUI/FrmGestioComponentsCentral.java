package prog2.vistaGUI;
import prog2.adaptador.Adaptador;
import prog2.model.BombaRefrigerant;
import prog2.vista.CentralUBException;

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
    private JTextField txtSistemaRefrigeracio;
    private JList lstBombesForaServei;
    private JCheckBox chkBomba1;
    private JCheckBox chkBomba2;
    private JCheckBox chkBomba3;
    private JCheckBox chkBomba4;
    private JLabel lblTemperatura;
    private float insercio;
    private boolean reactor;

    private void carregarBombesForaServei(Adaptador adaptador) {
        DefaultListModel<BombaRefrigerant> model = new DefaultListModel<>();
        for (BombaRefrigerant bomba : adaptador.getBombesForaServei()) {
            model.addElement(bomba);
        }
        lstBombesForaServei.setModel(model);
    }

    public FrmGestioComponentsCentral(Adaptador adaptador) {
        setContentPane(contentPane);
        setTitle("Gestio Components Central");
        setSize(600, 500);
        setModal(true);
        insercio = adaptador.getInsercio();
        txtBarresControl.setEditable(false);
        txtEstatReactor.setEditable(true);
        txtSistemaRefrigeracio.setEditable(false);
        float valorGuardat = adaptador.getInsercio();
        int valorSlider = Math.round(valorGuardat);
        sldBarresControl.setValue(valorSlider);
        lblBarresControl.setText("Inserció Barres: " + valorSlider + "%");
        insercio = valorSlider;
        chkEstatReactor.setSelected(adaptador.estaActiuReactor());
        chkBomba1.setSelected(adaptador.getActivatBomba(0));
        chkBomba2.setSelected(adaptador.getActivatBomba(1));
        chkBomba3.setSelected(adaptador.getActivatBomba(2));
        chkBomba4.setSelected(adaptador.getActivatBomba(3));
        carregarBombesForaServei(adaptador);
        lblTemperatura.setText("Temperatura del reactor: "+adaptador.getTemperatura());


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
                    try {
                        adaptador.activaReactor();
                    } catch (CentralUBException ex) {
                        JOptionPane.showMessageDialog(null,
                                "No es pot activar el reactor: " + ex.getMessage(),
                                "Error d'activació",
                                JOptionPane.ERROR_MESSAGE);
                        chkEstatReactor.setSelected(false);
                    }
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

        chkBomba1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chkBomba1.isSelected()) {
                    if (adaptador.estaForaDeServei(0)) {
                        JOptionPane.showMessageDialog(null, "La bomba 1 està fora de servei. No es pot activar.");
                        chkBomba1.setSelected(false); // Desmarca perquè no es pot activar
                    } else {
                        adaptador.activaBomba(0);
                    }
                } else {
                    adaptador.desactivaBomba(0);
                }
                carregarBombesForaServei(adaptador);

            }
        });


        chkBomba2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chkBomba2.isSelected()) {
                    if (adaptador.estaForaDeServei(1)) {
                        JOptionPane.showMessageDialog(null, "La bomba 2 està fora de servei. No es pot activar.");
                        chkBomba2.setSelected(false); // Desmarca perquè no es pot activar
                    } else {
                        adaptador.activaBomba(1);
                    }
                } else {
                    adaptador.desactivaBomba(1);
                }
                carregarBombesForaServei(adaptador);

            }
        });
        chkBomba3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chkBomba3.isSelected()) {
                    if (adaptador.estaForaDeServei(2)) {
                        JOptionPane.showMessageDialog(null, "La bomba 3 està fora de servei. No es pot activar.");
                        chkBomba3.setSelected(false); // Desmarca perquè no es pot activar
                    } else {
                        adaptador.activaBomba(2);
                    }
                } else {
                    adaptador.desactivaBomba(2);
                }
                carregarBombesForaServei(adaptador);

            }
        });
        chkBomba4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chkBomba4.isSelected()) {
                    if (adaptador.estaForaDeServei(3)) {
                        JOptionPane.showMessageDialog(null, "La bomba 4 està fora de servei. No es pot activar.");
                        chkBomba4.setSelected(false); // Desmarca perquè no es pot activar
                    } else {
                        adaptador.activaBomba(3);
                    }
                } else {
                    adaptador.desactivaBomba(3);
                }
                carregarBombesForaServei(adaptador);

            }
        });
    }
}
