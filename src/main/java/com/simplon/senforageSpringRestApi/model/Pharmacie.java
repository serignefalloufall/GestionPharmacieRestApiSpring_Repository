package com.simplon.senforageSpringRestApi.model;

import javax.persistence.*;

@Entity
@Table(name="pharmacie")
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nom;

    @Column
    private String quartier;

    @Column
    private String ville;

    @Column
    private int etat;

    public Pharmacie() {
    }

    public Pharmacie(int id, String nom, String quartier, String ville, int etat) {
        this.id = id;
        this.nom = nom;
        this.quartier = quartier;
        this.ville = ville;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
