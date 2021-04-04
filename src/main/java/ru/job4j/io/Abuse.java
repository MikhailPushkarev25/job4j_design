package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Mikhail Pushkarev
 * @since 04.04.2021
 * @version 2.2
 *
 */
public class Abuse {
    /**
     * Метод принмает два файла, и список который удаляет не нужные слова
     * @param source - файл
     * @param target - файл
     * @param words - список
     * @throws IOException - исключение
     */
    public static void drop(String source, String target, List<String> words) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))
        ) {
            in.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> !words.contains(word)).map(word -> word + " ")
                    .forEach(out::print);
        }
    }
}
