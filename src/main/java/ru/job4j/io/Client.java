package ru.job4j.io;

import java.io.*;
import java.net.Socket;

/**
 * @author Mikhail Pushkarev
 * @since 10.04.2021
 * @version 2.2
 * В классе клиент я принимаю ответ от сервер читаю и отправлю свой ответ серверу,
 * доступ к серверу я определил с помощью порта и хоста
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);
        System.out.println("Client");
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


           writer.write("Hello, you server?");
           writer.newLine();
           writer.flush();
           System.out.println(reader.readLine());

            reader.close();
            writer.close();
            socket.close();


    }
}
