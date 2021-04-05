package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Mikhail Pushkarev
 * @since 05.04.2021
 * @version 2.2
 * В методе мэйн - я указываю потоку файлов что пройдут только те у котрых формат js
 */
public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder is null");
        }
        Path start = Paths.get(args[0]);
        search(start, args[1]).forEach(System.out::println);
    }

    /**
     * Метод принимает усовершенствованную модель File
     * и Predicate
     * Обьект класса SearchFile принимает предикат
     * @param root
     * @return
     * @throws IOException
     */
    public static List<Path> search(Path root, String str) throws IOException {
        SearchFiles files = new SearchFiles(p -> p.toFile().getName().endsWith(str));
        Files.walkFileTree(root, files);
        return files.getList();
    }
}
