package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Mikhail Pushkarev
 * @since 10.04.2021
 * @version 2.2
 * В классе сервер я проверяю соединение с клиентом так же отправляю ответ клиенту
 * и читаю его ответ
 */
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8000);
        System.out.println("Server started");
        while (true) {
        Socket socket = server.accept();
        System.out.println("Client accept");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

           String str = reader.readLine();
           String request = "* " + str.length() + " line";
           writer.write(request);
           writer.newLine();
           writer.flush();

           reader.close();
           writer.close();
           socket.close();
       }
    }
}
