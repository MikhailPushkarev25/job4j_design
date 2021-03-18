package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Mikhail Pushkarev
 * @since 18.03.2021
 * @version 2.2
 *
 * В классе я имплементировал итератор, итератор последовательно проходит по элементам
 */
public class ArrayIt implements Iterator<Integer> {

    private final int[] data;
    private int point = 0;

    public ArrayIt(int[] data) {
        this.data = data;
    }

    /**
     * Метод проверяет условие
     * @return - возвращает результат
     */
    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    /**
     * Метод возвращает первый элемент, далее второй, и так по порядку.
     * так я создал условие, если в итераторе нет элементов то выкидываем исключение
     * @return - возвращаем эелемент
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
