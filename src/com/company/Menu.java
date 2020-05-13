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
                    playerPerso = this.createYourHeros(playerChoice);
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

        Guerrier guerrier = new Guerrier();

        /*
         * choisir un nom pour le nouveau Guerrier :: j'ai mis un boolean pour les vérifs regex plus tard....
         */
        boolean okName = false;

        while (!okName) {

            System.out.println("\nChoisis un nom pour ton Guerrier : ");

            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable nom du guerrier input
            String guerrierName = scanner.nextLine();


            switch (guerrierName) {
                case "Echap" -> {
                    System.out.println("Tu as quitté le jeu ! A bientôt :)");
                    okName = true;
                }
                case "" -> {
                    guerrier.setNom("Inconnu");
                    okName = true;
                }
                default -> {
                    guerrier.setNom(guerrierName);
                    okName = true;
                }
            }
        }

        /*
         * choisir les points de vie du nouveau guerrier
         */
        boolean okVie = false;

        System.out.println("\nChoisis maintenant ses points de vie (entre 5 et 10) : ");

        while (!okVie) {
            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable nom du guerrier input
            int guerrierVie = scanner.nextInt();


            if (guerrierVie >= 5 && guerrierVie <= 10) {
                guerrier.setVie(guerrierVie);
                okVie = true;
            } else {
                System.out.println("Merci d'entrer des points de vie entre 5 et 10 :");
            }

        }

        /*
         * choisir la force du nouveau guerrier
         */
        boolean okForce = false;

        System.out.println("\nPour finir choisis sa force (entre 5 et 10) : ");

        while (!okForce) {
            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable nom du guerrier input
            int guerrierForce = scanner.nextInt();

            if (guerrierForce >= 5 && guerrierForce <= 10) {
                guerrier.setForce(guerrierForce);
                okForce = true;
            } else {
                System.out.println("Merci d'entrer une force entre 5 et 10 :");
            }

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

        System.out.println("Tu vas créer ton Magicien.");

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
            magicien = new Magicien(magicienName, Integer.parseInt(magicienVie), Integer.parseInt(magicienForce));
        }

       System.out.println(magicien.toString());
        return magicien;
    }
}
