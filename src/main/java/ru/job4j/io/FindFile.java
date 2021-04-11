package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FindFile {

    public List<File> files(Path path, String type, String name) throws IOException {
        Predicate<Path> predicate;
        if (type.equals("name")) {
            predicate = p -> p.toFile().getName().endsWith(name);
        } else {
            predicate = p -> p.toFile().getName().matches(name);
        }

        List<Path> list = Searcher.listFile(path, predicate);
        List<File> file = new ArrayList<>();
        for (Path paths : list) {
            File files = Paths.get(paths.toString()).toFile();
            file.add(files);
        }
        return file;
    }

    public void packFile(List<File> list, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : list) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream buf = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(buf.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        AdjustArgument argument = new AdjustArgument(args);
        FindFile file = new FindFile();
        Path path = Paths.get(argument.getDirectory());
        List<File> files = file.files(path, argument.getType(), argument.getName());
        File targFile = new File(argument.getResult());
        file.packFile(files, targFile);
    }
}
