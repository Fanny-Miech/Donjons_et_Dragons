package com.company;

import com.company.personnages.Heros;

import java.sql.*;

import java.util.Scanner;

/**
 * Cette classe gere le deroulement du jeu
 */
public class Main {

    public static void main(String[] args) {
        // write your code here

//
//        BDD bdd;
//        bdd = new BDD();
//
//        bdd.getHeroes();
//
//        bdd.getHero(2);
//
//        bdd.createHero("Magicien", "test", 1, 1, "aucun");
//
//        bdd.updateHero(4, "Guerrier", "modif_ok", 4, 0, "aucun");
//
//        bdd.deleteHero();
//
//        bdd.clean();


        /**
         * Declare et instancie un scanner qu'on passera en parametre
         */
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
