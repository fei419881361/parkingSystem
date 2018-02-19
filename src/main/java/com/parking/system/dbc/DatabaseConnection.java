package com.parking.system.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接类
 */
public class DatabaseConnection {
    private static final String DBDriver = "com.mysql.jdbc.Driver";
 private static final String DBURL = "jdbc:mysql://localhost:3306/nodeSample";
    private static final String DBUSER = "mysql";
    private static final String DBPASS = "mysqladmin";

    private Connection conn;

    public DatabaseConnection(){
        try{
            Class.forName(DBDriver);
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        return this.conn;
    }
    public void Close() {
        if (this.conn != null){
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
