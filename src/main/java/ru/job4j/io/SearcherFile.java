package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.Predicate;

public class SearcherFile extends SimpleFileVisitor<Path> {

    private Predicate predicate;
    List<Path> result;

    public SearcherFile(Predicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes bfa) throws IOException {
        if (bfa.isRegularFile()) {
            if (predicate.test(path)) {
                result.add(path.toAbsolutePath());
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getResult() {
        return result;
    }

}
