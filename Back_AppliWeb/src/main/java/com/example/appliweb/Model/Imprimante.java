package com.example.appliweb.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "IMPRIMANTE")
@Data
public class Imprimante {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    public Imprimante(){

    }

    public Imprimante(Imprimante imprimante) {
        this.id = id;
        this.model = model;
        this.adresse = adresse;
    }

    @Column(name="model")
    private String model;

    @Column(name="adresse")
    private String adresse;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}