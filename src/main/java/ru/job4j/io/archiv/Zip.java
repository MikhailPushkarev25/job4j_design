package ru.job4j.io.archiv;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;
import ru.job4j.io.SearchFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Mikhail Pushkarev
 * @since 08.04.2021
 * @version 2.2
 * В классе реализован алгоритм архивации директории
 */
public class Zip {

    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toString())))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, String line) throws IOException {
        SearchFiles search = new SearchFiles(p -> !p.toFile().getName().endsWith(line));
        Files.walkFileTree(root, search);
        return search.getList();
    }

    public static void main(String[] args) throws IOException {
        new Zip().packSingleFile(
                new File("c:\\projects\\job4j_design\\main\\paks.sv"),
                new File("paks.zip")
        );

        ArgsName jvm =  ArgsName.of(args);
         new Zip().packFiles(
                 Zip.search(Path.of(jvm.get("d")), jvm.get("e")), Paths.get(jvm.get("o"))
         );
    }
}
