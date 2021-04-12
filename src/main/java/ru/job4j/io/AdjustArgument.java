package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class AdjustArgument {
    private String[] args;
    private Map<String, String> map = new HashMap<>();

    AdjustArgument(String[] args) {
        this.args = args;
    }

    public void attributes(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].substring(1).equals("m")
                    || (args[i].substring(1).equals("r")
                    || (args[i].substring(1).equals("f")))) {
                map.put(args[i].substring(1), null);
            } else if (args[i].substring(1).equals("n")
                           || (args[i].substring(1).equals("o")
                           || (args[i].substring(1).equals("d")))) {
                map.put(args[i].substring(1), args[i + 1]);
            }
        }
    }

    public Map<String, String> getMap() {
        return map;
    }

    public String valid(String args) {
        if (!map.containsKey(args)) {
            throw new IllegalArgumentException("Not found");
        }
        return map.get(args);
    }

    public String mask() {
        return valid("m");
    }

    public String regex() {
        return valid("r");
    }

    public String full() {
        return valid("f");
    }

    public String name() {
        return valid("n");
    }

    public String write() {
        return valid("o");
    }

    public String directory() {
        return valid("d");
    }


}
