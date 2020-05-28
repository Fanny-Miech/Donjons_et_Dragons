package com.company.events.bonus.attack.armes;

import com.company.events.bonus.attack.Attack;
import com.company.personnages.*;

/**
 * classe abstraite fille de Attack et parente de Epee et Massue
 */
public abstract class Arme extends Attack {

    /**
     * constructeur avec parametres
     *
     * @param name  String
     * @param force int
     */
    public Arme(String name, int force) {
        super(name, force);
    }

    /**
     * cette methode ajoute des points de force au Heros si celui-ci est un Guerrier sinon 'pas d'arme pour un Magicien'
     *
     * @param h Heros
     */
    @Override
    public void interact(Heros h) {
        this.titleEvent(h);
        //System.out.println("Arme");

        if (h instanceof Guerrier) {
            int force = h.getForce();
            h.setForce(force + this.force);

            System.out.println("\nVoilà une " + this.name + " pour toi " + h.getNom() +
                    ". Elle augmente ta force de frappe de " + this.force + " points."
                    + "\nForce actuelle : " + force + " | Nouvelle force : " + h.getForce());

        } else if (h instanceof Magicien) {
            System.out.println("\nDésolé mais pas d'arme pour les Magiciens");
        }
    }
}
