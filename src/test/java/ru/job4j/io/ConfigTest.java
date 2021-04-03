package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./src/main/add.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.values("name"), is("Petr Arsentev"));
    }

    @Test
    public void whenPairWithCommTest() {
        String path = "./src/main/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.values("name"), is("Mikhail Pushkarev"));
    }
}