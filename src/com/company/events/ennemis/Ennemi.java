package com.company.events.ennemis;

import com.company.contrats.Event;
import com.company.personnages.Heros;

public abstract class Ennemi implements Event {

    //**************  ATRIBUTS  ********************

    protected int vie;
    protected int attaque;

    //************  CONSTRUCTEURS  ************************

    public Ennemi() {
        this(0,0);
    }

    public Ennemi(int pvie, int pattaque){
        this.vie = pvie;
        this.attaque = pattaque;
    }

    //*****************  METHODS  *****************************

    //La méthode interact() fait partie du contrat entre interface et implements.
    @Override
    public void interact(Heros h) {
        System.out.println("// Ennemi --> ");
    }

    //*************** GETTER  ***********************


    public int getVie() {
        return vie;
    }

    public int getAttaque() {
        return attaque;
    }

    //******************  SETTER  ************************


    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

}
