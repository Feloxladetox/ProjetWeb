package com.example.appliweb.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CLIENT")
@Data
public class Client {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    public Client(){

    }

    public Client(Client client) {
        this.id = id;
        this.nom = nom;
        this.mdp = mdp;
        this.modimun = modimun;
        this.modimdeux = modimdeux;
    }

    @Column(name="nom")
    private String nom;

    @Column(name="mdp")
    private String mdp;

    @Column(name="modim1")
    private String modimun;


    @Column(name="modim2")
    private String modimdeux;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getModimun() {
        return modimun;
    }

    public void setModimun(String modimun) {
        this.modimun = modimun;
    }

    public String getModimdeux() {
        return modimdeux;
    }

    public void setModimdeux(String modimdeux) {
        this.modimdeux = modimdeux;
    }
}
