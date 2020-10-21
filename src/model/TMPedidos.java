package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import util.DateUtils;
import ws.HistorialPedidos;
import ws.Pedido;
import ws.WSPedidos;
import ws.WSPedidos_Service;

/**
 *
 * @author Edunaldo
 */
public class TMPedidos implements TableModel {

    private List<Pedido> listaPed;
    WSPedidos_Service pws;
    WSPedidos pws_interfaz;
    Date fechaPedListo;
    Date fechaRegistroPed;

    public TMPedidos(List<Pedido> listaPed) {
        this.listaPed = listaPed;
        pws = new WSPedidos_Service();
        pws_interfaz = pws.getWSPedidosPort();
    }

    public Pedido getPedidos(int index) {
        return listaPed.get(index);
    }

    @Override
    public int getRowCount() {
        return listaPed.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "N° Pedido";
            case 1:
                return "Nombre";
            case 2:
                return "Espera";
            default:
                return "Estado";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pe = listaPed.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pe.getId();
            case 1:
                return pe.getNomPersona();
            case 2: {
                if (pe.getEstadoPedido() == 1) {
                    String raw_date = pe.getFecha();
                    Date date = DateUtils.transformDate(raw_date);
                    Date now = Calendar.getInstance().getTime();
                    long tiempoInicial = date.getTime();
                    long tiempoFinal = now.getTime();
                    long resta = tiempoFinal - tiempoInicial;
                    long restaHor = ((resta / (1000 * 60 * 60)) % 24);
                    long restaMin = resta / (1000 * 60);
                    long restaMin2 = restaMin % 60;
                    long restaSeg = resta / (1000);
                    long restaSeg2 = restaSeg % 60;
                    String hora = (restaHor <= 9 ? "0" + restaHor : Long.toString(restaHor));
                    String minuto = (restaMin2 <= 9 ? "0" + restaMin2 : Long.toString(restaMin2));
                    String segundos = (restaSeg2 <= 9 ? "0" + restaSeg2 : Long.toString(restaSeg2));
                    return hora + ":" + minuto + ":" + segundos;
                } else {
                    return "Retire su pedido";
                }

            }
            default:
                return pe.getEstado();
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

}
