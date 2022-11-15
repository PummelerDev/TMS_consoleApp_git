import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Request {
    public static void start() {
        while (true) {
            System.out.println("""
                    Make a choose to make a request.
                    1 - username by id
                    2 - comments for posts by userId
                    Enter "exit" to return.
                    """);
            String sc = MyUtils.getNumb(2);
            if (sc.equals("exit")) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            switch (sc) {
                case "1" -> {
                    try (Connection connect = MyConnection.connection()) {
                        System.out.println("enter an id");
                        PreparedStatement preparedStatement = connect.prepareStatement("""
                                    SELECT u.username  FROM users u
                                    WHERE u.id = ?
                                    LIMIT 1
                                """);
                        int idPostFromUrl = MyUtils.fromKeyboardInt();
                        preparedStatement.setInt(1, idPostFromUrl);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            String title = resultSet.getString(1);
                            System.out.println(title);
                        }
                        preparedStatement.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "2" -> {
                    try (Connection connect = MyConnection.connection()) {
                        System.out.println("enter an id");
                        PreparedStatement preparedStatement = connect.prepareStatement("""
                                SELECT * FROM comments c
                                JOIN posts p ON c.postId = p.id
                                JOIN users u ON p.userId = u.id
                                WHERE u.id = ?
                                LIMIT 1
                                """);
                        int idPostFromUrl = MyUtils.fromKeyboardInt();
                        preparedStatement.setInt(1, idPostFromUrl);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            int id = resultSet.getInt(1);
                            System.out.println("/id/ " + id);
                            int userId = resultSet.getInt(2);
                            System.out.println("/userId/ " + userId);
                            String title = resultSet.getString(3);
                            System.out.println("/title/ " + title);
                            String body = resultSet.getString(4);
                            System.out.println("/body/ " + body);
                            String comments = resultSet.getString(5);
                            System.out.println("/comment/" + comments);
                            String body2 = resultSet.getString(4);
                            System.out.println("/body/ " + body2);
                            String comments2 = resultSet.getString(5);
                            System.out.println("/comment/" + comments2);
                            String body3 = resultSet.getString(4);
                            System.out.println("/body/ " + body2);
                            String comments3 = resultSet.getString(5);
                            System.out.println("/comment/" + comments2);
                        }
                        preparedStatement.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}