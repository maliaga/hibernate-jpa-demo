package com.marioaliaga.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by maliaga on 6/8/17.
 */
@Entity
@Table(name = "TBL_EMPLEADO")
public class Employee implements Serializable{

    @Id
    @Column(name = "COD_EMPLEADO")
    private Long codigo;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FECHA_NACIMIENTO")
    private LocalDate fechaNacimineto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ADDRESS")
    private Address address;

    public Employee() {
    }

    public Employee(Long codigo, String apellidos, String nombre, LocalDate fechaNacimineto) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaNacimineto = fechaNacimineto;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(LocalDate fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "codigo=" + codigo +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimineto=" + fechaNacimineto +
                ", address=" + address +
                '}';
    }


}
