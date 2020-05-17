package com.company;

import com.company.events.bonus.attack.sorts.BouleDeFeu;
import com.company.events.bonus.attack.sorts.Eclair;
import com.company.events.bonus.attack.armes.Epee;
import com.company.events.bonus.attack.armes.Massue;
import com.company.events.bonus.potions.Big;
import com.company.events.bonus.potions.Standard;
import com.company.contrats.Event;
import com.company.events.EventEmpty;
import com.company.events.ennemis.Dragon;
import com.company.events.ennemis.Gobelin;
import com.company.events.ennemis.Sorcier;

import java.util.ArrayList;

public class PlateauDeJeu {

    //*************  ATTRIBUTS  ****************************

    int nbCase = 64;
    ArrayList<Event> plateau;

    //*************  CONSTRUCTEUR  **************************

    public PlateauDeJeu(int nbCase) {
        this.nbCase = nbCase;
        this.plateau = new ArrayList<Event>();
        for (int i=0; i<nbCase ; i++){

            Event event;

            switch (i) {
                case 45, 52, 56, 62 :
                    event = new Dragon();
                    break;
                case 10, 20, 25, 32, 35, 36, 37, 40, 44, 47 :
                    event = new Sorcier();
                    break;
                case 3, 6, 9, 12, 15, 18, 21, 24, 27, 30 :
                    event = new Gobelin();
                    break;
                case 2, 11, 5, 22, 38 :
                    event = new Massue();
                    break;
                case 19, 26, 42, 53 :
                    event = new Epee();
                    break;
                case 1, 4, 8, 17, 23 :
                    event = new Eclair();
                    break;
                case 48, 49 :
                    event = new BouleDeFeu();
                    break;
                case 7, 13, 31, 33, 39, 43 :
                    event = new Standard();
                    break;
                case 28, 41 :
                    event = new Big();
                    break;
                default:
                    event = new EventEmpty();
                    break;
            }

            plateau.add(event);
        }

    }

    //**************** GETTER  ************************************
    public int getNbCase() {
        return nbCase;
    }


    public ArrayList<Event> getPlateau() {
        return plateau;
    }

    //*******************  SETTER  **********************************

    public void setPlateau(ArrayList<Event> plateau) {
        this.plateau = plateau;
    }

    public void setNbCase(int nbCase) {
        this.nbCase = nbCase;
    }



}
