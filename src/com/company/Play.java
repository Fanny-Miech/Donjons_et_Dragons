package com.company;

import com.company.contrats.Event;
import com.company.personnages.*;

import java.lang.Math;

import java.util.ArrayList;
import java.util.Scanner;

public class Play {

    int nbCase = 64;
    int playerCase = 1;
    int lap = 1;


    //**********************************************************************
    //                JET DE DES
    //********************************************************************

    public int dice() {
        return 1 + (int) (Math.random() * 6);
    }

    //****************************************************************************
    //                PLAYGAME
    //*****************************************************************************


    public void playGame(Heros perso) {

        PlateauDeJeu plateauDeJeu = new PlateauDeJeu(nbCase);
        ArrayList<Event> plateau = plateauDeJeu.getPlateau();

        Scanner sc = new Scanner(System.in);


        try {
            while (playerCase < nbCase) {


                sc.nextLine();

                int newDice = this.dice();
                System.out.println("Dé : " + newDice);

                playerCase = this.move(newDice);

                System.out.println("Tour n° : " + lap + "\nTon perso se trouve sur la case " + playerCase + "/64.");

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


    public int move(int dice) throws PersonnageHorsPlateauException {
        if (playerCase + dice > nbCase)
            throw new PersonnageHorsPlateauException();
        else {
            return playerCase + dice;
        }
    }
}


