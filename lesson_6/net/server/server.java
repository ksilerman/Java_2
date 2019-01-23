package lesson_6.net.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8888);
            System.out.println("Сервер запущен!");

            socket = server.accept();
            System.out.println("Клиент подключился! ");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            //DataInputStream in = new DataInputStream(socket.getInputStream());
            //DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String str = in.nextLine();
                if (str.equals("/end")){
                    break;
                }
                System.out.println(str);
                out.println("echo "+str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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

        }
    }
}
