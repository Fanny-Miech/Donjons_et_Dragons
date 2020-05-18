package com.company.events;

import com.company.contrats.Event;
import com.company.personnages.Heros;

public class EventEmpty implements Event {
    /**
     * interaction avec le Heros : ecrit 'case vide'
     *
     * @param h Heros
     */
    @Override
    public void interact(Heros h) {
        System.out.println("// Case vide");
    }
}
