package com.company;

public class Magicien {

    //*****************  VARIABLES  (public)  ************************

    private String nom;
    private int vie; //(3-6)
    private int force; //(8-15)
    private String sort; // private Sort = { private String nom ; private int force; }
    private String philtre;
    private String image;


    //**************    CONSTRUCTEURS   *******************************

    public Magicien() {
        System.out.println("Création d'un nouveau magicien.");
        nom = "Inconnu";
        vie = 3;
        force = 8;
        sort = "Inconnu";
        philtre = "Inconnu";
    }

    public Magicien(String pnom) {
        System.out.println("Création d'un nouveau magicien avec un nom.");
        nom = pnom;
        vie = 5;
        force = 5;
        sort = "Inconnu";
        philtre = "Inconnu";

    }

    public Magicien(String pnom, int pvie, int pforce, String psort, String pphiltre, String pimage) {
        System.out.println("Crétaion d'un nouveau magicien avec des paramètres.");
        nom = pnom;
        vie = pvie;
        force = pforce;
        sort = psort;
        philtre = pphiltre;
        image = pimage;

    }

    //*****************   METHODES **********************

    //toString -> retourne nom, image, vie et force.

    public String toString() {
        return
                "Nom du magicien : " + this.nom
                        + "\nimage : " + this.image
                        + "\npoints de vie : " + this.vie
                        + "\nforce : " + this.force
                        + "\nsort : " + this.sort
                        + "\nphiltre : " + this.philtre;
    }

    //************** GETTEURS  ******************


    public String getNom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }

    public int getForce() {
        return force;
    }

    public String getSort() {
        return sort;
    }

    public String getPhiltre() {
        return philtre;
    }

    public String getImage() {
        return image;
    }

    //**********************   SETTEURS  ***********************


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setPhiltre(String philtre) {
        this.philtre = philtre;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
