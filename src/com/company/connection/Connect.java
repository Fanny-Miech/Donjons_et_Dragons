package com.company.connection;

import java.sql.*;


//regarder prepareStatement
//String query = ""
//pattern singleton
//Connection : attribut ou variable locale ?

public class Connect {

    protected Connection conn;
    //private ResultSetMetaData resultMeta;


    /**
     * Etablit la connexion avec la BDD
     */
    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver OK");

            String url = "jdbc:mysql://localhost:3306/donjon_et_dragons";
            String user = "root";
            String passwd = "";

            this.conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection effective !");

            //on recupère les MetaData (données relatives à la table : nom de la table, des champs, nombre de lignes, type des données,...)
            //this.resultMeta = result.getMetaData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}


