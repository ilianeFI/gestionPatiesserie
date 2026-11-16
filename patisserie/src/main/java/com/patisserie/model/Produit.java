package com.patisserie.model;

import java.util.ArrayList;
import java.util.List;

public class Produit {
    private int id;
    private String nom;
    private double prix;
    private Categorie categorie;
    private int quantiteStock;
    private List<LigneRecette> recette;

    public Produit() {
        recette = new ArrayList<>();
    }

    public Produit(int id, String nom, double prix, Categorie categorie, int quantiteStock) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.quantiteStock = quantiteStock;
        this.recette = new ArrayList<>();
    }

    public void ajouterIngredient(Ingredient ingredient, double quantiteNecessaire) {
        recette.add(new LigneRecette(ingredient, quantiteNecessaire));
    }

    public boolean peutVendre(int quantite) {
        return quantite > 0 && quantiteStock >= quantite;
    }

    public void retirerDuStock(int quantite) {
        if (!peutVendre(quantite)) {
            throw new IllegalArgumentException("Stock insuffisant pour " + nom);
        }
        quantiteStock -= quantite;
    }

    public void ajouterAuStock(int quantite) {
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public List<LigneRecette> getRecette() {
        return recette;
    }

    public void setRecette(List<LigneRecette> recette) {
        this.recette = recette;
    }

    @Override
    public String toString() {
        return id + " - " + nom + " | " + prix + " DH | stock : " + quantiteStock;
    }
}
