package Herramientas;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EnlaceDB {

    private Connection conex;
    private Statement estSQL;
    PreparedStatement preparedStatement = null;

    private String loginDB = "root";
    private String passwordDB = "root";
    private String dataBase = "jdbc:mysql://localhost:3306/demo";
    private String databaseName = "demo";

    private String driver = "com.mysql.jdbc.Driver";

    public ResultSet executeQuery(String expSQL) {
        ResultSet rs = null;
        try {
            estSQL = (Statement) conex.createStatement();// QUITAR ESTA LINEA CUANDO LOS QUERYS ANIDADOS YA ESTEN CORREGIDOS 
            rs = estSQL.executeQuery(expSQL);
            return rs;
        } catch (SQLException e) {
            System.out.println("##### Query Error: #####" + expSQL);
        }
        return rs;
    }

    public ResultSet executeQueryPrepared(String expSQL) {
        ResultSet rs = null;
        try {
            preparedStatement = (PreparedStatement) conex.prepareStatement(expSQL);
            rs = preparedStatement.executeQuery();
        } catch (SQLException e1) {
            System.out.println("Error SQL :" + e1.getMessage());
            e1.printStackTrace();
            System.out.println("##### Query Error: #####" + expSQL);
        }
        return rs;
    }

    public int execute(String expSQL) {
        int resultado = -1;
        try {
            //			estSQL = conex.createStatement();
            estSQL.execute(expSQL);
            resultado = estSQL.getUpdateCount();
        } catch (SQLException e) {
            System.out.println("SQLException in execute method:" + e.getMessage());
            System.out.println("##### Query Error: #####" + expSQL);
        }
        return resultado;
    }

    public int executeSynchronized(String expSQL) {
        int resultado = -1;
        try {
            //			estSQL = conex.createStatement();
            estSQL.execute(expSQL);
            resultado = estSQL.getUpdateCount();
        } catch (SQLException e) {
            System.out.println("SQLException in execute method:" + e.getMessage());
        }

        return resultado;
    }

    public void openDatabase() {
        try {
            Class.forName(driver).newInstance();
        } catch (InstantiationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {

            this.conex = (Connection) DriverManager.getConnection(dataBase, loginDB, passwordDB);
            this.estSQL = (Statement) conex.createStatement();
        } catch (SQLException e) {
            System.out.println("SQLException in openDatabase method:"
                    + e.getMessage());
        }
    }

    public void closeDatabase() {
        try {
            this.estSQL.close();
            this.conex.close();
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                preparedStatement = null;
            }
        } catch (SQLException e) {
            System.out.println("SQLException in method closeDatabase" + e.getMessage());
        }
    }

    public void openDatabaseTrans() {
        try {
            Class.forName(driver).newInstance();
        } catch (InstantiationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {

            this.conex = (Connection) DriverManager.getConnection(dataBase, loginDB, passwordDB);
            this.conex.setAutoCommit(false);
            System.out.println("Deshabilito Commit");
            this.estSQL = (Statement) conex.createStatement();
        } catch (SQLException e) {
            System.out.println("SQLException in openDatabase method:"
                    + e.getMessage());
        }
    }

    public void closeDatabaseTrans(int flag) {
        try {
            if (flag == 0) {
                System.out.println("Aplico Commit close");
                this.estSQL.close();
                this.conex.commit();
                this.conex.close();
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    preparedStatement = null;
                }

            } else {
                System.out.println("Aplico Rollback");
                this.estSQL.close();
                this.conex.rollback();
                this.conex.close();
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    preparedStatement = null;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException in method closeDatabase" + e.getMessage());
        }
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName(driver);//org.gjt.mm.mysql.Driver
            this.conex = (Connection) DriverManager.getConnection(dataBase, loginDB, passwordDB);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (Connection) DriverManager.getConnection(dataBase, loginDB, passwordDB);
    }

    public CallableStatement prepareCall(String expSQL) {
        ResultSet rs = null;
        CallableStatement callableStatement = null;
        try {
            callableStatement = (CallableStatement) conex.prepareCall(expSQL);
            callableStatement.execute();
        } catch (SQLException e1) {
            System.out.println("Error SQL :" + e1.getMessage());
            e1.printStackTrace();
            System.out.println("##### Query Error: #####" + expSQL);
        }
        return callableStatement;
    }

    public CallableStatement prepareCall(CallableStatement callableStatement) {
        ResultSet rs = null;
        try {
            callableStatement.execute();
        } catch (SQLException e1) {
            System.out.println("Error SQL :" + e1.getMessage());
            e1.printStackTrace();
        }
        return callableStatement;
    }

    public CallableStatement prepareCallableStatement(String query) {
        try {
            return (CallableStatement) conex.prepareCall(query);
        } catch (SQLException e1) {
            System.out.println(e1);
            return null;
        }
    }

}
