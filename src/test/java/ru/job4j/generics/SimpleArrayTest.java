package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void add() {
        SimpleArray<Integer> array = new SimpleArray<Integer>(10);
        array.add(10);
        assertThat(array.get(0), is(10));
    }

    @Test
    public void set() {
        SimpleArray<Integer> array = new SimpleArray<Integer>(4);
        array.add(10);
        array.set(0, 11);
        int expected = array.get(0);
        assertThat(expected, is(11));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove() {
        SimpleArray<Integer> array = new SimpleArray<Integer>(3);
        array.add(10);
        array.add(20);
        array.remove(0);
        array.get(1);
    }

    @Test
    public void iterator() {
        SimpleArray<Integer> array = new SimpleArray<Integer>(3);
        Iterator<Integer> it = array.iterator();
        array.add(1);
        array.add(2);
        array.add(3);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
    }
}