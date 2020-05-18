package com.company.events.bonus;

import com.company.contrats.Event;
import com.company.personnages.Heros;

/**
 * classe abstraite implements event
 */
public abstract class Bonus implements Event {

    //***************  METHODS  ****************

    /**
     * cette methode fait partie du contrat avec l'interface event
     * ecrit 'caisse surprise' + le nom de la classe du parent de l'event (sort, arme ou potion)
     * getClass().getSuperclass - reflexivite
     *
     * @param h Heros
     */
    @Override
    public void interact(Heros h) {
        //Réflexivité -> getSuperclass() chercher la class du parent.
        System.out.print("// Caisse surprise --> " + this.getClass().getSuperclass().getSimpleName());
    }


}
