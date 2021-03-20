package ru.job4j.generics;

public class Animal {

    private String name;
    private int count;

    public Animal(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", count=" + count + '}';
    }
}
