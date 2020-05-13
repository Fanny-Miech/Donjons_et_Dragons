package com.company.personnages;

public class Guerrier extends Heros {

    //*****************  ATTRIBUTS  (public)  ************************

    private String nom;
    private int vie; //(5-10)
    private int force;//(5-10)


    //**************    CONSTRUCTEURS   *******************************

    public Guerrier() {
        System.out.println("Création d'un nouveau guerrier.");
        nom = "Inconnu";
        vie = 5;
        force = 5;
    }

    public Guerrier(String nom) {
        System.out.println("Création d'un nouveau guerrier avec un nom.");
        this.nom = nom;
        vie = 5;
        force = 5;

    }

    public Guerrier(String pnom, int pvie, int pforce) {
        System.out.println("Création d'un nouveau guerrier avec des paramètres.");
        nom = pnom;
        vie = pvie;
        force = pforce;

    }

    //*****************   METHODES **********************

    //toString -> retourne nom, image, vie et force.

    public String toString() {
        return
                "Nom du guerrier : " + this.nom
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


    //*********************   MUTATEURS   (setters)  ****************************

    public void setNom(String nom) {

        if (!nom.equals("")) {
            this.nom = nom;
        } else {
            this.nom = "Ninja";
        }
    }

    public void setVie(int vie) {
        if (vie >= 5 && vie <= 10) {
            this.vie = vie;
        } else if (vie > 10) {
            this.vie = 10;
        } else {
            this.vie = 5;
        }
    }

    public void setForce(int force) {
        if (force >= 5 && force <= 10) {
            this.force = force;
        } else if (force > 10) {
            this.force = 10;
        } else {
            this.force = 5;
        }
    }

}
