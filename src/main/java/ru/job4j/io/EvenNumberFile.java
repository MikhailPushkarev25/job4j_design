package ru.job4j.io;

import java.io.FileInputStream;

/**
 * @author Mikhail Pushkarev
 * @since 03.04.2021
 * @version 2.2
 * В классе представлен пример вывода четных и не четных чисел
 * я разбиваю строки через метод сплит
 * далее проверяю что строка больше нуля
 * далее привожу строку в число
 * далее делю по модулю и вывожу результат
 */
public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder str = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                str.append((char) read);
            }
            String[] lines = str.toString().split(System.lineSeparator());
            for (String line : lines) {
                if (line.length() > 0) {
                    int i = Integer.parseInt(line);
                    if (i % 2 == 0) {
                        System.out.println(i);
                    } else {
                        System.out.println("Не четное число");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
