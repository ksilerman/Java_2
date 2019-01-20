package lesson_6.net.client;

import java.io.*;
import java.net.Socket;

public class client {

    public static void main(String[] args) {
        new chat();
    }

    public static class chat {
        String SERVER_ADDR = "localhost";
        int SERVER_PORT = 8888;
        Socket socket;

        public chat() {
            try {
                socket = new Socket(SERVER_ADDR, SERVER_PORT);
                BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter    out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                        String userText,serverText;
                            while ((userText = inu.readLine())!=null) {
                                out.println(userText);
                                serverText = in.readLine();
                                System.out.println(serverText);

                                if (userText.equals("exit")) {
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


