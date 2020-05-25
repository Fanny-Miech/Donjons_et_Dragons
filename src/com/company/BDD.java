package com.company;

import java.sql.*;

public class BDD {

    private Statement state;
    private ResultSet result;
    private ResultSetMetaData resultMeta;


    public BDD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver OK");

            String url = "jdbc:mysql://localhost:3306/donjon_et_dragons";
            //String url = "jdbc:mysql://localhost/phpmyadmin/db_structure.php?server=1&db=donjon_et_dragons";
            String user = "root";
            String passwd = "";


            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection effective !");

            //Création d'un objet Statement (permet d'executer des instructions sql)
            this.state = conn.createStatement();

            //on recupère les MetaData (données relatives à la table : nom de la table, des champs, nombre de lignes, type des données,...)
            this.resultMeta = result.getMetaData();

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    public void getHeroes() {
        try {
            //L'objet ResultSet contient le résultat de la requete SQL
            this.result = state.executeQuery("select * from heros");

            System.out.println("\nLISTE DES HEROS");
            System.out.println("--------------------------------");
            while (result.next()) {
                System.out.print("\t" + result.getString("type") + "\t |");
                System.out.print("\t" + result.getString("nom") + "\t |");
                System.out.println("\n--------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void getHero(int ID) {
        try {
            //L'objet ResultSet contient le résultat de la requete SQL
            this.result = state.executeQuery("select * from heros WHERE id=ID");

            //result.first();

            System.out.println("\nDETAIL SUR LE HEROS " + ID);
            System.out.println("--------------------------------");
            System.out.print("\t Type : " + result.getString("type") + "\t |");
            System.out.print("\t Nom : " + result.getString("nom") + "\t |");
            System.out.print("\t Vie : " + result.getInt("niveauVie") + "\t |");
            System.out.print("\t Force : " + result.getInt("niveauForce") + "\t |");
            System.out.print("\t Equipement : " + result.getString("equipement") + "\t |");
            System.out.println("\n--------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void createHero() {

    }

    public static void updateHero() {

    }

    public static void deleteHero() {

    }

}
