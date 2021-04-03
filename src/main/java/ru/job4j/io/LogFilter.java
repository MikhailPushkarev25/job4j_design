package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Pushkarev
 * @since 03.04.2021
 * @version 2.2
 * В классе прдставлена система чтения файла
 * в файле есть некие строки, нужно из строк выбрать предпоследнее число 404
 * прочитать
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

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
