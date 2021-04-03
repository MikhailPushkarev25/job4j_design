package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * @author Mikhail Pushkarev
 * @since 03.04.2021
 * @version 2.2
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * метод читает файл и записывает ключ и значение в мапу.
     */
    public void load() {
        List<String> list = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(list::add);
            for (String line : list) {
                if (line.length() > 0) {
                    String[] spl = line.split("=");
                    values.put(spl[0], spl[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * возвращает значение по ключу
     * @param key - ключ
     * @return - значение
     */
    public String values(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader red = new BufferedReader(new FileReader(this.path))) {
            red.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Config("pair_without_comment.properties"));
    }
}
