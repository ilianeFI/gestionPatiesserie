package com.patisserie.model;

import java.time.LocalDateTime;

public class Production {
    private int id;
    private LocalDateTime date;
    private int quantiteProduite;
    private Produit produit;
    private Employe patissier;

    public Production() {
        date = LocalDateTime.now();
    }

    public Production(int id, LocalDateTime date, int quantiteProduite,
                      Produit produit, Employe patissier) {
        this.id = id;
        this.date = date;
        this.quantiteProduite = quantiteProduite;
        this.produit = produit;
        this.patissier = patissier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getQuantiteProduite() {
        return quantiteProduite;
    }

    public void setQuantiteProduite(int quantiteProduite) {
        this.quantiteProduite = quantiteProduite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Employe getPatissier() {
        return patissier;
    }

    public void setPatissier(Employe patissier) {
        this.patissier = patissier;
    }

    @Override
    public String toString() {
        return "Production " + id + " | " + produit.getNom()
                + " x " + quantiteProduite + " | " + date;
    }
}
