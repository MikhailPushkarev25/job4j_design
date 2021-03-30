package ru.job4j.collection.map;

import org.junit.Test;
import org.w3c.dom.Node;
import ru.job4j.collection.ForwardLinked;
import ru.job4j.collection.SimpleStack;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    @Test
    public void whenHashMapAdd() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        assertThat(map.insert("a", "ync"), is(true));
    }

    @Test
    public void whenDelete() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.insert("a", "ejf");
        assertThat(map.delete("a"), is(true));
    }

    @Test
    public void whenGet() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.insert("a", "afef");
        assertThat(map.get("a"), is("afef"));
    }

    @Test
    public void whenArraysTwo() {
        SimpleHashMap<Integer, Integer> map = new SimpleHashMap<>();
        map.insert(1, 2);
        map.insert(5, 10);
        assertThat(map.size(), is(2));
    }

    @Test
    public void whenTestHashMap() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.insert("1", "1");
        map.insert("2", "2");
        map.insert("3", "3");
        map.insert("4", "4");
        map.insert("5", "5");
        map.insert("6", "6");
        map.insert("7", "7");
        map.insert("8", "8");
        map.insert("9", "9");
        map.insert("10", "10");
        map.insert("11", "11");
        map.insert("12", "12");
        map.insert("13", "13");
        map.insert("14", "14");
        map.insert("15", "15");
        map.insert("16", "16");
        map.insert("17", "17");
        map.insert("18", "18");
        assertThat(map.get("18"), is("18"));
    }

    @Test
    public void whenTestIterator() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.insert("a", "b");
       Iterator<String> iterator = map.iterator();
       assertThat(iterator.next(), is("b"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenTestError() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.insert("a", "b");
        Iterator<String> it = map.iterator();
        map.insert("c", "k");
        it.next();
    }
}