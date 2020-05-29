package com.company;

import com.company.connection.HerosModel;
import com.company.personnages.*;

//Nécessaire pour lire les input du player
import java.util.Scanner;

/**
 * Cette classe gere l'affichage du menu : choix et creation du Heros
 */
public class Menu {

    //private static Scanner scanner;
    private static final Scanner scanner = new Scanner(System.in);


    //*********************************************************************
    //                      WELCOME
    //******************************************************************


    /**
     * Cette methode accueille le joueur sur le plateau de Donjon et Dragons
     */
    public void welcome() {
        System.out.println("\n---------------------------------------------------------------------" +
                "\n\tBienvenue sur le plateau de Donjon et Dragons !!!" +
                "\n---------------------------------------------------------------------");
        System.out.println("\nPrêt à en découdre ?");
        System.out.println("\nNB : tu peux quitter le jeu à tout moment en tapant 'q'.");
    }

    //*************************************************************************
    //                  WHAT DO YOU WANT TO DO ?
    //**************************************************************************

    public Heros doWhat() {
        HerosModel hm;
        hm = new HerosModel();
        Heros heros = null;

        System.out.println("Voici la liste de nos Héros");
        hm.getHeroes();
        System.out.println("\nQue veux-tu faire ?" +
                "\n-> Créer un nouveau héros (cr)" +
                "\n-> Charger un héros existant pour jouer (ch)" +
                "\n-> Modifier un héros (m)" +
                "\n-> Supprimer un héros (s)" +
                "\nTape cr / ch / m ou s");
        String playerChoice = scanner.nextLine();
        toQuit(playerChoice);

        if (playerChoice.equals("cr")) {
            heros = this.chooseYourPerso();
        } else if (playerChoice.equals("ch") || playerChoice.equals("m") || playerChoice.equals("s")) {
            System.out.println("Saisis à présent le numero du personnage que tu as choisi");
            int id = scanner.nextInt();

            switch (playerChoice) {
                case "ch" -> heros = this.loadHerosModel(id);
                case "m" -> this.updateHerosModel(id);
                case "s" -> hm.deleteHero(id);

            }
        } else {
            heros = this.doWhat();
        }

        return heros;

    }


    //****************************************************************
    //                   TO QUIT
    //*****************************************************************

    /**
     * Cette Methode arrete l'execution du code
     *
     * @param str String
     */
    public static void toQuit(String str) {
        if (str.equals("q")) {
            System.out.println("Tu as quitté le jeu ! A bientôt.");
            System.exit(0);
        }
    }

    //*********************************************************************
    //                  REPLAY
    //*********************************************************************

    /**
     * Cette methode demande au joueur s'il veut refaire une partie
     * Auquel cas il recommence avec un nv perso
     *
     * @param h Heros
     */
    public static void replay(Heros h) {
        System.out.println("Veux-tu faire une nouvelle partie ? (o/n)");
        String replay = scanner.nextLine();
        Menu.toQuit(replay);
    }


    //*******************************************************************************
    //                   CHOIX DU PERSO
    //*************************************************************************************


    /**
     * Cette methode demande au joueur de choisir son Heros : Guerrier ou Magicien
     * Le joueur peut quitter le jeu à tout moment en tapant 'q'
     *
     * @return heros Heros
     */
    public Heros chooseYourPerso() {

        /**
         * isReady est un boolean qui conditionne la boucle while suivante.
         * tant que le joueur n'a pas entre "Magicien" ou "Guerrier" ou 'q' on ressoumet la requete d'input
         */
        boolean isReady = false;
        //petite Phrase d'entrée de jeu : "choisis ton perso
        System.out.print("\nChoisis ton perso (Guerrier / Magicien) : ");

        /**
         * playerPerso est un Herso null - Heros = class abstraite
         */
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

//        System.out.println("-----------------------------------------\nVeux-tu modifier ton perso ? (o/n) ");
//        String modif = scanner.nextLine();
//        this.toQuit(modif);
//        if (modif.equals("o")) {
//            playerPerso = modifHeros(scanner, playerPerso);
//        }

        return playerPerso;

    }

    //********************************************************
    //              LANCEMENT DU JEU
    //**********************************************************

    /**
     * Cette methode demande au joueur de lancer le jeu
     * S'il tape 'o' ou '' le jeu commence - Play play = new Play()
     *
     * @param perso Heros
     */
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

