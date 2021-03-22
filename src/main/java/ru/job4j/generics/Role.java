package ru.job4j.generics;

public class Role extends User {

    protected Role(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Role{}";
    }
}
