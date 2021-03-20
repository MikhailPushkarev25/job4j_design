package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Mikhail Pushkarev
 * @since 21.03.2021
 * @version 2.2
 * @param <T> - дженерик
 *  В классе реализован ArrayList, не динамический
 */
public class SimpleArray<T> implements Iterable<T> {

    private final T[] values;
    private int count = 0;

    public SimpleArray(int i) {
        values = (T[]) new Object[i];
    }

    /**
     * Метод добавляет элементы в массив
     * @param model - принимает элемент
     */
    public void add(T model) {
        values[count++] = model;
    }

    /**
     * Метод меняет исходящий элемент на новый
     * @param index - исходный элемент
     * @param model - новый элемент
     */
    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        values[index] = model;
    }

    /**
     * Метод удаляет элемент по индексу
     * @param index - принимает индекс по которому нужно удалить элемент
     */
    public void remove(int index) {
        Objects.checkIndex(index, count);
        System.arraycopy(values, index + 1, values, index, count - 1);
        count--;
    }

    /**
     * Метод возвращает индекс элемента
     * @param index - индекс
     * @return - возвращает индекс
     */
    public T get(int index) {
        Objects.checkIndex(index, count);
        return values[index];
    }

    /**
     * Итератор последовательно проходит по лементам, пока они есть в массиве
     * @return - вернуть следующий элемент.
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public String toString() {
        return "SimpleArray{" + "values=" + Arrays.toString(values) + ", count=" + count + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleArray<?> array = (SimpleArray<?>) o;
        return count == array.count && Arrays.equals(values, array.values);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }
}