    /**
     * Cette methode permet de creer un nouveau personnage Guerrier ou Magicien selon le choix fait precedemment
     * Elle demande au joueur d'entrer un nom, des points de vie et une force d'attaque
     * Selon les input du joueur differents constructeurs seront appeles
     * Les input seront aussi testes pour correspondre aux exigences des attributs de chaque personnage
     * Le joueur peut quitter le programme à tout moment en tapant 'q'
     *
     * @param scanner Scanner
     * @param type    String - le nom du Heros choisi par le joueur
     * @return yourHeros = new Magicien ou new Guerrier
     */
    public Heros createYourHeros(Scanner scanner, String type) {
        Heros yourHeros;

        //--------------------------------------------------------------------------------
        //Saisir l'input du player pour construire son Heros
        //--------------------------------------------------------------------------------

        //récupère input name
        System.out.print("\nChoisis un nom pour ton " + type + " : ");
        String herosName = scanner.nextLine();
        Menu.toQuit(herosName);


        //récupère input vie
        String vie;
        if (type.equals("Guerrier")) {
            vie = "(entre 5 et 10)";
        } else {
            vie = "(entre 3 et 6)";
        }
        System.out.print("Choisis une force de vie pour ton " + type + " " + vie + " : ");
        String herosVie = scanner.nextLine();
        Menu.toQuit(herosVie);

        //récupérer input force
        String force;
        if (type.equals("Guerrier")) {
            force = "(entre 5 et 10)";
        } else {
            force = "(entre 8 et 15)";
        }
        System.out.print("Choisis une force d'attaque pour ton " + type + " " + force + " : ");
        String herosForce = scanner.nextLine();
        Menu.toQuit(herosForce);


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

        this.createHerosModel(yourHeros);

        return yourHeros;
    }

    //**********************************************************************
    //                  MODIF HEROS
    //*************************************************************************


    /**
     * Cette methode fait appel aux getter et setter de la classe Heros pour modifier les attributs du Heros du joueur
     * Le joueur peut quitter le jeu a tout moment en entrant 'q'
     *
     * @param scanner Scanner
     * @param heros   Heros
     * @return heros - nouveau heros apres modification(s)
     */
    public Heros modifHeros(Scanner scanner, Heros heros) {

        System.out.println("Nom actuel : " + heros.getNom() + " //Nouveau nom : ");
        String newName = scanner.nextLine();
        Menu.toQuit(newName);
        if (!newName.equals("")) {
            heros.setNom(newName);
        }

        System.out.println("Vie actuelle : " + heros.getVie() + " //Nouvelle vie : ");
        String newVie = scanner.nextLine();
        Menu.toQuit(newVie);
        if (!newVie.equals("")) {
            heros.setVie(Integer.parseInt(newVie));
        }

        System.out.println("Force actuelle : " + heros.getForce() + " //Nouvelle force : ");
        String newForce = scanner.nextLine();
        Menu.toQuit(newForce);
        if (!newForce.equals("")) {
            heros.setForce(Integer.parseInt(newForce));
        }

        System.out.println(heros.toString());
        return heros;
    }


    //**************************************************************************************
    //                CREATE HEROS-MODEL
    //***************************************************************************************

    public void createHerosModel(Heros heros) {
        HerosModel hm;
        hm = new HerosModel();
        String type = heros.getClass().getSimpleName();
        String nom = heros.getNom();
        int vie = heros.getVie();
        int force = heros.getForce();
        String equipement = heros.getAttaque();

        System.out.println("\n" + type + " " + nom + " " + vie + " " + force + " " + equipement);

        hm.createHero(type, nom, vie, force, equipement);

        System.out.println("Le héros " + heros.getNom() + " a été sauvegardé.");
    }

    //*************************************************************************************
    //               LOAD HEROS-MODEL
    //*********************************************************************************

    public Heros loadHerosModel(int id) {
        HerosModel hm;
        hm = new HerosModel();

        Heros heros;

        String type = hm.getHeroType(id);
        String nom = hm.getHeroNom(id);
        int vie = hm.getHeroVie(id);
        int force = hm.getHeroForce(id);

        if (type.equals("Guerrier")) {
            heros = new Guerrier(nom, vie, force);
        } else {
            heros = new Magicien(nom, vie, force);
        }

        System.out.println(heros.toString());

        return heros;
    }


    //******************************************************************************
    //                  UPDATE HEROS-MODEL
    //*******************************************************************************

    public void updateHerosModel(int id) {
        HerosModel hm;
        hm = new HerosModel();

        hm.getHero(id);

        System.out.println("Entre le nouveau nom de ton perso : ");
        String newName = scanner.nextLine();
        toQuit(newName);

        if (!newName.equals("")) {
            hm.updateHero(id, newName);
        } else {
            this.updateHerosModel(id);
        }


    }


}

