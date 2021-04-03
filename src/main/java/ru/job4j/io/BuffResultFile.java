package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @author Mikhail Pushkarev
 * @since 03.04.2021
 * @version 2.2
 */
public class BuffResultFile {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream("res.txt")))) {
            pw.write("Hello, world!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
