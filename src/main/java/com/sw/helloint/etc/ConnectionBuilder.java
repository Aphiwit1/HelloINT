/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.helloint.etc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author jiraw
 */
public class ConnectionBuilder {

    public static Connection getConnection() throws ClassNotFoundException {
        Connection conn = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            String dbIp = System.getProperty("CAREERITY_DB_IP");
            String dbName = System.getProperty("CAREERITY_DB_NAME");
            String dbUsername = System.getProperty("CAREERITY_DB_USER");
            String dbPassword = System.getProperty("CAREERITY_DB_PASS");
            String dbPort = System.getProperty("CAREERITY_DB_PORT");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + dbIp + ":" + dbPort + "/" + dbName + "?zeroDateTimeBehavior=convertToNull", dbUsername, dbPassword);
        } catch (SQLException | ClassCastException err) {
            System.err.println(err);
        }
        return conn;
    }
}
