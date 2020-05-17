package com.company.events.bonus.attack.armes;

import com.company.events.bonus.attack.Attack;
import com.company.personnages.*;


public abstract class Arme extends Attack {

    public Arme(String name, int force) {
        super(name, force);
    }

//    @Override
//    public void interact (Heros h) {
//        if (h instanceof Magicien){
//            System.out.println("Nouvelle Arme pour ton Guerrier : " + this.name);
//        } else if (h instanceof Guerrier) {
//            System.out.println("Pas d'Arme pour un Magicien !");
//        }
//    }

    @Override
    public void interact(Heros h) {
        super.interact(h);
        System.out.println("Arme");

        if (h instanceof Guerrier) {
            int force = h.getForce();
            h.setForce(force + this.force);

            System.out.println("Voilà une " + this.name + " pour " + h.getNom() +
                    ". Elle augmente ta force de frappe de " + this.force + " points."
                    + "\nForce actuelle : " + force + " | Nouvelle force : " + h.getForce());

        } else if (h instanceof Magicien) {
            System.out.println("Désolé mais pas d'arme pour les Magiciens");
        }
    }
}
