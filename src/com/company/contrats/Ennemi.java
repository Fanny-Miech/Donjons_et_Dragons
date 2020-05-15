package com.company.contrats;

import com.company.contrats.Event;
import com.company.personnages.Heros;

public class Ennemi implements Event {
    private int vie;
    private int attaque;

    public Ennemi() {
        this(0,0);
    }

    public Ennemi(int pvie, int pattaque){
        this.vie = pvie;
        this.attaque = pattaque;
    }

    @Override
    public void interact(Heros h) {
        System.out.println("J'engage le combat");
    }
}
