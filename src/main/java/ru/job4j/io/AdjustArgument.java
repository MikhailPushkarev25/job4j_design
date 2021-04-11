package ru.job4j.io;

public class AdjustArgument {

    private String directory;
    private String name;
    private String type;
    private String result;

    public AdjustArgument(String[] args) {
        for (String str : args) {
            String[] line = str.split("=");
            if (line.length == 2) {
                if (line[0].equals("-d")) {
                    directory = line[1];
                } else if (line[0].equals("-n")) {
                    name = line[1];
                } else if (line[0].equals("-t")) {
                    type = line[1];
                } else if (line[0].equals("-o")) {
                    result = line[1];
                }
            }
        }
    }

    public String getDirectory() {
        return directory;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getResult() {
        return result;
    }
}
