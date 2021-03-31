package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

/**
 * @author Mikhail Pushkarev
 * @since 31.03.2021
 * @version 2.2
 * @param <E>
 *     В классе реализовано дерево, обход происходит в ширину.
 */
public class SimpleTree<E> implements Tree<E> {

    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean b = false;
        Optional<Node<E>> optional = findBy(child);
        if (optional.isEmpty() && findBy(parent).isPresent()) {
            findBy(parent).get().children.add(new Node<>(child));
            b = true;
        }
        return b;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
       return findByPredicate(el -> el.value.equals(value));
    }

    public boolean isBinary() {
        return findByPredicate(el -> el.children.size() > 2).isEmpty();
    }


    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> node = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                node = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return node;
    }
}


