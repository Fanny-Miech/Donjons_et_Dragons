package com.company;

import com.company.personnages.Heros;
import com.company.personnages.PersonnageHorsPlateauException;

import java.lang.Math;

import java.util.Scanner;

public class Play {

    int nbCase = 64;
    int playerCase = 1;
    int lap = 1;


    //**********************************************************************
    //                JET DE DES
    //********************************************************************

    public int dice() {
        int dice = 1 + (int) (Math.random() * 6);
        return dice;
    }

    //****************************************************************************
    //                PLAYGAME
    //*****************************************************************************


    public void playGame(Heros perso) {

        PlateauDeJeu plateau = new PlateauDeJeu();
        plateau.toString();



        while (playerCase < nbCase) {

            Scanner sc = new Scanner(System.in);
            sc.nextLine();

            int newDice = this.dice();
            System.out.println("Dé : " + newDice);

            try {
                playerCase = this.move(newDice);
            } catch (PersonnageHorsPlateauException e) {
                playerCase = nbCase;
                System.out.println(e.getMessage());
            }

            System.out.println("Tour n° : " + lap + "\nTon perso se trouve sur la case " + playerCase + "/64.");
            lap++;
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


/// Event event = new Event();
