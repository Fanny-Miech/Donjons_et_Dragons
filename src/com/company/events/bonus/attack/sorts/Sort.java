package com.company.events.bonus.attack.sorts;

import com.company.events.bonus.attack.Attack;
import com.company.personnages.*;

/**
 * classe abstraite fille de Attack
 */
public abstract class Sort extends Attack {

    /**
     * constructeur avec parametres
     *
     * @param name  String
     * @param force int
     */
    public Sort(String name, int force) {
        super(name, force);
    }

    /**
     * cette methode ajoute des points de force au heros si celui-ci est un Magicien sinon "pas de sort pour un Guerrier"
     *
     * @param h Heros
     */
    @Override
    public void interact(Heros h) {
        this.titleEvent(h);
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
