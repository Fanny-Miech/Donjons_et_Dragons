package com.company.events;

import com.company.contrats.IEvent;
import com.company.personnages.Heros;

public class EventEmpty implements IEvent {
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
