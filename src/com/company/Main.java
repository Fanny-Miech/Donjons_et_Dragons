package com.company;

import com.company.personnages.Heros;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Scanner;

/**
 * Cette classe gere le deroulement du jeu
 */
public class Main {

    public static void main(String[] args) {
        // write your code here


        //Test connection BDD
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver OK");

            String url = "jdbc:mysql://localhost:3306/donjon_et_dragons";
            //String url = "jdbc:mysql://localhost/phpmyadmin/db_structure.php?server=1&db=donjon_et_dragons";
            String user = "root";
            String passwd = "";


            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection effective !");

        } catch (Exception e) {
            e.printStackTrace();
        }








        /**
         * Declare et instancie un scanner qu'on passera en parametre
         */
        Scanner sc = new Scanner(System.in);


        //Initialise un nouveau jeu
        Menu part1 = new Menu();
        part1.welcome();

        //choix du perso
        Heros perso = part1.chooseYourPerso(sc);

        //lancement du jeu
        part1.readyToPlay(perso);


    }


}
