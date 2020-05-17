package com.company;

import com.company.personnages.*;

//Nécessaire pour lire les input du player
import java.util.Scanner;

public class Menu {


    //*********************************************************************
    //                      WELCOME
    //******************************************************************


    public void welcome() {
        System.out.println("\n---------------------------------------------------------------------" +
                "\n\tBienvenue sur le plateau de Donjon et Dragons !!!" +
                "\n---------------------------------------------------------------------");
        System.out.println("\nPrêt à en découdre ?");
        System.out.println("\nNB : tu peux quitter le jeu à tout moment en tapant 'q'.");
    }


    //****************************************************************
    //                   TO QUIT
    //*****************************************************************

    public void toQuit(String str) {
        if (str.equals("q")) {
            System.out.println("Tu as quitté le jeu ! A bientôt.");
            System.exit(0);
        }
    }

    //*******************************************************************************
    //                   CHOIX DU PERSO
    //*************************************************************************************


    public Heros chooseYourPerso(Scanner scanner) {

        boolean isReady = false;
        //petite Phrase d'entrée de jeu : "choisis ton perso
        System.out.print("\nChoisis ton perso (Guerrier / Magicien) : ");
        Heros playerPerso = null;


        //Tant qu'on n'est pas prêt :
        while (!isReady) {


            //nouvelle variable playerChoice = input du player
            String playerChoice = scanner.nextLine();
            this.toQuit((playerChoice));


            //Vérif des inputs
            switch (playerChoice) {
                case "Guerrier" -> {
                    System.out.println("------> Tu as choisi le Guerrier.");
                    isReady = true;
                    System.out.println("\n-------------------------------------\nTu peux maintenant créer ton Guerrier !");
                    playerPerso = this.createYourHeros(scanner, playerChoice);
                    //playerPerso = this.createYourWarrior();
                }
                case "Magicien" -> {
                    System.out.println("------> Tu as choisi le Magicien.");
                    isReady = true;
                    System.out.println("\n--------------------------------------\nTu peux maintenant créer ton Magicien !");
                    playerPerso = this.createYourHeros(scanner, playerChoice);
                    //playerPerso = this.createYourWizard();
                }
                default -> System.out.println("Choisis entre Guerrier et Magicien stp :)");
            }

        }

        System.out.println("-----------------------------------------\nVeux-tu modifier ton perso ? (o/n) ");
        String modif = scanner.nextLine();
        this.toQuit(modif);
        if (modif.equals("o")) {
            playerPerso = modifHeros(scanner, playerPerso);
        }

        return playerPerso;

    }

    //********************************************************
    //              LANCEMENT DU JEU
    //**********************************************************

    public void readyToPlay(Heros perso) {
        System.out.println("\n-------------------------------------------\nOn lance le jeu ? (o/n)");
        Scanner scanner = new Scanner(System.in);
        String play = scanner.nextLine();
        this.toQuit(play);
        if (play.equals("o") || play.equals("")) {
            Play play1 = new Play();
            play1.playGame(perso);
        } else {
            System.exit(0);
        }
    }


    //*******************************************************************************
    //               CREATE YOUR HEROS
    //*************************************************************************************

    public Heros createYourHeros(Scanner scanner, String type) {
        Heros yourHeros;

        //--------------------------------------------------------------------------------
        //Saisir l'input du player pour construire son Heros
        //--------------------------------------------------------------------------------

        //récupère input name
        System.out.print("\nChoisis un nom pour ton " + type + " : ");
        String herosName = scanner.nextLine();
        this.toQuit(herosName);


        //récupère input vie
        String vie;
        if (type.equals("Guerrier")) {
            vie = "(entre 5 et 10)";
        } else {
            vie = "(entre 3 et 6)";
        }
        System.out.print("Choisis une force de vie pour ton " + type + " " + vie + " : ");
        String herosVie = scanner.nextLine();
        this.toQuit(herosVie);

        //récupérer input force
        String force;
        if (type.equals("Guerrier")) {
            force = "(entre 5 et 10)";
        } else {
            force = "(entre 8 et 15)";
        }
        System.out.print("Choisis une force d'attaque pour ton " + type + " " + force + " : ");
        String herosForce = scanner.nextLine();
        this.toQuit(herosForce);


        //---------------------------------------------------------------------------
        //Vérif des inputs et construction d'un Heros en fonction des input
        //-----------------------------------------------------------------------------

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
                yourHeros = new Magicien(herosName, Integer.parseInt(herosVie), Integer.parseInt(herosForce));
            }

        }

        System.out.println("\nVoilà ton Héros : " + yourHeros.toString());
        return yourHeros;
    }

    //**********************************************************************
    //                  MODIF HEROS
    //*************************************************************************


    public Heros modifHeros(Scanner scanner, Heros heros) {

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
            heros.setVie(Integer.parseInt(newVie));
        }

        System.out.println("Force actuelle : " + heros.getForce() + " //Nouvelle force : ");
        String newForce = scanner.nextLine();
        this.toQuit(newForce);
        if (!newForce.equals("")) {
            heros.setForce(Integer.parseInt(newForce));
        }

        System.out.println(heros.toString());
        return heros;
    }



    //******************************************************************************************************************
    //
    //*********************************  OBSOLETE  ********************************************************************
    //
    //******************************************************************************************************************


    //**********************************************************************************
    //               CREATE WARRIOR
    //**********************************************************************************


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
    //                CREATE MAGICIEN
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
