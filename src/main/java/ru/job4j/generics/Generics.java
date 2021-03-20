package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mikhail Pushkarev
 * @since 20.03.2021
 * @version 2.2
 *
 * В классе я показал как работают дженерики
 * общий доступ, верхний уровень доступа, нижний уровень доступа
 */
public class Generics {
    public static void main(String[] args) {
        Generics gen = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal("Animal", 2));
        second.add(new Predator("Predator", 2));
        third.add(new Tiger("Tiger", 1));

        gen.printObject(first);
        gen.printObject(second);
        gen.printObject(third);
        System.out.println();

       // gen.printBoundedWildCard(first);
        gen.printBoundedWildCard(second);
        gen.printBoundedWildCard(third);
        System.out.println();

        gen.printLowerBoundedWildCard(first);
        gen.printLowerBoundedWildCard(second);
       // gen.printLowerBoundedWildCard(third);

    }

    public void printObject(List<?> list) {
        for (Iterator<?> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент " + next);
        }
    }

    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент " + next);
        }
    }

    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент " + next);
        }
    }
}
