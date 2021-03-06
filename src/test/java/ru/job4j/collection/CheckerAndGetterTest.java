package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static ru.job4j.collection.CheckerAndGetter.getElement;

public class CheckerAndGetterTest {

    @Test
    public void whenGetNull() {
        List<String> list = new ArrayList<>();
        String result = getElement(list);
        String expected = "";
        assertThat(result, is(expected));
    }

    @Test
    public void whenGetFirstElement() {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        String result = getElement(list);
        String expected = "first";
        assertThat(result, is(expected));
    }
}