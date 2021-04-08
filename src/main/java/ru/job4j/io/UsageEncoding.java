package ru.job4j.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author Mikhail Pushkarev
 * @since 08.04.2021
 * @version 2.2
 * В классе приводится пример кодировки
 * к примеру мы указали в файле слова в кодировке UTF-8
 * далее в виндовс мы добавили новые строки но в кодировке виндовс, для прочтения
 * я явно указал в конструкторе кодировку и прочел ее
 */
public class UsageEncoding {

    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path, Charset.forName("WINDOWS-1251")))) {
            int data;
            while ((data = br.read()) > 0) {
                builder.append((char) data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void writeDataInFile(String path, String data) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            br.write(data + System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "./src/main/text.txt";
        UsageEncoding encoding = new UsageEncoding();
        List<String> list = List.of(
                "Новая строка 1",
                "Новая строка 2",
                "Новая строка 3",
                "Новая строка 4",
                "Новая строка 5"
        );

        for (String str : list) {
            encoding.writeDataInFile(path, str);
        }
        String s = encoding.readFile(path);
        System.out.println("Данные из файла: ");
        System.out.println(s);
    }
}
