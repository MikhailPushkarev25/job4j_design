package ru.job4j.collection;

/**
 * @author Mikhail Pushkarev
 * @since 26.03.2021
 * @version 2.2
 * @param <E>
 *     В классе реализован стек по принципу стопок тарелок, добавляем по одному элементу.
 */
public class SimpleStack<E> {
    private ForwardLinked<E> linked = new ForwardLinked<>();
    private int size;

    /**
     * Счетчик для добавления и удаления очереди
     * @return - вернуть индекс
     */
    public int getSize() {
        return size;
    }

    /**
     * Метод возвращает из связновго списка метод deleteFirst, удаляем из начала
     * @return - вернуть результат
     */
    public E pop() {
        size--;
        return linked.deleteFirst();
    }

    /**
     * Метод добавляет элемент по принципу стопки тарелок, в начало,
     * в связном списке
     * @param value - элемент
     */
    public void push(E value) {
        linked.addFirst(value);
        size++;
    }
}
