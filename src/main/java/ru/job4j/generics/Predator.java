package ru.job4j.generics;

public class Predator extends Animal {

    private String name;
    private String color;

    public Predator(String name, int count) {
        super(name, count);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Predator{" + "name='" + name + '\'' + ", color='" + color + '\'' + '}';
    }
}
