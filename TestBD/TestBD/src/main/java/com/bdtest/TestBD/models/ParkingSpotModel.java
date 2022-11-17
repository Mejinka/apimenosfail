package com.bdtest.TestBD.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class ParkingSpotModel {

    @Id
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    @Column (nullable = false, unique = true, length = 7)
    private String matriculaCar;
    @Column (nullable = false, length = 70)
    private String referencia;
    @Column (nullable = false,  length = 130)
    private String clienteName;
    @Column (nullable = false,  length = 10)
    private String produto;
    @Column (nullable = false)
    private LocalDateTime registrationDate;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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



    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getClienteName() {
        return clienteName;
    }

    public void setClienteName(String clienteName) {
        this.clienteName = clienteName;
    }



}
