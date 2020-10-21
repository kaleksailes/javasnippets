import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

    //
    //
    //

    // execute method can be used with any type of SQL statements and it returns a
    // boolean. A true indicates that the execute method returned a result set
    // object which can be retrieved using getResultSet method. false indicates that
    // the query returned an int value or void. execute method can run both select
    // and insert/update statements.
    // executeQuery method execute statements that returns a result set by fetching
    // some data from the database. It executes only SELECT statements.
    // executeUpdate method execute sql statements that
    // INSERT/UPDATE/DELETE/CREATE_DB data at the database. This method return int
    // value representing number of records affected; //Returns 0 if the query
    // returns nothing. The method accepts only non-select statements.

    /*---------------------------------------------------------------------------------------*/
    // JDBC (CREATE DATABASE AND UPDATE)
    public static void JDBC_ExecuteUpdate() {

        try {

            // Driver jdc de mysql, URL de la base de datos y los credenciales
            final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

            // URL de la base de datos
            final String DB_URL = "jdbc:mysql://localhost/JDBC";

            // Credenciales de la base de datos
            final String USER = "username";
            final String PASS = "password";

            // Registra el driver de JDBC mysql
            Class.forName(JDBC_DRIVER);

            // Conexion a la base de datos
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Con createStatement(); creamos un objecto que su deber es enviar Statements
            // de SQL a la base de datos.
            Statement stmt = conn.createStatement();

            // Statement para crear la base de datos
            String createDb = "CREATE TABLE Users " + "(UserId INTEGER not NULL," + " Username VARCHAR(255), "
                    + " Password VARCHAR(255), " + " PinNumber INTEGER, " + " PRIMARY KEY ( UserId ))";// <-- UserId es
                                                                                                       // el PRIMARY KEY

            // Ejecutamos el statement de SQL
            // DML - Data manipulation Language
            stmt.execute(createDb);
            // executeUpdate() tambien se puede usar para statements de INSERT, UPDATE or
            // DELETE

            System.out.println("Database was created");

            // STEP 4: Execute a query
            String sql = "UPDATE Employees set age=? WHERE id=? AND firstname=?";
            PreparedStatement preStmt = conn.prepareStatement(sql);

            preStmt.setInt(1, 30);
            preStmt.setInt(2, 103);
            preStmt.setString(3, "Name");

            // Let us update age of the record with ID = 103;
            int rows = stmt.executeUpdate(sql);
            System.out.println("Rows impacted : " + rows);

        } catch (ClassNotFoundException | SQLException e) {

            System.out.print("Error creando Database." + e);
        }
    }

    /*---------------------------------------------------------------------------------------*/
    // JDB (INSERT)
    public static void JDBC_INSERT() {

        try {

            // Driver jdc de mysql, URL de la base de datos y los credenciales
            final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

            // URL de la base de datos
            final String DB_URL = "jdbc:mysql://localhost/JDBC";

            // Credenciales de la base de datos
            final String USER = "username";
            final String PASS = "password";

            // Registra el driver de JDBC mysql
            Class.forName(JDBC_DRIVER);

            // Conexion a la base de datos
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Con createStatement(); creamos un objecto que su deber es enviar Statements
            // de SQL a la base de datos.

            // Execute a query
            String sql = "INSERT INTO warehouses(id, firstname, lastname, cellphone) VALUES(?,?,?,?)";
            PreparedStatement preStmt = conn.prepareStatement(sql);

            preStmt.setInt(1, 1);
            preStmt.setString(2, "Marta");
            preStmt.setString(3, "Nara");
            preStmt.setDouble(4, 4561452);

            int rows = preStmt.executeUpdate(sql);
            System.out.println("Record was inserted into the table...");
            System.out.println("Rows impacted : " + rows);

        } catch (ClassNotFoundException | SQLException e) {

            System.out.print("Error: " + e);
        }
    }

    /*---------------------------------------------------------------------------------------*/
    // JDB EXECUTE QUERY (SELECT QUERY)
    // Select Statement
    public static void JDBC_ExecuteQuery() {

        Connection conn = null;
        ResultSet rs;

        try {

            // Driver jdc de mysql, URL de la base de datos y los credenciales
            final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

            // URL de la base de datos
            final String DB_URL = "jdbc:mysql://localhost/JDBC";

            // Credenciales de la base de datos
            final String USER = "username";
            final String PASS = "password";

            // STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Let us select all the records and display them.
            String sql = "SELECT * FROM Employees WHERE id = ? AND first = ?";
            PreparedStatement preStmt = conn.prepareStatement(sql);

            preStmt.setInt(1, 1);
            preStmt.setString(2, "name");

            rs = preStmt.executeQuery(sql);

            // STEP 5: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }

            // STEP 6: Clean-up environment
            rs.close();
            preStmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("Error - " + e);
        }
    }

}