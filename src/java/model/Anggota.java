/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import core.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Michael Donny Kusuma
 */
public class Anggota {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static void inputAnggota(Anggota a){
        Connection conn = null;
        PreparedStatement ps = null;       
        conn = DatabaseManager.getDBConnection();
             try{
                 ps = conn.prepareCall("INSERT INTO ANGGOTA VALUES(?,?)");
                 ps.setString(1, a.password);
                 ps.setString(2, a.password);
                 ps.executeUpdate();
                 conn.commit();
             }
             catch(SQLException ex){
             }
             finally{
                 try{
                     ps.close();
                     conn.close();}
                 catch (SQLException ex){
                 }
             }
     }
    
    public static Anggota[] showAnggota(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = DatabaseManager.getDBConnection();
        Anggota db[] = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM ANGGOTA");
            rs.next();
            db = new Anggota[rs.getInt(1)];
            rs = st.executeQuery("SELECT * FROM ANGGOTA");
            int index =0;
            while(rs.next()){
                db[index] = new Anggota();
                db[index].setUsername(rs.getString(1));
                db[index].setPassword(rs.getString(2));
                index++;               
            }
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());       
        }
        finally{
            try{
                rs.close();
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    return db;
    }
    
}
