package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Mikhail Pushkarev
 * @since 03.04.2021
 * @version 2.2
 * В классе представлен код который читает из файла,
 * эта система на много быстрее осуществлят чтение символов.
 */
public class BuffReadFile {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("read.txt"))) {
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
