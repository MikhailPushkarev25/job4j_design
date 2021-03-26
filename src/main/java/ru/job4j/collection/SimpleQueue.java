package ru.job4j.collection;

/**
 * @author Mikhail Pushkarev
 * @since 26.03.2021
 * @version 2.2
 * @param <E>
 *     В классе реализована очередь на двух стеках
 */
public class SimpleQueue<E> {

    private final SimpleStack<E> in = new SimpleStack<>();
    private final SimpleStack<E> out = new SimpleStack<>();

    /**
     * Метод добавляет элемент в первый стек, далее перетаскивает его во второй стек в обратном порядке
     * и удаляет его.
     * @return - вернуть удаленный элемент
     */
    public E pull() {
        if (out.getSize() == 0) {
            while (in.getSize() > 0) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Метод добавляет элемент в стек.
     * @param value
     */
    public void push(E value) {
        in.push(value);
    }
}
