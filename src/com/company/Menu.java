package com.company;

//Nécessaire pour lire les input du player

import com.company.personnages.*;

import java.util.Scanner;

public class Menu {

    //method d'accueil sur le plateau de Donjon et dragons
    public void welcome() {
        System.out.println("\n\tBienvenue sur le plateau de Donjon et Dragons !!!");
        System.out.println("\nPrêt à en découdre ?");
        System.out.println("NB : tu peux quitter le jeu à tout moment en tapant 'Echap'.");
    }

    //method début du jeu pour choisir son perso
    public Heros chooseYourPerso() {

        boolean isReady = false;
        //petite Phrase d'entrée de jeu : "choisis ton perso
        System.out.println("\nChoisis ton perso (Guerrier / Magicien) : ");
        Heros playerPerso = new Heros();


        //Tant qu'on n'est pas prêt :
        while (!isReady) {

            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable playerChoice = input du player
            String playerChoice = scanner.nextLine();

            //si playerChoice == Guerrier
            //créer un Guerrier
            switch (playerChoice) {
                case "Guerrier" -> {
                    System.out.println("Tu as choisi le Guerrier.");
                    isReady = true;
                    System.out.println("\nTu peux maintenant créer ton Guerrier !");
                    //playerPerso = this.createYourHeros(playerChoice);
                    playerPerso = this.createYourWarrior();
                }
                case "Magicien" -> {
                    System.out.println("Tu as choisi le Magicien.");
                    isReady = true;
                    System.out.println("\nTu peux maintenant créer ton Magicien !");
                    playerPerso = this.createYourWizard();
                }
                case "Echap" -> {
                    System.out.println("Tu as quitté le jeu ! A bientôt.");
                    isReady = true;
                }
                default -> System.out.println("Choisis entre Guerrier et Magicien stp :)");
            }

        }

        System.out.println("On lance le jeu ?");
        Play play = new Play();
        play.playGame();

        return playerPerso;

    }


    public Heros createYourHeros(String type) {
        Heros yourHeros = new Guerrier();
        return yourHeros;
    }

    /*
     *
     * @return un nouveau Guerrier
     */


    public Guerrier createYourWarrior() {

        Guerrier guerrier;

        // Input nom, vie et force du player

        //Instancie un nouveau scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nChoisis un nom pour ton Guerrier : ");
        //nouvelle variable nom du magicien input
        String guerrierName = scanner.nextLine();
        if (guerrierName.equals("Q")) {
            System.out.println("A bientôt :)");
            System.exit(0);
        }

        System.out.println("\nChoisis une force de vie pour ton Magicien (entre 5 et 10) : ");
        String guerrierVie = scanner.nextLine();
        if (guerrierVie.equals("Q")) {
            System.out.println("A bientôt :)");
            System.exit(0);
        }

        System.out.println("\nChoisis une force d'attaque pour ton Magicien (entre 5 et 10) : ");
        String guerrierForce = scanner.nextLine();
        if (guerrierForce.equals("Q")) {
            System.out.println("A bientôt :)");
            System.exit(0);
        }


        //Vérif des inputs et construction d'un Magicien en fonction des input

        if (guerrierName.equals("") && guerrierVie.equals("") && guerrierForce.equals("")) {
            guerrier = new Guerrier();
        }

        else if (!guerrierName.equals("") && guerrierVie.equals("") && guerrierForce.equals("")) {
            guerrier = new Guerrier(guerrierName);
        }

        else {
            if (Integer.parseInt(guerrierVie)>10) {
                guerrierVie = "10";
            } else if (Integer.parseInt(guerrierVie)<5) {
                guerrierVie = "5";
            }
            if (Integer.parseInt(guerrierForce)>10) {
                guerrierForce = "10";
            } else if (Integer.parseInt(guerrierForce)<5) {
                guerrierForce = "5";
            }
            guerrier = new Guerrier(guerrierName, Integer.parseInt(guerrierVie), Integer.parseInt(guerrierForce));
        }

        System.out.println(guerrier.toString());
        return guerrier;
    }


    /*
     *
     ****@return un nouveau Magicien
     */

    public Magicien createYourWizard() {

        Magicien magicien;

        // Input nom, vie et force du player

        //Instancie un nouveau scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nChoisis un nom pour ton Magicien : ");
        //nouvelle variable nom du magicien input
        String magicienName = scanner.nextLine();
        if (magicienName.equals("Q")) {
            System.out.println("A bientôt :)");
            System.exit(0);
        }

        System.out.println("\nChoisis une force de vie pour ton Magicien (entre 3 et 6) : ");
        String magicienVie = scanner.nextLine();
        if (magicienVie.equals("Q")) {
            System.out.println("A bientôt :)");
            System.exit(0);
        }

        System.out.println("\nChoisis une force d'attaque pour ton Magicien (entre 8 et 15) : ");
        String magicienForce = scanner.nextLine();
        if (magicienForce.equals("Q")) {
            System.out.println("A bientôt :)");
            System.exit(0);
        }


        //Vérif des inputs et construction d'un Magicien en fonction des input

        if (magicienName.equals("") && magicienVie.equals("") && magicienForce.equals("")) {
            magicien = new Magicien();
        }

        else if (!magicienName.equals("") && magicienVie.equals("") && magicienForce.equals("")) {
            magicien = new Magicien(magicienName);
        }

        else {
            if (Integer.parseInt(magicienVie)>6) {
                magicienVie = "6";
            } else if (Integer.parseInt(magicienVie)<3) {
                magicienVie = "3";
            }
            if (Integer.parseInt(magicienForce)>15) {
                magicienForce = "15";
            } else if (Integer.parseInt(magicienForce)<8) {
                magicienForce = "8";
            }
            magicien = new Magicien(magicienName, Integer.parseInt(magicienVie), Integer.parseInt(magicienForce));
        }

       System.out.println(magicien.toString());
        return magicien;
    }
}
