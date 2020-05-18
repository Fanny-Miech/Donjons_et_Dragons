package com.company.events.bonus;

import com.company.contrats.Event;
import com.company.personnages.Heros;

public abstract class Bonus implements Event {

    //***************  METHODS  ****************

    //Dans le contrat interface/implements
    @Override
    public void interact(Heros h) {
        //Réflexivité -> getSuperclass() chercher la class du parent.
        System.out.print("// Caisse surprise --> " + this.getClass().getSuperclass().getSimpleName());
    }


}
