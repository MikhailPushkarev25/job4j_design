package ru.job4j.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1,2);
        assertThat(Arrays.asList(1, 2, 3), is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(list, 3 ,2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), is(input));
    }

    @Test
    public void whenRemove() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListUtils.removeIf(list, r -> r < 2);
        assertThat(Arrays.asList(2, 3, 4, 5), is(list));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.replaceIf(list, r -> r == 2, 4);
        assertThat(Arrays.asList(1, 4, 3, 4), is(list));

    }

    @Test
    public void whenRemoveAll() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.removeAll(list, Arrays.asList(2, 3));
        assertThat(Arrays.asList(1), is(list));
    }
}