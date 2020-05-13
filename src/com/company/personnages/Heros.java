package com.company.personnages;

public class Heros {

    //*****************  ATTRIBUTS  *****************************

    protected String nom;
    protected int vie;
    protected int force;
    protected String attaque;
    protected String defense;


    //*********************** CONSTRUCTEUR  **********************

    public Heros() {
        nom = "Inconnu";
        vie = 3;
        force = 5;
        attaque = "??";
        defense = "??";

    }

    public Heros(String pickNom){
        nom = pickNom;
        vie = 3;
        force = 5;
        attaque = "??";
        defense = "??";
    }

    public Heros(String pickNom, int pickVie, int pickForce, String pickAttaque, String pickDefense) {
        nom = pickNom;
        vie = pickVie;
        force = pickForce;
        attaque = pickAttaque;
        defense = pickDefense;
    }

    //************  GETTERS  ******************


    public String getNom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }

    public int getForce() {
        return force;
    }

    public String getAttaque() {
        return attaque;
    }

    public String getDefense() {
        return defense;
    }

    //******************   SETTERS  ***********************


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setAttaque(String attaque) {
        this.attaque = attaque;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

}
