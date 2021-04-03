package ru.job4j.io;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Pushkarev
 * @since 03.04.2021
 * @version 2.2
 * В классе прдставлена система чтения файла
 * в файле есть некие строки, нужно из строк выбрать предпоследнее число 404
 * прочитать
 *
 * Так же добавил метод который записывает результат первого метода в файл
 */
public class LogFilter {

    public static List<String> filter(String filter) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filter))) {
           for (String line = in.readLine(); line != null; line = in.readLine()) {
               String[] str = line.split(" ");
               if (str[str.length - 2].equals("404")) {
                   list.add(line);
               }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter pw = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String str : log) {
                pw.write(str);
                pw.write(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
        save(log, "404.txt");
    }
}
