package com.company.events.bonus.attack.sorts;

import com.company.events.bonus.attack.Attack;
import com.company.personnages.*;

public abstract class Sort extends Attack {

    public Sort(String name, int force) {
        super(name, force);
    }

//    @Override
//    public void interact (Heros h) {
//        if (h instanceof Magicien){
//            System.out.println("Nouveau sort pour ton Magicien : " + this.name);
//        } else if (h instanceof Guerrier) {
//            System.out.println("Pas de sort pour un Guerrier !");
//        }
//    }

    @Override
    public void interact(Heros h) {
        super.interact(h);
        //System.out.println("Sort");

        if (h instanceof Magicien) {
            int force = h.getForce();
            h.setForce(force + this.force);

            System.out.println("\nVoilà un sort " + this.name + " pour toi " + h.getNom() +
                    ". Il augmente ta force de frappe de " + this.force + " points."
                    + "\nForce actuelle : " + force + " | Nouvelle force : " + h.getForce());

        } else if (h instanceof Guerrier) {
            System.out.println("\nDésolé mais pas de sort pour les Guerriers");
        }
    }
}
