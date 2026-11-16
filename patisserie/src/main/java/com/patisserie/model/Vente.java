package com.patisserie.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Vente {
    private int id;
    private LocalDateTime date;
    private Employe caissier;
    private List<LigneVente> lignes;

    public Vente() {
        date = LocalDateTime.now();
        lignes = new ArrayList<>();
    }

    public Vente(int id, LocalDateTime date, Employe caissier) {
        this.id = id;
        this.date = date;
        this.caissier = caissier;
        this.lignes = new ArrayList<>();
    }

    public void ajouterLigne(Produit produit, int quantite) {
        lignes.add(new LigneVente(produit, quantite));
    }

    public double calculerTotal() {
        double total = 0;
        for (LigneVente ligne : lignes) {
            total += ligne.calculerSousTotal();
        }
        return total;
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

    public Employe getCaissier() {
        return caissier;
    }

    public void setCaissier(Employe caissier) {
        this.caissier = caissier;
    }

    public List<LigneVente> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneVente> lignes) {
        this.lignes = lignes;
    }

    @Override
    public String toString() {
        return "Vente " + id + " | " + date + " | total : " + calculerTotal() + " DH";
    }
}
