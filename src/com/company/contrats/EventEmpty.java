package com.company.contrats;

import com.company.personnages.Heros;

public class EventEmpty implements Event {
    @Override
    public void interact(Heros h) {
        System.out.println("Case vide");
    }
}
