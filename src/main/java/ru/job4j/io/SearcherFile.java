package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.Predicate;

public class SearcherFile extends SimpleFileVisitor<Path> {
    private List<File> result;
    private Predicate predicate;

    public SearcherFile(Predicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes bfa) throws IOException {
        boolean b = true;
        if (b) {
            result.add(path.toFile());
        }
        return FileVisitResult.CONTINUE;
    }

    public List<File> getResult() {
        return result;
    }

}
