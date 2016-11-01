/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetobd.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe Teixeira
 */
public class ConnectionFactory {

    // jdbc:oracle:thin:@localhost:1521:XE
    private static ConnectionFactory instance;
    private Connection connection;
    private final String db = "XE";
    private final String username = "system";
    private final String password = "system";
    private final String protocol="jdbc:oracle:thin:@localhost:1521:";
    private final String driver = "oracle.jdbc.OracleDriver";

    private ConnectionFactory() {
        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(protocol+db, username, password);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}