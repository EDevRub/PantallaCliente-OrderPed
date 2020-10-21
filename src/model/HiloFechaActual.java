package model;

import gui.App;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Edunaldo
 */
public class HiloFechaActual implements Runnable {

    private JLabel label;
    private boolean sigue;
    private Calendar c;

    public HiloFechaActual(JLabel label) {
        this.label = label;
        sigue = true;
    }

    @Override
    public void run() {
        while (sigue) {
            c = Calendar.getInstance();

            int dia = c.get(Calendar.DATE);
            String dia2 = (dia <= 9 ? "0" + dia : Integer.toString(dia));
            int mes = c.get(Calendar.MONTH) + 1;
            String mes2 = (mes <= 9 ? "0" + mes : Integer.toString(mes));
            int anio = c.get(Calendar.YEAR);
            String anio2 = (anio <= 9 ? "0" + anio : Integer.toString(anio));

            label.setText(dia2 + "-" + mes2 + "-" + anio2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void stop() {
        sigue = false;
    }

}
