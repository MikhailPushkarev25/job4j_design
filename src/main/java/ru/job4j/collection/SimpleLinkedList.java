package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Mikhail Pushkarev
 * @since 25.03.2021
 * @version 2.2
 * @param <E>
 */
public class SimpleLinkedList<E> implements List<E> {

    private int size = 0;
    private int modCount = 0;
    private Node<E> nextNode;
    private Node<E> prevNode;

    /**
     * Метод добавляет элемент в конец,
     * изначально я передаю в предыдущую ноду элемент и указываю на первую ноду
     * далее в условии проверяю что инкремент равен нулю
     * поэтому связываю первую ноду с последней
     * инкрементирую иначе добавляю следую щий элемент в конец
     * @param value - принимает элемент
     */
    @Override
    public void add(E value) {
        prevNode = new Node<>(value, nextNode, null);
       if (size == 0) {
           nextNode = prevNode;
           size++;
           modCount++;
       } else {
           nextNode.next = prevNode;
           size++;
           modCount++;
       }
        
    }

    /**
     * Метод возвращает элемент,
     * я провожу валидацию по индексу.
     * создаю переменную ноды и приравниваю туда следующий указатель.
     * цикл по индексу, далее в переменную приравниваю следующий индекс и возвращаю жлемент
     * @param index - принимает индекс
     * @return - возвращает результат
     */
    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> res = nextNode;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
       return res.item;
    }

    /**
     * Метод возвращает вложенный класс,
     * метод hasNext- проверяет на изменение элементов при выполнение программы
     * next- проверяет наличие элемента, в переменную добавляем элемент и указываем на следующий
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> node = nextNode;
            private int i = modCount;

            @Override
            public boolean hasNext() {
                if (i != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E res = node.item;
                node = node.next;
                return res;
            }
        };
    }

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
