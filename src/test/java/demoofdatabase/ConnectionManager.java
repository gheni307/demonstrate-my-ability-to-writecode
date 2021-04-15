package demoofdatabase;

import tool.ConnectionType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    static Connection connectToDatabaseServer(String dbUrl, String dbPort, String dbUserName, String dbPassword,
                                              String defaultDatabase, ConnectionType connectionType){

        Connection connection = null;
        String JTDS_Driver = "net.sourceforge.jtds.jdbc.Driver";
        String MSQL_Driver = "com.mysql.cj.jdbc.Driver";

        switch (connectionType){
            case MSSQLSERVER:
                try {
                    Class.forName(JTDS_Driver);
                } catch (ClassNotFoundException e) {
                    new RuntimeException("please check your driver information");
                }
                String connectionUrl = "jdbc:jtds:sqlserver://"+dbUrl+";databaseName="+defaultDatabase;

                try {
                    connection = DriverManager.getConnection(connectionUrl,dbUserName,dbPassword);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

            case MYSQLSERVER:
                try {
                    Class.forName(MSQL_Driver).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                String connectionMYSQL = "jdbc:mysql://"+dbUrl+":"+dbPort+"/"+defaultDatabase;

                try {
                    connection = DriverManager.getConnection(connectionMYSQL,dbUserName,dbPassword);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

            default:
                System.out.println("you need to specify database connection type(MSSQL or MySQL");
        }
        return connection;
    }

    static void closeDatabaseConnection(Connection connection){
        try {
            if (!connection.isClosed()){
                System.out.println("database connection is established");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (connection.isClosed()){
                System.out.println("database connection is has been closed");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
