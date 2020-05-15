package com.company.contrats;

import com.company.contrats.Event;
import com.company.personnages.Heros;

public class Bonus implements Event {
    @Override
    public void interact(Heros h) {
        System.out.println("Voilà des bonus");
    }
}
