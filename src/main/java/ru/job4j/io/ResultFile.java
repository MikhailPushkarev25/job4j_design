package ru.job4j.io;


import java.io.FileOutputStream;

/**
 * @author Mikhail Pushkarev
 * @since 03.04.2021
 * @version 2.2
 * В классе представлен пример записи текста в файл,
 * для этого конструктор принимает имя файла,
 * далее метод out.write - записывает текст в файл и переводит в массив байт
 * далее закрываем ресурс
 */
public class ResultFile {
    public static void main(String[] args) {

        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("Hello, world!".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
