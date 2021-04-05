package ru.job4j.io;

import java.io.File;

/**
 * @author Mikhail Pushkarev
 * @since 04.04.2021
 * @version 2.2
 * В классе представлен пример работы класса Faile
 * первое условие - что файл найден
 * второе условие что в файле есть директория
 * и третье вывод длины директории
 * четвертое что файл не имеет абстрактный путь
 * поэтому выводим имя файлов и длину
 */
public class Dir {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER");
        }

        File file = new File(args[0]);

        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }

        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subFile : file.listFiles()) {
            if (!subFile.isFile()) {
                System.out.println("Имя файла - " + subFile.getName());
                System.out.println("Размер файла - " + subFile.length() + " байт");
            }
        }
    }
}
