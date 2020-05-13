package com.company.personnages;

public class Magicien extends Heros {

    //*****************  VARIABLES  (public)  ************************

    private String nom;
    private int vie; //(3-6)
    private int force; //(8-15)


    //**************    CONSTRUCTEURS   *******************************

    public Magicien() {
        System.out.println("Création d'un nouveau magicien.");
        nom = "Inconnu";
        vie = 3;
        force = 8;

    }

    public Magicien(String pnom) {
        System.out.println("Création d'un nouveau magicien avec un nom.");
        nom = pnom;
        vie = 5;
        force = 5;

    }

    public Magicien(String pnom, int pvie, int pforce) {
        System.out.println("Création d'un nouveau magicien avec des paramètres.");
        nom = pnom;
        vie = pvie;
        force = pforce;

    }

    //*****************   METHODES **********************

    //toString -> retourne nom, image, vie et force.

    public String toString() {
        return
                "Nom du magicien : " + this.nom
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


    //**********************   SETTERS  ***********************


    public void setNom(String nom) {
        if (!nom.equals("")) {
            this.nom = nom;
        } else {
            this.nom = "Harry";
        }
    }

    public void setVie(int vie) {
        if (vie >= 3 && vie <= 6) {
            this.vie = vie;
        } else if (vie > 6) {
            this.vie = 6;
        } else {
            this.vie = 3;
        }
    }

    public void setForce(int force) {
        if (force >= 8 && force <= 15) {
            this.force = force;
        } else if (force > 15) {
            this.force = 15;
        } else {
            this.force = 8;
        }
    }

}
