package com.company;

import com.company.contrats.Bonus;
import com.company.contrats.Ennemi;
import com.company.contrats.Event;
import com.company.contrats.EventEmpty;

import java.util.ArrayList;

public class PlateauDeJeu extends ArrayList {

    int nbCase = 64;
    ArrayList<Event> plateau;

    public PlateauDeJeu() {
        this.plateau = new ArrayList<Event>();
        this.plateau.add(new EventEmpty());
        this.plateau.add(new Ennemi());
        this.plateau.add(new Bonus());

    }

//        for (int i=0; i<nbCase ; i++){
//            plateau.add(new Event());
//
//            switch (i) {
//                case
//            }
//       }


}
