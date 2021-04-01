package ru.job4j.collection;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalizeTest {

    @Test
    public void whenDiffTestChanged() {
        List<Analise.User> list = Arrays.asList(
                new Analise.User(1, "aaaa"),
                new Analise.User(2, "vvvv"),
                new Analise.User(3, "dddd"),
                new Analise.User(4, "ssss"),
                new Analise.User(5, "qqqq")
        );

        ArrayList<Analise.User> list2 = new ArrayList<>(Arrays.asList(
                new Analise.User(1, "eeee"),
                new Analise.User(2, "yyyy"),
                new Analise.User(3, "oooo"),
                new Analise.User(4, "llll"),
                new Analise.User(5, "mmmm")
        ));
        Analise.Info rsl = Analise.diff(list, list2);
        assertThat(rsl.toString(), is("Info{added=0, changed=5, deleted=0}"));
    }

    @Test
    public void whenDeleteTestDiff() {
        List<Analise.User> list = Arrays.asList(
                new Analise.User(1, "Mikhail"),
                new Analise.User(2, "Roman"),
                new Analise.User(3, "Egor"),
                new Analise.User(4, "Vadim"),
                new Analise.User(5, "Vlad")
        );

        ArrayList<Analise.User> list2 = new ArrayList<>(Arrays.asList(
                new Analise.User(1, "Mikhail")
        ));
        Analise.Info rsl = Analise.diff(list, list2);
        assertThat(rsl.toString(), is("Info{added=0, changed=0, deleted=4}"));
    }

    @Test
    public void whenAddTestDiff() {
        List<Analise.User> list = Arrays.asList(
                new Analise.User(1, "Mikhail"),
                new Analise.User(2, "Roman"),
                new Analise.User(3, "Egor"),
                new Analise.User(4, "Vadim"),
                new Analise.User(5, "Vlad")
        );

        List<Analise.User> list2 = Arrays.asList(
                new Analise.User(1, "Mikhail"),
                new Analise.User(2, "Roman"),
                new Analise.User(3, "Egor"),
                new Analise.User(4, "Vadim"),
                new Analise.User(5, "Vlad"),
                new Analise.User(6, "Klub"),
                new Analise.User(7, "Hous")
        );
        Analise.Info rsl = Analise.diff(list, list2);
        assertThat(rsl.toString(), is("Info{added=2, changed=0, deleted=0}"));
    }
}