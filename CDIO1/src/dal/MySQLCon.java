package dal;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class CreateTableInsertRows {

    // Initialize connection variables.
    String host = "universitydtudb.mysql.database.azure.com";
    String database = "cdiosampledb";
    String user = "myadmin@universitydtudb";
    String password = "2GpZ#P/h{&";
    Connection connection = null;

    // check that the driver is installed
    public void setup() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (
                ClassNotFoundException e) {
            throw new ClassNotFoundException("MariaDB JDBC driver NOT detected in library path.", e);
        }

        System.out.println("MariaDB JDBC driver detected in library path.");


        // Initialize connection object
        try {
            String url = String.format("jdbc:mariadb://%s/%s", host, database);

            // Set connection properties.
            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");

            // get connection
            connection = DriverManager.getConnection(url, properties);
        } catch (
                SQLException e) {
            throw new SQLException("Failed to create connection to database.", e);
        }

    }

    public static void main(String[] args) throws Exception {
        CreateTableInsertRows createRows = new CreateTableInsertRows();
        createRows.setup();
        if (createRows.connection != null) {
            System.out.println("Successfully created connection to database.");

            // Perform some SQL queries over the connection.
            try {
                // Drop previous table of same name if one exists.
                Statement statement = createRows.connection.createStatement();
                statement.execute("DROP TABLE IF EXISTS inventory;");
                System.out.println("Finished dropping table (if existed).");

                // Create table.
                statement.execute("CREATE TABLE inventory (id serial PRIMARY KEY, name VARCHAR(50), quantity INTEGER);");
                System.out.println("Created table.");

                // Insert some data into table.
                int nRowsInserted = 0;
                PreparedStatement preparedStatement = createRows.connection.prepareStatement("INSERT INTO inventory (name, quantity) VALUES (?, ?);");
                preparedStatement.setString(1, "banana");
                preparedStatement.setInt(2, 150);
                nRowsInserted += preparedStatement.executeUpdate();

                preparedStatement.setString(1, "orange");
                preparedStatement.setInt(2, 154);
                nRowsInserted += preparedStatement.executeUpdate();

                preparedStatement.setString(1, "apple");
                preparedStatement.setInt(2, 100);
                nRowsInserted += preparedStatement.executeUpdate();
                System.out.println(String.format("Inserted %d row(s) of data.", nRowsInserted));

                // NOTE No need to commit all changes to database, as auto-commit is enabled by default.

            } catch (SQLException e) {
                throw new SQLException("Encountered an error when executing given sql statement.", e);
            }
        } else {
            System.out.println("Failed to create connection to database.");
        }
        System.out.println("Execution finished.");
    }
}