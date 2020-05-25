package com.company;

import java.sql.*;

public class BDD {

    private Connection conn;
    private Statement state;
    private ResultSet result;
    private ResultSetMetaData resultMeta;


    /**
     * Etablit la connexion avec la BDD
     */
    public BDD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver OK");

            String url = "jdbc:mysql://localhost:3306/donjon_et_dragons";
            String user = "root";
            String passwd = "";

            this.conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection effective !");

            //Création d'un objet Statement (permet d'executer des instructions sql)
            this.state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //on recupère les MetaData (données relatives à la table : nom de la table, des champs, nombre de lignes, type des données,...)
            //this.resultMeta = result.getMetaData();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Affiche l'id, le type et le nom des heros enregistrés en bdd
     */
    public void getHeroes() {
        try {
            //L'objet ResultSet contient le résultat de la requete SQL
            this.result = this.state.executeQuery("select * from heros");

            System.out.println("\nLISTE DES HEROS");
            System.out.println("--------------------------------");
            while (this.result.next()) {
                System.out.print("\t" + this.result.getInt("id") + "\t |");
                System.out.print("\t" + this.result.getString("type") + "\t |");
                System.out.print("\t" + this.result.getString("nom") + "\t |");
                System.out.println("\n--------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * Affiche les details concernant un heros precis depuis son id
     *
     * @param ID int
     */
    public void getHero(int ID) {
        try {
            //Création d'un objet Statement (permet d'executer des instructions sql)
            //this.state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //L'objet ResultSet contient le résultat de la requete SQL
            this.result = this.state.executeQuery("select * from heros WHERE id=" + ID);

            this.result.first();
            System.out.println("\nDETAILS SUR LE HEROS " + ID);
            System.out.println("--------------------------------");
            System.out.print("\t Type : " + this.result.getString("type") + "\t |");
            System.out.print("\t Nom : " + this.result.getString("nom") + "\t |");
            System.out.print("\t Vie : " + this.result.getInt("niveauVie") + "\t |");
            System.out.print("\t Force : " + this.result.getInt("niveauForce") + "\t |");
            System.out.print("\t Equipement : " + this.result.getString("equipement") + "\t |");
            System.out.println("\n--------------------------------");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * cree un nv heros en bdd
     */
    public void createHero(String type, String nom, int niveauVie, int niveauForce, String equipement) {
        try {
            this.state.executeUpdate("INSERT INTO heros (type, nom, niveauVie, niveauForce, equipement) VALUES ('" + type + "','" + nom + "','" + niveauVie + "','" + niveauForce + "','" + equipement + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * modifie un heros de la bdd
     */
    public void updateHero(int ID, String type, String nom, int niveauVie, int niveauForce, String equipement) {
        try {
            //Création d'un objet Statement (permet d'executer des instructions sql)
            //this.state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //L'objet ResultSet contient le résultat de la requete SQL
            this.result = this.state.executeQuery("select * from heros WHERE id=" + ID);

            this.result.first();

            //on affiche ce que l'on trouve :
            this.getHero(ID);

            //on met à jour les champs
            this.result.updateString("type", type);
            this.result.updateString("nom", nom);
            this.result.updateInt("niveauVie", niveauVie);
            this.result.updateInt("niveauForce", niveauForce);
            this.result.updateString("equipement", equipement);

            //On valide
            this.result.updateRow();

            //on affiche les modifications
            System.out.println("*********************************************");
            System.out.println("\t Après modification : ");
            this.getHero(ID);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * supprime un heros de la bdd
     */
    public void deleteHero() {
        try {
            this.state.executeUpdate("DELETE FROM heros WHERE niveauVie=0");
        }catch( Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * clean (reinitialise a zero) les variables liees a la connexion avec la bdd
     */
    public void clean() {
        try {
            this.result.close();
            this.state.close();
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

}


