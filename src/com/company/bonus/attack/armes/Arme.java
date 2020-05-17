package com.company.bonus.attack.armes;

import com.company.bonus.attack.Attack;
import com.company.personnages.*;


public abstract class Arme extends Attack {

    public Arme(String name, int force) {
        super(name, force);
    }

    @Override
    public void interact (Heros h) {
        if (h instanceof Magicien){
            System.out.println("Nouveau sort pour ton Magicien : " + this.name);
        } else if (h instanceof Guerrier) {
            System.out.println("Pas de sort pour un Guerrier !");
        }
    }
}
