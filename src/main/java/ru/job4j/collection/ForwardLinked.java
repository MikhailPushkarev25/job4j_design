package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Mikhail Pushkarev
 * @since 25.03.2021
 * @version 2.2
 * @param <E>
 */
public class ForwardLinked<E> implements Iterable<E> {

    private Node<E> head;

    /**
     * Метод добавляет элемент в начало.
     * @param value
     */
    public void add(E value) {
        Node<E> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }

        Node<E> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * Метод добавляет элемент в начало и дальше
     * @param value
     */
    public void addFirst(E value) {
       Node<E> node = new Node<>(value, null);
       if (value == null) {
           head = node;
       } else {
           node.next = head;
           head = node;

       }
    }

    /**
     * Метод сначала проверяет на наличие элемента, если его нет то падает исключение
     * иначе в переменную добавляю head
     * приравниваю след элемент
     * зануляю его и возвращаю эелемент
     * @return - вернуть элемент
     */
    public E deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<E> res = head;
        head = head.next;
        res.next = null;
        return res.value;
    }

    /**
     * Метод переворачивает односвязный список чисел, то есть я создал три ноды.
     * в одну добавил голову,
     * в цикле while я проверяю что в голове есть какой либо элемент значит выполняем условие инче
     * нет, далее я в переменную next добавляю элемент и следую дальше,
     * далее я в следующий узел добавлю нул элемент то есть мы прошли по узлу и остановились,
     * далее мы начинаем идти в обратном порядке в переменную prev добавляю элемент то есть идем
     * в обратном направлении, поэтому в current добавляю next и тд. кода мы проходим
     * в обратном порядке то привниваю в ссылочную переменную предыдущий эелемент
     */
    public boolean revert() {
       Node<E> next = null;
       Node<E> prev = null;
       Node<E> current = head;
       boolean b = false;
       if (!b) {
           while (current != null) {
               next = current.next;
               current.next = prev;
               prev = current;
               current = next;
           }
       }
       head = prev;
       return b;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E val = node.value;
                node = node.next;
                return val;
            }
        };
    }

    public static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
