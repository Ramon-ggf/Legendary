
package bibliotecamusica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    
    static String DBpath = "jdbc:sqlite:biblioteca.db";
    static Connection conn;
    
    public static void ChangeDB (String sql){
        try {
            DBManager.conn = DriverManager.getConnection(DBManager.DBpath);
            Statement st = DBManager.conn.createStatement();
            st.execute(sql);
            DBManager.conn.close();
        }catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
    }
    
    public static void CloseDB(){
        try{
            conn.close();
        }catch(SQLException error) {
            Logger.LoggerFiller(error.getMessage(), "Error");
        }
    }
    
    public static ResultSet CheckDB (String sql){
        try{
            DBManager.conn = DriverManager.getConnection(DBManager.DBpath);
            Statement st = DBManager.conn.createStatement();
            st.execute(sql);
            
            Statement stm = DBManager.conn.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            
            return rst;
        }
        catch (SQLException error){
            Logger.LoggerFiller(error.getMessage(), "Error");
            return null;
        }
    }
    
}
