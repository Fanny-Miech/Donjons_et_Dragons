package com.company;

import com.company.contrats.Bonus;
import com.company.contrats.Ennemi;
import com.company.contrats.Event;
import com.company.contrats.EventEmpty;
import com.company.personnages.Guerrier;
import com.company.personnages.Heros;
import com.company.personnages.Magicien;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //*********************************
        //         TEST
        //********************************

        Heros heros = new Magicien();

        ArrayList<Event> plateau = new ArrayList<Event>();
        plateau = new ArrayList<Event>();
        plateau.add(new EventEmpty());
        plateau.add(new Ennemi());
        plateau.add(new Bonus());


        for (
                int i = 0; i < plateau.size(); i++) {
            plateau.get(i).interact(heros);
        }


        //**********************************


        //test Menu
        Menu part1 = new Menu();
        part1.welcome();

        //choix du perso
        Heros perso = part1.chooseYourPerso();

        //lancement du jeu
        part1.readyToPlay(perso);


    }


}
