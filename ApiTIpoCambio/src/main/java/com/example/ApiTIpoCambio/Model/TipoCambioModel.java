package com.example.ApiTIpoCambio.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class TipoCambioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String usuario;
    @Column
    private String monedaOrigen;
    @Column
    private String monedaDestino;
    @Column
    private Double monto;
    @Column
    private Double montoCambiado;



    public Double getMontoCambiado() {
        return montoCambiado;
    }

    public void setMontoCambiado(Double montoCambiado) {
        this.montoCambiado = montoCambiado;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

}
