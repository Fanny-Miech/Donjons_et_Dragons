package com.company;

import java.util.Scanner;

public class Menu {

    //method début du jeu pour choisir son perso

    public void PersoChoose() {
        boolean isReady = false;
        while (!isReady) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choisis ton perso (Guerrier / Magicien) : ");
            String playerChoice = scanner.nextLine();

            if (playerChoice.equals("Guerrier") || playerChoice.equals("Magicien")) {
                System.out.println("Tu as choisis le " + playerChoice + ".");
                isReady = true;

            } else if (playerChoice.equals("Echap")) {
                System.out.println("Tu as quitté le jeu !");

            } else {
                System.out.println("Choisis entre Guerrier et Magicien stp :)");
            }

        }
    }
}
