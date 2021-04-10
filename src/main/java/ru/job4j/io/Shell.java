package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;

public class Shell {
    private List<String> list = new ArrayList<>();
    private static final String STR = "/";

    public void cd(String path) {
        if (path.equals(STR)) {
            list.add(path);
        } else {
            String[] line = path.split("/");
            list.add(STR);
            for (int i = 0; i < line.length; i++) {
                if (line[i].equals("..")) {
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                } else if (!line[i].equals("..")) {
                    list.add(line[i]);
                }
            }
        }
    }

    public String pwd() {
        return list.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
    }
}
