/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.helloint.etc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jiraw
 */
public class ConnectionBuilder {

    public static Connection getConnection() {
        Connection conn = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("env.properties");
        Properties prop = new Properties();
        try {
            prop.load(input);
            String dbIp = prop.getProperty("CAREERITY_DB_IP");
            System.out.println(dbIp);
            String dbName = prop.getProperty("CAREERITY_DB_NAME");
            String dbUsername = prop.getProperty("CAREERITY_DB_USER");
            String dbPassword = prop.getProperty("CAREERITY_DB_PASS");
            String dbPort = prop.getProperty("CAREERITY_DB_PORT");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + dbIp + ":" + dbPort + "/" + dbName + "?zeroDateTimeBehavior=convertToNull", dbUsername, dbPassword);
        } catch (SQLException | ClassCastException | ClassNotFoundException | IOException err) {
            System.err.println(err);
        }
        return conn;
    }
}
