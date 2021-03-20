package ru.job4j.iterator;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FlatMapTest {

    @Test
    public void whenDiffNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator(),
                List.of(2, 3).iterator()
        ).iterator();

        FlatMap<Integer> flat = new FlatMap<>(data);
        assertThat(flat.next(), is(1));
        assertThat(flat.next(), is(2));
        assertThat(flat.next(), is(3));
    }

    @Test
    public void whenSeqNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator()
        ).iterator();
        FlatMap<Integer> flatMap = new FlatMap<>(data);
        assertThat(flatMap.next(), is(1));
        assertThat(flatMap.next(), is(2));
        assertThat(flatMap.next(), is(3));
    }

    @Test
    public void whenMultiHasNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();
        FlatMap<Integer> flatMap = new FlatMap<>(data);
        assertThat(flatMap.hasNext(), is(true));
        assertThat(flatMap.hasNext(), is(true));
    }

    @Test
    public void whenHasNextMultiFalse() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();

        FlatMap<Integer> flatMap = new FlatMap<>(data);
        assertThat(flatMap.next(), is(1));
        assertThat(flatMap.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmpty() {
        Iterator<Iterator<Object>> data = List.of(
                List.of().iterator()
        ).iterator();

        FlatMap<Object> flatMap = new FlatMap<>(data);
        flatMap.next();
    }
}