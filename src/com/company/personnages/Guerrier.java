package com.company.personnages;

public class Guerrier {

    //*****************  ATTRIBUTS  (public)  ************************

    private String nom;
    private int vie; //(5-10)
    private int force;//(5-10)
    private String image;


    //**************    CONSTRUCTEURS   *******************************

    public Guerrier() {
        System.out.println("Création d'un nouveau guerrier.");
        nom = "Inconnu";
        vie = 5;
        force = 5;
        image = "Inconnu";
    }

    public Guerrier(String pnom) {
        System.out.println("Création d'un nouveau guerrier avec un nom.");
        nom = pnom;
        vie = 5;
        force = 5;
        image = "Inconnu";

    }

    public Guerrier(String pnom, int pvie, int pforce, String pimage) {
        System.out.println("Création d'un nouveau guerrier avec des paramètres.");
        nom = pnom;
        vie = pvie;
        force = pforce;
        image = pimage;

    }

    //*****************   METHODES **********************

    //toString -> retourne nom, image, vie et force.

    public String toString() {
        return
                "Nom du guerrier : " + this.nom
                        + "\nImage : " + this.image
                        + "\nPoints de vie : " + this.vie
                        + "\nForce d'attaque : " + this.force;

    }


    //***********    ACCESSEURS     (Getters)  ************************

    //Retourne le nom du guerrier
    public String getNom() {
        return nom;
    }

    //Retourne la vie du guerrier
    public int getVie() {
        return vie;
    }

    //Retourne la force du guerrier
    public int getForce() {
        return force;
    }

    public String getImage() {
        return image;
    }

    //*********************   MUTATEURS   (setters)  ****************************

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
