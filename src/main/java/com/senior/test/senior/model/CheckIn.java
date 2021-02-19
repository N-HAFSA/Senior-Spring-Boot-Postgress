package com.senior.test.senior.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class CheckIn {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dataEntrada;
    private String dataSaida;
    private boolean adicionalVeiculo;
    
    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private hospede hospede;

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public boolean isAdicionalVeiculo() {
        return adicionalVeiculo;
    }

    public void setAdicionalVeiculo(boolean adicionalVeiculo) {
        this.adicionalVeiculo = adicionalVeiculo;
    }

    public hospede getHospede() {
        return hospede;
    }

    public void setHospede(hospede hospede) {
        this.hospede = hospede;
    }

    @Override
    public String toString() {
        return "CheckIn [adicionalVeiculo=" + adicionalVeiculo + ", dataEntrada=" + dataEntrada + ", dataSaida="
                + dataSaida + ", hospede=" + hospede + "]";
    }

    public CheckIn(String dataEntrada, String dataSaida, boolean adicionalVeiculo,
            com.senior.test.senior.model.hospede hospede) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.adicionalVeiculo = adicionalVeiculo;
        this.hospede = hospede;
    }

    public CheckIn(long id, String dataEntrada, String dataSaida, boolean adicionalVeiculo,
            com.senior.test.senior.model.hospede hospede) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.adicionalVeiculo = adicionalVeiculo;
        this.hospede = hospede;
    }

    public CheckIn() {
    }

    
}
