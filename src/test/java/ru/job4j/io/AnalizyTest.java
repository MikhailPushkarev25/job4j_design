package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public  TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenTestIntervalLog() throws IOException {
        File source = folder.newFile("source.log");
        File target = folder.newFile("dest.lg");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("400 10:57:01");
            out.println("200 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
       Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(builder::append);
        }
        assertThat(builder.toString(), is("10:57:01;10:58:01" + "11:01:02;11:02:02"));
    }
}