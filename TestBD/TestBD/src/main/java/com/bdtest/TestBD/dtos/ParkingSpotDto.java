package com.bdtest.TestBD.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDto {

    @NotBlank
    private String produto;
    @NotBlank
    @Size (max = 7)
    private String matriculaCar;
    @NotBlank
    private String referencia;
    @NotBlank
    private String clienteName;


    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getMatriculaCar() {
        return matriculaCar;
    }

    public void setMatriculaCar(String matriculaCar) {
        this.matriculaCar = matriculaCar;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }


    public String getClienteName() {
        return clienteName;
    }

    public void setClienteName(String clienteName) {
        this.clienteName = clienteName;
    }



}
