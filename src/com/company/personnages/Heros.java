package com.company.personnages;

/**
 * Classe abstraite
 * classe mere de tous les personnages Heros du jeu (Guerrier et Magicien)
 */
public abstract class Heros {

    //*****************  ATTRIBUTS  *****************************

    protected String nom;
    protected int vie;
    protected int force;
    protected String attaque;
    protected String defense;


    //*********************** CONSTRUCTEURS  **********************

    public Heros() {
//        nom = "Inconnu";
//        vie = 3;
//        force = 5;
//        attaque = "??";
//        defense = "??";
        this("Inconnu");
    }

    public Heros(String pickNom) {
//        nom = pickNom;
//        vie = 3;
//        force = 5;
//        attaque = "??";
//        defense = "??";
        this(pickNom, 3, 5, "??", "??");
    }

    public Heros(String pickNom, int pickVie, int pickForce, String pickAttaque, String pickDefense) {
        nom = pickNom;
        vie = pickVie;
        force = pickForce;
        attaque = pickAttaque;
        defense = pickDefense;
    }

    //*************  METHODS  ********************

    /**
     *
     * @return String avec le nom, la vie et la force du Heros
     */
    @Override
    public String toString() {
        return  "Nom du Héros : " + this.nom
                + "\nPoints de vie : " + this.vie
                + "\nForce d'attaque : " + this.force;
    }

    //************  GETTERS  ******************


    /**
     *
     * @return nom du Heros (string)
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return vie du heros (int)
     */
    public int getVie() {
        return vie;
    }

    /**
     *
     * @return force du heros (int)
     */
    public int getForce() {
        return force;
    }

    /**
     *
     * @return attaque du heros
     */
    public String getAttaque() {
        return attaque;
    }

    /**
     *
     * @return defense du heros
     */
    public String getDefense() {
        return defense;
    }


    //******************   SETTERS  ***********************


    /**
     *
     * @param nom String
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param vie int
     */
    public void setVie(int vie) {
        this.vie = vie;
    }

    /**
     *
     * @param force int
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     *
     * @param attaque String
     */
    public void setAttaque(String attaque) {
        this.attaque = attaque;
    }

    /**
     *
     * @param defense String
     */
    public void setDefense(String defense) {
        this.defense = defense;
    }

}
