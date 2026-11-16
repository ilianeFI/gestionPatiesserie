package com.patisserie.model;

public class Employe {
    private int id;
    private String nom;
    private String prenom;
    private String login;
    private String motDePasse;
    private RoleEmploye role;

    public Employe() {
    }

    public Employe(int id, String nom, String prenom, String login,
                   String motDePasse, RoleEmploye role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public String getNomComplet() {
        return prenom + " " + nom;
    }

    public boolean authentifier(String login, String motDePasse) {
        return this.login.equals(login) && this.motDePasse.equals(motDePasse);
    }

    public boolean peutVendre() {
        return role == RoleEmploye.CAISSIER || role == RoleEmploye.GERANT;
    }

    public boolean peutProduire() {
        return role == RoleEmploye.PATISSIER
                || role == RoleEmploye.CHEF_PATISSIER
                || role == RoleEmploye.GERANT;
    }

    public boolean peutGererStock() {
        return role == RoleEmploye.CHEF_PATISSIER || role == RoleEmploye.GERANT;
    }

    public boolean peutGererEmployes() {
        return role == RoleEmploye.GERANT;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public RoleEmploye getRole() {
        return role;
    }

    public void setRole(RoleEmploye role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return id + " - " + getNomComplet() + " (" + role + ")";
    }
}
