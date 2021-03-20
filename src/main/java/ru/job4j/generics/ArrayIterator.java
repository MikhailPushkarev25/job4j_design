package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Mikhail Pushkarev
 * @since 21.03.2021
 * @version 2.2
 * @param <E> - дженерик
 *   Простая реализация итератора
 */
public class ArrayIterator<E> implements Iterator<E> {

    private E[] value;
    private int count;

    public ArrayIterator(E[] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return count < value.length;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return value[count++];
    }
}
