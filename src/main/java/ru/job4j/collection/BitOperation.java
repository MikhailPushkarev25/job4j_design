package ru.job4j.collection;

public class BitOperation {
    public static void main(String[] args) {
        int x = 300;
        System.out.println(Integer.toBinaryString(x));

        int y = ~300;
        System.out.println(y);

        System.out.println(277 & 432);
        System.out.println(277 | 432);
        System.out.println(277 ^ 432);
    }
}
