/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Productos.ManagedBean;

import com.Productos.Entidades.Productos;
import com.Productos.Servicces.ProductosFacadeLocal;
import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.util.*;
import java.util.logging.*;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.chart.MeterGaugeChartModel;

/**
 *
 * @author user
 */
@Named(value = "productosMB")
@RequestScoped
public class ProductosMB {

    @EJB
    private ProductosFacadeLocal productosFacade;

    private String seccion;
    private String nombreArticulo;
    private int precio;
    private String fecha;
    private String importado;
    private String pais;

    Productos prod = new Productos();
    private MeterGaugeChartModel meterGaugeModel;
    static final Logger LOGGER = Logger.getLogger(ProductosMB.class.getName());

    public ProductosMB() {
        createMeterGaugeModel();
    }

    //retorna la lista de los productos en la base de datos
    public List<Productos> getProductos() {
        return productosFacade.findAll();
    }

    public void crear() {
        try {
            // Productos prod = new Productos();
            prod.setSeccion(seccion);
            prod.setNombrearticulo(nombreArticulo);
            prod.setPrecio(precio);
            prod.setPaisdeorigen(pais);

            productosFacade.create(prod);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado"));

        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al insertar datos", e.getMessage());

        }

    }

    public void eliminar(Productos pr) {
        try {

            pr.setSeccion(seccion);
            pr.setNombrearticulo(nombreArticulo);
            pr.setPrecio(precio);
            pr.setPaisdeorigen(pais);
            productosFacade.remove(pr);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado"));

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error al eliminar datos", e.getMessage());
            e.getStackTrace();

        }
    }

    public void editar(CellEditEvent event) {

        try {
            Object oldValue = event.getOldValue();
            Object newValue = event.getNewValue();

            if (newValue != null && !newValue.equals(oldValue)) {

                prod = (Productos) event.getNewValue();

                prod.setNombrearticulo(nombreArticulo);
                prod.setPrecio(precio);
                prod.setPaisdeorigen(pais);
                productosFacade.edit(prod);
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo editado", "Anterior: " + oldValue + ", Nuevo:" + newValue);
                FacesContext.getCurrentInstance().addMessage(null, msg);

            }

        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al editar datos", e.getMessage());
            e.getStackTrace();

        }

    }

    public MeterGaugeChartModel getMeterGaugeModel() {
        meterGaugeModel.setValue(Math.random() * 220);
        return meterGaugeModel;
    }

    private void createMeterGaugeModel() {
        List<Number> intervals = new ArrayList<Number>() {
            {
                add(20);
                add(50);
                add(120);
                add(220);
            }
        };
        meterGaugeModel = new MeterGaugeChartModel(0, intervals);
    }


//GETTERS Y SETTERS
public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion.toUpperCase();
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo.toUpperCase();
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {

        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImportado() {
        return importado;
    }

    public void setImportado(String importado) {
        this.importado = importado.toUpperCase();
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais.toUpperCase();
    }
//FIN GETTERS Y SETTERS

}
