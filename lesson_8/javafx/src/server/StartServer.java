package lesson_8.javafx.src.server;

import java.sql.SQLException;

public class StartServer {
    public static void main(String[] args) {
        try {
            new Server();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
