package src.java.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
        
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static boolean connect() {
        String url = "jdbc:mysql://localhost:3306/db_s2_ETU003114";
        String user = "ETU003114";
        String password = "3M3o3SX5";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void closeConnection(){
        try {
            connection.close();   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(){
        try {
            statement.close();   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(){
        try {
            resultSet.close();   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(){
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
    public static PreparedStatement getStatement(){
        return statement;
    }
    public static ResultSet getResultSet(){
        return resultSet;
    }
    
    public static void setConnection(Connection c){
        connection = c;
    }
    public static void setStatement(String query) throws SQLException{
        statement = connection.prepareStatement(query);
    }
    public static void setResult() throws SQLException{
        resultSet = statement.executeQuery();
    }
}
