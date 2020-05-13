package com.company.personnages;

public class Magicien extends Heros {

    //*****************  VARIABLES  (public)  ************************

//    private String nom;
//    private int vie; //(3-6)
//    private int force; //(8-15)


    //**************    CONSTRUCTEURS   *******************************

    public Magicien() {
        super("Inconnu", 3, 8, "??", "??");

    }

    public Magicien(String pickNom) {
        super(pickNom, 5, 5, "??", "??");

    }

    public Magicien(String pickNom, int pickVie, int pickForce) {
        super(pickNom, pickVie, pickForce, "??", "??");

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
