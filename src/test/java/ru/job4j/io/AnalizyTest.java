package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void whenTestIntervalLog() {
        String log = "./src/main/source.log";
        String path = "./src/main/dest.lg";
        Analizy analizy = new Analizy();
       List<String> expected  = new ArrayList<>();
       expected.add("10:57:01;10:58:01");
       expected.add("11:01:02;11:02:02");
       List<String> result = new ArrayList<>();
       analizy.unavailable(log, path);
       try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
           bf.lines().forEach(result::add);
       } catch (Exception e) {
           e.printStackTrace();
       }
       assertThat(result, is(expected));

    }
}