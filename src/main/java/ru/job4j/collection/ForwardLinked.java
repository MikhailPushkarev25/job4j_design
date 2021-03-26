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
