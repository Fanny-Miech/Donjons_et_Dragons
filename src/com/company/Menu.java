package com.company;

//Nécessaire pour lire les input du player

import java.util.Scanner;

public class Menu {

    //method d'accueil sur le plateau de Donjon et dragons
    public void welcome() {
        System.out.println("\n\tBienvenue sur le plateau de Donjon et Dragons !!!");
        System.out.println("\nPrêt à en découdre ?");
        System.out.println("NB : tu peux quitter le jeu à tout moment en tapant 'Echap'.");
    }

    //method début du jeu pour choisir son perso
    public Object chooseYourPerso() {

        boolean isReady = false;
        //petite Phrase d'entrée de jeu : "choisis ton perso
        System.out.println("\nChoisis ton perso (Guerrier / Magicien) : ");
        Object playerPerso = new Object();


        //Tant qu'on n'est pas prêt :
        while (!isReady) {

            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable playerChoice = input du player
            String playerChoice = scanner.nextLine();

            switch (playerChoice) {

                //si playerChoice == Guerrier
                case "Guerrier":
                    System.out.println("Tu as choisi le Guerrier.");
                    isReady = true;
                    //créer un Guerrier
                    playerPerso = this.createAWarrior();
                    break;
                case "Magicien":
                    System.out.println("Tu as choisi le Magicien.");
                    isReady = true;
                    playerPerso = this.createAWizard();
                    break;
                case "Echap":
                    System.out.println("Tu as quitté le jeu ! A bientôt.");
                    isReady = true;
                    break;
                default:
                    System.out.println("Choisis entre Guerrier et Magicien stp :)");
            }

        }
        return playerPerso;

    }


    public Object createAWarrior() {
        Guerrier guerrier = new Guerrier();
        System.out.println(guerrier.toString());
        return guerrier;
    }

    public Object createAWizard() {
        Magicien magicien = new Magicien();
        System.out.println(magicien.toString());
        return magicien;
    }
}
