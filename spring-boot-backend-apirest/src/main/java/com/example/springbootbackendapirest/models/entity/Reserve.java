package com.example.springbootbackendapirest.models.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "RESERVA")
public class Reserve {
    @Id
    @Column(name = "CODIGO")
    private Long codigo;

    @Column(name = "ID_MATRÍCULA")
    private String idMatricula;

    @Column(name = "ID_PARQUEADERO")
    private Long idParqueadero;

    @Column(name = "FECHA_RESERVA")
    private Date fechaReserva;

    @Column(name = "HORA_ENTRADA")
    private String horaEntrada;

    @Column(name = "HORA_SALIDA")
    private String horaSalida;

    // Constructor, getters y setters

    public Reserve() {
    }



    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Long getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(Long idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
}

