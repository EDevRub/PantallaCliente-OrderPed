package gui;

import model.ThreadTabla;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.EditTabla;
import model.HiloFechaActual;
import model.HiloHoraActual;
import model.TMPedidos;
//import sun.security.jca.GetInstance;
import ws.Pedido;
import ws.WSPedidos;
import ws.WSPedidos_Service;

/**
 *
 * @author Edunaldo
 */
public class App extends javax.swing.JFrame {

    WSPedidos_Service pws;
    WSPedidos pws_interfaz;
    private Thread hiloTabla;
    private Thread hiloFecha;
    private Thread hiloHoraActual;

    //DefaultTableModel model;
    public App() {
        initComponents();
        //model = new DefaultTableModel();

        pws = new WSPedidos_Service();
        pws_interfaz = pws.getWSPedidosPort();

        hiloTabla = new Thread(new ThreadTabla(pws_interfaz, tbl_PedidosEnCola)); //Hilo para cargar la tabla desde el WS
        hiloTabla.start();
        hiloFecha = new Thread(new HiloFechaActual(lbl_FechaMostrar)); //Hilo para mostrar la fecha
        hiloFecha.start();
        hiloHoraActual = new Thread(new HiloHoraActual(lbl_HoraMostrar));//Hilo para mostrar la hora
        hiloHoraActual.start();

        init();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_FechaMostrar = new javax.swing.JLabel();
        lbl_HoraMostrar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_PedidosEnCola = new javax.swing.JTable();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_FechaMostrar.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        lbl_FechaMostrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_FechaMostrar.setText("00-00-0000");
        getContentPane().add(lbl_FechaMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 104, 1910, 60));

        lbl_HoraMostrar.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        lbl_HoraMostrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_HoraMostrar.setText("00:00:00");
        getContentPane().add(lbl_HoraMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1900, 40));

        tbl_PedidosEnCola.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        tbl_PedidosEnCola.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_PedidosEnCola.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_PedidosEnCola);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 1880, 730));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoPedidos.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2280, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {

            javax.swing.UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lbl_FechaMostrar;
    private javax.swing.JLabel lbl_HoraMostrar;
    private javax.swing.JTable tbl_PedidosEnCola;
    // End of variables declaration//GEN-END:variables

    public void init() {
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setBounds(0, 0, 1920, 1080);
        //this.setLocation(1920, 80);
        tbl_PedidosEnCola.getTableHeader().setPreferredSize(new java.awt.Dimension(40, 40));
        tbl_PedidosEnCola.setDefaultRenderer(Object.class, new EditTabla());

    }

    public void cargarTabla() {
        List<Pedido> listaPedi = pws_interfaz.pedidosDeHoy();
        TMPedidos tm = new TMPedidos(listaPedi);
        tbl_PedidosEnCola.setModel(tm);
    }
}
