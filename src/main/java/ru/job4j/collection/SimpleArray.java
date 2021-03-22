package ru.job4j.collection;

import java.util.*;

/**
 * @author Mikhail Pushkarev
 * @since 21.03.2021
 * @version 2.2
 * @param <T>
 *     В классе я создал работу ArrayList - динамический
 */
public class SimpleArray<T> implements Iterable<T> {

    private  Object[] obj = new Object[10];
    private int count = 0;
     int size = 0;

    /**
     * Метод возвращает элемент по индексу, метод Objects - проводит валидацию
     * @param index - индекс
     * @return - вернуть результат
     */
    public T get(int index) {
        return (T) obj[Objects.checkIndex(index, count)];
    }

    /**
     * Метод добавляет элемент в массив, массив динамический, то есть
     * у нас массив размерностью на 10 элементов, если пользователь добавил больше элементов,
     * то у нас создается массив в два раза больше и старые элементы копируются в новый.
     * @param model - принимает элемент.
     */
    public void add (T model) {
        if (obj.length <= count) {
            Arrays.copyOf(obj, obj.length * 2);
        }
         obj[count++] = model;
        size++;
    }

    /**
     * Метод создает внутренний класс итератор, я создал в нем две переменные,
     * в в классе SimpleArray я создал счетчик, в классе итератор я его приравниваю к переменной,
     * в методе hasNext - проверяю наличие элементов,
     * в методе next - я ловлю исключения, в первом условии я проверяю что элементы остались,
     * если пользователь указавает на ячеку, а там нет элемента то падает исключение NoSuchElementException()
     * во втором условии я ловлю исключение, если пользователь добавил значение,
     * при этом программа уже выполняется, и пользователь решил изменить значение во время работы
     * то падает исключение ConcurrentModificationException().
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int var = 0;
            private int i = size;

            @Override
            public boolean hasNext() {
                return var < i;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (var != size) {
                    throw new ConcurrentModificationException();
                }
                return (T) obj[var++];
            }
        };
    }

    @Override
    public String toString() {
        return "SimpleArray{" + "obj=" + Arrays.toString(obj) + ", count=" + count + '}';
    }
}
