package com.company;

import com.company.contrats.Event;
import com.company.personnages.Heros;
import com.company.personnages.Magicien;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);


        //Initialise un nouveau jeu
        Menu part1 = new Menu();
        part1.welcome();

        //choix du perso
        Heros perso = part1.chooseYourPerso(sc);

        //lancement du jeu
        part1.readyToPlay(perso);


    }


}
