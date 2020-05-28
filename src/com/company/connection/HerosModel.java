package com.company.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HerosModel {

    private Connection conn = Database.getInstance().getConnect();

    private Statement state;
    private ResultSet result;
    private String query = "SELECT * FROM heros";
    private String query2 = this.query + " WHERE id= ";

    /**
     * Affiche l'id, le type et le nom des heros enregistrés en bdd
     */
    public void getHeroes() {
        try {
            //Création d'un objet Statement (permet d'executer des instructions sql)
            this.state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //L'objet ResultSet contient le résultat de la requete SQL
            this.result = this.state.executeQuery(this.query);

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
            this.state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //L'objet ResultSet contient le résultat de la requete SQL
            this.result = this.state.executeQuery(this.query2 + ID);

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
            this.state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //L'objet ResultSet contient le résultat de la requete SQL
            this.result = this.state.executeQuery(this.query2 + ID);

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
            String query = "DELETE FROM heros WHERE niveauVie=0";
            this.state.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clear() {
        try {
            this.result.close();
            this.state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
