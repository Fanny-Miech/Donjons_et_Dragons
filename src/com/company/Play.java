package com.company;

import java.lang.Math;

import java.util.Scanner;

public class Play {

    int nbCase = 64;
    int playerCase = 1;
    int lap = 0;


    public int dice() {
        int dice = 1 + (int)(Math.random()*6);
        return dice;
    }

    public void playGame() {
        while (playerCase < nbCase) {
            int newDice = this.dice();
            System.out.println(newDice);
            playerCase += newDice;
            lap ++;
            System.out.println("Ton perso se trouve sur la case " + playerCase + "/64.");
        }

        System.out.println("You WIN !");
        System.out.println();

    }
}
