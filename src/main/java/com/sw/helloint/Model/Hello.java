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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jiraw
 */
public class Hello {

    public List<String> bringHello() {
        List<String> helloMessage = new ArrayList<String>();
        try {
            Connection conn = ConnectionBuilder.getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM hello");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                helloMessage.add(rs.getString("message"));
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return helloMessage;
    }
}
