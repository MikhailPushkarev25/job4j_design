package ru.job4j.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ModelTest {

    @Test
    public void whenTestModel() {
        Map<Integer, Model> map = new HashMap<>();
        map.put(1, new Model("Mikhail", 25));
        map.put(2, new Model("Roman", 28));
        assertThat(map.get(1), is(new Model("Mikhail", 25)));
    }
}