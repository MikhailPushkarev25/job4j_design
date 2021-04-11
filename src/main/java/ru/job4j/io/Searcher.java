package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Searcher {

    public static List<Path> listFile(Path root, Predicate<Path> predicate) throws IOException {
        SearcherFile file = new SearcherFile(predicate);
        Files.walkFileTree(root, file);
        return file.getResult();
    }
}
