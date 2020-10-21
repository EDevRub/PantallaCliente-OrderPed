
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para pedidosPorFecha complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pedidosPorFecha">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fecha_Filtro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pedidosPorFecha", propOrder = {
    "fechaFiltro"
})
public class PedidosPorFecha {

    @XmlElement(name = "fecha_Filtro")
    protected String fechaFiltro;

    /**
     * Obtiene el valor de la propiedad fechaFiltro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaFiltro() {
        return fechaFiltro;
    }

    /**
     * Define el valor de la propiedad fechaFiltro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaFiltro(String value) {
        this.fechaFiltro = value;
    }

}
