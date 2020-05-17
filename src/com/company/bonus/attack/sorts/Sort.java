package com.company.bonus.attack.sorts;

import com.company.bonus.attack.Attack;
import com.company.personnages.*;

public abstract class Sort extends Attack {

    public Sort(String name, int force) {
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
