package com.company.personnages;

/**
 * classe enfant de Heros
 */
public class Magicien extends Heros {

    //*****************  VARIABLES  (public)  ************************

//    private String nom;
//    private int vie; //(3-6)
//    private int force; //(8-15)


    //**************    CONSTRUCTEURS   *******************************

    public Magicien() {
        //super("Inconnu", 3, 8, "??", "??");
        this("Inconnu");

    }

    public Magicien(String pickNom) {
        //super(pickNom, 3, 8, "??", "??");
        this(pickNom,3,8);

    }

    public Magicien(String pickNom, int pickVie, int pickForce) {
        super(pickNom, pickVie, pickForce, "??", "??");

    }

    //*****************   METHODES **********************

    //toString -> retourne nom, image, vie et force.

    /**
     *
     * @return Magicien en plus du toString du parent
     */
    @Override
    public String toString() {
        return "--> Magicien\n" + super.toString();

    }


    //************** GETTERS  ******************


//    public String getNom() {
//        return nom;
//    }
//
//    public int getVie() {
//        return vie;
//    }
//
//    public int getForce() {
//        return force;
//    }


    //**********************   SETTERS  ***********************


    /**
     *
     * @param nom String
     */
    public void setNom(String nom) {
        if (!nom.equals("")) {
            super.nom = nom;
        } else {
            super.nom = "Harry";
        }
    }

    /**
     * verifie si la vie est bien comprise entre 3 et 6 sinon vie = vieMin ou vieMax
     * @param vie int
     */
    public void setVie(int vie) {
        if (vie >= 3 && vie <= 6) {
            super.vie = vie;
        } else if (vie > 6) {
            super.vie = 6;
        } else {
            super.vie = 3;
        }
    }

    /**
     * verifie si la force est bien comprise entre 8 et 15 sinon force = forceMin ou forceMax
     * @param force int
     */
    public void setForce(int force) {
        if (force >= 8 && force <= 15) {
            super.force = force;
        } else if (force > 15) {
            super.force = 15;
        } else {
            super.force = 8;
        }
    }

}
