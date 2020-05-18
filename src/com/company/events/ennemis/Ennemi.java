package com.company.events.ennemis;

import com.company.contrats.Event;
import com.company.personnages.Heros;

/**
 * classe abstraite implement de Event -> doit avoir une methode interact()
 */
public abstract class Ennemi implements Event {

    //**************  ATRIBUTS  ********************

    /**
     * points de vie de l'ennemi
     */
    protected int vie;
    /**
     * force d'attaque
     */
    protected int attaque;

    //************  CONSTRUCTEURS  ************************

    /**
     * constructeur vide : ennemi avec vie et attaque = 0
     */
    public Ennemi() {
        this(0,0);
    }

    /**
     *
     * @param pvie int
     * @param pattaque int
     */
    public Ennemi(int pvie, int pattaque){
        this.vie = pvie;
        this.attaque = pattaque;
    }

    //*****************  METHODS  *****************************

    /**
     * La méthode interact() fait partie du contrat entre interface et implements.
     * elle ecrit le nom de l'ennemi et sa force
     * @param h Heros
     */
    @Override
    public void interact(Heros h) {
        System.out.println("// Ennemi --> " + this.getClass().getSimpleName() + " | Attaque : " + this.getAttaque());
    }

    //*************** GETTER  ***********************


    /**
     *
     * @return vie
     */
    public int getVie() {
        return vie;
    }

    /**
     *
     * @return attaque
     */
    public int getAttaque() {
        return attaque;
    }

    //******************  SETTER  ************************


    /**
     *
     * @param vie int
     */
    public void setVie(int vie) {
        this.vie = vie;
    }

    /**
     *
     * @param attaque int
     */
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

}
