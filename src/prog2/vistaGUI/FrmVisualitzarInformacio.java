package prog2.vistaGUI;
import prog2.adaptador.Adaptador;
import javax.swing.*;
import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FrmVisualitzarInformacio extends JDialog {
    private JPanel contentPane;
    private JComboBox cmboxOpcionsVisualitzar;
    private JTextArea txtInformacio;

    // Com els metodes mostra no tornen un string, cal atrapar la sortida.
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    PrintStream oldOut = System.out;

    public FrmVisualitzarInformacio(Adaptador adaptador) {
        setContentPane(contentPane);
        setTitle("Gestio Components Central");
        setSize(600, 500);
        setModal(true);

        cmboxOpcionsVisualitzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                PrintStream oldOut = System.out;
                System.setOut(ps);
                String opcion = (String) cmboxOpcionsVisualitzar.getSelectedItem();
                if (opcion.equals("Elements que pots Visualitzar")) {
                    txtInformacio.setText("");

                } else if (opcion.equals("Estat de la Central")) {
                    adaptador.mostraEstat();

                } else if (opcion.equals("Pàgina Bitàcola")) {
                    adaptador.mostraBitacola();

                } else {
                    adaptador.mostraIncidencies();
                }
                System.out.flush();
                System.setOut(oldOut);
                txtInformacio.setText(baos.toString());

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
