
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cantPedBuenosSEGFiltrados complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cantPedBuenosSEGFiltrados">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fecha1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tiempo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cantPedBuenosSEGFiltrados", propOrder = {
    "fecha1",
    "fecha2",
    "tiempo"
})
public class CantPedBuenosSEGFiltrados {

    protected String fecha1;
    protected String fecha2;
    protected int tiempo;

    /**
     * Obtiene el valor de la propiedad fecha1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha1() {
        return fecha1;
    }

    /**
     * Define el valor de la propiedad fecha1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha1(String value) {
        this.fecha1 = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha2() {
        return fecha2;
    }

    /**
     * Define el valor de la propiedad fecha2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha2(String value) {
        this.fecha2 = value;
    }

    /**
     * Obtiene el valor de la propiedad tiempo.
     * 
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Define el valor de la propiedad tiempo.
     * 
     */
    public void setTiempo(int value) {
        this.tiempo = value;
    }

}
