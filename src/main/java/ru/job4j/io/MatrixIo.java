package ru.job4j.io;

import java.io.FileOutputStream;

/**
 * @author Mikhail Pushkarev
 * @since 03.04.2021
 * @version 2.2
 *  В классе представлен вывод таблицы умножения
 */
public class MatrixIo {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("matrix.txt")) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    out.write((" " + i + " * " + " " + j +  " = " + " " + i * j + " " + System.lineSeparator()).getBytes());
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
