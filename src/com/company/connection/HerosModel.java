package com.company.connection;

import java.sql.*;

public class HerosModel {

    private final Connection conn = Database.getInstance().getConnect();

    private final String query = "SELECT * FROM heros";

    /**
     * Affiche l'id, le type et le nom des heros enregistrés en bdd
     */
    public void getHeroes() {
        PreparedStatement prepare = null;
        ResultSet result = null;

        try {

            prepare = this.conn.prepareStatement(this.query);

            result = prepare.executeQuery();

            System.out.println("\nLISTE DES HEROS");
            System.out.println("--------------------------------");
            while (result.next()) {
                System.out.print("\t" + result.getInt("id") + "\t |");
                System.out.print("\t" + result.getString("type") + "\t |");
                System.out.print("\t" + result.getString("nom") + "\t |");
                System.out.println("\n--------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.clearStatement(prepare);
            this.clearResult(result);
        }

    }


    /**
     * Affiche les details concernant un heros precis depuis son id
     *
     * @param ID int
     */
    public void getHero(int ID) {
        PreparedStatement prepare = null;
        ResultSet result = null;

        try {

            String query = "SELECT * FROM heros WHERE id=?";
            prepare = this.conn.prepareStatement(query);

            prepare.setInt(1, ID);
            result = prepare.executeQuery();

            result.next();
            System.out.println("\nDETAILS SUR LE HEROS " + ID);
            System.out.println("--------------------------------");
            System.out.print("\t Type : " + result.getString("type") + "\t |");
            System.out.print("\t Nom : " + result.getString("nom") + "\t |");
            System.out.print("\t Vie : " + result.getInt("niveauVie") + "\t |");
            System.out.print("\t Force : " + result.getInt("niveauForce") + "\t |");
            System.out.print("\t Equipement : " + result.getString("equipement") + "\t |");
            System.out.println("\n--------------------------------");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.clearResult(result);
            this.clearStatement(prepare);
        }

    }

    //*******************************************************************************
    //                  GET ELEMENTS FROM HEROS BY ID
    //********************************************************************************

    public String getHeroType(int id) {
        PreparedStatement prepare = null;
        ResultSet result = null;

        String type = null;

        try {

            String query = "SELECT * FROM heros WHERE id=?";
            prepare = this.conn.prepareStatement(query);

            prepare.setInt(1, id);
            result = prepare.executeQuery();

            result.next();
            type = result.getString("type");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.clearResult(result);
            this.clearStatement(prepare);
        }

        return type;
    }

    public String getHeroNom(int id){
        PreparedStatement prepare = null;
        ResultSet result = null;

        String nom = null;

        try {

            String query = "SELECT * FROM heros WHERE id=?";
            prepare = this.conn.prepareStatement(query);

            prepare.setInt(1, id);
            result = prepare.executeQuery();

            result.next();
            nom = result.getString("nom");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.clearResult(result);
            this.clearStatement(prepare);
        }

        return nom;

    }

    public int getHeroVie(int id){
        PreparedStatement prepare = null;
        ResultSet result = null;

        int vie = 0;

        try {

            String query = "SELECT * FROM heros WHERE id=?";
            prepare = this.conn.prepareStatement(query);

            prepare.setInt(1, id);
            result = prepare.executeQuery();

            result.next();
            vie = result.getInt("niveauVie");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.clearResult(result);
            this.clearStatement(prepare);
        }

        return vie;

    }

    public int getHeroForce(int id){
        PreparedStatement prepare = null;
        ResultSet result = null;

        int force = 0;

        try {

            String query = "SELECT * FROM heros WHERE id=?";
            prepare = this.conn.prepareStatement(query);

            prepare.setInt(1, id);
            result = prepare.executeQuery();

            result.next();
            force = result.getInt("niveauForce");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.clearResult(result);
            this.clearStatement(prepare);
        }

        return force;

    }


    //******************************************************************
    //                   CREATE HEROS-MODEL
    //********************************************************************

    /**
     * cree un nv heros en bdd
     */
    public void createHero(String type, String nom, int niveauVie, int niveauForce, String equipement) {
        Statement state = null;
        PreparedStatement prepare = null;

        try {
//            state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            prepare = this.conn.prepareStatement("INSERT INTO heros (type, nom, niveauVie, niveauForce, equipement) VALUES (?,?,?,?,?)");

            prepare.setString(1, type);
            prepare.setString(2, nom);
            prepare.setInt(3, niveauVie);
            prepare.setInt(4, niveauForce);
            prepare.setString(5, equipement);

            prepare.executeUpdate();

//
//            String query = "INSERT INTO heros (type, nom, niveauVie, niveauForce, equipement) VALUES ('" + type + "','" + nom + "','" + niveauVie + "','" + niveauForce + "','" + equipement + "')";
//            System.out.println(query);
//            this.state.executeUpdate(query);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.clearStatement(state);
            this.clearStatement(prepare);
        }

    }

    /**
     * modifie un heros de la bdd
     */
    public void updateHero(int ID, String nom) {

        Statement state = null;
        PreparedStatement prepare = null;

        try {
            //Création d'un objet Statement (permet d'executer des instructions sql)

            state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            prepare = this.conn.prepareStatement("UPDATE heros set nom=? WHERE id=?");

            prepare.setString(1, nom);
            prepare.setInt(2, ID);

            prepare.executeUpdate();
            System.out.println(("héros modifié"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.clearStatement(state);
            this.clearStatement(prepare);
        }

    }

    /**
     * supprime un heros de la bdd en fonction de son id
     *
     * @param id int
     */
    public void deleteHero(int id) {

        PreparedStatement prepare = null;

        try {
            String query = "DELETE FROM heros WHERE id =?";

            prepare = this.conn.prepareStatement(query);
            prepare.setInt(1, id);

            prepare.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            clearStatement(prepare);
        }
        System.out.println("Le Héros " + id + " a été supprimé.");

    }


    /**
     * @param result ResultSet
     */
    public void clearResult(ResultSet result) {

        try {
            if (result != null) {
                result.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     *
     * @param st statement
     */
    public void clearStatement(Statement st) {

        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
