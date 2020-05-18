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
import java.util.Collections;
import java.util.Random;

/**
 * Cette classe gere la creation et l'affichage d'un nouveau plateau de jeu
 */
public class PlateauDeJeu {

    //*************  ATTRIBUTS  ****************************

    /**
     * Nombre de case du plateau
     */
    int nbCase;
    /**
     * Le plateau est une ArrayList d'Event
     */
    ArrayList<Event> plateau;

    //*************  CONSTRUCTEURS  **************************

    /**
     *Le constructeur du plateau de jeu instancie un nouveau plateau de jeu en dur avec des events (dragon, Sorcier... ou case vide)
     */
    public PlateauDeJeu(int nbCase) {
        this.nbCase = nbCase;
        this.plateau = new ArrayList<Event>();
        for (int i=1; i<nbCase+1 ; i++){

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


    //******************  METHODS  ***************************************

    /**
     * cette methode melange les cases du pateau existant
     */
    public void shuffle(){
        Collections.shuffle(this.plateau);

    }

    /**
     *cette methode affiche l'evenement qui se trouve sur chaque case du plateau
     */
    public void display(ArrayList<Event> plateau) {

        System.out.println("Voici ton nouveau plateau de jeu : ");
        int i = 1;
        for (Event event : plateau) {
            System.out.println("Case " + i + " : " + event.getClass().getSimpleName());
            i++;
        }
    }

    //**************** GETTER  ************************************

    /**
     *
     * @return le nombre de case du plateau (int)
     */
    public int getNbCase() {
        return nbCase;
    }


    /**
     *
     * @return le plateau (ArrayList)
     */
    public ArrayList<Event> getPlateau() {
        return plateau;
    }

    //*******************  SETTER  **********************************

    /**
     *Permet de modifier l'attribut plateau
     * @param plateau ArrayList<>
     */
    public void setPlateau(ArrayList<Event> plateau) {
        this.plateau = plateau;
    }

    /**
     * permet de modifier l'attribut nbCase
     * @param nbCase int
     */
    public void setNbCase(int nbCase) {
        this.nbCase = nbCase;
    }



}
