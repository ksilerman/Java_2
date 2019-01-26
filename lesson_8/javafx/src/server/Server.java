package lesson_8.javafx.src.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clients;

    public Server() throws SQLException {
        AuthService.connect();
//        System.out.println(AuthService.getNickByLoginAndPass("login1","pass1"));
//        AuthService.addMessageToDB("nick2","nick3","hello world!!!","11");
//        System.out.println(AuthService.getMessageFromDBForNick("nick2"));

        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился! ");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void broadcastMsg(String msg, String sender) {
        AuthService.addMessageToDB(sender, null, msg, "01");

        for (ClientHandler c : clients) {
            c.sendMsg(sender + ": " + msg);
        }
    }

    public void broadcastMsg(String msg, String sender, String receiver) {
        AuthService.addMessageToDB(sender, receiver, msg, "01");

        for (ClientHandler c : clients) {
            if (c.getNick().equals(receiver) || (c.getNick().equals(sender)))
                c.sendMsg("private[" + sender + "] to [" + receiver + "]: " + msg);
        }
    }


    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
        broadcastClientList();
        clientHandler.sendMsg(
                AuthService.getMessageFromDBForNick(clientHandler.getNick()));
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastClientList();
    }

    public boolean isNickAuthorized(String nick) {
        boolean isAuth = false;
        for (ClientHandler c : clients) {
            if (c.getNick().equals(nick)) {
                isAuth = true;
            }
        }
        return isAuth;
    }

    public void broadcastClientList() {
        StringBuilder sb = new StringBuilder();
        sb.append("/clientlist ");

        for (ClientHandler c : clients) {
            sb.append(c.getNick() + " ");
        }
        String msg = sb.toString();

        for (ClientHandler c : clients) {
            c.sendMsg(msg);
        }
    }
}
