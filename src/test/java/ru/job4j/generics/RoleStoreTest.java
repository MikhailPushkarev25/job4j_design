package ru.job4j.generics;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void add() {
        RoleStore role = new RoleStore();
        role.add(new Role("a"));
        Role one = role.findById("a");
        assertThat(role.delete(one.getId()), is(true));
    }

    @Test
    public void replace() {
        RoleStore role = new RoleStore();
        role.add(new Role("a"));
        assertThat(role.replace("a", new Role("b")), is(true));
    }
}