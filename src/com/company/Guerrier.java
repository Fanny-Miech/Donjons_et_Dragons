package com.company;

public class Guerrier {

    //*****************  ATTRIBUTS  (public)  ************************

    private String nom;
    private int vie; //(5-10)
    private int force;//(5-10)
    private String arme; //arme  = objet avec nom et niveau d'attaque
    private String bouclier;
    private String image;


    //**************    CONSTRUCTEURS   *******************************

    public Guerrier() {
        System.out.println("Création d'un nouveau guerrier.");
        nom = "Inconnu";
        vie = 5;
        force = 5;
        arme = "Inconnu";
        bouclier = "Inconnu";
        image = "Inconnu";
    }

    public Guerrier(String pnom) {
        System.out.println("Création d'un nouveau guerrier avec un nom.");
        nom = pnom;
        vie = 5;
        force = 5;
        arme = "Inconnu";
        bouclier = "Inconnu";
        image = "Inconnu";

    }

    public Guerrier(String pnom, int pvie, int pforce, String parme, String pbouclier, String pimage) {
        System.out.println("Crétaion d'un nouveau guerrier avec des paramètres.");
        nom = pnom;
        vie = pvie;
        force = pforce;
        arme = parme;
        bouclier = pbouclier;
        image = pimage;

    }

    //*****************   METHODES **********************

    //toString -> retourne nom, image, vie et force.

    public String toString(){
        return
                "Nom du guerrier : " + this.nom
                        + "\nimage : " + this.image
                        + "\npoints de vie : " + this.vie
                        + "\nforce : " + this.force;
    }

    //***********    ACCESSEURS     (Getteurs)  ************************

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

    //Retourne l'arme du guerrier
    public String getArme() {
        return arme;
    }

    //Retourne le bouclier du guerrier
    public String getBouclier() {
        return bouclier;
    }

    public String getImage() {
        return image;
    }

    //*********************   MUTATEURS   (setteurs)  ****************************

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setArme(String arme) {
        this.arme = arme;
    }

    public void setBouclier(String bouclier) {
        this.bouclier = bouclier;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
