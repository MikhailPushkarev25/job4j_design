package ru.job4j.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Mikhail Pushkarev
 * @since 09.04.2021
 * @version 2.2
 * В классе представлен пример работы клиента и сервера
 * с помощью порта мы узнаем положение сервера
 * далее мы записываем и читаем данные в сервер при наборе слова bye - сервер закрывается
 * так же я рефакторил код, теперь при вводе определенного слова. Случается ответ от клиента
 * так же при вводе Exit сервер прекращает работу
 */
public class EchoServer {
    @SuppressWarnings("checkstyle:InnerAssignment")
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello".getBytes());
                        } else if(str.contains("Exit")) {
                            server.isClosed();
                            break;
                        } else if(str.contains("Any")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("What ".getBytes());
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                }
            }
        }
    }
}
