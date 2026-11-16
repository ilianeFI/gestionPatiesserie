package com.patisserie.model;

public class LigneVente {
    private Produit produit;
    private int quantite;
    private double prixUnitaire;

    public LigneVente() {
    }

    public LigneVente(Produit produit, int quantite, double prixUnitaire) {
        this.produit = produit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public LigneVente(Produit produit, int quantite) {
        this(produit, quantite, produit.getPrix());
    }

    public double calculerSousTotal() {
        return quantite * prixUnitaire;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    @Override
    public String toString() {
        return produit.getNom() + " x " + quantite + " = " + calculerSousTotal() + " DH";
    }
}
