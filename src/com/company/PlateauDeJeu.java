package com.company;

import com.company.bonus.*;
import com.company.contrats.Bonus;
import com.company.contrats.Ennemi;
import com.company.contrats.Event;
import com.company.contrats.EventEmpty;
import com.company.ennemis.Dragon;
import com.company.ennemis.Gobelin;
import com.company.ennemis.Sorcier;
import com.company.personnages.Heros;

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
