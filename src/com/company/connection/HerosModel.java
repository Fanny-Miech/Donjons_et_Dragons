package com.company.connection;

import java.sql.*;

public class HerosModel {

    private final Connection conn = Database.getInstance().getConnect();

    private final String query = "SELECT * FROM heros";

    /**
     * Affiche l'id, le type et le nom des heros enregistrés en bdd
     */
    public void getHeroes() {
        try {
            PreparedStatement prepare;
            prepare = this.conn.prepareStatement(this.query);

            ResultSet result = prepare.executeQuery();

            System.out.println("\nLISTE DES HEROS");
            System.out.println("--------------------------------");
            while (result.next()) {
                System.out.print("\t" + result.getInt("id") + "\t |");
                System.out.print("\t" + result.getString("type") + "\t |");
                System.out.print("\t" + result.getString("nom") + "\t |");
                System.out.println("\n--------------------------------");
            }

            result.close();
            prepare.close();

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
            Statement state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            PreparedStatement prepare;
            String query = "SELECT * FROM heros WHERE id=";
//            prepare = this.conn.prepareStatement(query);



            ResultSet result = state.executeQuery(query + ID);

//            prepare.setInt(1, ID);

            result.first();
            System.out.println("\nDETAILS SUR LE HEROS " + ID);
            System.out.println("--------------------------------");
            System.out.print("\t Type : " + result.getString("type") + "\t |");
            System.out.print("\t Nom : " + result.getString("nom") + "\t |");
            System.out.print("\t Vie : " + result.getInt("niveauVie") + "\t |");
            System.out.print("\t Force : " + result.getInt("niveauForce") + "\t |");
            System.out.print("\t Equipement : " + result.getString("equipement") + "\t |");
            System.out.println("\n--------------------------------");

//            prepare.close();
            result.close();
            state.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * cree un nv heros en bdd
     */
    public void createHero(String type, String nom, int niveauVie, int niveauForce, String equipement) {
        try {
            Statement state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            PreparedStatement prepare;
            prepare = this.conn.prepareStatement("INSERT INTO heros (type, nom, niveauVie, niveauForce, equipement) VALUES (?,?,?,?,?)");

            prepare.setString(1, type);
            prepare.setString(2, nom);
            prepare.setInt(3, niveauVie);
            prepare.setInt(4, niveauForce);
            prepare.setString(5, equipement);

            prepare.executeUpdate();

            prepare.close();
            state.close();


//
//            String query = "INSERT INTO heros (type, nom, niveauVie, niveauForce, equipement) VALUES ('" + type + "','" + nom + "','" + niveauVie + "','" + niveauForce + "','" + equipement + "')";
//            System.out.println(query);
//            this.state.executeUpdate(query);



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * modifie un heros de la bdd
     */
    public void updateHero(int ID, String nom) {
        try {
            //Création d'un objet Statement (permet d'executer des instructions sql)
            Statement state;
            state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            PreparedStatement prepare;
            prepare = this.conn.prepareStatement("UPDATE heros set nom=? WHERE id=?");

            prepare.setString(1, nom);
            prepare.setInt(2, ID);

            int i = prepare.executeUpdate();
            System.out.println((i+ " héros modifié"));

            state.close();
            prepare.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * supprime un heros de la bdd en fonction de son id
     * @param id int
     */
    public void deleteHero(int id) {
        try {
            String query = "DELETE FROM heros WHERE id =?";

            PreparedStatement prepare;
            prepare = this.conn.prepareStatement(query);
            prepare.setInt(1, id);

            prepare.executeUpdate();

            prepare.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Le Héros " + id + " a été supprimé.");

    }


}
