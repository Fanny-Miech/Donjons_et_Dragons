package com.company.events.bonus.attack;

import com.company.events.bonus.Bonus;
import com.company.personnages.Heros;

/**
 * classe abstraite enfant de Bonus et parent de Arme et Sort
 */
public abstract class Attack extends Bonus {

    //*****************  ATTRIBUTS  **************

    /**
     * nom de l'attaque
     */
    protected String name;
    /**
     * force de l'attaque
     */
    protected int force;

    //*****************  CONSTRUCTEURS  *************

    /**
     * constructeur avec parametres
     *
     * @param name  String
     * @param force int
     */
    public Attack(String name, int force) {
        this.name = name;
        this.force = force;
    }

    //***************** METHODS  ********************

    /**
     * cette methode interagit entre l'event et le Heros
     * c'est la meme que pour le parent
     *
     * @param h Heros
     */
//    @Override
//    public void interact(Heros h) {
//        super.interact(h);
//        //System.out.println(super.toString());
//    }

    /**
     * @return nom de cette arme et sa force
     */
    @Override
    public String toString() {
        return "Arme : " + this.name + " // Force d'attaque : " + this.force;
    }

    //*****************  GETTER  ***********************

    /**
     * @return nom de cette attaque
     */
    public String getName() {
        return name;
    }

    /**
     * @return force de cette attaque
     */
    public int getForce() {
        return force;
    }


    //***************** SETTER  *************************

    /**
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param force int
     */
    public void setForce(int force) {
        this.force = force;
    }
}
