/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.helloint.Model;

import com.sw.helloint.etc.ConnectionBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jiraw
 */
public class Hello {
    public String bringHello() {
        String helloMessage = "";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionBuilder.getConnection();
            if (conn != null) {
                pstm = conn.prepareStatement("SELECT * FROM hello WHERE id = 1");
            }
            else {
                System.out.println("connection is null");
            }
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                helloMessage = rs.getString("message");
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Hello.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Hello.class.getName()).log(Level.SEVERE, null, ex);
        }
        return helloMessage;
    }
}
