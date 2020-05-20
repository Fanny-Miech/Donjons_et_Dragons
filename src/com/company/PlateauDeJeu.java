package com.company;

import com.company.events.bonus.attack.sorts.BouleDeFeu;
import com.company.events.bonus.attack.sorts.Eclair;
import com.company.events.bonus.attack.armes.Epee;
import com.company.events.bonus.attack.armes.Massue;
import com.company.events.bonus.potions.Big;
import com.company.events.bonus.potions.Standard;
import com.company.contrats.IEvent;
import com.company.events.EventEmpty;
import com.company.events.ennemis.Dragon;
import com.company.events.ennemis.Gobelin;
import com.company.events.ennemis.Sorcier;

import java.util.ArrayList;
import java.util.Collections;

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
    ArrayList<IEvent> plateau;

    //*************  CONSTRUCTEURS  **************************

    /**
     * Le constructeur du plateau de jeu instancie un nouveau plateau de jeu en dur avec des events (dragon, Sorcier... ou case vide)
     *
     * @param nbCase int
     */
    public PlateauDeJeu(int nbCase) {
        this.nbCase = nbCase;
        this.plateau = new ArrayList<IEvent>();
        for (int i = 0; i <= nbCase ; i++) {

            IEvent event;

            switch (i) {
                case 45, 52, 56, 62:
                    event = new Dragon();
                    break;
                case 10, 20, 25, 32, 35, 36, 37, 40, 44, 47:
                    event = new Sorcier();
                    break;
                case 3, 6, 9, 12, 15, 18, 21, 24, 27, 30:
                    event = new Gobelin();
                    break;
                case 2, 11, 5, 22, 38:
                    event = new Massue();
                    break;
                case 19, 26, 42, 53:
                    event = new Epee();
                    break;
                case 1, 4, 8, 17, 23:
                    event = new Eclair();
                    break;
                case 48, 49:
                    event = new BouleDeFeu();
                    break;
                case 7, 13, 31, 33, 39, 43:
                    event = new Standard();
                    break;
                case 28, 41:
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
     * cette methode melange les cases du plateau existant
     */
    public void shuffle() {
        Collections.shuffle(this.plateau);
    }

    /**
     * cette methode affiche l'evenement qui se trouve sur chaque case du plateau
     *
     * @param plateau ArrayList
     */
    public void display(ArrayList<IEvent> plateau) {

        System.out.println("Voici ton nouveau plateau de jeu : ");
        int i = 0;
        for (IEvent event : plateau) {
            System.out.println("Case " + i + " : " + event.getClass().getSimpleName());
            i++;
        }
    }

    //**************** GETTER  ************************************

    /**
     * @return le nombre de case du plateau (int)
     */
    public int getNbCase() {
        return nbCase;
    }


    /**
     * @return le plateau (ArrayList)
     */
    public ArrayList<IEvent> getPlateau() {
        return plateau;
    }

    //*******************  SETTER  **********************************

    /**
     * Permet de modifier l'attribut plateau
     *
     * @param plateau ArrayList
     */
    public void setPlateau(ArrayList<IEvent> plateau) {
        this.plateau = plateau;
    }

    /**
     * permet de modifier l'attribut nbCase
     *
     * @param nbCase int
     */
    public void setNbCase(int nbCase) {
        this.nbCase = nbCase;
    }


}
