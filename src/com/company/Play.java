package com.company;

import com.company.contrats.IEvent;
import com.company.events.EventEmpty;
import com.company.events.ennemis.Ennemi;
import com.company.personnages.*;

import java.lang.Math;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cette classe gere l'algorithme du jeu
 */
public class Play {

    /**
     * Nombre de cases sur le plateau
     */
    private int nbCase = 64;
    /**
     * La position du joueur (quel n° de case ?)
     */
    private int playerCase;
    /**
     * le nombre de tour de jeu
     */
    private int lap = 1;

    /**
     * pour savoir si une partie est en cours
     */
    private boolean play = true;


    //**********************************************************************
    //                JET DE DES
    //********************************************************************

    /**
     * Calcule le lancer de de (1 de)
     *
     * @return une valeur aleatoire entre 1 et 6
     */
    public int dice() {
        return 1 + (int) (Math.random() * 6);
    }

    //****************************************************************************
    //                PLAYGAME
    //*****************************************************************************


    /**
     * Cette methode instancie un nouveau plateau de jeu
     * <p>Elle permet au joueur d'avancer sur le plateau de jeu et d'interagir en fonction des evenements rencontres (ennemi, bonus ou case vide)</p>
     *
     * @param perso Heros - les interactions sont differentes selon s'il s'agit d'un Guerrier ou d'un Magicien
     */
    public void playGame(Heros perso) {

        PlateauDeJeu plateauDeJeu = new PlateauDeJeu(nbCase);
        ArrayList<IEvent> plateau = plateauDeJeu.getPlateau();

        playerCase = perso.getPosition();

        //plateauDeJeu.display(plateau);

        plateauDeJeu.shuffle();
        plateauDeJeu.display(plateau);

        Scanner sc = new Scanner(System.in);


        try {
            while (playerCase <= nbCase && play) {

                sc.nextLine();

                int newDice = this.dice();
                System.out.println("Dé : " + newDice);

                playerCase = this.move(newDice);
                perso.setPosition(playerCase);

                System.out.println("Tour n° : " + lap + "\n" + perso.getNom() + " se trouve sur la case " + playerCase + "/64.");

                plateau.get(playerCase).interact(perso);

                if (plateau.get(playerCase) instanceof Ennemi) {
                    this.interactEnnemy(plateau, perso);
                }

                lap++;
            }

        } catch (
                PersonnageHorsPlateauException e) {
            playerCase = nbCase;
            System.out.println(e.getMessage());
        }

        System.out.println("\nYou WIN !");
        System.out.println();

    }


//**********************************************************************************
//                     MOVE
//********************************************************************************


    /**
     * Cette methode permet au joueur d'avancer sur le plateau en fonction du lancer de de
     *
     * @param dice int
     * @return nouvelle position du joueur
     * @throws PersonnageHorsPlateauException si le joueur sort du plateau de jeu
     */
    public int move(int dice) throws PersonnageHorsPlateauException {
        if (playerCase + dice > nbCase)
            throw new PersonnageHorsPlateauException();
        else {
            return playerCase + dice;
        }
    }


//*************************************************************************
//                     INTERACT ENNEMI
//****************************************************************************

    /**
     * Cette methode interagit avec le perso s'il tombe sur une case Ennemi :
     * Cette methode demande au joueur s'il veut se battre -
     * si oui : fight ! et si l'ennemi meurt on remplace la case par une case vide.
     * si non : le joueur recule de random case (entre 1 et 6).
     *
     * @param plateau ArrayList
     * @param perso   Heros
     */
    public void interactEnnemy(ArrayList<IEvent> plateau, Heros perso) {

        while (plateau.get(playerCase) instanceof Ennemi) {

            boolean isEnnemi = true;

            Ennemi ennemi = (Ennemi) plateau.get(playerCase); //caste l'ennemi IEvent en Ennemi -> force la classe

            while (perso.getVie() > 0 && ennemi.getVie() > 0 && isEnnemi) {

                //demande au joueur s'il veut se battre ou fuir + récupère et test l'input
                System.out.println("Ta vie : " + perso.getVie() + " | ta force : " + perso.getForce()
                        + "\nVeux-tu te battre ?  (o/n)");
                Scanner scanner = new Scanner(System.in);
                String toDo = scanner.nextLine();
                Menu.toQuit(toDo);

                //si le joueur veut se battre -- fight !
                if (toDo.equals("o")) {
                    ennemi.fight(perso);
                    //si l'ennemi meurt remplacer la case par une case vide
                    if (ennemi.getVie() == 0) {
                        plateau.set(playerCase, new EventEmpty());
                    }
                } else { //sinon il recule (goAway
                    perso.setPosition(ennemi.goAway(perso));
                    playerCase = perso.getPosition();
                    plateau.get(playerCase).interact(perso);

                    isEnnemi = false;
                }
            }
        }
    }
}

