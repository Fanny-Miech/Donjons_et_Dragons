package com.company;

//Nécessaire pour lire les input du player

import com.company.personnages.*;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    //*********************************************************************
    //***************************** WELCOME  ****************************
    //******************************************************************


    public void welcome() {
        System.out.println("\n\tBienvenue sur le plateau de Donjon et Dragons !!!");
        System.out.println("\nPrêt à en découdre ?");
        System.out.println("NB : tu peux quitter le jeu à tout moment en tapant 'Echap'.");
    }


    //****************************************************************
    //********************* TO QUIT  *********************************
    //*****************************************************************

    public void toQuit(String str) {
        if (str.equals("q")) {
            System.out.println("Tu as quitté le jeu ! A bientôt.");
            System.exit(0);
        }
    }

    //*******************************************************************************
    //*************************  CHOIX DU PERSO  ****************************************
    //*************************************************************************************


    public Heros chooseYourPerso() {

        boolean isReady = false;
        //petite Phrase d'entrée de jeu : "choisis ton perso
        System.out.println("\nChoisis ton perso (Guerrier / Magicien) : ");
        Heros playerPerso = null;

        //Instancie un nouveau scanner
        Scanner scanner = new Scanner(System.in);

        //Tant qu'on n'est pas prêt :
        while (!isReady) {


            //nouvelle variable playerChoice = input du player
            String playerChoice = scanner.nextLine();
            this.toQuit((playerChoice));


            //Vérif des inputs
            switch (playerChoice) {
                case "Guerrier" -> {
                    System.out.println("Tu as choisi le Guerrier.");
                    isReady = true;
                    System.out.println("\nTu peux maintenant créer ton Guerrier !");
                    playerPerso = this.createYourHeros(playerChoice);
                    //playerPerso = this.createYourWarrior();
                }
                case "Magicien" -> {
                    System.out.println("Tu as choisi le Magicien.");
                    isReady = true;
                    System.out.println("\nTu peux maintenant créer ton Magicien !");
                    playerPerso = this.createYourHeros(playerChoice);
                    //playerPerso = this.createYourWizard();
                }
                default -> System.out.println("Choisis entre Guerrier et Magicien stp :)");
            }

        }

        System.out.println("Veux-tu modifier ton perso ? (o/n) ");
        String modif = scanner.nextLine();
        this.toQuit(modif);
        if (modif.equals("o")) {
            playerPerso = modifHeros(playerPerso);
        }

        System.out.println("On lance le jeu ?");
        Play play = new Play();
        play.playGame();


        return playerPerso;

    }


    //*******************************************************************************
    //******************* CREATE YOUR HEROS *******************************************
    //*************************************************************************************

    public Heros createYourHeros(String type) {
        Heros yourHeros;

        //*************************************************************************
        //Saisir l'input du player pour construire son Heros
        //**********************************************************************************



        //récupère input name
        System.out.println("\nChoisis un nom pour ton " + type + " : ");
        String herosName = scanner.nextLine();
        this.toQuit(herosName);


        //récupère input vie
        String vie;
        if (type.equals("Guerrier")) {
            vie = "(entre 5 et 10)";
        } else {
            vie = "(entre 3 et 6)";
        }
        System.out.println("\nChoisis une force de vie pour ton " + type + " " + vie + " : ");
        String herosVie = scanner.nextLine();
        this.toQuit(herosVie);

        //récupérer input force
        String force;
        if (type.equals("Guerrier")) {
            force = "(entre 5 et 10)";
        } else {
            force = "(entre 8 et 15)";
        }
        System.out.println("\nChoisis une force d'attaque pour ton " + type + " " + force + " : ");
        String herosForce = scanner.nextLine();
        this.toQuit(herosForce);


        //**************************************************************************************
        //Vérif des inputs et construction d'un Her Magicien en fonction des input
        //****************************************************************************************

        if (herosName.equals("") && herosVie.equals("") && herosForce.equals("")) {
            if (type.equals("Guerrier")) {
                yourHeros = new Guerrier();
            } else {
                yourHeros = new Magicien();
            }

        } else if (!herosName.equals("") && herosVie.equals("") && herosForce.equals("")) {
            if (type.equals("Guerrier")) {
                yourHeros = new Guerrier(herosName);
            } else {
                yourHeros = new Magicien(herosName);
            }
        } else {
            if (type.equals("Guerrier")) {
                if (Integer.parseInt(herosVie) > 10) {
                    herosVie = "10";
                } else if (Integer.parseInt(herosVie) < 5) {
                    herosVie = "5";
                }
                if (Integer.parseInt(herosForce) > 10) {
                    herosForce = "10";
                } else if (Integer.parseInt(herosForce) < 5) {
                    herosForce = "5";
                }
                yourHeros = new Guerrier(herosName, Integer.parseInt(herosVie), Integer.parseInt(herosForce));
            } else {
                if (Integer.parseInt(herosVie) > 6) {
                    herosVie = "6";
                } else if (Integer.parseInt(herosVie) < 3) {
                    herosVie = "3";
                }
                if (Integer.parseInt(herosForce) > 15) {
                    herosForce = "15";
                } else if (Integer.parseInt(herosForce) < 8) {
                    herosForce = "8";
                }
                yourHeros = new Guerrier(herosName, Integer.parseInt(herosVie), Integer.parseInt(herosForce));
            }

        }

        System.out.println(yourHeros.toString());
        return yourHeros;
    }

    //**********************************************************************
    //***************  MODIF HEROS  ******************************************
    //*************************************************************************


    public Heros modifHeros(Heros heros) {

        System.out.println("Nom actuel : " + heros.getNom() + " //Nouveau nom : ");
        String newName = scanner.nextLine();
        this.toQuit(newName);
        if (!newName.equals("")) {
            heros.setNom(newName);
        }

        System.out.println("Vie actuelle : " + heros.getVie() + " //Nouvelle vie : ");
        String newVie = scanner.nextLine();
        this.toQuit(newVie);
        if (!newVie.equals("")) {
            heros.setNom(newVie);
        }

        System.out.println("Force actuelle : " + heros.getForce() + " //Nouvelle force : ");
        String newForce = scanner.nextLine();
        this.toQuit(newForce);
        if (!newForce.equals("")) {
            heros.setNom(newForce);
        }

        System.out.println(heros.toString());
        return heros;
    }

    //**********************************************************************************
    //************* CREATE WARRIOR *******************************
    //**********************************************************************


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
        } else if (!guerrierName.equals("") && guerrierVie.equals("") && guerrierForce.equals("")) {
            guerrier = new Guerrier(guerrierName);
        } else {
            if (Integer.parseInt(guerrierVie) > 10) {
                guerrierVie = "10";
            } else if (Integer.parseInt(guerrierVie) < 5) {
                guerrierVie = "5";
            }
            if (Integer.parseInt(guerrierForce) > 10) {
                guerrierForce = "10";
            } else if (Integer.parseInt(guerrierForce) < 5) {
                guerrierForce = "5";
            }
            guerrier = new Guerrier(guerrierName, Integer.parseInt(guerrierVie), Integer.parseInt(guerrierForce));
        }

        System.out.println(guerrier.toString());
        return guerrier;
    }


    //******************************************************************************************
    //*********************  CREATE MAGICIEN  ************************************
    //**************************************************************************************

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
        } else if (!magicienName.equals("") && magicienVie.equals("") && magicienForce.equals("")) {
            magicien = new Magicien(magicienName);
        } else {
            if (Integer.parseInt(magicienVie) > 6) {
                magicienVie = "6";
            } else if (Integer.parseInt(magicienVie) < 3) {
                magicienVie = "3";
            }
            if (Integer.parseInt(magicienForce) > 15) {
                magicienForce = "15";
            } else if (Integer.parseInt(magicienForce) < 8) {
                magicienForce = "8";
            }
            magicien = new Magicien(magicienName, Integer.parseInt(magicienVie), Integer.parseInt(magicienForce));
        }

        System.out.println(magicien.toString());
        return magicien;
    }
}
