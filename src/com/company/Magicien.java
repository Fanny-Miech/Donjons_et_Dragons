package com.company;

public class Magicien {

    //*****************  VARIABLES  (public)  ************************

    private String nom;
    private int vie; //(3-6)
    private int force; //(8-15)
    private String image;


    //**************    CONSTRUCTEURS   *******************************

    public Magicien() {
        System.out.println("Création d'un nouveau magicien.");
        nom = "Inconnu";
        image = "Inconnu";
        vie = 3;
        force = 8;

    }

    public Magicien(String pnom) {
        System.out.println("Création d'un nouveau magicien avec un nom.");
        nom = pnom;
        image = "Inconnu";
        vie = 5;
        force = 5;

    }

    public Magicien(String pnom, String pimage, int pvie, int pforce) {
        System.out.println("Création d'un nouveau magicien avec des paramètres.");
        nom = pnom;
        vie = pvie;
        force = pforce;
        image = pimage;

    }

    //*****************   METHODES **********************

    //toString -> retourne nom, image, vie et force.

    public String toString() {
        return
                "Nom du magicien : " + this.nom
                        + "\nImage : " + this.image
                        + "\nPoints de vie : " + this.vie
                        + "\nForce d'attaque : " + this.force;
    }

    //************** GETTERS  ******************


    public String getNom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }

    public int getForce() {
        return force;
    }

    public String getImage() {
        return image;
    }

    //**********************   SETTERS  ***********************


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
