package ru.job4j.jdbc;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConnectionDemoTest {

    @Test
    public void load() throws Exception {
        ConnectionDemo demo = new ConnectionDemo();
       ClassLoader loader = ConnectionDemo.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            demo.load(io);
        }
        String value = demo.getValue("url");
        assertThat(value, is("jdbc:postgresql://localhost:5432/idea_db"));
    }
}