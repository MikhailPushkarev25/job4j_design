package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class CheckerAndGetter {

    public static String getElement(List<String> list) {
        list.add("");
        if (list.isEmpty()) {
            return list.get(0);
        } else {
           return list.get(0);
        }
    }
}
