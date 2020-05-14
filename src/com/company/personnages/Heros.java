package com.company.personnages;

import com.company.armes.Arme;

public abstract class Heros {

    //*****************  ATTRIBUTS  *****************************

    protected String nom;
    protected int vie;
    protected int force;
    protected String attaque;
    protected String defense;
    //protected int position;


    //*********************** CONSTRUCTEURS  **********************

    public Heros() {
        nom = "Inconnu";
        vie = 3;
        force = 5;
        attaque = "??";
        defense = "??";
        //position = 1;

    }

    public Heros(String pickNom) {
        nom = pickNom;
        vie = 3;
        force = 5;
        attaque = "??";
        defense = "??";
        //position = 1;
    }

    public Heros(String pickNom, int pickVie, int pickForce, String pickAttaque, String pickDefense) {
        nom = pickNom;
        vie = pickVie;
        force = pickForce;
        attaque = pickAttaque;
        defense = pickDefense;
        //position = 1;
    }

    //*************  METHODS  ********************

    @Override
    public String toString() {
        return  "Nom du Héros : " + this.nom
                + "\nPoints de vie : " + this.vie
                + "\nForce d'attaque : " + this.force
                /*+ "\nPosition sur le plateau : case n° " + this.position*/;
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

//    public int getPosition() {
//        return position;
//    }

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

//    public void setPosition(int position) {
//        this.position = position;
//    }
}
