package ru.job4j.io;

import java.io.FileInputStream;

/**
 * @author Mikhail Pushkarev
 * @since 03.04.2021
 * @version 2.2
 * В классе представлен пример считывания текста и вывода результата на консоль
 */
public class ReadFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("Input.txt")) {
            StringBuilder str = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                str.append((char) read);
            }
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
