package com.marioaliaga.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by maliaga on 6/13/17.
 */

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @Column(name = "ID_ADDRESS")
    private Long id;

    @Column(name = "ADDRESS")
    private String direccion;

    @Column(name = "LOCATION")
    private String localidad;

    @Column(name = "PROVINCE")
    private String provincia;

    @Column(name = "COUNTRY")
    private String pais;

    public Address() {
    }

    public Address(Long id, String direccion, String localidad, String provincia, String pais) {
        this.id = id;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
