package com.company;

import com.company.connection.HerosModel;
import com.company.personnages.Heros;

import java.sql.*;

import java.util.Scanner;

/**
 * Cette classe gere le deroulement du jeu
 */
public class Main {

    public static void main(String[] args) {
        // write your code here

//        HerosModel herosModel;
//        herosModel = new HerosModel();
//
//        herosModel.getHeroes();
//
//        herosModel.getHero(2);
//
//        herosModel.createHero("Magicien", "test", 0, 10, "aucun");
//
//        herosModel.updateHero(9, "Guerrier", "modif_ok", 4, 0, "aucun");
//
//        herosModel.deleteHero();
//
//        herosModel.clear();



        /**
         * Declare et instancie un scanner qu'on passera en parametre
         */

        Ascii.chateau();
        Ascii.title();

        Scanner sc = new Scanner(System.in);


        //Initialise un nouveau jeu
        Menu part1 = new Menu();
        part1.welcome();

        //choix du perso
        Heros perso = part1.doWhat();

        Ascii.dragon();
        if (perso != null) {
            //lancement du jeu
            part1.readyToPlay(perso);
        }

    }

}
