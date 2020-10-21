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
public class HiloHoraActual implements Runnable {


    private JLabel label;
    private boolean sigue;
    private Calendar c;

    public HiloHoraActual(JLabel label) {
        this.label = label;
        sigue = true;
    }

    @Override
    public void run() {
        while (sigue) {
            c = Calendar.getInstance();

            int hora = c.get(Calendar.HOUR_OF_DAY);
            if (hora == -1) {
                hora = 0;
            }
            String hora2 = (hora <= 9 ? "0" + hora : Integer.toString(hora));
            int minuto = c.get(Calendar.MINUTE);
            String minuto2 = (minuto <= 9 ? "0" + minuto : Integer.toString(minuto));
            int segundo = c.get(Calendar.SECOND);
            String segundo2 = (segundo <= 9 ? "0" + segundo : Integer.toString(segundo));

            label.setText(hora2 + ":" + minuto2 + ":" + segundo2);
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
