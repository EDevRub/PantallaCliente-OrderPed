/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import model.TMPedidos;
import ws.Pedido;
import ws.WSPedidos;

/**
 *
 * @author Edunaldo
 */
public class ThreadTabla implements Runnable {

    private WSPedidos pedidos;
    private JTable tabla;

    public ThreadTabla(WSPedidos pedidos, JTable tabla) {
        this.pedidos = pedidos;
        this.tabla = tabla;
    }

    @Override
    public void run() {
        while (true) {
            TMPedidos tm = new TMPedidos(pedidos.pedidosDeHoy());
            tabla.setModel(tm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
