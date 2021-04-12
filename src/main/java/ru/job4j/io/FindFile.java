package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FindFile {

    private Predicate<Path> searchCondition(AdjustArgument args) {
        Predicate<Path> predicate = null;
        if (args.getMap().containsKey(args.full())) {
            predicate = new RegexSearch(args.name());
        } else if (args.getMap().containsKey(args.mask())) {
            predicate = new RegexSearch(pattern(args.name()));
        } else if (args.getMap().containsKey(args.name())) {
            predicate = new RegexSearch(args.name());
        }
        return predicate;
    }

    public List<File> search(AdjustArgument args) throws IOException {
        SearcherFile searcher = new SearcherFile(searchCondition(args));
        Path path = Paths.get(args.directory());
        Files.walkFileTree(path, searcher);
        return searcher.getResult();
    }

    public void write(List<File> files, AdjustArgument args) {
        try (PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(args.write())))) {
            for (File file : files) {
                pw.print(file.getName() + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String pattern(String str) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a == '*') {
                string.append(".*");
            } else if (a == '.') {
                string.append("\\.");
            } else {
                string.append(a);
            }
        }
        return string.toString();
    }

    public static void main(String[] args) throws IOException {
        FindFile findFile = new FindFile();
        AdjustArgument argument = new AdjustArgument(args);
        argument.attributes(args);
        List<File> file = findFile.search(argument);
        findFile.write(file, argument);
    }


    private static class RegexSearch implements Predicate<Path> {
        private Pattern pattern;

        @Override
        public boolean test(Path path) {
            return pattern.matcher(path.toFile().getName()).matches();
        }

        public RegexSearch(String name) {
            this.pattern = Pattern.compile(name);
        }
    }
}

