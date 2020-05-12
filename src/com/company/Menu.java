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
                    System.out.println("\nTu peux maintenant créer ton Guerrier !");
                    playerPerso = this.createYourWarrior();
                    break;
                case "Magicien":
                    System.out.println("Tu as choisi le Magicien.");
                    isReady = true;
                    System.out.println("\nTu peux maintenant créer ton Magicien !");
                    playerPerso = this.createYourWizard();
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


    /**
     *
     *
     *
     * @return un nouveau Guerrier
     */


    public Object createYourWarrior() {

        Guerrier guerrier = new Guerrier();

        /**
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
                case "Echap":
                    System.out.println("Tu as quitté le jeu ! A bientôt :)");
                    okName = true;
                    break;
                case "":
                    guerrier.setNom("Inconnu");
                    okName = true;
                    break;
                default:
                    guerrier.setNom(guerrierName);
                    okName = true;

            }
        }

        /**
         * choisir une image pour le nouveau Guerrier :: j'ai mis un boolean pour les vérifs regex plus tard....
         */
        boolean okImage = false;

        while (!okImage) {

            System.out.println("\nChoisis maintenant une image : ");

            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable nom du guerrier input
            String guerrierImage = scanner.nextLine();


            switch (guerrierImage) {
                case "Echap" -> {
                    System.out.println("Tu as quitté le jeu ! A bientôt :)");
                    okImage = true;
                }
                case "" -> {
                    guerrier.setImage("Inconnu");
                    okImage = true;
                }
                default -> {
                    guerrier.setImage(guerrierImage);
                    okImage = true;
                }
            }
        }

        /**
         * choisir les points de vie du nouveau guerrier
         */
        boolean okVie = false;

        System.out.println("\nChoisis maintenant ses points de vie (entre 5 et 10) : ");

        while (!okVie) {
            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable nom du guerrier input
            int guerrierVie = scanner.nextInt();


            if (guerrierVie < 5 || guerrierVie > 10) {
                System.out.println("Merci d'entrer des points de vie entre 5 et 10 :");
            }
            else if (guerrierVie >=5 && guerrierVie <= 10) {
                guerrier.setVie(guerrierVie);
                okVie = true;
            }

        }

        /**
         * choisir la force du nouveau guerrier
         */
        boolean okForce = false;

        System.out.println("\nPour finir choisis sa force (entre 5 et 10) : ");

        while (!okForce) {
            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable nom du guerrier input
            int guerrierForce = scanner.nextInt();


            if (guerrierForce < 5 || guerrierForce > 10) {
                System.out.println("Merci d'entrer une force entre 5 et 10 :");
            }
            else if (guerrierForce >=5 && guerrierForce <= 10) {
                guerrier.setForce(guerrierForce);
                okForce = true;
            }

        }


        System.out.println(guerrier.toString());
        return guerrier;
    }

    public Object createYourWizard() {
        Magicien magicien = new Magicien();

        /**
         * choisir un nom pour le nouveau Guerrier :: j'ai mis un boolean pour les vérifs regex plus tard....
         */
        boolean okName = false;

        while (!okName) {

            System.out.println("\nChoisis un nom pour ton Magicien : ");

            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable nom du magicien input
            String magicienName = scanner.nextLine();


            switch (magicienName) {
                case "Echap":
                    System.out.println("Tu as quitté le jeu ! A bientôt :)");
                    okName = true;
                    break;
                case "":
                    magicien.setNom("Inconnu");
                    okName = true;
                    break;
                default:
                    magicien.setNom(magicienName);
                    okName = true;

            }
        }

        /**
         * choisir une image pour le nouveau magicien:: j'ai mis un boolean pour les vérifs regex plus tard....
         */
        boolean okImage = false;

        while (!okImage) {

            System.out.println("\nChoisis maintenant une image : ");

            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable nom du guerrier input
            String magicienImage = scanner.nextLine();


            switch (magicienImage) {
                case "Echap" -> {
                    System.out.println("Tu as quitté le jeu ! A bientôt :)");
                    okImage = true;
                }
                case "" -> {
                    magicien.setImage("Inconnu");
                    okImage = true;
                }
                default -> {
                    magicien.setImage(magicienImage);
                    okImage = true;
                }
            }
        }

        /**
         * choisir les points de vie du nouveau guerrier
         */
        boolean okVie = false;

        System.out.println("\nChoisis maintenant ses points de vie (entre 3 et 6) : ");

        while (!okVie) {
            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable nom du guerrier input
            int magicienVie = scanner.nextInt();


            if (magicienVie < 3 || magicienVie > 6) {
                System.out.println("Merci d'entrer des points de vie entre 3 et 6 :");
            }
            else if (magicienVie >=3 && magicienVie <= 6) {
                magicien.setVie(magicienVie);
                okVie = true;
            }

        }

        /**
         * choisir la force du nouveau guerrier
         */
        boolean okForce = false;

        System.out.println("\nPour finir choisis sa force (entre 8 et 15) : ");

        while (!okForce) {
            //Instancie un nouveau scanner
            Scanner scanner = new Scanner(System.in);
            //nouvelle variable nom du magicien input
            int magicienForce = scanner.nextInt();


            if (magicienForce < 8 || magicienForce > 15) {
                System.out.println("Merci d'entrer une force entre 8 et 15 :");
            }
            else if (magicienForce >=8 && magicienForce <= 15) {
                magicien.setForce(magicienForce);
                okForce = true;
            }

        }

        System.out.println(magicien.toString());
        return magicien;
    }
}
