package ru.job4j.collection;

import java.util.Iterator;

/**
 * @author Mikhail Pushkarev
 * @since 27.03.2021
 * @version 2.2
 * @param <T>
 *     Класс реализует Set - то есть извлекает дублирующие элементы,
 *     класс на основе класса SimpleArray
 */
public class SimpleSet<T> implements Set<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    /**
     * Метод добавляет элемент, в условии проверяет что элемент есть и сравнивает его
     * если добавили первый элемент мы переходим к методу contains, метод проверяет есть ли
     * такой же в массиве, если нет идем дальше, добавили второй такой же элемент
     * метод contains проверяет и находит дубликат, выходим из  метода и выдаем false.
     * @param value - элемент
     * @return - вернуть результат
     */
    @Override
    public boolean add(T value) {
            if (!contains(value)) {
                set.add(value);
                return true;
        }
        return false;
    }
    /**
     * Метод проверяет на дубликаты элементов
     */
    @Override
    public boolean contains(T value) {
        boolean b = false;
        for (T t : set) {
            if (t.equals(value)) {
                b = true;
                break;
        }
    }
        return b;
    }

    /**
     * Iterator - работает на основе итератора в классе SimpleArray
     * @return - возвращает последовательность элементов в массиве
     */
    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
