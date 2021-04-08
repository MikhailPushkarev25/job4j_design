package ru.job4j.io.archiv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
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

    public void run() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        writeFile(botAnswers, "Bot: " + res);
        while (!res.equals(OUT)) {
            if (res.equals(STOP)) {
                System.out.println("Stop bot");
                flag = false;
            }
            if (res.equals(CONTINUE)) {
                System.out.println("Continue bot");
                flag = true;
            }
            if (flag) {
                String answer = readFile(path);
                System.out.println(answer);
                writeFile(botAnswers, "Bot: " + answer);
            }
            res = scanner.nextLine();
            writeFile(botAnswers, "Usage Massage" + res);
        }
        scanner.close();

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
        String[] result = builder.toString().split(" ");
        Random random = new Random();
        int index = random.nextInt(result.length);
        return result[index];
    }

    public void writeFile(String path, String data) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
            br.write(data + System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./src/main/console.txt", "./src/main/console_log.txt");
        cc.run();
    }
}
