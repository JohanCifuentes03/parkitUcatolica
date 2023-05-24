package com.example.springbootbackendapirest.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PARQUEADERO")
public class Parking {

    @Id
    @Column(name = "CODIGO")
    private Long codigo;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DIRECCIÓN")
    private String direccion;

    @Column(name = "TELÉFONO")
    private Long telefono;

    @Column(name = "CORREO_ELECTRÓNICO")
    private String correoElectronico;

    @Column(name = "CUPOS_TOTALES")
    private Long cuposTotales;

    @Column(name = "ID_DUEÑO")
    private Long idDueno;

    @Column(name = "ID_LOCALIDAD")
    private Long idLocalidad;

    @Column(name = "PRECIO_MINUTO")
    private Double precioMinuto;

    // Constructor, getters y setters

    // Constructor vacío
    public Parking() {
    }

    // Getters y setters

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Long getCuposTotales() {
        return cuposTotales;
    }

    public void setCuposTotales(Long cuposTotales) {
        this.cuposTotales = cuposTotales;
    }

    public Long getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(Long idDueno) {
        this.idDueno = idDueno;
    }

    public Long getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Long idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Double getPrecioMinuto() {
        return precioMinuto;
    }

    public void setPrecioMinuto(Double precioMinuto) {
        this.precioMinuto = precioMinuto;
    }
}
