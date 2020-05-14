package com.company.personnages;

public class Guerrier extends Heros {

    //*****************  ATTRIBUTS  (public)  ************************

//    private String nom;
//    private int vie; //(5-10)
//    private int force;//(5-10)


    //**************    CONSTRUCTEURS   *******************************

    public Guerrier() {
            super("Inconnu", 3, 8, "??", "??");

        }

    public Guerrier(String pickNom) {
            super(pickNom, 5, 5, "??", "??");

        }

    public Guerrier(String pickNom, int pickVie, int pickForce) {
            super(pickNom, pickVie, pickForce, "??", "??");

        }

    //*****************   METHODES **********************

    //toString -> retourne nom, image, vie et force.

    @Override
    public String toString() {
        return "--> Guerrier\n" + super.toString();

    }


    //***********    ACCESSEURS     (Getters)  ************************

//    //Retourne le nom du guerrier
//    public String getNom() {
//        return nom;
//    }
//
//    //Retourne la vie du guerrier
//    public int getVie() {
//        return vie;
//    }
//
//    //Retourne la force du guerrier
//    public int getForce() {
//        return force;
//    }


    //*********************   MUTATEURS   (setters)  ****************************

    public void setNom(String nom) {

        if (!nom.equals("")) {
            super.nom = nom;
        } else {
            super.nom = "Ninja";
        }
    }

    public void setVie(int vie) {
        if (vie >= 5 && vie <= 10) {
            super.vie = vie;
        } else if (vie > 10) {
            super.vie = 10;
        } else {
            super.vie = 5;
        }
    }

    public void setForce(int force) {
        if (force >= 5 && force <= 10) {
            super.force = force;
        } else if (force > 10) {
            super.force = 10;
        } else {
            super.force = 5;
        }
    }

}
