package ru.job4j.io.archiv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Mikhail Pushkarev
 * @since 08.04.2021
 * @version 2.2
 * В классе создан консольный чат с ботом
 * я задаю вопрос бот отвечает и все это записывается в файл
 * для ответов бота есть предложения в другом файле
 *
 */
public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "Закончить";
    private static final String STOP = "Стоп";
    private static final String CONTINUE = "Продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path, Charset.forName("UTF-8")))) {
            int data;
            while ((data = br.read()) > 0) {
                builder.append((char) data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] str = builder.toString().split(" ");
        Random random = new Random();
        int index = random.nextInt(str.length);
        return str[index];
    }

    public void writeFile(String path, String data) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
            br.write(data + System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        writeFile(botAnswers, "User: " + str);
        while (!str.equals(OUT)) {
            if (str.equals(STOP)) {
                System.out.println("Bot STOP: ");
                flag = false;
            }
            if (str.equals(CONTINUE)) {
                System.out.println("Bot CONTINUE: ");
                flag = true;
            }
            if (flag) {
                String answer = readFile(path);
                System.out.println(answer);
                writeFile(botAnswers, "Bot: " + answer);
            }
            str = scanner.nextLine();
            writeFile(botAnswers, "User: " + str);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./src/main/bot.txt", "./src/main/bot_log.txt");
        cc.run();
    }
}
