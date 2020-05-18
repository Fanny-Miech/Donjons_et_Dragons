package com.company;

import com.company.contrats.Event;
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
    int nbCase = 64;
    /**
     * La position du joueur (quel n° de case ?)
     */
    int playerCase = 1;
    /**
     * le nombre de tour de jeu
     */
    int lap = 1;


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
        ArrayList<Event> plateau = plateauDeJeu.getPlateau();

        //plateauDeJeu.display(plateau);

        plateauDeJeu.shuffle();

        plateauDeJeu.display(plateau);


        Scanner sc = new Scanner(System.in);


        try {
            while (playerCase < nbCase) {


                sc.nextLine();

                int newDice = this.dice();
                System.out.println("Dé : " + newDice);

                playerCase = this.move(newDice);

                System.out.println("Tour n° : " + lap + "\n" + perso.getNom() + " se trouve sur la case " + playerCase + "/64.");

                plateau.get(playerCase).interact(perso);

                lap++;
            }

        } catch (PersonnageHorsPlateauException e) {
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
}


