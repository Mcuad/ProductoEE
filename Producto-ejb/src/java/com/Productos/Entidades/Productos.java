/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Productos.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByCodart", query = "SELECT p FROM Productos p WHERE p.codart = :codart")
    , @NamedQuery(name = "Productos.findBySeccion", query = "SELECT p FROM Productos p WHERE p.seccion = :seccion")
    , @NamedQuery(name = "Productos.findByNombrearticulo", query = "SELECT p FROM Productos p WHERE p.nombrearticulo = :nombrearticulo")
    , @NamedQuery(name = "Productos.findByPrecio", query = "SELECT p FROM Productos p WHERE p.precio = :precio")
    , @NamedQuery(name = "Productos.findByPaisdeorigen", query = "SELECT p FROM Productos p WHERE p.paisdeorigen = :paisdeorigen")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "CODART")
    private Integer codart;
   
    @Column(name = "SECCION" ,length = 10)
    private String seccion;
    
    @Column(name = "NOMBREARTICULO", length = 19)
    private String nombrearticulo;
    
    @Column(name = "PRECIO")
    private Integer precio;

    @Column(name = "PAISDEORIGEN", length = 9)
    private String paisdeorigen;

    public Productos() {
    }

    public Productos(Integer codart) {
        this.codart = codart;
    }

    public Integer getCodart() {
        return codart;
    }

    public void setCodart(Integer codart) {
        this.codart = codart;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNombrearticulo() {
        return nombrearticulo;
    }

    public void setNombrearticulo(String nombrearticulo) {
        this.nombrearticulo = nombrearticulo;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getPaisdeorigen() {
        return paisdeorigen;
    }

    public void setPaisdeorigen(String paisdeorigen) {
        this.paisdeorigen = paisdeorigen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codart != null ? codart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.codart == null && other.codart != null) || (this.codart != null && !this.codart.equals(other.codart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Productos.Entidades.Productos[ codart=" + codart + " ]";
    }
    
}
