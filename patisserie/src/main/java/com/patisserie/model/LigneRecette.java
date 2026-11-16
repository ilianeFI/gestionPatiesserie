package com.patisserie.model;

public class LigneRecette {
    private Ingredient ingredient;
    private double quantiteNecessaire;

    public LigneRecette() {
    }

    public LigneRecette(Ingredient ingredient, double quantiteNecessaire) {
        this.ingredient = ingredient;
        this.quantiteNecessaire = quantiteNecessaire;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getQuantiteNecessaire() {
        return quantiteNecessaire;
    }

    public void setQuantiteNecessaire(double quantiteNecessaire) {
        this.quantiteNecessaire = quantiteNecessaire;
    }

    @Override
    public String toString() {
        return ingredient.getNom() + " : " + quantiteNecessaire + " " + ingredient.getUnite();
    }
}
