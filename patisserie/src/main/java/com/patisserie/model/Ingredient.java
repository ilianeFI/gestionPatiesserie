package com.patisserie.model;

public class Ingredient {
    private int id;
    private String nom;
    private double quantiteStock;
    private String unite;

    public Ingredient() {
    }

    public Ingredient(int id, String nom, double quantiteStock, String unite) {
        this.id = id;
        this.nom = nom;
        this.quantiteStock = quantiteStock;
        this.unite = unite;
    }

    public boolean stockSuffisant(double quantiteDemandee) {
        return quantiteDemandee > 0 && quantiteStock >= quantiteDemandee;
    }

    public void retirerDuStock(double quantite) {
        if (!stockSuffisant(quantite)) {
            throw new IllegalArgumentException("Stock insuffisant pour " + nom);
        }
        quantiteStock -= quantite;
    }

    public void ajouterAuStock(double quantite) {
        if (quantite <= 0) {
            throw new IllegalArgumentException("La quantite doit etre positive");
        }
        quantiteStock += quantite;
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

    public double getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(double quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    @Override
    public String toString() {
        return id + " - " + nom + " : " + quantiteStock + " " + unite;
    }
}
