package com.company.bonus;

import com.company.contrats.Event;
import com.company.personnages.Heros;

public abstract class Bonus implements Event {

    //***************  METHODS  ****************

    //Dans le contrat interface/implements
    @Override
    public void interact(Heros h) {
        System.out.println("Caisse surprise");
    }


}
