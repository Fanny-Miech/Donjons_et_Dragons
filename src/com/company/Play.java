package com.company;

import java.lang.Math;

public class Play {

    int nbCase = 64;
    int playerCase = 0;


    public int dice() {
        int dice = 1 + (int)(Math.random()*6);
        return dice;
    }

    public void playGame() {
        while (playerCase < nbCase) {
            int newDice = this.dice();
            System.out.println(newDice);
            playerCase += newDice;
            System.out.println("Ton perso se trouve sur la case " + playerCase + "/64.");

        }

    }
}
