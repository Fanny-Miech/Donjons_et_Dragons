package com.company.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static Database instance;
    private Connection conn;

    private Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver OK");

            String url = "jdbc:mysql://localhost:3306/donjon_et_dragons";
            String user = "root";
            String passwd = "";

            this.conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection effective !");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnect() {
        return this.conn;
    }

}
