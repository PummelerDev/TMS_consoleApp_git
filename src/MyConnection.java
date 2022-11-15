import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
    public static Connection connection() throws SQLException {
        Connection connection;
        String url = "jdbc:sqlite:E:\\java-workspace\\TMS_consoleApp\\db\\db_consoleApp.db";
        connection = DriverManager.getConnection(url);
        return connection;
    }
    public static void connect(String request){
        try (Connection connect = getConnect()){
            Statement statement = connect.createStatement();
            statement.execute(request);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static Connection getConnect() throws SQLException {
        Connection connection;
        String url = "jdbc:sqlite:E:\\java-workspace\\TMS_consoleApp\\db\\db_consoleApp.db";
        connection = DriverManager.getConnection(url);
        return connection;
    }
}
