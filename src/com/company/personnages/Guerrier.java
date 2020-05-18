package com.company.personnages;

/**
 * classe fille de heros
 */
public class Guerrier extends Heros {

    //*****************  ATTRIBUTS  (public)  ************************

//    private String nom;
//    private int vie; //(5-10)
//    private int force;//(5-10)


    //**************    CONSTRUCTEURS   *******************************

    public Guerrier() {
            //super("Inconnu", 5, 5, "??", "??");
        this("Inconnu");

        }

    public Guerrier(String pickNom) {
            //super(pickNom, 5, 5, "??", "??");
        this(pickNom, 5, 5);

        }

    public Guerrier(String pickNom, int pickVie, int pickForce) {
            super(pickNom, pickVie, pickForce, "??", "??");

        }

    //*****************   METHODES **********************

    //toString -> retourne nom, image, vie et force.

    /**
     *
     * @return string ajoute la classe du heros a la methode super.toString()
     */
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

    /**
     *
     * @param nom String
     */
    public void setNom(String nom) {

        if (!nom.equals("")) {
            super.nom = nom;
        } else {
            super.nom = "Ninja";
        }
    }

    /**
     * verifie si la vie est bien comprise entre 5 et 10 sinon vie = vieMin ou vieMax
     * @param vie int
     */
    public void setVie(int vie) {
        if (vie >= 5 && vie <= 10) {
            super.vie = vie;
        } else if (vie > 10) {
            super.vie = 10;
        } else {
            super.vie = 5;
        }
    }

    /**
     * verifie si la force est bien comprise entre 5 et 10 sinon force = forceMin ou forceMax
     * @param force int
     */
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
